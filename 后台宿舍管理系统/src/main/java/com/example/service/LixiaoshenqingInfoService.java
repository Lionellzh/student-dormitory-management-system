package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.LixiaoshenqingInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.LixiaoshenqingInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.LixiaoshenqingInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class LixiaoshenqingInfoService {

    @Resource
    private LixiaoshenqingInfoDao lixiaoshenqingInfoDao;
	
	//kuabiaojisuan3

    public LixiaoshenqingInfo add(LixiaoshenqingInfo lixiaoshenqingInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // lixiaoshenqingInfo.setAccount((double) 0);
	  
        lixiaoshenqingInfoDao.insertSelective(lixiaoshenqingInfo);
        return lixiaoshenqingInfo;
    }

    public void delete(Long id) {
        lixiaoshenqingInfoDao.deleteByPrimaryKey(id);
    }

    public void update(LixiaoshenqingInfo lixiaoshenqingInfo) {
        //shangxchxuantupxian
		//youdianzan
        lixiaoshenqingInfoDao.updateByPrimaryKeySelective(lixiaoshenqingInfo);
    }

    public LixiaoshenqingInfo findById(Long id) {
        return lixiaoshenqingInfoDao.selectByPrimaryKey(id);
    }

    public List<LixiaoshenqingInfoVo> findAll() {
        return lixiaoshenqingInfoDao.findByXingming("all");
    }

    public PageInfo<LixiaoshenqingInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<LixiaoshenqingInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = lixiaoshenqingInfoDao.findByXingming(xingming);}
		if (user.getLevel().equals("学生")) {all = lixiaoshenqingInfoDao.findByXingminglist2(xingming,user.getXuehao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<LixiaoshenqingInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<LixiaoshenqingInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = lixiaoshenqingInfoDao.findByXingming(xingming);
		if (user.getLevel().equals("学生")) {all = lixiaoshenqingInfoDao.findByXingminglist2(xingming,user.getXuehao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public LixiaoshenqingInfoVo findByUserName(String name) {
//        return lixiaoshenqingInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        LixiaoshenqingInfo lixiaoshenqingInfo = lixiaoshenqingInfoDao.selectByPrimaryKey(id);
        if(lixiaoshenqingInfo.getStatus().equals("是")){
            lixiaoshenqingInfo.setStatus("否");
            lixiaoshenqingInfoDao.updateByPrimaryKey(lixiaoshenqingInfo);
        }else if(lixiaoshenqingInfo.getStatus().equals("否")){
            lixiaoshenqingInfo.setStatus("是");
            lixiaoshenqingInfoDao.updateByPrimaryKey(lixiaoshenqingInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}

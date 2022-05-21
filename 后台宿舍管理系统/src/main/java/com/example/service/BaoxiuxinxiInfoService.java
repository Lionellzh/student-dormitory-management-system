package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.BaoxiuxinxiInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.BaoxiuxinxiInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.BaoxiuxinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class BaoxiuxinxiInfoService {

    @Resource
    private BaoxiuxinxiInfoDao baoxiuxinxiInfoDao;
	
	//kuabiaojisuan3

    public BaoxiuxinxiInfo add(BaoxiuxinxiInfo baoxiuxinxiInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // baoxiuxinxiInfo.setAccount((double) 0);
	  
        baoxiuxinxiInfoDao.insertSelective(baoxiuxinxiInfo);
        return baoxiuxinxiInfo;
    }

    public void delete(Long id) {
        baoxiuxinxiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(BaoxiuxinxiInfo baoxiuxinxiInfo) {
        //shangxchxuantupxian
		//youdianzan
        baoxiuxinxiInfoDao.updateByPrimaryKeySelective(baoxiuxinxiInfo);
    }

    public BaoxiuxinxiInfo findById(Long id) {
        return baoxiuxinxiInfoDao.selectByPrimaryKey(id);
    }

    public List<BaoxiuxinxiInfoVo> findAll() {
        return baoxiuxinxiInfoDao.findByXingming("all");
    }

    public PageInfo<BaoxiuxinxiInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<BaoxiuxinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = baoxiuxinxiInfoDao.findByXingming(xingming);}
		if (user.getLevel().equals("学生")) {all = baoxiuxinxiInfoDao.findByXingminglist2(xingming,user.getXuehao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<BaoxiuxinxiInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<BaoxiuxinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = baoxiuxinxiInfoDao.findByXingming(xingming);
		if (user.getLevel().equals("学生")) {all = baoxiuxinxiInfoDao.findByXingminglist2(xingming,user.getXuehao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public BaoxiuxinxiInfoVo findByUserName(String name) {
//        return baoxiuxinxiInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        BaoxiuxinxiInfo baoxiuxinxiInfo = baoxiuxinxiInfoDao.selectByPrimaryKey(id);
        if(baoxiuxinxiInfo.getStatus().equals("是")){
            baoxiuxinxiInfo.setStatus("否");
            baoxiuxinxiInfoDao.updateByPrimaryKey(baoxiuxinxiInfo);
        }else if(baoxiuxinxiInfo.getStatus().equals("否")){
            baoxiuxinxiInfo.setStatus("是");
            baoxiuxinxiInfoDao.updateByPrimaryKey(baoxiuxinxiInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}

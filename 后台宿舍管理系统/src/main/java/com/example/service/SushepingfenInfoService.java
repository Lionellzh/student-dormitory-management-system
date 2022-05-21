package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.SushepingfenInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.SushepingfenInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.SushepingfenInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class SushepingfenInfoService {

    @Resource
    private SushepingfenInfoDao sushepingfenInfoDao;
	
	//kuabiaojisuan3

    public SushepingfenInfo add(SushepingfenInfo sushepingfenInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // sushepingfenInfo.setAccount((double) 0);
	  
        sushepingfenInfoDao.insertSelective(sushepingfenInfo);
        return sushepingfenInfo;
    }

    public void delete(Long id) {
        sushepingfenInfoDao.deleteByPrimaryKey(id);
    }

    public void update(SushepingfenInfo sushepingfenInfo) {
        //shangxchxuantupxian
		//youdianzan
        sushepingfenInfoDao.updateByPrimaryKeySelective(sushepingfenInfo);
    }

    public SushepingfenInfo findById(Long id) {
        return sushepingfenInfoDao.selectByPrimaryKey(id);
    }

    public List<SushepingfenInfoVo> findAll() {
        return sushepingfenInfoDao.findBySushehao("all");
    }

    public PageInfo<SushepingfenInfoVo> findPage(String sushehao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<SushepingfenInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = sushepingfenInfoDao.findBySushehao(sushehao);}
		
        
        return PageInfo.of(all);
    }
	
	public PageInfo<SushepingfenInfoVo> findPageqt(String sushehao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<SushepingfenInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = sushepingfenInfoDao.findBySushehao(sushehao);
		
	
	
        
        return PageInfo.of(all);
    }

   // public SushepingfenInfoVo findByUserName(String name) {
//        return sushepingfenInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        SushepingfenInfo sushepingfenInfo = sushepingfenInfoDao.selectByPrimaryKey(id);
        if(sushepingfenInfo.getStatus().equals("是")){
            sushepingfenInfo.setStatus("否");
            sushepingfenInfoDao.updateByPrimaryKey(sushepingfenInfo);
        }else if(sushepingfenInfo.getStatus().equals("否")){
            sushepingfenInfo.setStatus("是");
            sushepingfenInfoDao.updateByPrimaryKey(sushepingfenInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}

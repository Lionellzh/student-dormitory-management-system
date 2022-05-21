package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.JiaofeixinxiInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.JiaofeixinxiInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.JiaofeixinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class JiaofeixinxiInfoService {

    @Resource
    private JiaofeixinxiInfoDao jiaofeixinxiInfoDao;
	
	//kuabiaojisuan3

    public JiaofeixinxiInfo add(JiaofeixinxiInfo jiaofeixinxiInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // jiaofeixinxiInfo.setAccount((double) 0);
	  
        jiaofeixinxiInfoDao.insertSelective(jiaofeixinxiInfo);
        return jiaofeixinxiInfo;
    }

    public void delete(Long id) {
        jiaofeixinxiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(JiaofeixinxiInfo jiaofeixinxiInfo) {
        //shangxchxuantupxian
		//youdianzan
        jiaofeixinxiInfoDao.updateByPrimaryKeySelective(jiaofeixinxiInfo);
    }

    public JiaofeixinxiInfo findById(Long id) {
        return jiaofeixinxiInfoDao.selectByPrimaryKey(id);
    }

    public List<JiaofeixinxiInfoVo> findAll() {
        return jiaofeixinxiInfoDao.findByXingming("all");
    }

    public PageInfo<JiaofeixinxiInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaofeixinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = jiaofeixinxiInfoDao.findByXingming(xingming);}
		if (user.getLevel().equals("学生")) {all = jiaofeixinxiInfoDao.findByXingminglist2(xingming,user.getXuehao()); }        
        
        return PageInfo.of(all);
    }
	
	public PageInfo<JiaofeixinxiInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<JiaofeixinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = jiaofeixinxiInfoDao.findByXingming(xingming);
		if (user.getLevel().equals("学生")) {all = jiaofeixinxiInfoDao.findByXingminglist2(xingming,user.getXuehao()); }        
	
	
        
        return PageInfo.of(all);
    }

   // public JiaofeixinxiInfoVo findByUserName(String name) {
//        return jiaofeixinxiInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        JiaofeixinxiInfo jiaofeixinxiInfo = jiaofeixinxiInfoDao.selectByPrimaryKey(id);
        if(jiaofeixinxiInfo.getStatus().equals("是")){
            jiaofeixinxiInfo.setStatus("否");
            jiaofeixinxiInfoDao.updateByPrimaryKey(jiaofeixinxiInfo);
        }else if(jiaofeixinxiInfo.getStatus().equals("否")){
            jiaofeixinxiInfo.setStatus("是");
            jiaofeixinxiInfoDao.updateByPrimaryKey(jiaofeixinxiInfo);
        }
    }
	public void changeIszf(Long id) {
       JiaofeixinxiInfo jiaofeixinxiInfo = jiaofeixinxiInfoDao.selectByPrimaryKey(id);
        if(jiaofeixinxiInfo.getIszf().equals("是")){
            jiaofeixinxiInfo.setIszf("否");
            jiaofeixinxiInfoDao.updateByPrimaryKey(jiaofeixinxiInfo);
        }else if(jiaofeixinxiInfo.getIszf().equals("否")){
            jiaofeixinxiInfo.setIszf("是");
            jiaofeixinxiInfoDao.updateByPrimaryKey(jiaofeixinxiInfo);
        }
    }
	//youtixing
	
	
   
}

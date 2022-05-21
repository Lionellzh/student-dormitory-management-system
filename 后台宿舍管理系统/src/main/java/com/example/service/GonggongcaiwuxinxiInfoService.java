package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.GonggongcaiwuxinxiInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.GonggongcaiwuxinxiInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.GonggongcaiwuxinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class GonggongcaiwuxinxiInfoService {

    @Resource
    private GonggongcaiwuxinxiInfoDao gonggongcaiwuxinxiInfoDao;
	
	//kuabiaojisuan3

    public GonggongcaiwuxinxiInfo add(GonggongcaiwuxinxiInfo gonggongcaiwuxinxiInfo) {
        List<Long> zhaopianflst = gonggongcaiwuxinxiInfo.getZhaopianflst();
        if (!CollectionUtil.isEmpty(zhaopianflst)) {
            gonggongcaiwuxinxiInfo.setZhaopian(zhaopianflst.toString());
        }
		
		        //shangxchxuantupxian
        // 唯一校验
        
      // gonggongcaiwuxinxiInfo.setAccount((double) 0);
	  
        gonggongcaiwuxinxiInfoDao.insertSelective(gonggongcaiwuxinxiInfo);
        return gonggongcaiwuxinxiInfo;
    }

    public void delete(Long id) {
        gonggongcaiwuxinxiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(GonggongcaiwuxinxiInfo gonggongcaiwuxinxiInfo) {
        List<Long> zhaopianflst = gonggongcaiwuxinxiInfo.getZhaopianflst();
        if (!CollectionUtil.isEmpty(zhaopianflst)) {
            gonggongcaiwuxinxiInfo.setZhaopian(zhaopianflst.toString());
        }
		
		        //shangxchxuantupxian
		//youdianzan
        gonggongcaiwuxinxiInfoDao.updateByPrimaryKeySelective(gonggongcaiwuxinxiInfo);
    }

    public GonggongcaiwuxinxiInfo findById(Long id) {
        return gonggongcaiwuxinxiInfoDao.selectByPrimaryKey(id);
    }

    public List<GonggongcaiwuxinxiInfoVo> findAll() {
        return gonggongcaiwuxinxiInfoDao.findByWupinbianhao("all");
    }

    public PageInfo<GonggongcaiwuxinxiInfoVo> findPage(String wupinbianhao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<GonggongcaiwuxinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = gonggongcaiwuxinxiInfoDao.findByWupinbianhao(wupinbianhao);}

        if (user.getLevel().equals("学生")) {all = gonggongcaiwuxinxiInfoDao.findByWupinbianhao(wupinbianhao);}
        return PageInfo.of(all);
    }
	
	public PageInfo<GonggongcaiwuxinxiInfoVo> findPageqt(String wupinbianhao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<GonggongcaiwuxinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = gonggongcaiwuxinxiInfoDao.findByWupinbianhao(wupinbianhao);
		
	
	
        
        return PageInfo.of(all);
    }

   // public GonggongcaiwuxinxiInfoVo findByUserName(String name) {
//        return gonggongcaiwuxinxiInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        GonggongcaiwuxinxiInfo gonggongcaiwuxinxiInfo = gonggongcaiwuxinxiInfoDao.selectByPrimaryKey(id);
        if(gonggongcaiwuxinxiInfo.getStatus().equals("是")){
            gonggongcaiwuxinxiInfo.setStatus("否");
            gonggongcaiwuxinxiInfoDao.updateByPrimaryKey(gonggongcaiwuxinxiInfo);
        }else if(gonggongcaiwuxinxiInfo.getStatus().equals("否")){
            gonggongcaiwuxinxiInfo.setStatus("是");
            gonggongcaiwuxinxiInfoDao.updateByPrimaryKey(gonggongcaiwuxinxiInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}

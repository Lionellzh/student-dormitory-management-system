package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.ShangfangxinxiangInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.ShangfangxinxiangInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.ShangfangxinxiangInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class ShangfangxinxiangInfoService {

    @Resource
    private ShangfangxinxiangInfoDao shangfangxinxiangInfoDao;
	
	//kuabiaojisuan3

    public ShangfangxinxiangInfo add(ShangfangxinxiangInfo shangfangxinxiangInfo) {
        //shangxchxuantupxian
        // 唯一校验
        
      // shangfangxinxiangInfo.setAccount((double) 0);
	  
        shangfangxinxiangInfoDao.insertSelective(shangfangxinxiangInfo);
        return shangfangxinxiangInfo;
    }

    public void delete(Long id) {
        shangfangxinxiangInfoDao.deleteByPrimaryKey(id);
    }

    public void update(ShangfangxinxiangInfo shangfangxinxiangInfo) {
        //shangxchxuantupxian
		//youdianzan
        shangfangxinxiangInfoDao.updateByPrimaryKeySelective(shangfangxinxiangInfo);
    }

    public ShangfangxinxiangInfo findById(Long id) {
        return shangfangxinxiangInfoDao.selectByPrimaryKey(id);
    }

    public List<ShangfangxinxiangInfoVo> findAll() {
        return shangfangxinxiangInfoDao.findByShangfangbianhao("all");
    }

    public PageInfo<ShangfangxinxiangInfoVo> findPage(String shangfangbianhao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<ShangfangxinxiangInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = shangfangxinxiangInfoDao.findByShangfangbianhao(shangfangbianhao);}

        if (user.getLevel().equals("学生")) {all = shangfangxinxiangInfoDao.findByShangfangbianhao(shangfangbianhao);}
        return PageInfo.of(all);
    }
	
	public PageInfo<ShangfangxinxiangInfoVo> findPageqt(String shangfangbianhao, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<ShangfangxinxiangInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = shangfangxinxiangInfoDao.findByShangfangbianhao(shangfangbianhao);
		
	
	
        
        return PageInfo.of(all);
    }

   // public ShangfangxinxiangInfoVo findByUserName(String name) {
//        return shangfangxinxiangInfoDao.findByUsername(name);
//    }

	//yoxulogindenxglu
	
    public void changeStatus(Long id) {
        ShangfangxinxiangInfo shangfangxinxiangInfo = shangfangxinxiangInfoDao.selectByPrimaryKey(id);
        if(shangfangxinxiangInfo.getStatus().equals("是")){
            shangfangxinxiangInfo.setStatus("否");
            shangfangxinxiangInfoDao.updateByPrimaryKey(shangfangxinxiangInfo);
        }else if(shangfangxinxiangInfo.getStatus().equals("否")){
            shangfangxinxiangInfo.setStatus("是");
            shangfangxinxiangInfoDao.updateByPrimaryKey(shangfangxinxiangInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	
	
   
}

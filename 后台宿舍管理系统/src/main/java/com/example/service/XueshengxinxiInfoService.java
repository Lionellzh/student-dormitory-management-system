package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import com.example.dao.XueshengxinxiInfoDao;
//kuabiaojisuan1
import com.example.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.entity.XueshengxinxiInfo;
//kuabiaojisuan2
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.XueshengxinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.crypto.SecureUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class XueshengxinxiInfoService {

    @Resource
    private XueshengxinxiInfoDao xueshengxinxiInfoDao;
	
	//kuabiaojisuan3

    public XueshengxinxiInfo add(XueshengxinxiInfo xueshengxinxiInfo) {
        //shangxchxuantupxian
        // 唯一校验
        int count = xueshengxinxiInfoDao.checkRepeat("xuehao", xueshengxinxiInfo.getXuehao(), null);
if (count > 0) {
	throw new CustomException("1001", "该学号\"" + xueshengxinxiInfo.getXuehao() + "\"已存在");
}
      // xueshengxinxiInfo.setAccount((double) 0);
	  
        xueshengxinxiInfoDao.insertSelective(xueshengxinxiInfo);
        return xueshengxinxiInfo;
    }

    public void delete(Long id) {
        xueshengxinxiInfoDao.deleteByPrimaryKey(id);
    }

    public void update(XueshengxinxiInfo xueshengxinxiInfo) {
        //shangxchxuantupxian
		//youdianzan
        xueshengxinxiInfoDao.updateByPrimaryKeySelective(xueshengxinxiInfo);
    }

    public XueshengxinxiInfo findById(Long id) {
        return xueshengxinxiInfoDao.selectByPrimaryKey(id);
    }

    public List<XueshengxinxiInfoVo> findAll() {
        return xueshengxinxiInfoDao.findByXingming("all");
    }

    public PageInfo<XueshengxinxiInfoVo> findPage(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<XueshengxinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        if (user.getLevel().equals("管理员")) {all = xueshengxinxiInfoDao.findByXingming(xingming);}
		
        
        return PageInfo.of(all);
    }
	
	public PageInfo<XueshengxinxiInfoVo> findPageqt(String xingming, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
		
		List<XueshengxinxiInfoVo> all=null;
        Account user = (Account) request.getSession().getAttribute("user");
        all = xueshengxinxiInfoDao.findByXingming(xingming);
		
	
	
        
        return PageInfo.of(all);
    }

   // public XueshengxinxiInfoVo findByUserName(String name) {
//        return xueshengxinxiInfoDao.findByUsername(name);
//    }

	public XueshengxinxiInfo login(String xuehao, String mima) {
        XueshengxinxiInfo xueshengxinxiInfo = xueshengxinxiInfoDao.findByXuehaozj(xuehao);
        if (xueshengxinxiInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(mima).equalsIgnoreCase(xueshengxinxiInfo.getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return xueshengxinxiInfo;
    }
	
    public void changeStatus(Long id) {
        XueshengxinxiInfo xueshengxinxiInfo = xueshengxinxiInfoDao.selectByPrimaryKey(id);
        if(xueshengxinxiInfo.getStatus().equals("是")){
            xueshengxinxiInfo.setStatus("否");
            xueshengxinxiInfoDao.updateByPrimaryKey(xueshengxinxiInfo);
        }else if(xueshengxinxiInfo.getStatus().equals("否")){
            xueshengxinxiInfo.setStatus("是");
            xueshengxinxiInfoDao.updateByPrimaryKey(xueshengxinxiInfo);
        }
    }
	//ddaizdhifu
	//youtixing
	 public void update2(XueshengxinxiInfoVo xueshengxinxiInfo) {
        //shangxchxuantupxian
        if (StringUtils.isEmpty(xueshengxinxiInfo.getMima())) {
            // 默认密码123456
            xueshengxinxiInfo.setMima(SecureUtil.md5("123456"));
        } else {
            xueshengxinxiInfo.setMima(SecureUtil.md5(xueshengxinxiInfo.getMima()));
        }
        xueshengxinxiInfoDao.updateByPrimaryKeySelective(xueshengxinxiInfo);
    }
	
   
}

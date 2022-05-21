package com.example.dao;

import com.example.entity.JiaofeixinxiInfo;
import com.example.vo.JiaofeixinxiInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface JiaofeixinxiInfoDao extends Mapper<JiaofeixinxiInfo> {
    List<JiaofeixinxiInfoVo> findByXingming(@Param("xingming") String xingming);
	List<JiaofeixinxiInfoVo> findByXingminglist2(@Param("xingming") String xingming,@Param("xuehao") String xuehao);        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from jiaofeixinxi_info where xuehao = #{xuehao}")
    JiaofeixinxiInfo selectByXuehao(String xuehao);
	
	@Select("SELECT * FROM jiaofeixinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}

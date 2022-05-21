package com.example.dao;

import com.example.entity.LixiaoshenqingInfo;
import com.example.vo.LixiaoshenqingInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface LixiaoshenqingInfoDao extends Mapper<LixiaoshenqingInfo> {
    List<LixiaoshenqingInfoVo> findByXingming(@Param("xingming") String xingming);
	List<LixiaoshenqingInfoVo> findByXingminglist2(@Param("xingming") String xingming,@Param("xuehao") String xuehao);        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from lixiaoshenqing_info where xuehao = #{xuehao}")
    LixiaoshenqingInfo selectByXuehao(String xuehao);
	
	@Select("SELECT * FROM lixiaoshenqing_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}

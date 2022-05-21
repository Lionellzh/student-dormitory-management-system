package com.example.dao;

import com.example.entity.BaoxiuxinxiInfo;
import com.example.vo.BaoxiuxinxiInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface BaoxiuxinxiInfoDao extends Mapper<BaoxiuxinxiInfo> {
    List<BaoxiuxinxiInfoVo> findByXingming(@Param("xingming") String xingming);
	List<BaoxiuxinxiInfoVo> findByXingminglist2(@Param("xingming") String xingming,@Param("xuehao") String xuehao);        
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from baoxiuxinxi_info where xuehao = #{xuehao}")
    BaoxiuxinxiInfo selectByXuehao(String xuehao);
	
	@Select("SELECT * FROM baoxiuxinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}

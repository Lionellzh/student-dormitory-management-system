package com.example.dao;

import com.example.entity.SushepingfenInfo;
import com.example.vo.SushepingfenInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface SushepingfenInfoDao extends Mapper<SushepingfenInfo> {
    List<SushepingfenInfoVo> findBySushehao(@Param("sushehao") String sushehao);
	
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from sushepingfen_info where sushehao = #{sushehao}")
    SushepingfenInfo selectBySushehao(String sushehao);
	
	@Select("SELECT * FROM sushepingfen_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}

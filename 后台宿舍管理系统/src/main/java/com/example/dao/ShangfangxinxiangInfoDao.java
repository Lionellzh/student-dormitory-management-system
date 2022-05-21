package com.example.dao;

import com.example.entity.ShangfangxinxiangInfo;
import com.example.vo.ShangfangxinxiangInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface ShangfangxinxiangInfoDao extends Mapper<ShangfangxinxiangInfo> {
    List<ShangfangxinxiangInfoVo> findByShangfangbianhao(@Param("shangfangbianhao") String shangfangbianhao);
	
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from shangfangxinxiang_info where shangfangbianhao = #{shangfangbianhao}")
    ShangfangxinxiangInfo selectByShangfangbianhao(String shangfangbianhao);
	
	@Select("SELECT * FROM shangfangxinxiang_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}

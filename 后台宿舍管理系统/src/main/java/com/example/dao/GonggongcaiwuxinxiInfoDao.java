package com.example.dao;

import com.example.entity.GonggongcaiwuxinxiInfo;
import com.example.vo.GonggongcaiwuxinxiInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface GonggongcaiwuxinxiInfoDao extends Mapper<GonggongcaiwuxinxiInfo> {
    List<GonggongcaiwuxinxiInfoVo> findByWupinbianhao(@Param("wupinbianhao") String wupinbianhao);
	
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from gonggongcaiwuxinxi_info where wupinbianhao = #{wupinbianhao}")
    GonggongcaiwuxinxiInfo selectByWupinbianhao(String wupinbianhao);
	
	@Select("SELECT * FROM gonggongcaiwuxinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	
	
	
    
	
	

}

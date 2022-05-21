package com.example.dao;

import com.example.entity.XueshengxinxiInfo;
import com.example.vo.XueshengxinxiInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface XueshengxinxiInfoDao extends Mapper<XueshengxinxiInfo> {
    List<XueshengxinxiInfoVo> findByXingming(@Param("xingming") String xingming);
	
    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);
    
    Integer count();
	
	@Select("select * from xueshengxinxi_info where xuehao = #{xuehao}")
    XueshengxinxiInfo selectByXuehao(String xuehao);
	
	@Select("SELECT * FROM xueshengxinxi_info order by id")
    List<Map<String, Object>> daochuexcel();
	
	
	
	@Select("SELECT distinct(xingbie) as aa,count(id) as bb FROM xueshengxinxi_info group by xingbie order by id")
List<Map<String, Object>> xueshengxinxi_tj_xingbie();
@Select("SELECT distinct(sushehao) as aa,count(id) as bb FROM xueshengxinxi_info group by sushehao order by id")
List<Map<String, Object>> xueshengxinxi_tj_sushehao();
@Select("SELECT distinct(banji) as aa,count(id) as bb FROM xueshengxinxi_info group by banji order by id")
List<Map<String, Object>> xueshengxinxi_tj_banji();


	
	XueshengxinxiInfoVo findByXuehaozj(String xuehao);

}

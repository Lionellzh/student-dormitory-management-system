package com.example.controller;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.XueshengxinxiInfo;
import com.example.dao.XueshengxinxiInfoDao;
import com.example.service.XueshengxinxiInfoService;
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.EchartsData;
import com.example.vo.XueshengxinxiInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/xueshengxinxiInfo")
public class XueshengxinxiInfoController {

    @Resource
    private XueshengxinxiInfoService xueshengxinxiInfoService;
	@Resource
    private XueshengxinxiInfoDao xueshengxinxiInfoDao;

    @PostMapping
    public Result<XueshengxinxiInfo> add(@RequestBody XueshengxinxiInfoVo xueshengxinxiInfo) {
        
		xueshengxinxiInfo.setMima(SecureUtil.md5(xueshengxinxiInfo.getMima()));
		xueshengxinxiInfoService.add(xueshengxinxiInfo);
        return Result.success(xueshengxinxiInfo);
    }
	
	//youtixing1
    //youtixing2

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        xueshengxinxiInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody XueshengxinxiInfoVo xueshengxinxiInfo) {
        xueshengxinxiInfoService.update(xueshengxinxiInfo);
        return Result.success();
    }
    //@PutMapping("/update2")
//    public Result update2(@RequestBody XueshengxinxiInfoVo xueshengxinxiInfo) {
//        xueshengxinxiInfoService.update2(xueshengxinxiInfo);
//        return Result.success();
//    }
    @GetMapping("/{id}")
    public Result<XueshengxinxiInfo> detail(@PathVariable Long id) {
        XueshengxinxiInfo xueshengxinxiInfo = xueshengxinxiInfoService.findById(id);
        return Result.success(xueshengxinxiInfo);
    }
    @GetMapping("/changeStatus/{id}")
    public Result<XueshengxinxiInfo> changeStatus(@PathVariable Long id) {
        xueshengxinxiInfoService.changeStatus(id);
        return Result.success();
    }
	

    @GetMapping
    public Result<List<XueshengxinxiInfoVo>> all() {
        return Result.success(xueshengxinxiInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<XueshengxinxiInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(xueshengxinxiInfoService.findPage(name, pageNum, pageSize, request));
    }
	
	 @GetMapping("/pageqt/{name}")
    public Result<PageInfo<XueshengxinxiInfoVo>> pageqt(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "8") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(xueshengxinxiInfoService.findPageqt(name, pageNum, pageSize, request));
    }

   // @PostMapping("/register")
//    public Result<XueshengxinxiInfo> register(@RequestBody XueshengxinxiInfo xueshengxinxiInfo) {
//        if (StrUtil.isBlank(xueshengxinxiInfo.getName()) || StrUtil.isBlank(xueshengxinxiInfo.getPassword())) {
//            throw new CustomException(ResultCode.PARAM_ERROR);
//        }
//        return Result.success(xueshengxinxiInfoService.add(xueshengxinxiInfo));
//    }

    /**
    * 批量通过excel添加信息
    * @param file excel文件
    * @throws IOException
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<XueshengxinxiInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(XueshengxinxiInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // 处理一下空数据
            List<XueshengxinxiInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getXingming())).collect(Collectors.toList());
            for (XueshengxinxiInfo info : resultList) {
                xueshengxinxiInfoService.add(info);
            }
        }
        return Result.success();
    }
	@GetMapping("/get/xueshengxinxi_tj_xingbie")
    Result<List<EchartsData>> xueshengxinxi_tj_xingbie() {
        List<EchartsData> list = new ArrayList<>();
        List<Map<String, Object>> xueshengxinxi_tj_xingbieList = xueshengxinxiInfoDao.xueshengxinxi_tj_xingbie();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : xueshengxinxi_tj_xingbieList) {

            typeMap.put((String)map.get("aa"), (Double.valueOf((String)map.get("bb").toString())));

        }
        getPieData("学生信息按性别统计", list, typeMap);
        getBarData("学生信息按性别统计", list, typeMap);
        return Result.success(list);
    }@GetMapping("/get/xueshengxinxi_tj_sushehao")
    Result<List<EchartsData>> xueshengxinxi_tj_sushehao() {
        List<EchartsData> list = new ArrayList<>();
        List<Map<String, Object>> xueshengxinxi_tj_sushehaoList = xueshengxinxiInfoDao.xueshengxinxi_tj_sushehao();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : xueshengxinxi_tj_sushehaoList) {

            typeMap.put((String)map.get("aa"), (Double.valueOf((String)map.get("bb").toString())));

        }
        getPieData("学生信息按宿舍号统计", list, typeMap);
        getBarData("学生信息按宿舍号统计", list, typeMap);
        return Result.success(list);
    }@GetMapping("/get/xueshengxinxi_tj_banji")
    Result<List<EchartsData>> xueshengxinxi_tj_banji() {
        List<EchartsData> list = new ArrayList<>();
        List<Map<String, Object>> xueshengxinxi_tj_banjiList = xueshengxinxiInfoDao.xueshengxinxi_tj_banji();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : xueshengxinxi_tj_banjiList) {

            typeMap.put((String)map.get("aa"), (Double.valueOf((String)map.get("bb").toString())));

        }
        getPieData("学生信息按班级统计", list, typeMap);
        getBarData("学生信息按班级统计", list, typeMap);
        return Result.success(list);
    }
    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
		row.put("xuehao", "A学号");row.put("mima", "A密码");row.put("xingming", "A姓名");row.put("xingbie", "A性别");row.put("shenfenzheng", "A身份证");row.put("dianhua", "A电话");row.put("sushehao", "A宿舍号");row.put("banji", "A班级");row.put("fangjianhao", "A房间号");row.put("jiankangma", "A健康码");row.put("beizhu", "A备注");
		row.put("status", "是");
		row.put("level", "xueshengxinxi");

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=xueshengxinxiInfoModel.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	@GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("xuehao", "A学号");row.put("mima", "A密码");row.put("xingming", "A姓名");row.put("xingbie", "A性别");row.put("shenfenzheng", "A身份证");row.put("dianhua", "A电话");row.put("sushehao", "A宿舍号");row.put("banji", "A班级");row.put("fangjianhao", "A房间号");row.put("jiankangma", "A健康码");row.put("beizhu", "A备注");

        row.put("status", "是");
        row.put("level", "权限");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = xueshengxinxiInfoDao.daochuexcel();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=xueshengxinxiInfo.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	private void getPieData(String name, List<EchartsData> pieList, Map<String, Double> dataMap) {
        EchartsData pieData = new EchartsData();
        EchartsData.Series series = new EchartsData.Series();

        Map<String, String> titleMap = new HashMap<>(2);
        titleMap.put("text", name);
        pieData.setTitle(titleMap);

        series.setName(name + "比例");
        series.setType("pie");
        series.setRadius("55%");

        List<Object> objects = new ArrayList<>();
        List<Object> legendList = new ArrayList<>();
        for (String key : dataMap.keySet()) {
            Double value = dataMap.get(key);
            objects.add(new JSONObject().putOpt("name", key).putOpt("value", value));
            legendList.add(key);
        }
        series.setData(objects);

        pieData.setSeries(Collections.singletonList(series));
        Map<String, Boolean> map = new HashMap<>();
        map.put("show", true);
        pieData.setTooltip(map);

        Map<String, Object> legendMap = new HashMap<>(4);
        legendMap.put("orient", "vertical");
        legendMap.put("x", "left");
        legendMap.put("y", "center");
        legendMap.put("data", legendList);
        pieData.setLegend(legendMap);

        pieList.add(pieData);
    }

    private void getBarData(String name, List<EchartsData> barList, Map<String, Double> dataMap) {
        EchartsData barData = new EchartsData();
        EchartsData.Series series = new EchartsData.Series();

        List<Object> seriesObjs = new ArrayList<>();
        List<Object> xAxisObjs = new ArrayList<>();
        for (String key : dataMap.keySet()) {
            Double value = dataMap.get(key);
            xAxisObjs.add(key);
            seriesObjs.add(value);
        }

        series.setType("bar");
        series.setName(name);
        series.setData(seriesObjs);
        barData.setSeries(Collections.singletonList(series));

        Map<String, Object> xAxisMap = new HashMap<>(1);
        xAxisMap.put("data", xAxisObjs);
        barData.setxAxis(xAxisMap);

        barData.setyAxis(new HashMap<>());

        Map<String, Object> legendMap = new HashMap<>(1);
        legendMap.put("data", Collections.singletonList(name));
        barData.setLegend(legendMap);

        Map<String, Boolean> map = new HashMap<>(1);
        map.put("show", true);
        barData.setTooltip(map);

        Map<String, String> titleMap = new HashMap<>(1);
        titleMap.put("text", name);
        barData.setTitle(titleMap);

        barList.add(barData);
    }
}
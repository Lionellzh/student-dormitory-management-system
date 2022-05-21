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
import com.example.entity.ShangfangxinxiangInfo;
import com.example.dao.ShangfangxinxiangInfoDao;
import com.example.service.ShangfangxinxiangInfoService;
import com.example.exception.CustomException;
import com.example.common.ResultCode;
import com.example.vo.EchartsData;
import com.example.vo.ShangfangxinxiangInfoVo;
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
@RequestMapping(value = "/shangfangxinxiangInfo")
public class ShangfangxinxiangInfoController {

    @Resource
    private ShangfangxinxiangInfoService shangfangxinxiangInfoService;
	@Resource
    private ShangfangxinxiangInfoDao shangfangxinxiangInfoDao;

    @PostMapping
    public Result<ShangfangxinxiangInfo> add(@RequestBody ShangfangxinxiangInfoVo shangfangxinxiangInfo) {
        
		//mixmajixami
		shangfangxinxiangInfoService.add(shangfangxinxiangInfo);
        return Result.success(shangfangxinxiangInfo);
    }
	
	//youtixing1
    //youtixing2

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        shangfangxinxiangInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ShangfangxinxiangInfoVo shangfangxinxiangInfo) {
        shangfangxinxiangInfoService.update(shangfangxinxiangInfo);
        return Result.success();
    }
    //@PutMapping("/update2")
//    public Result update2(@RequestBody ShangfangxinxiangInfoVo shangfangxinxiangInfo) {
//        shangfangxinxiangInfoService.update2(shangfangxinxiangInfo);
//        return Result.success();
//    }
    @GetMapping("/{id}")
    public Result<ShangfangxinxiangInfo> detail(@PathVariable Long id) {
        ShangfangxinxiangInfo shangfangxinxiangInfo = shangfangxinxiangInfoService.findById(id);
        return Result.success(shangfangxinxiangInfo);
    }
    @GetMapping("/changeStatus/{id}")
    public Result<ShangfangxinxiangInfo> changeStatus(@PathVariable Long id) {
        shangfangxinxiangInfoService.changeStatus(id);
        return Result.success();
    }
	

    @GetMapping
    public Result<List<ShangfangxinxiangInfoVo>> all() {
        return Result.success(shangfangxinxiangInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<ShangfangxinxiangInfoVo>> page(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(shangfangxinxiangInfoService.findPage(name, pageNum, pageSize, request));
    }
	
	 @GetMapping("/pageqt/{name}")
    public Result<PageInfo<ShangfangxinxiangInfoVo>> pageqt(@PathVariable String name,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "8") Integer pageSize,
                                                HttpServletRequest request) {
        return Result.success(shangfangxinxiangInfoService.findPageqt(name, pageNum, pageSize, request));
    }

   // @PostMapping("/register")
//    public Result<ShangfangxinxiangInfo> register(@RequestBody ShangfangxinxiangInfo shangfangxinxiangInfo) {
//        if (StrUtil.isBlank(shangfangxinxiangInfo.getName()) || StrUtil.isBlank(shangfangxinxiangInfo.getPassword())) {
//            throw new CustomException(ResultCode.PARAM_ERROR);
//        }
//        return Result.success(shangfangxinxiangInfoService.add(shangfangxinxiangInfo));
//    }

    /**
    * 批量通过excel添加信息
    * @param file excel文件
    * @throws IOException
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {

        List<ShangfangxinxiangInfo> infoList = ExcelUtil.getReader(file.getInputStream()).readAll(ShangfangxinxiangInfo.class);
        if (!CollectionUtil.isEmpty(infoList)) {
            // 处理一下空数据
            List<ShangfangxinxiangInfo> resultList = infoList.stream().filter(x -> ObjectUtil.isNotEmpty(x.getShangfangbianhao())).collect(Collectors.toList());
            for (ShangfangxinxiangInfo info : resultList) {
                shangfangxinxiangInfoService.add(info);
            }
        }
        return Result.success();
    }
	//yoxutonxgjitu
    @GetMapping("/getExcelModel")
    public void getExcelModel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
		row.put("shangfangbianhao", "A上访编号");row.put("shangfangbiaoti", "A上访标题");row.put("shangfangneirong", "A上访内容");
		row.put("status", "是");
		row.put("level", "shangfangxinxiang");

        List<Map<String, Object>> list = CollUtil.newArrayList(row);

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=shangfangxinxiangInfoModel.xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	@GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("shangfangbianhao", "A上访编号");row.put("shangfangbiaoti", "A上访标题");row.put("shangfangneirong", "A上访内容");

        row.put("status", "是");
        row.put("level", "权限");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = shangfangxinxiangInfoDao.daochuexcel();
        Map<String, Double> typeMap = new HashMap<>();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=shangfangxinxiangInfo.xlsx");

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
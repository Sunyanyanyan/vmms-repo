package com.zckj.vmms.vmms.controller;


import com.zckj.vmms.utils.ColumnTitleMap;
import com.zckj.vmms.vmms.service.DetailService;
import com.zckj.vmms.vmms.service.ExportDataService;
import com.zckj.vmms.vmms.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @desc:数据导出api控制器
 * @author: sunyan
 * @time: 2020.6.5
 */

@Controller
@RequestMapping(value = "/exportdata")
@Slf4j
@Api(tags = "导出数据到excel接口")
public class ExportDataController {

    @Autowired
    private ExportDataService exportDataService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DetailService detailService;

    /**
     * @param response   返回对象
     * @param date_start 筛选时间，开始(预留，查询时并未做筛选数据处理)
     * @param date_end   筛选时间，结束(预留，查询时并未做筛选数据处理)
     * @method: GET
     * @desc: 导出数据，生成xlsx文件
     */
    @GetMapping(value = "/excel/order")
    @ApiOperation(value = "导出工单表")
    public void getOrderInfoExcel(HttpServletResponse response,
                                  @RequestParam(required = false) String date_start,
                                  @RequestParam(required = false) String date_end) {
        try {
            List<Map<String, Object>> orderList = orderService.listMaps();
            ArrayList<String> titleKeyList = new ColumnTitleMap("orderInfo").getTitleKeyList();
            Map<String, String> titleMap = new ColumnTitleMap("orderInfo").getColumnTitleMap();
            exportDataService.exportDataToExcel(response, titleKeyList, titleMap, orderList);
        } catch (Exception e) {
            //
            System.out.println(e.toString());
        }
    }

    /**
     * @param response   返回对象
     * @param date_start 筛选时间，开始(预留，查询时并未做筛选数据处理)
     * @param date_end   筛选时间，结束(预留，查询时并未做筛选数据处理)
     * @method: GET
     * @desc: 导出数据，生成xlsx文件
     */
    @GetMapping(value = "/excel/detail")
    @ApiOperation(value = "导出维修清单表")
    public void getDetailListExcel(HttpServletResponse response,
                                   @RequestParam(required = false) String date_start,
                                   @RequestParam(required = false) String date_end) {

        try {
            List<Map<String, Object>> orderList = detailService.listMaps();
            ArrayList<String> titleKeyList = new ColumnTitleMap("detailList").getTitleKeyList();
            Map<String, String> titleMap = new ColumnTitleMap("detailList").getColumnTitleMap();
            exportDataService.exportDataToExcel(response, titleKeyList, titleMap, orderList);
        } catch (Exception e) {
            //
            System.out.println(e.toString());
        }
    }
}


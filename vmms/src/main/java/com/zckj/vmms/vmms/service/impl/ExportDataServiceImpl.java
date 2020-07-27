package com.zckj.vmms.vmms.service.impl;

import com.zckj.vmms.utils.ExportExcelUtil;
import com.zckj.vmms.vmms.service.ExportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExportDataServiceImpl implements ExportDataService {

    @Autowired
    ExportExcelUtil exportExcelUtil;

    /*导出数据表*/
    public void exportDataToExcel(HttpServletResponse response, ArrayList<String> titleKeyList, Map<String, String> titleMap, List<Map<String,Object>> src_list) {
        try {
            exportExcelUtil.expoerDataExcel(response, titleKeyList, titleMap, src_list);
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        }
    }
}

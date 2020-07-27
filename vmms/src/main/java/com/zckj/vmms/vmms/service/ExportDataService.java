package com.zckj.vmms.vmms.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @desc:数据导出服务
 * @author: sunyan
 * @time: 2020.6.5
 */
public interface ExportDataService {

    /*导出用户数据表*/
    void exportDataToExcel(HttpServletResponse response, ArrayList<String> titleKeyList, Map<String, String> titleMap, List<Map<String,Object>> src_list);
}


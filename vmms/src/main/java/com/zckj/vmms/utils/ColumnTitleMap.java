package com.zckj.vmms.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc:数据导出，生成excel文件时的列名称集合
 * @author: sunyan
 * @time: 2020.6.5
 */
public class ColumnTitleMap {
    private Map<String, String> columnTitleMap = new HashMap<String, String>();
    private ArrayList<String> titleKeyList = new ArrayList<String> ();

    public ColumnTitleMap(String datatype) {
        switch (datatype) {
            case "orderInfo":
                initOrderInfoColu();
                initOrderInfoTitleKeyList();
                break;
            case "detailList":
                initDetailListColu();
                initDetailListTitleKeyList();
                break;
            default:
                break;
        }

    }
    /**
     * mysql工单表需要导出字段--显示名称对应集合
     */
    private void initOrderInfoColu() {
        columnTitleMap.put("order_id", "ID");
        columnTitleMap.put("shop_id", "维修厂编号");
        columnTitleMap.put("car_id", "车牌号");
        columnTitleMap.put("region_number", "车辆所属单位编号");
        columnTitleMap.put("application_time", "申请时间");
        columnTitleMap.put("applicant_name", "申请人姓名");
        columnTitleMap.put("applicant_id", "申请人编号");
        columnTitleMap.put("status", "状态");
        columnTitleMap.put("repair_nature", "维修性质");
        columnTitleMap.put("before_img_url", "维修前照片路径");
        columnTitleMap.put("after_img_url", "维修后照片路径");
        columnTitleMap.put("damage_img_url", "损坏件照片路径");
        columnTitleMap.put("repair_desc", "故障描述");
        columnTitleMap.put("start_time", "维修开始时间");
        columnTitleMap.put("end_time", "维修结束时间");
        columnTitleMap.put("export_status", "导出标志[0-未导出;1-已导出]");
        columnTitleMap.put("longitude", "经度");
        columnTitleMap.put("latitude", "纬度");
    }

    /**
     * mysql工单表需要导出字段集
     */
    private void initOrderInfoTitleKeyList() {
        titleKeyList.add("order_id");
        titleKeyList.add("shop_id");
        titleKeyList.add("car_id");
        titleKeyList.add("region_number");
        titleKeyList.add("application_time");
        titleKeyList.add("applicant_name");
        titleKeyList.add("applicant_id");
        titleKeyList.add("status");
        titleKeyList.add("repair_nature");
        titleKeyList.add("before_img_url");
        titleKeyList.add("after_img_url");
        titleKeyList.add("damage_img_url");
        titleKeyList.add("repair_desc");
        titleKeyList.add("start_time");
        titleKeyList.add("end_time");
        titleKeyList.add("export_status");
        titleKeyList.add("longitude");
        titleKeyList.add("latitude");
    }
    /**
     * mysql维修清单表需要导出字段--显示名称对应集合
     */
    private void initDetailListColu() {
        columnTitleMap.put("detail_id", "ID");
        columnTitleMap.put("order_id", "所属工单编号");
        columnTitleMap.put("item", "项目名称");
        columnTitleMap.put("item_bill", "项目费用");
    }

    /**
     * mysql维修清单表需要导出字段集
     */
    private void initDetailListTitleKeyList() {
        titleKeyList.add("detail_id");
        titleKeyList.add("order_id");
        titleKeyList.add("item");
        titleKeyList.add("item_bill");
    }

    public Map<String, String> getColumnTitleMap() {
        return columnTitleMap;
    }

    public ArrayList<String> getTitleKeyList() {
        return titleKeyList;
    }
}

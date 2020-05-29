package com.zckj.vmms.utils;


import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class IdUtil {
    /**
     * 自定义主键：年份+5位流水号
     * @param lastId   最后一条记录主键值
     * @return
     */
    public static Integer getNewId(int lastId){
        String lastIdStr = String.valueOf(lastId);
//        String yearStr = lastIdStr.substring(0, 4);
        String serialStr = lastIdStr.substring(4);
        Date date = DateUtil.date();
        String yearStr = String.valueOf(DateUtil.year(date));

        String newSerialStr = "00001";
        if(!serialStr.isEmpty()){
            int serial = Integer.parseInt(serialStr);
            if (serial == 99999){
                serial = 0;
            }
            int newSerial = serial + 1;
            newSerialStr = String.format(yearStr + "%05d", newSerial);
        }

        return Integer.parseInt(newSerialStr);
    }

    public static void main(String[] args) {
        Integer equipmentNo = IdUtil.getNewId(202099999);
        System.out.println("生成设备编号：" + equipmentNo);
    }
}

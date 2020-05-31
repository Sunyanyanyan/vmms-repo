package com.zckj.vmms.utils;


import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class IdUtil {
    /**
     * 自定义主键：年份+5位流水号，如：202000001
     * @param lastId   最后一条记录主键值
     * @return
     */
    public static Integer getOrderId(int lastId){
        String lastIdStr = String.valueOf(lastId);
        //舍弃前4位
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

    /**
     * 自定义主键：3位流水号，如：101
     * @param lastId   最后一条记录主键值
     * @return
     */
    public static Integer getDetailId(int lastId){
        if (lastId == 999){
            lastId = 0;
        }
        lastId++;
        String format = String.format("%03d", lastId);
        return  Integer.parseInt(format);
    }
}

package com.zckj.vmms.vmms.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.vmms.utils.*;
import com.zckj.vmms.vmms.dao.DetailDao;
import com.zckj.vmms.vmms.dao.OrderDao;
import com.zckj.vmms.vmms.entity.DetailEntity;
import com.zckj.vmms.vmms.entity.OrderEntity;
import com.zckj.vmms.vmms.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;


@Service("orderService")
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private DetailDao detailDao;

    /**
     * 添加维修申请
     *
     * @param attribute
     * @param description
     */
    @Override
    public int saveOrder(String attribute, String description) {
        OrderEntity orderEntity = new OrderEntity();
        DetailEntity detailEntity = new DetailEntity();
        String lastIdStr = orderDao.queryMaxOrderId();

        if (lastIdStr != null) {
            int lastId = Integer.parseInt(lastIdStr);
            Integer orderId = IdUtil.getOrderId(lastId);

            orderEntity.setOrderId(orderId);
        }

        String now = DateUtil.now();
        orderEntity.setApplicationTime(now);
        orderEntity.setAttribute(attribute);
        orderEntity.setDescription(description);
        orderEntity.setStatus("待审批");
        int insert = orderDao.insert(orderEntity);
        //往清单表插入所属工单编号
        Integer orderId = orderEntity.getOrderId();
        detailEntity.setOrderId(orderId);
        detailDao.insert(detailEntity);

        return insert;
    }

//    @Override
//    public R uploadImg(MultipartFile[] multipartFile, String picture) {
//        OrderEntity orderEntity = new OrderEntity();
//        try {
//            String dir="E:/tomcat9/webapps/img";
//            File fileDir=new File(dir);
//            if(!fileDir.exists()) {
//                fileDir.mkdirs();
//            }
//            for (int i = 0; i < multipartFile.length; i++) {
//                String fileSuffix=multipartFile[i].getOriginalFilename().substring(multipartFile[i].getOriginalFilename().lastIndexOf("."));
//                String fileName= UUID.randomUUID().toString()+fileSuffix;
//                File file=new File(fileDir+"/"+fileName);
//                multipartFile[i].transferTo(file);
//                R.ok("图片上传成功");
//                log.info("----------"+fileName);
//                orderEntity.setBeforeImgUrl();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            R.error("图片上传失败");
//        }
//        return R.ok();
//    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

}
package com.zckj.vmms.vmms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zckj.vmms.utils.IdUtil;
import com.zckj.vmms.utils.PageUtils;
import com.zckj.vmms.utils.Query;
import com.zckj.vmms.vmms.dao.DetailDao;
import com.zckj.vmms.vmms.entity.DetailEntity;
import com.zckj.vmms.vmms.entity.OrderEntity;
import com.zckj.vmms.vmms.service.DetailService;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("detailService")
public class DetailServiceImpl extends ServiceImpl<DetailDao, DetailEntity> implements DetailService {

    @Autowired
    private DetailDao detailDao;


    @Override
    public int saveDetail(DetailEntity detail) {
        String lastIdStr = detailDao.queryMaxDetailId();

        if (lastIdStr != null) {
            int lastId = Integer.parseInt(lastIdStr);
            Integer detailId = IdUtil.getDetailId(lastId);
            detail.setDetailId(detailId);
        }

        OrderEntity orderEntity = new OrderEntity();
        Integer orderId = orderEntity.getOrderId();
        detail.setOrderId(orderId);

        return detailDao.insert(detail);
    }

    /**
     * 导出excel
     * @return
     */
/*    @Override
    public XSSFWorkbook show() {
        List<DetailEntity> list = detailDao.selectList(null);//查出数据库数据
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("维修清单");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("序号");//第一列
        titleRow.createCell(1).setCellValue("ID");
        titleRow.createCell(2).setCellValue("所属工单编号");
        titleRow.createCell(3).setCellValue("项目名称");
//        titleRow.createCell(4).setCellValue("项目费用");
        int cell = 1;
        for (DetailEntity detailEntity : list) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(cell);
            row.createCell(1).setCellValue(detailEntity.getDetailId());//将数据库的数据遍历出来
            row.createCell(2).setCellValue(detailEntity.getOrderId());
            row.createCell(3).setCellValue(detailEntity.getItem());
//            row.createCell(4).setCellValue((RichTextString) detailEntity.getItemBill());
            cell++;
        }
        return wb;
    }*/

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DetailEntity> page = this.page(
                new Query<DetailEntity>().getPage(params),
                new QueryWrapper<DetailEntity>()
        );

        return new PageUtils(page);
    }
}
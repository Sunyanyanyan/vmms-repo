package com.zckj.vmms.utils;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class FileUploadUtil {

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    public static String uploadFile(MultipartFile file) {

        String url = null;

        if (file.isEmpty()) {
            return "文件为空";
        } else {
            //保存时的文件名
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();
            String timeName = df.format(calendar.getTime());
            //文件重新命名
            Random random = new Random();
            String fileNameAuto = String.format("_%X", random.nextInt());
            String name = file.getOriginalFilename();
            int pos = name.lastIndexOf(".");
            //获取文件名后缀Fi
            String ext = name.substring(pos);
            String fileName = timeName + fileNameAuto + ext;

//            log.info("fileName:"+fileName);
            //保存文件的绝对路径
            WebApplicationContext webApplicationContext = (WebApplicationContext) SpringContextUtils.applicationContext;
            ServletContext servletContext = webApplicationContext.getServletContext();
//            String realPath = servletContext.getRealPath("/");
//            log.info("realPath:"+realPath);
//            String filePath = realPath + "WEB-INF"+File.separator + "classes" + File.separator +"static" + File.separator + "resource" + File.separator+fileName;

            String filePath = "D:/fileUpload/" + fileName;
//            log.info("绝对路径:" + filePath);
            File newFile = new File(filePath);

            //MultipartFile的方法直接写文件
            try {

                //上传文件
                file.transferTo(newFile);

                //数据库存储的相对路径
                String projectPath = servletContext.getContextPath();
                HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
                String contextpath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + projectPath;
                //url="http://你自己的域名/项目名/images/"+fileName;//正式项目
                url = contextpath + "/images/" + fileName;//本地运行项目
//                log.info("保存文件路径：" + filePath);
//                log.info("相对路径:" + url);
                //文件URL存入数据库表
//                orderEntity.setBeforeImgUrl(url);
//                boolean flag = orderService.save(orderEntity);
//
//                if (flag) {
////                    Collection<OrderEntity> orderEntities = orderService.list();
//
//                    return R.ok().put("添加成功", flag);
//                } else {
//                    return R.ok().put("添加失败", null);
//                }
//
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }

        }
        return url;
    }
}

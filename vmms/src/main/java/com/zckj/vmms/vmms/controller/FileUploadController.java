package com.zckj.vmms.vmms.controller;

import com.zckj.vmms.utils.HttpContextUtils;
import com.zckj.vmms.utils.R;
import com.zckj.vmms.utils.SpringContextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Api("上传图片至云服务器")
@CrossOrigin//跨域
@RestController
@RequestMapping("/vmms/order")
public class FileUploadController {

    @ApiOperation(value = "图片上传")
    @PostMapping(value = "/uploadFile", produces = "application/json;charset=UTF-8")
    public R upLoadAccessory(@ApiParam(name = "file", value = "文件", required = true)
                                 @RequestParam("file") MultipartFile file){

        Map<String,Object> map = new HashMap<>();

        if (file.isEmpty()) {
            return R.ok(map);

        }else {

            //保存时的文件名
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();
            String dateName = df.format(calendar.getTime())+file.getOriginalFilename();

            System.out.println(dateName);
            //保存文件的绝对路径
            WebApplicationContext webApplicationContext = (WebApplicationContext) SpringContextUtils.applicationContext;
            ServletContext servletContext = webApplicationContext.getServletContext();
//            String realPath = servletContext.getRealPath("/");
//            String filePath = realPath + "WEB-INF"+File.separator + "classes" + File.separator +"static" + File.separator + "resource" + File.separator+dateName;

            String filePath = "D:/fileUpload/" + dateName;
            System.out.println("绝对路径:"+filePath);

            File newFile = new File(filePath);

            //MultipartFile的方法直接写文件
            try {

                //上传文件
                file.transferTo(newFile);

                //数据库存储的相对路径
                String projectPath = servletContext.getContextPath();
                HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
                String contextpath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+projectPath;
                String url = contextpath + "/resource/"+dateName;
                System.out.println("相对路径:"+url);
                //文件名与文件URL存入数据库表




            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }

        }
        return R.ok(map);
    }

}

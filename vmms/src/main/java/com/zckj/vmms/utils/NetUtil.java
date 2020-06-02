package com.zckj.vmms.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 实现http发送服务
 */
public class NetUtil {

    public static final Logger log = LoggerFactory.getLogger(NetUtil.class);
    public static CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    /**
     * get 请求获取String类型数据
     *
     * @param url
     * @return
     */
    public static String get(String url) {
        log.info("get 请求开始 ...");

        StringBuffer sb = new StringBuffer();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStreamReader reader = new InputStreamReader(entity.getContent(), "utf-8");
            char[] charbuffer;
            while (0 < reader.read(charbuffer = new char[10])) {
                sb.append(charbuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpGet.releaseConnection();
        }

        log.info(sb.toString());
        log.info("get 请求开始 ...");
        return sb.toString();
    }

    /**
     * post 请求获取数据
     *
     * @param url
     * @param data
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String post(String url, Map<String, String> data) {
        log.info("post 请求开始 ...");

        StringBuffer sb = new StringBuffer();
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
        if (null != data) {
            for (String key : data.keySet()) {
                valuePairs.addAll((Collection<? extends NameValuePair>) new BasicNameValuePair(key, data.get(key)));
            }
        }
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            BufferedInputStream bis = new BufferedInputStream(httpEntity.getContent());
            byte[] buffer;
            while (0 < bis.read(buffer = new byte[128])) {
                sb.append(new String(buffer, "utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            //数据格式有误
            e.printStackTrace();
        } catch (IOException e) {
            //请求出错
            e.printStackTrace();
        } finally {
            httpPost.releaseConnection();
        }

        log.info(sb.toString());
        log.info("post 请求开始 ...");
        return sb.toString();
    }
}

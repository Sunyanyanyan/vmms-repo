package com.zckj.vmms.vmms.controller;

import com.alibaba.fastjson.JSON;
import com.zckj.vmms.utils.NetUtil;
import com.zckj.vmms.vmms.entity.Oauth2Token;
import com.zckj.vmms.vmms.entity.WeChatUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {

//    private static Logger log = LoggerFactory.getLogger(WeChatController.class);

    private static final String APP_ID = "wx530cdb581ccd5af7";

    private static final String APP_SECRET = "c63afcc630d2f4b97635191653385469";

    //回调地址，要跟下面的地址能调通（/wxLogin）
//    private static final String BACK_URL = "https://自己的域名/wechat/wechat/wxLogin";
    private static final String BACK_URL = "http://wechat.vmms.nat123.net/wechat/wxLogin";

    //登录成功回调地址（返回你指定的地址）
//    private static final String URL_LOGIN = "https://自己的域名/wechat/hello";
    private static final String URL_LOGIN = "http://wechat.vmms.nat123.net/wechat/hello";

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 向指定 URL 发送 GET 方法的请求
     * URL 所代表远程资源的响应结果
     * @param request
     * @param response
     *
     * 用户同意授权，获取 code
     * @throws IOException
     */
    @RequestMapping("/wxLoginInit")
    public void loginInt(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("微信授权登录...");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
                + APP_ID
                + "&redirect_uri="
                + URLEncoder.encode(BACK_URL, "UTF-8")
                + "&response_type=code"
                + "&scope=snsapi_userinfo"
                + "&state=STATE#wechat_redirect" ;
        //重定向到重定向地址
        response.sendRedirect(url);
    }

    @RequestMapping("/wxLogin")
    public void wxLogin(HttpServletRequest request, HttpServletResponse response) {
        log.info("用户同意授权,重定向到重定向地址,获取 code");

        String code = request.getParameter("code");
        log.info("code:" + code);
        String appId = APP_ID;
        String appSecret = APP_SECRET;
        try {
            // 获取网页授权 access_token openid 等
            Oauth2Token oauth2Token = getOauth2Token(appId, appSecret, code);
            // 网页授权接口访问凭证
            String accessToken = oauth2Token.getAccessToken();
            // 用户标识
            String openId = oauth2Token.getOpenId();
            // 获取用户信息
            WeChatUserEntity weChatUser = getWxUserInfo(accessToken, openId);

            // 具体业务 start
            // 具体有业务需求
            // ...
            log.info(oauth2Token.toString());
            log.info(weChatUser.toString());
            //  ...
            // 具体业务 end

            // 授权登录成功后，跳转到指定的链接
            response.sendRedirect(URL_LOGIN);
        }catch(IOException e) {
            e.printStackTrace();
            log.error("网络异常");
        }
    }

    /**
     * 通过网页授权获取用户信息
     *
     * @param accessToken 网页授权接口调用凭证
     * @param openId 用户标识
     * @return
     */
    private WeChatUserEntity getWxUserInfo(String accessToken, String openId) {
        log.info("获取用户信息 开始...");
        log.info("网页授权接口访问凭证AccessToken:" + accessToken);
        log.info("用户标识openId:" + openId);

        WeChatUserEntity wxUserInfo = null;

        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        requestUrl = requestUrl.replace("OPENID", openId);

        log.info("拼接请求地址:" + requestUrl);

        // 通过网页授权获取用户信息
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(NetUtil.get(requestUrl));

        if (null != jsonObject) {
            try {
                wxUserInfo = new WeChatUserEntity();
                wxUserInfo.setOpenId(jsonObject.getString("openid"));
                wxUserInfo.setNickname(jsonObject.getString("nickname"));
                wxUserInfo.setSex(jsonObject.getInteger("sex"));
                wxUserInfo.setCountry(jsonObject.getString("country"));
                wxUserInfo.setProvince(jsonObject.getString("province"));
                wxUserInfo.setCity(jsonObject.getString("city"));
                wxUserInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
                //用户授权信息
                List<String> list = JSON.parseArray(jsonObject.getString("privilege"), String.class);
                wxUserInfo.setPrivilegeList(list);
                //与开放平台公用的唯一标识，只有在用户将公众号绑定到微信开放平台账号后，才会出现该字段
                wxUserInfo.setUnionid(jsonObject.getString("unionid"));
            }catch (Exception e) {
                wxUserInfo = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("获取用户信息失败  errcode:{} errmsg:{}",errorCode,errorMsg);
            }
        }

        log.info("获取用户信息 结束...");
        return wxUserInfo;
    }

    /**
     * 获取网页授权凭证
     * @param appId 公众账号的唯一标识
     * @param appSecret 公众账号的密钥
     * @param code
     * @return
     */
    private Oauth2Token getOauth2Token(String appId, String appSecret, String code) {
        log.info("获取网页授权凭证 开始...");

        Oauth2Token auth = null;

        //拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);
        requestUrl = requestUrl.replace("CODE", code);

        log.info("拼接后的请求地址为:" + requestUrl);

        //获取网页授权凭证
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject (NetUtil.get(requestUrl));

        if(null != jsonObject) {
            try {
                auth = new Oauth2Token();
                auth.setAccessToken(jsonObject.getString("access_token"));
                auth.setExpiresIn(jsonObject.getInteger("expires_in"));
                auth.setRefreshToken("refresh_token");
                auth.setOpenId("openid");
                auth.setScope("scope");
            }catch(Exception e) {
                auth = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("获取网页授权凭证失败 errcode:{} errmsg:{}",errorCode,errorMsg);
            }
        }

        log.info("获取网页授权凭证 结束...");
        return auth;
    }
}

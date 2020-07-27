package com.zckj.vmms.vmms.vo;

import lombok.Data;
import lombok.ToString;

/**
 * access_token 等信息的实体类
 */
@Data
@ToString
public class Oauth2Token {

    private String accessToken; //网页授权接口调用凭证
    private int expiresIn; //凭证有效时长
    private String refreshToken; //用于刷新凭证
    private String openId; //用户标识
    private String scope; //用户授权作用域

}

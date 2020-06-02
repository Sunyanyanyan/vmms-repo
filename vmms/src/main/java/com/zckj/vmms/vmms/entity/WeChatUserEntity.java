package com.zckj.vmms.vmms.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息的实体类
 */
@Data
@ToString
public class WeChatUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id; //主键 id
    private String openId; //用户主键
    private String nickname; //用户昵称
    private Integer sex; //性别(1:男,2:女,0:未知)
    private String country; //国家
    private String province; //省份
    private String city; //城市
    private String headimgurl; //用户头像链接
    private String unionid; //unionid
    private List<String> privilegeList; //用户特权信息

}

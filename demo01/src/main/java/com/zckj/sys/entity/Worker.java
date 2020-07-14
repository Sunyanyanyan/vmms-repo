package com.zckj.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author sunyan
 * @since 2020-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("WORKER")
@ApiModel(value="Worker对象", description="")
public class Worker implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单位编号")
    @TableId("ORGNO")
    private String orgno;

    @ApiModelProperty(value = "操作员编号")
    @TableField("WORKERID")
    private String workerid;

    @ApiModelProperty(value = "操作员姓名")
    @TableField("WORKERNAME")
    private String workername;

    @ApiModelProperty(value = "登录帐号")
    @TableField("CODE")
    private String code;

    @ApiModelProperty(value = "密码")
    @TableField("PWD")
    private String pwd;

    @ApiModelProperty(value = "权限")
    @TableField("ROLEID")
    private String roleid;

    @ApiModelProperty(value = "证件编号")
    @TableField("IDCARD")
    private String idcard;

    @ApiModelProperty(value = "电话")
    @TableField("TELE")
    private String tele;

    @ApiModelProperty(value = "状态")
    @TableField("STATE")
    private String state;

    @ApiModelProperty(value = "岗位")
    @TableField("GW")
    private String gw;

    @ApiModelProperty(value = "部门")
    @TableField("WGNO")
    private String wgno;

    @ApiModelProperty(value = "首页")
    @TableField("HOME")
    private String home;

    @ApiModelProperty(value = "是否发送短信")
    @TableField("SMS")
    private String sms;


}

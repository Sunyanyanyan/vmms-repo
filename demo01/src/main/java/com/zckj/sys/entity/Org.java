package com.zckj.sys.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

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
@TableName("ORG")
@ApiModel(value="Org对象", description="")
public class Org implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单位编号")
    @TableId("ORGNO")
    private String orgno;

    @ApiModelProperty(value = "单位名称")
    @TableField("ORGNAME")
    private String orgname;

    @ApiModelProperty(value = "类型")
    @TableField("ORGTYPE")
    private String orgtype;

    @ApiModelProperty(value = "上级编号")
    @TableField("PARENTNO")
    private String parentno;

    @ApiModelProperty(value = "等级")
    @TableField("GRADE")
    private Integer grade;

    @ApiModelProperty(value = "经度")
    @TableField("POINT_X")
    private BigDecimal pointX;

    @ApiModelProperty(value = "伟度")
    @TableField("POINT_Y")
    private BigDecimal pointY;

    @ApiModelProperty(value = "备注")
    @TableField("NOTE")
    private String note;

    @TableField(exist=false)	// 标注不是表里面的属性，自定义属性
    private List<Org> children;


}

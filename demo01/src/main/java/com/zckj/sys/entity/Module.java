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
@TableName("MODULE")
@ApiModel(value="Module对象", description="")
public class Module implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "模块编号")
    @TableId("MODULEID")
    private Integer moduleid;

    @ApiModelProperty(value = "模块名称")
    @TableField("MODULENAME")
    private String modulename;

    @ApiModelProperty(value = "文件名（web项目不用填）")
    @TableField("FILENAME")
    private String filename;

    @ApiModelProperty(value = "页面（窗体）路径")
    @TableField("FORMNAME")
    private String formname;

    @ApiModelProperty(value = "序号")
    @TableField("ORDID")
    private Integer ordid;

    @ApiModelProperty(value = "分类")
    @TableField("PARENT")
    private String parent;

    @ApiModelProperty(value = "等级")
    @TableField("GRADE")
    private Integer grade;

    @ApiModelProperty(value = "图标文件")
    @TableField("ICON")
    private String icon;


}

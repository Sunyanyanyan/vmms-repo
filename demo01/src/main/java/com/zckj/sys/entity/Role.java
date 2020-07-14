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
@TableName("ROLE")
@ApiModel(value="Role对象", description="")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "岗位编号")
    @TableId("ROLEID")
    private String roleid;

    @ApiModelProperty(value = "模块编号")
    @TableField("MODULEID")
    private Integer moduleid;

    @ApiModelProperty(value = "岗位名称")
    @TableField("ROLENAME")
    private String rolename;

    @ApiModelProperty(value = "等级")
    @TableField("GRADE")
    private Integer grade;

    @ApiModelProperty(value = "序号")
    @TableField("ORDID")
    private Integer ordid;


}

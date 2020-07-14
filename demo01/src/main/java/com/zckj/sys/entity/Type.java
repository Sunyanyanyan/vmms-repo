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
@TableName("TYPE")
@ApiModel(value="Type对象", description="")
public class Type implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ORGNO")
    private String orgno;

    @TableField("NAME")
    private String name;

    @TableField("NOTE")
    private String note;

    @TableField("TJ")
    private String tj;

    @TableField("ORDID")
    private Integer ordid;


}

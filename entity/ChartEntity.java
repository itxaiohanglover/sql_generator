package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
@TableName("chart")
public class ChartEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId
    private Integer id;

    /**
     * 类型，0人，1地区
     */
    private Integer type;

    /**
     * x轴数据
     */
    private String xVal;

    /**
     * y轴数据
     */
    private String yVal;

}

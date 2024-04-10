package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("data_sta")
public class DataStaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId
    private Integer id;
    /**
     * 指标
     */
    private String target;
    /**
     * 统计时间
     */
    @JsonProperty(value = "createTime")
    private Date createTime;
    /**
     * 数据
     */
    @JsonProperty(value = "dataSta")
    private Double dataSta;

    /**
     * 父ID
     */
    @JsonProperty(value = "pId")
    private Integer pId;
    /**
     * 省份ID
     */
    @JsonProperty(value = "regionId")
    private Integer regionId;
}

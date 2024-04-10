package com.artboy.common.utils.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author ljz
 */
@Data
@TableName("map_info")
public class MapInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    @TableId
    private Integer id;
    /**
     * 城市名称
     */
    private String region;
    /**
     * GDP
     */
    private String introduce;
    /**
     * 人均GDP
     */
    private Integer val;
    /**
     * 人均GDP
     */

    private Integer ran;
    /**
     * 公共预算收入
     */
    @JsonProperty(value = "pId")
    private Integer pId;
    /**
     * 人口数量
     */
    private Integer year;

}

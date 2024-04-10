package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
 *
 *
 * @author ljz
 */
@Data
@TableName("location")
public class LocationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId
    private Integer id;
    /**
     * 地区
     */
    private String region;
    /**
     * 经度
     */
    private Double longitude;
    /**
     *  纬度
     */
    private Double latitude;

}

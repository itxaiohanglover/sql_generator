package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("menu")
public class MenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId
    private Integer id;

    /**
     * 上一级ID
     */
    @JsonProperty(value = "pId")
    private Integer pId;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 子分类
     */
    @TableField(exist = false)
    private List<MenuEntity> children;
}

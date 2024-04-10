package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 *
 * @author hang
 * @email 1531137510@qq.com
 * @date 2022-03-07 21:10:23
 */
@Data
@TableName("region")
public class RegionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Integer id;
	/**
	 * 父ID
	 */
	@JsonProperty(value = "pId")
	private Integer pId;
	/**
	 * 地区名
	 */
	private String name;
	/**
	 * 地区信息
	 */
	private String info;
	/**
	 * 子分类
	 */
	@TableField(exist = false)
	private List<RegionEntity> children;

	/*
	* 图片地址
	* */
	private String img;

}

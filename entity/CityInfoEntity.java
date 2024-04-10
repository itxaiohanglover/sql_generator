package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author Lan
 * @email 408171674@qq.com
 * @date 2022-03-24 21:11:16
 */
@Data
@TableName("city_info")
public class CityInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 城市名称
	 */
	private String name;
	/**
	 * GDP
	 */
	private String gdp;
	/**
	 * 人均GDP
	 */
	@JsonProperty(value = "pGdp")
	private String pGdp;
	/**
	 * 公共预算收入
	 */
	private String income;
	/**
	 * 人口数量
	 */
	private String number;
	/**
	 * 城市照片
	 */
	private String img;

}

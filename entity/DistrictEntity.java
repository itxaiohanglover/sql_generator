package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

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
@TableName("district")
public class DistrictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Integer id;
	/**
	 * 中文名
	 */
	private String chName;
	/**
	 * 英文名
	 */
	private String enName;
	/**
	 * 别名
	 */
	private String alias;
	/**
	 * 类别（省、市、县、景点）
	 */
	private Integer type;
	/**
	 * 地理位置
	 */
	private String location;
	/**
	 * 面积
	 */
	private String area;
	/**
	 * 下辖地区
	 */
	private String governsArea;
	/**
	 * 政府驻地
	 */
	private String government;
	/**
	 * 电话区号
	 */
	private String phone;
	/**
	 * 邮政区码
	 */
	private Integer code;
	/**
	 * 气候条件
	 */
	private String climate;
	/**
	 * 著名景点
	 */
	private String scenery;
	/**
	 * 火车站
	 */
	private String train;
	/**
	 * 车牌代码
	 */
	private String car;
	/**
	 * 地区生产总值
	 */
	private String gdp;
	/**
	 * 人    口
	 */
	private String person;
	/**
	 * 行政代码
	 */
	private String adminCode;
	/**
	 * 党政领导
	 */
	private String official;
	/**
	 * 所属地区ID
	 */
	@JsonProperty(value = "pId")
	private Integer pId;

}

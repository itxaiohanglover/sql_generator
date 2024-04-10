package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 *
 * @author Lan
 * @email 408171674@qq.com
 * @date 2022-04-13 21:19:15
 */
@Data
@TableName("pay_log")
public class PayLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 下单时间
	 */
	private Date payTime;
	/**
	 * 下单编号
	 */
	private String payCode;
	/**
	 * 下单内容
	 */
	private String payContent;
	/**
	 * 订单金额
	 */
	private Integer payMoney;
	/**
	 * 订单状态
	 */
	private Integer payType;

}

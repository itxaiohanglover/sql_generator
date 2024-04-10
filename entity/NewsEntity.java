package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author Lan
 * @email 408171674@qq.com
 * @date 2022-03-24 21:11:16
 */
@Data
@TableName("news")
public class NewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private Integer id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 信息
	 */
	private String info;
	/**
	 * 创建时间
	 */
	@JsonProperty(value = "createTime")
	private String createTime;
	/**
	 * 路径
	 */
	private String src;

}

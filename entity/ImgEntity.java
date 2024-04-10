package com.artboy.common.utils.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 *
 * @author hang
 * @email 1531137510@qq.com
 * @date 2022-03-07 21:10:23
 */
@Data
@TableName("img")
public class ImgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private Integer id;
	/**
	 * 图片地址
	 */
	private String src;
	/**
	 * 所属ID
	 */
	private Integer pId;
	/**
	 * 类型（地区、人物，1，0）
	 */
	private Integer type;

}

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
@TableName("person")
public class PersonEntity implements Serializable {
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
	 * 国籍
	 */
	private String nationality;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 籍    贯
	 */
	private String birth;
	/**
	 * 出生日期
	 */
	private String birthDay;
	/**
	 * 毕业院校
	 */
	private String school;
	/**
	 * 领导地区ID
	 */
	private Integer regionId;

}

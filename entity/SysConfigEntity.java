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
 * @date 2022-04-16 22:32:24
 */
@Data
@TableName("sys_config")
public class SysConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 配置名
	 */
	@TableId
	private String name;
	/**
	 * 配置路径
	 */
	private String path;
	/**
	 * 备注
	 */
	private String mark;

}

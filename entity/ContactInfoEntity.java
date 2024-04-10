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
 * @date 2022-05-02 20:13:41
 */
@Data
@TableName("contact_info")
public class ContactInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 姓名
     */
    private String name;
    /**
     * 电话
     */
    private String tel;
    /**
     * 部门
     */
    private String department;
    /**
     * 职位
     */
    private String position;
    /**
     * 操作
     */
    private String operation;
}

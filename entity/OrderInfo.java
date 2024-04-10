package com.artboy.common.utils.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (OrderInfo)表实体类
 *
 * @author makejava
 * @since 2022-05-03 21:06:16
 */
@SuppressWarnings("serial")
@Data
@TableName("order_info")
public class OrderInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    //订单id
    private Object id;
    //订单标题
    private String title;
    //商户订单编号
    private String orderNo;
    //用户id
    private Integer userId;
    //订单金额(分)
    private Integer totalFee;
    //订单二维码连接
    private String codeUrl;
    //订单状态
    private String orderStatus;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

}


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
@TableName("message")
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * 主要内容
     */
    private String content;
    /**
     * 时间
     */
    private Date time;
    /**
     * 是否已读
     */
    private String isread;

}

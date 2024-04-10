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
 * @date 2022-04-29 20:37:29
 */
@Data
@TableName("export_record")
public class ExportRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *id
     */
    @TableId
    private Integer id;
    /**
     *用户
     */
    private String user;
    /**
     *pdf
     */
    private String pdf;
    /**
     *导出时间
     */
    private Date time;
    /**
     *是否导出成功
     */
    private String success;

}

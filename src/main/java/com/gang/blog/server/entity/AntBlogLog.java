package com.gang.blog.server.entity;

import com.gang.blog.server.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ant-black
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("ant_blog_log")
public class AntBlogLog extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * log 类型
     */
    private String logType;

    /**
     * log 标题
     */
    private String logTitle;

    /**
     * log 数据
     */
    private String logData;

    /**
     * 创建日期
     */
    @TableField("createDate")
    private LocalDateTime createDate;

    /**
     * 结束时间
     */
    @TableField("endDate")
    private LocalDateTime endDate;

    /**
     * 日志状态
     */
    private String logStatus;


}

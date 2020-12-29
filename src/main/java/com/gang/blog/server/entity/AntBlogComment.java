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
@TableName("ant_blog_comment")
public class AntBlogComment extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 评论标题
     */
    private String commentTitle;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论类型
     */
    private String commentType;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private LocalDateTime createDate;

    /**
     * 创建人
     */
    @TableField("createUser")
    private String createUser;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 评论Ip
     */
    private String ip;


}

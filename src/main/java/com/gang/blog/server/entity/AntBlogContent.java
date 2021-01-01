package com.gang.blog.server.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gang.blog.server.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author ant-black
 * @since 2020-05-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("ant_blog_content")
public class AntBlogContent extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String contentBody;

    private String contentCode;

    private String contentTitle;

    private String contentInfo;

    private String contentForeword;

    private String contentOrder;

    private String contentBodyType;

    private String contentStart;

    private String contentPath;

    private String contentFolder;

    private String contentHot;

    private String contentExt;

    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

    /**
     * ant_blog_tag
     */
    @TableField("BLOG_TAG")
    private String blogTag;

    /**
     * ant_blog_template
     */
    @TableField("BLOG_TEMPLATE")
    private String blogTemplate;

    /**
     * ant_blog_type
     */
    @TableField("BLOG_TYPE")
    private String blogType;


}

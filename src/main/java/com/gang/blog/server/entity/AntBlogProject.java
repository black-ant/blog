package com.gang.blog.server.entity;

import com.gang.blog.server.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ant-black
 * @since 2020-07-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("ant_blog_project")
public class AntBlogProject extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目描述
     */
    private String projectDesc;

    /**
     * 项目Code
     */
    private String projectCode;

    /**
     * 项目路径
     */
    private String projectPath;

    /**
     * 项目所有人
     */
    private String projectUser;

    /**
     * 项目标签
     */
    private String projectTag;

    /**
     * 项目图标
     */
    private String projectIcon;


}

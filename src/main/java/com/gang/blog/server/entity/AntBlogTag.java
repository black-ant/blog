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
 * @since 2020-05-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("ant_blog_tag")
public class AntBlogTag extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * tag 类型
     */
    private String tagType;

    private String tagName;

    private String tagOrder;

    /**
     * 其他配置
     */
    private String tagExt;


}

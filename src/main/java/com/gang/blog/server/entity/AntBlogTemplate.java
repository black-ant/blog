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
@TableName("ant_blog_template")
public class AntBlogTemplate extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 模板主体
     */
    private String templateBody;

    private String templateName;

    private String templateDesc;

    private String templateStatus;

    private String templateCode;


}

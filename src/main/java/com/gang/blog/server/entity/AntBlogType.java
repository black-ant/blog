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
@TableName("ant_blog_type")
public class AntBlogType extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * type 类型( 技术 想法 杂文)
     */
    private String typeName;

    /**
     * 状态 
     */
    private String typeStatus;

    /**
     * 排序
     */
    private String typeOrder;

    /**
     * 描述
     */
    private String typeDesc;


}

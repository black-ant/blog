package com.gang.blog.server.entity;

import com.gang.blog.server.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("ant_blog_type")
public class AntBlogType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String typeCode;

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

    /**
     * 排序方式 (集合内)
     */
    private String typeSort;

    /**
     * 二级分类 : COLLECTION / ESSAYS / BLOG
     */
    private String typeClassify;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 修改人
     */
    private String updateUser;

}

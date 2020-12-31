package com.gang.blog.server.entity;

import com.gang.blog.server.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author ant-black
 * @since 2020-12-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("ant_blog_folder")
public class AntBlogFolder extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String folderName;

    private String folderPath;

    private String folderCode;

    private Date createDate;

    private Date updateDate;

    /**
     * 0 : 不处理 , 1 处理
     */
    private String status;

    /**
     * 0: 顶层 , 1 子级
     */
    private String type;

    /**
     * 根节点
     */
    private String root;

    /**
     * 索引
     */
    private Integer childIndex;

    private String parentCode;

    private String parentId;

    private String parentName;

}

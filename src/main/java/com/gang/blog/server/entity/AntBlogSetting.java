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
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("ant_blog_setting")
public class AntBlogSetting extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 配置代码串
     */
    private String settingCode;

    /**
     * 配置名
     */
    private String settingName;

    /**
     * 配置值
     */
    private String settingValue;

    /**
     * 配置类
     */
    private String settingType;

    /**
     * 配置状态 : 可用 - 不可用
     */
    private Integer settingStatus;

    /**
     * 附件信息
     */
    private String remarks;


}

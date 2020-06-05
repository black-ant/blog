package com.gang.blog.server.entity;

import com.gang.blog.server.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
@TableName("ant_blog_user")
public class AntBlogUser extends BaseEntity {

    private static final long serialVersionUID=1L;

    private String userName;

    private String userType;

    private String userRole;

    private String userEmail;

    private String userMobile;

    private String userStatus;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private String userPassword;

    private String userExt;


}

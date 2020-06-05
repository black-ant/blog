package com.gang.blog.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Date 2020/5/10 14:53
 * @Created by zengzg
 */
public class BaseEntity {

    @TableId(type = IdType.UUID)
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

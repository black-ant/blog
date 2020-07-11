package com.gang.blog.server.to;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * @Classname AntBlogDocTO
 * @Description TODO
 * @Date 2020/7/5 14:08
 * @Created by zengzg
 */
public class AntBlogDocTO {

    private String name;

    private String desc;

    private String code;

    private String type;

    private String classType;

    private String status;

    @JSONField(name = "item")
    private Map<String, AntBlogDocTO> itemMap;

    private AntBlogDocTO parentInfo;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, AntBlogDocTO> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<String, AntBlogDocTO> itemMap) {
        this.itemMap = itemMap;
    }

    public AntBlogDocTO getParentInfo() {
        return parentInfo;
    }

    public void setParentInfo(AntBlogDocTO parentInfo) {
        this.parentInfo = parentInfo;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}

package com.gang.blog.server.type;

/**
 * @Classname SettingKeyTypeEnum
 * @Description TODO
 * @Date 2020/10/19 23:33
 * @Created by zengzg
 */
public enum SettingKeyTypeEnum {

    AUTO_PULL_BLOG("blog.pull.auto", "自动拉取");

    private String key;
    private String description;


    SettingKeyTypeEnum(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

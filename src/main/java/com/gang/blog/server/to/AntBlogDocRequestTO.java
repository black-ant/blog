package com.gang.blog.server.to;

import java.util.Map;

/**
 * @Classname AntBlogDocRequestTO
 * @Description TODO
 * @Date 2020/7/5 14:09
 * @Created by zengzg
 */
public class AntBlogDocRequestTO {

    /**
     * 项目路径
     */
    private String projectPath;

    /**
     * 项目类型
     */
    private String type;

    /**
     * 描述文档
     */
    private String settingFile = "BLOG";

    private Map<String, AntBlogDocTO> treeMap;

    private String rootPath;

    private String parentFile;

    private String parentId;

    private String parentCode;

    public AntBlogDocRequestTO() {
    }

    public AntBlogDocRequestTO(String projectPath, String type, String settingFile) {
        this.projectPath = projectPath;
        this.type = type;
        this.settingFile = settingFile;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSettingFile() {
        return settingFile;
    }

    public void setSettingFile(String settingFile) {
        this.settingFile = settingFile;
    }

    public Map<String, AntBlogDocTO> getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(Map<String, AntBlogDocTO> treeMap) {
        this.treeMap = treeMap;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getParentFile() {
        return parentFile;
    }

    public void setParentFile(String parentFile) {
        this.parentFile = parentFile;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}

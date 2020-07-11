package com.gang.blog.server.cache;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gang.blog.server.entity.AntBlogTag;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname BaseBlogCache
 * @Description TODO
 * @Date 2020/6/21 15:38
 * @Created by zengzg
 */
public abstract class BaseBlogCache implements IBlogCache {

    /**
     * 标签缓存
     */
    protected Map<String, AntBlogTag> tagCacheMap = new ConcurrentHashMap();

    /**
     * 类型缓存
     */
    protected Map<String, AntBlogTag> typeMap = new ConcurrentHashMap();

    /**
     * 菜单缓存
     */
    protected Map<String, JSONArray> viewMenuMap = new ConcurrentHashMap();


    public Map<String, AntBlogTag> getTagCacheMap() {
        return tagCacheMap;
    }

    public void setTagCacheMap(Map<String, AntBlogTag> tagCacheMap) {
        this.tagCacheMap = tagCacheMap;
    }

    public Map<String, AntBlogTag> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, AntBlogTag> typeMap) {
        this.typeMap = typeMap;
    }

    public Map<String, JSONArray> getViewMenuMap() {
        return viewMenuMap;
    }

    public void setViewMenuMap(Map<String, JSONArray> viewMenuMap) {
        this.viewMenuMap = viewMenuMap;
    }
}

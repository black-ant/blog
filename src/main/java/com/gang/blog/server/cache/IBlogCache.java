package com.gang.blog.server.cache;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogTag;

import java.util.List;
import java.util.Map;

/**
 * @Classname IBlogCache
 * @Description TODO
 * @Date 2020/6/21 15:35
 * @Created by zengzg
 */
public interface IBlogCache {

    Map<String, AntBlogTag> getTagCacheMap();

    void setTagCacheMap(Map<String, AntBlogTag> tagCacheMap);

    Map<String, AntBlogTag> getTypeMap();

    void setTypeMap(Map<String, AntBlogTag> typeMap);

    Map<String, JSONArray> getViewMenuMap();

    void setViewMenuMap(Map<String, JSONArray> viewMenuMap);

}

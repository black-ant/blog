package com.gang.blog.server.logic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gang.blog.server.cache.IBlogCache;
import com.gang.blog.server.cache.MemoryBlogCache;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.service.impl.AntBlogContentServiceImpl;
import com.gang.blog.server.utils.MybatisQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Classname CacheLogic
 * @Description TODO
 * @Date 2020/6/21 15:33
 * @Created by zengzg
 */
@Component
public class BlogCacheLogic {

    @Autowired
    private MemoryBlogCache blogCache;

    @Autowired
    private AntBlogContentServiceImpl contentService;

    /**
     * 添加缓存菜单
     *
     * @param contentList
     */
    public JSONArray addViewMenu(List<AntBlogContent> contentList) {
        JSONArray menu = new JSONArray();
        if (!CollectionUtils.isEmpty(contentList)) {
            menu = blogCache.getViewMenuMap().get(contentList.get(0).getBlogType());
            menu = menu == null ? new JSONArray() : menu;
            for (AntBlogContent item : contentList) {
                JSONObject menuItem = new JSONObject();
                menuItem.put("id", item.getId());
                menuItem.put("menuName", item.getContentTitle());
                menu.add(menuItem);
            }
        }
        return menu;
    }

    /**
     * 获取缓存菜单
     *
     * @param blogType
     * @return
     */
    public JSONArray getViewMenu(String blogType) {
        JSONArray menuArray = blogCache.getViewMenuMap().get(blogType);
        if (menuArray == null) {
            List<AntBlogContent> contentList = contentService.list(MybatisQueryWrapper.buildEq("BLOG_TYPE", blogType));
            menuArray = addViewMenu(contentList);
        }
        return menuArray;
    }


}

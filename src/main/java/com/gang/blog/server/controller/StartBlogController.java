package com.gang.blog.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogProject;
import com.gang.blog.server.entity.AntBlogType;
import com.gang.blog.server.entity.BaseEntity;
import com.gang.blog.server.logic.BlogCacheLogic;
import com.gang.blog.server.service.impl.AntBlogContentServiceImpl;
import com.gang.blog.server.service.impl.AntBlogProjectServiceImpl;
import com.gang.blog.server.service.impl.AntBlogTypeServiceImpl;
import com.gang.common.lib.to.ResponseModel;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Classname StartController
 * @Description TODO
 * @Date 2020/5/10 13:50
 * @Created by zengzg
 */
@RestController
@RequestMapping("/blog")
public class StartBlogController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, List<BaseEntity>> cacheTagMap = new HashMap<>();

    @Autowired
    private AntBlogContentServiceImpl contentService;

    @Autowired
    private BlogCacheLogic blogCacheLogic;

    @Autowired
    private AntBlogTypeServiceImpl typeService;

    @Autowired
    private AntBlogProjectServiceImpl projectService;

    @GetMapping("/index")
    public ResponseModel<JSONObject> getIndex() {
        JSONObject repJSON = new JSONObject();
        return ResponseModel.commonResponse(repJSON);
    }

    @GetMapping("/refushCache")
    public ResponseModel<JSONObject> refushCache(@RequestParam("type") String type) {
        JSONObject repJSON = new JSONObject();
        if (StringUtils.isNotEmpty(type)) {
            cacheTagMap.remove(type);
        } else {
            cacheTagMap.clear();
        }
        return ResponseModel.commonResponse(repJSON);
    }

    @GetMapping("/project")
    public ResponseModel getProjectByType(@RequestParam(value = "type", defaultValue = "") String type) {
        QueryWrapper<AntBlogProject> wrapper = new QueryWrapper();
        AntBlogProject project = null;
        if (StringUtils.isEmpty(type) || type.equals("undefined")) {
            List<AntBlogProject> list = projectService.list();
            project = list.get(0);
            List<BaseEntity> popularCollectionList = list.stream().collect(Collectors.toList());
            cacheTagMap.put("project", popularCollectionList);
        } else {
            wrapper.eq("project_code", type);
            project = projectService.getOne(wrapper);
        }
        return ResponseModel.commonResponse(project).addInfo("pojectList", cacheTagMap.get("project"));
    }

    @GetMapping(value = "/docs/{page}", produces = {"application/json"})
    public ResponseModel<IPage<AntBlogContent>> getBlog(@PathVariable("page") Integer pageNum) {
        IPage<AntBlogContent> pageObj = new Page<>(pageNum, 3);
        IPage<AntBlogContent> pageResult = contentService.page(pageObj);
        return ResponseModel.commonResponse(pageResult);
    }

    @GetMapping(value = "/view/{key}", produces = {"application/json"})
    public ResponseModel readBlog(@PathVariable("key") String key) {
        AntBlogContent content = contentService.getById(key);
        return ResponseModel.commonResponse(content);
    }

    @GetMapping(value = "/views", produces = {"application/json"})
    public ResponseModel readBlogCollection(@RequestParam("type") String blogType, @RequestParam("key") String key) {
        JSONArray menu = blogCacheLogic.getViewMenu(blogType);
        AntBlogContent content = "0".equals(key) ? contentService.getOneByType(blogType) : contentService.getById(key);
        return ResponseModel.commonResponse(content).addInfo("menu", menu);
    }

    @GetMapping(value = "/collection/{page}", produces = {"application/json"})
    public ResponseModel getCollection(@PathVariable("page") Integer pageNum) {

        QueryWrapper<AntBlogType> wrapper = new QueryWrapper();
        IPage<AntBlogType> pageObj = new Page<>(pageNum, 3);
        IPage<AntBlogType> pageResult = typeService.page(pageObj, wrapper);
        if (cacheTagMap.isEmpty()) {
            buildCollection();
        }
        return ResponseModel.commonResponse(pageResult).addInfo("tag", cacheTagMap);
    }

    /**
     * build Collection
     */
    public void buildCollection() {
        List<BaseEntity> typeList = typeService.list().stream().collect(Collectors.toList());
        cacheTagMap.put("type", typeList);

        IPage<AntBlogType> pageObj = new Page<>(1, 5);
        QueryWrapper<AntBlogType> wrapper = new QueryWrapper();
        wrapper.orderByDesc("type_sort");
        IPage<AntBlogType> pageResult = typeService.page(pageObj, wrapper);
        List<BaseEntity> popularCollectionList = pageResult.getRecords().stream().collect(Collectors.toList());
        cacheTagMap.put("popularCollection", popularCollectionList);
    }
}

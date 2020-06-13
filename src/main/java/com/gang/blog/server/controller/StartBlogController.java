package com.gang.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.service.impl.AntBlogContentServiceImpl;
import com.gang.common.lib.to.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    private AntBlogContentController antBlogContentController;

    @Autowired
    private AntBlogContentServiceImpl contentService;


    @GetMapping("/index")
    public ResponseModel<JSONObject> getIndex() {
        JSONObject repJSON = new JSONObject();
        return ResponseModel.commonResponse(repJSON);
    }

    @GetMapping("/project")
    public ModelAndView getProject() {
        ModelAndView model = new ModelAndView();
        model.setViewName("blog/project");
        return model;
    }

    @GetMapping(value = "/blog/{page}", produces = {"application/json"})
    public ResponseModel<IPage<AntBlogContent>> getBlog(@PathVariable("page") Integer pageNum) {
        IPage<AntBlogContent> pageObj = new Page<>(pageNum, 3);
        IPage<AntBlogContent> pageResult = contentService.page(pageObj);
        return ResponseModel.commonResponse(pageResult);
    }

    @GetMapping(value = "/read/{key}", produces = {"application/json"})
    public ModelAndView readBlog(@PathVariable("key") String key) {
        ModelAndView model = antBlogContentController.getOne(key);
        logger.info("------> {} <-------", model.getModel());
        model.setViewName("blog/details");
        return model;
    }

}

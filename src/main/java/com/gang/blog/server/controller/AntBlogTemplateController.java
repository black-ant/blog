package com.gang.blog.server.controller;


import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogTemplate;
import com.gang.blog.server.service.impl.AntBlogContentServiceImpl;
import com.gang.blog.server.service.impl.AntBlogTemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ant-black
 * @since 2020-05-10
 */
@RestController
@RequestMapping("/template")
public class AntBlogTemplateController extends AbstractControllerView<AntBlogTemplateServiceImpl, AntBlogTemplate> {

    @Autowired
    private AntBlogTemplateServiceImpl templateService;

    @Override
    public String getMapping() {
        return null;
    }

    public void setService() {
        super.service = templateService;
    }
}


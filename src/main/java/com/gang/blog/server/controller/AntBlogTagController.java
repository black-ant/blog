package com.gang.blog.server.controller;


import com.gang.blog.server.entity.AntBlogTag;
import com.gang.blog.server.service.impl.AntBlogTagServiceImpl;
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
@RequestMapping("/tag")
public class AntBlogTagController extends AbstractControllerView<AntBlogTagServiceImpl, AntBlogTag> {

    private static final String MAPPING = "tag";

    @Override
    public String getMapping() {
        return MAPPING;
    }

    @Autowired
    public void setService(AntBlogTagServiceImpl antBlogContentService) {
        super.service = antBlogContentService;
    }
}


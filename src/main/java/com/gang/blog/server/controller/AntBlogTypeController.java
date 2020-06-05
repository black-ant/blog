package com.gang.blog.server.controller;


import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogType;
import com.gang.blog.server.service.impl.AntBlogContentServiceImpl;
import com.gang.blog.server.service.impl.AntBlogTypeServiceImpl;
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
@RequestMapping("/type")
public class AntBlogTypeController extends AbstractControllerView<AntBlogTypeServiceImpl, AntBlogType> {

    private static final String MAPPING = "type";

    @Override
    public String getMapping() {
        return MAPPING;
    }

    @Autowired
    public void setService(AntBlogTypeServiceImpl antBlogContentService) {
        super.service = antBlogContentService;
    }

}


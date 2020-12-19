package com.gang.blog.server.controller;


import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.service.impl.AntBlogContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ant-black
 * @since 2020-05-10
 */
@RestController
@RequestMapping("/content")
public class AntBlogContentController extends AbstractControllerView<AntBlogContentServiceImpl, AntBlogContent> {

    private static final String MAPPING = "content";

    @Override
    public String getMapping() {
        return MAPPING;
    }

    @Autowired
    public void setService(AntBlogContentServiceImpl antBlogContentService) {
        super.service = antBlogContentService;
    }

    @Override
    public void beforeBuild(AntBlogContent entity) {
        entity.setContentBodyType("MARKDOWN");
        entity.setContentOrder("1");
        entity.setCreateUser("1");
        entity.setCreateDate(new Date());
    }
}


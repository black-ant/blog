package com.gang.blog.server.controller;


import com.gang.blog.server.entity.AntBlogTag;
import com.gang.blog.server.entity.AntBlogUser;
import com.gang.blog.server.service.impl.AntBlogTagServiceImpl;
import com.gang.blog.server.service.impl.AntBlogUserServiceImpl;
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
@RequestMapping("/user")
public class AntBlogUserController extends AbstractControllerView<AntBlogUserServiceImpl, AntBlogUser> {

    @Override
    public String getMapping() {
        return "user";
    }

    @Autowired
    public void setService(AntBlogUserServiceImpl antBlogContentService) {
        super.service = antBlogContentService;
    }
}


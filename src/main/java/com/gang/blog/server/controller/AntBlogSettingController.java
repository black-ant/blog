package com.gang.blog.server.controller;


import com.gang.blog.server.entity.AntBlogSetting;
import com.gang.blog.server.service.impl.AntBlogSettingServiceImpl;
import com.gang.blog.server.service.impl.AntBlogTemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * <p>
 * 前端控制器 625
 * </p>
 *
 * @author ant-black
 * @since 2020-09-24
 */
@RestController
@RequestMapping("/setting")
public class AntBlogSettingController extends AbstractControllerView<AntBlogTemplateServiceImpl, AntBlogSetting> {

    @Autowired
    private AntBlogSettingServiceImpl service;

    @Override
    public String getMapping() {
        return "setting";
    }

    @PostConstruct
    public void setService() {
        super.service = service;
    }
}


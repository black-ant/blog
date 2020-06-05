package com.gang.blog.server.controller;


import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.service.impl.AntBlogContentServiceImpl;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
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


package com.gang.blog.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.service.impl.AntBlogContentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("byFolder")
    public List<AntBlogContent> getFolderContent(@RequestParam("folderId") String folderId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("content_folder", folderId);
        return service.list(wrapper);
    }

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


package com.gang.blog.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gang.blog.server.entity.AntBlogFolder;
import com.gang.blog.server.service.impl.AntBlogContentServiceImpl;
import com.gang.blog.server.service.impl.AntBlogFolderServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @Classname AntBlogFolderController
 * @Description TODO
 * @Date 2020/12/19 15:47
 * @Created by zengzg
 */
@Controller
@RequestMapping("/folder")
public class AntBlogFolderController extends AbstractControllerView<AntBlogFolderServiceImpl, AntBlogFolder> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ModelAndView getAll() {
        logger.info("this is getAll");
        ModelAndView modelAndView = getModelAndView("list");
        modelAndView.addObject("datalist", service.list());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", "0");
        List<AntBlogFolder> antBlogFolders = service.list(queryWrapper);
        modelAndView.addObject("folders", antBlogFolders);
        return modelAndView;
    }

    @GetMapping("rootList")
    public @ResponseBody List<AntBlogFolder> getRootList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", "0");
        List<AntBlogFolder> antBlogFolders = service.list(queryWrapper);
        return antBlogFolders;
    }

    @Override
    public String getMapping() {
        return "folder";
    }

    @Autowired
    public void setService(AntBlogFolderServiceImpl service) {
        super.service = service;
    }
}

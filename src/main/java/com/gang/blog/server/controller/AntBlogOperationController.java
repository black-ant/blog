package com.gang.blog.server.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname AntBlogOperationController
 * @Description TODO
 * @Date 2020/12/19 22:15
 * @Created by zengzg
 */
@Controller
@RequestMapping("/operation")
public class AntBlogOperationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${com.gang.blog.view.package:control}")
    private String controlViewPackage;


    @GetMapping
    public ModelAndView getOperation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(controlViewPackage + "/blog_operation");
        return modelAndView;
    }
}

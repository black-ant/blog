package com.gang.blog.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname AntBlogIndexController
 * @Description TODO
 * @Date 2020/12/25 23:17
 * @Created by zengzg
 */
@RestController
@RequestMapping("/index")
public class AntBlogIndexController {

    @GetMapping
    public ModelAndView getIndex() {
        ModelAndView view = new ModelAndView();
        view.setViewName("control/index");
        return view;
    }
}

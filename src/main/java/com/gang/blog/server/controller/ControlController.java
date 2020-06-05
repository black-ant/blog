package com.gang.blog.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname ControlController
 * @Description TODO
 * @Date 2020/5/10 17:42
 * @Created by zengzg
 */
@RequestMapping("/control")
@Controller
public class ControlController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("index")
    public ModelAndView getIndex() {
        ModelAndView model = new ModelAndView();

        logger.info("------> this is in indes <-------");
        model.setViewName("/control/index");
        return model;
    }
}

package com.gang.blog.server.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gang.blog.server.entity.BaseEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Produces;

/**
 * @Classname AbstractView
 * @Description TODO
 * @Date 2020/3/21 19:39
 * @Created by zengzg
 */
@Produces(value = "application/json")
public abstract class AbstractControllerView<T extends IService, D extends BaseEntity> extends BaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${com.gang.blog.view.package:control}")
    private String controlViewPackage;

    @GetMapping("get/{key}")
    public ModelAndView getOne(@PathVariable("key") String key) {
        ModelAndView modelAndView = getModelAndView("edit");
        if (key.equals("null") || key.equals("0")) {
            modelAndView.addObject("data", null);
        } else {
            modelAndView.addObject("data", service.getById(key));
        }

        return modelAndView;
    }

    @GetMapping("list")
    public ModelAndView getAll() {
        logger.info("this is getAll");

        ModelAndView modelAndView = getModelAndView("list");
        modelAndView.addObject("datalist", service.list());
        return modelAndView;
    }

    public ModelAndView getModelAndView(String suffix) {
        ModelAndView modelAndView = new ModelAndView();

        String suffixView = StringUtils.isEmpty(controlViewPackage)
                ? suffix
                : controlViewPackage + (StringUtils.isEmpty(suffix) ? "/" : "/" + suffix + "_");

        modelAndView.setViewName(suffixView + getMapping());
        return modelAndView;
    }

    public abstract String getMapping();

    public void beforeBuild(D entity) {

    }
}

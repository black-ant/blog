package com.gang.blog.server.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gang.blog.server.entity.BaseEntity;
import com.gang.blog.server.to.BlogResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname BaseService
 * @Description TODO
 * @Date 2020/5/16 13:59
 * @Created by zengzg
 */
public class BaseService<T extends IService, D extends BaseEntity> {

    protected IService service;

    @GetMapping("delete")
    public BlogResponseModel delete(@PathVariable("key") String key) {
        service.removeById(key);
        return BlogResponseModel.commonResponse("Success");
    }

    @PostMapping("insert")
    public BlogResponseModel insert(@ModelAttribute("entity") D entity) {
        return BlogResponseModel.commonResponse(service.save(entity));
    }

    @PostMapping("insertOrUpdate")
    public BlogResponseModel insertOrUpdate(@RequestBody D entity) {
        return BlogResponseModel.commonResponse(service.saveOrUpdate(entity));
    }

    @PostMapping("update")
    public BlogResponseModel update(@ModelAttribute("entity") D entity) {
        return BlogResponseModel.commonResponse(service.saveOrUpdate(entity));
    }

}

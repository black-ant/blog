package com.gang.blog.server.service.impl;

import com.gang.blog.server.entity.AntBlogSetting;
import com.gang.blog.server.type.SettingKeyTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname AntProperties
 * @Description TODO
 * @Date 2020/10/19 22:31
 * @Created by zengzg
 */
@Component
public class AntProperties {

    @Autowired
    private AntBlogSettingServiceImpl settingService;

    @Cacheable(cacheNames = "properties", key = "pull")
    public Boolean getAutoPullTurn() {
        AntBlogSetting setting = settingService.getOneByCode(SettingKeyTypeEnum.AUTO_PULL_BLOG.getKey());
        return "true".equals(setting.getSettingValue());
    }

}

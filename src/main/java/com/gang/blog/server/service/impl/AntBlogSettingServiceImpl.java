package com.gang.blog.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogSetting;
import com.gang.blog.server.mapper.AntBlogSettingMapper;
import com.gang.blog.server.service.IAntBlogSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gang.blog.server.utils.MybatisQueryWrapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ant-black
 * @since 2020-09-24
 */
@Service
public class AntBlogSettingServiceImpl extends ServiceImpl<AntBlogSettingMapper, AntBlogSetting> implements IAntBlogSettingService {

    public AntBlogSetting getOneByName(String settinName) {
        return getOneByKeyAndValue("setting_name", settinName);
    }

    public AntBlogSetting getOneByCode(String settingCode) {
        return getOneByKeyAndValue("setting_code", settingCode);
    }


    public AntBlogSetting getOneByKeyAndValue(String key, String value) {
        IPage<AntBlogSetting> userIPage = baseMapper.selectPage(
                new Page<AntBlogSetting>(1, 1),
                MybatisQueryWrapper.buildEq("key", value)
        );

        AntBlogSetting setting = null;
        if (userIPage.getSize() > 0 && !userIPage.getRecords().isEmpty()) {
            setting = userIPage.getRecords().get(0);
        }
        return setting;
    }

}

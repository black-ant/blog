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
 *  服务实现类
 * </p>
 *
 * @author ant-black
 * @since 2020-09-24
 */
@Service
public class AntBlogSettingServiceImpl extends ServiceImpl<AntBlogSettingMapper, AntBlogSetting> implements IAntBlogSettingService {

    /**
     * 根据 Name 查询单个 AntBlogSetting
     *
     * @param blogType
     * @return
     */
    public AntBlogSetting getOneByName(String blogType) {
        IPage<AntBlogSetting> userIPage = baseMapper.selectPage(new Page<AntBlogSetting>(1, 1), MybatisQueryWrapper.buildEq("setting_name", blogType));
        AntBlogSetting setting = null;
        if (userIPage.getSize() > 0 && !userIPage.getRecords().isEmpty()) {
            setting = userIPage.getRecords().get(0);
        }
        return setting;
    }

}

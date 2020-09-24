package com.gang.blog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.mapper.AntBlogContentMapper;
import com.gang.blog.server.service.IAntBlogContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gang.blog.server.utils.MybatisQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ant-black
 * @since 2020-05-10
 */
@Service
public class AntBlogContentServiceImpl extends ServiceImpl<AntBlogContentMapper, AntBlogContent> implements IAntBlogContentService {


    /**
     * 根据 Type 查询单个 AntBlogContent
     *
     * @param blogType
     * @return
     */
    public AntBlogContent getOneByType(String blogType) {
        IPage<AntBlogContent> userIPage = baseMapper.selectPage(new Page<AntBlogContent>(1, 1), MybatisQueryWrapper.buildEq("BLOG_TYPE", blogType));
        AntBlogContent content = null;
        if (userIPage.getSize() > 0 && !userIPage.getRecords().isEmpty()) {
            content = userIPage.getRecords().get(0);
        }
        return content;
    }

    /**
     * @param code
     * @return
     */
    public AntBlogContent getOneByCode(String code) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("content_code", code);
        wrapper.select("id");
        return getOne(wrapper);
    }

}

package com.gang.blog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gang.blog.server.entity.AntBlogType;
import com.gang.blog.server.mapper.AntBlogTypeMapper;
import com.gang.blog.server.service.IAntBlogTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ant-black
 * @since 2020-05-10
 */
@Service
public class AntBlogTypeServiceImpl extends ServiceImpl<AntBlogTypeMapper, AntBlogType> implements IAntBlogTypeService {

    /**
     * 通过 Code
     * @param code
     * @return
     */
    public AntBlogType getByCode(String code) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type_code", code);
        return getOne(wrapper);
    }
}

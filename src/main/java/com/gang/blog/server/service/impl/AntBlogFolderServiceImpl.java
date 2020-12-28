package com.gang.blog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gang.blog.server.entity.AntBlogFolder;
import com.gang.blog.server.mapper.AntBlogFolderMapper;
import com.gang.blog.server.service.IAntBlogFolderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ant-black
 * @since 2020-12-19
 */
@Service
public class AntBlogFolderServiceImpl extends ServiceImpl<AntBlogFolderMapper, AntBlogFolder> implements IAntBlogFolderService {

    /**
     * @param code
     * @return
     */
    public AntBlogFolder findByCode(String code) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("folder_code", code);
        List<AntBlogFolder> list = this.list(wrapper);
        return list.get(0);
    }
}

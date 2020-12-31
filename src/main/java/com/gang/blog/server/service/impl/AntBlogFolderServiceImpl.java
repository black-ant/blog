package com.gang.blog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogFolder;
import com.gang.blog.server.entity.AntBlogType;
import com.gang.blog.server.mapper.AntBlogFolderMapper;
import com.gang.blog.server.service.IAntBlogFolderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gang.blog.server.to.AntBlogDocRequestTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
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
        return list.isEmpty() ? null : list.get(0);
    }


    public String createFolder(File fileItem, AntBlogDocRequestTO docRequestTO) {

        AntBlogFolder blogFolder;
        String relativePath = StringUtils.remove(fileItem.getPath(), docRequestTO.getRootPath());
        String parentRelativePath = StringUtils.remove(fileItem.getParent(), docRequestTO.getRootPath());

        AntBlogFolder folderOld = findByCode(relativePath);
        if (folderOld != null) {
            blogFolder = folderOld;
            blogFolder.setUpdateDate(new Date());
        } else {
            blogFolder = new AntBlogFolder();
            blogFolder.setCreateDate(new Date());
            blogFolder.setUpdateDate(new Date());
            blogFolder.setStatus("0");
            blogFolder.setType("0");
        }

        blogFolder.setFolderCode(relativePath);
        blogFolder.setFolderName(fileItem.getName());
        blogFolder.setFolderPath(fileItem.getPath());

        blogFolder.setParentName(fileItem.getParent());
        blogFolder.setParentCode(parentRelativePath);
        blogFolder.setParentId(docRequestTO.getFolderMap().get(parentRelativePath));

        blogFolder.setRoot(docRequestTO.getRootPath());
//        blogFolder.setChildIndex(relativePath.split("/\").length - 1);
        saveOrUpdate(blogFolder);
        docRequestTO.getFolderMap().put(relativePath, blogFolder.getId());
        return blogFolder.getId();
    }

}

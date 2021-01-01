package com.gang.blog.server.service.impl;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogType;
import com.gang.blog.server.mapper.AntBlogContentMapper;
import com.gang.blog.server.service.IAntBlogContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gang.blog.server.to.AntBlogDocTO;
import com.gang.blog.server.utils.MybatisQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.Date;
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

    @Autowired
    private AntBlogTypeServiceImpl blogTypeService;

    /**
     * 根据 Type 查询单个 AntBlogContent
     *
     * @param blogType
     * @return
     */
    public AntBlogContent getOneByType(String blogType) {
        IPage<AntBlogContent> userIPage = baseMapper.selectPage(new Page<AntBlogContent>(1, 1),
                MybatisQueryWrapper.buildEq("BLOG_TYPE", blogType));
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

    /**
     * 创建 Blog Content
     *
     * @param file
     * @param antBlogDocTO
     * @return
     */
    public String createContent(File file, AntBlogDocTO antBlogDocTO, String parentId) {

        AntBlogContent blogContent = new AntBlogContent();
        blogContent.setContentBodyType("MARKDOWN");
        blogContent.setContentBody(FileUtil.readString(file, "UTF-8"));
        blogContent.setContentFolder(parentId);
        if (antBlogDocTO == null) {
            blogContent.setContentTitle(file.getName());
            blogContent.setContentCode(file.getName());
            blogContent.setContentForeword(file.getName());
        } else {
            blogContent.setContentTitle(antBlogDocTO.getName());
            blogContent.setContentCode(antBlogDocTO.getCode());
            blogContent.setContentForeword(StringUtils.isNotEmpty(antBlogDocTO.getDesc()) ? antBlogDocTO.getDesc() :
                    getDesc(blogContent.getContentBody()));
        }


        AntBlogType blogType = getOrCreate(antBlogDocTO);

        blogContent.setBlogType(blogType.getTypeCode());
        blogContent.setCreateDate(new Date());

        AntBlogContent content = getOneByCode(blogContent.getContentCode());
        if (content != null) {
            blogContent.setId(content.getId());
        } else {
            blogContent.setContentHot("1");
            blogContent.setContentStart("1");
        }

        saveOrUpdate(blogContent);
        return "";
    }

    /**
     * 获取文档描述
     *
     * @return
     */
    public String getDesc(String docContent) {
        Integer index = StringUtils.indexOf(docContent, "\n|\r");
        // 起始位置
        Integer descStart = index > 0 ? index : 0;
        // 结束位置
        Integer descEnd = docContent.length() > 500 ? 500 : docContent.length();
        String descContetn = docContent.substring(descStart, descEnd);
//        descContetn = descContetn.replaceAll("\\r\\n", " ");
        descContetn = descContetn.replaceAll("\\[TOC\\]", "");
        //        logger.info("------> file :{} , {}-{} <-------", file.getPath(), descStart, descEnd);
        return descContetn;
    }


    /**
     * @param antBlogDocTO
     * @return
     */
    public AntBlogType getOrCreate(AntBlogDocTO antBlogDocTO) {
        String code = StringUtils.isEmpty(antBlogDocTO.getParentInfo().getCode()) ? "COMMON" :
                antBlogDocTO.getParentInfo().getCode();

        AntBlogType blogType = blogTypeService.getByCode(code);
        if (blogType == null) {
            blogType = new AntBlogType();

            blogType.setTypeClassify("1");
            blogType.setTypeCode(code);
            blogType.setTypeClassify(antBlogDocTO.getParentInfo().getClassType().toUpperCase());
        } else {
            blogType.setId(blogType.getId());
        }
        blogType.setTypeName(antBlogDocTO.getParentInfo().getName());
        blogType.setTypeOrder("1");
        blogType.setTypeStatus("1");
        blogType.setTypeDesc(antBlogDocTO.getParentInfo().getDesc());
        blogType.setUpdateUser("ant-black");
        blogType.setUpdateDate(new Date());
        blogTypeService.saveOrUpdate(blogType);
        return blogType;
    }


}

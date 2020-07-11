package com.gang.blog.server.service.impl;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogType;
import com.gang.blog.server.to.AntBlogDocRequestTO;
import com.gang.blog.server.to.AntBlogDocTO;
import com.gang.blog.server.utils.BlogFileUtils;
import com.gang.common.lib.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * @Classname BasePullService
 * @Description TODO
 * @Date 2020/7/11 15:38
 * @Created by zengzg
 */
public abstract class BasePullService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected AntBlogContentServiceImpl contentService;

    @Autowired
    protected AntBlogTypeServiceImpl blogTypeService;

    public abstract String pull(AntBlogDocRequestTO docRequestTO);

    /**
     * 递归处理 File 文件
     * 1 fileName -> contentCode (文件名避免了特殊字符)
     *
     * @param filePath
     * @return
     */
    public Boolean pullLogic(String filePath, AntBlogDocRequestTO docRequestTO) {
        Map<String, File> files = FileUtils.getFilesMapNoSuffix(filePath);
        if (!CollectionUtils.isEmpty(files)) {
            File settingFile = files.get(docRequestTO.getSettingFile());
            String config = FileUtil.isEmpty(settingFile) ? "" : FileUtil.readString(settingFile, "UTF-8");
            AntBlogDocTO antBlogDocTO = StringUtils.isNotEmpty(config) ? JSONObject.parseObject(config, AntBlogDocTO.class) : null;
            files.keySet().forEach(item -> {
                File fileItem = files.get(item);
                if (checkFile(fileItem)) {
                    if (FileUtil.isDirectory(fileItem)) {
                        pullLogic(fileItem.getPath(), docRequestTO);
                    } else {
                        if (antBlogDocTO != null && antBlogDocTO.getItemMap() != null) {
                            AntBlogDocTO blogDocTOChild = antBlogDocTO.getItemMap().get(BlogFileUtils.getFileName(fileItem.getName()));
                            if (blogDocTOChild != null) {
                                blogDocTOChild.setParentInfo(antBlogDocTO);
                                blogDocTOChild.setCode(BlogFileUtils.getFileName(fileItem.getName()));
                                createContent(fileItem, blogDocTOChild);
                            }
                        }
                    }
                } else {
                    logger.info("------> skip this file <-------");
                }
            });
        }
        return Boolean.TRUE;
    }

    /**
     * 过滤文本
     *
     * @return
     */
    public Boolean checkFile(File file) {
        String fileName = file.getName();
        if (fileName.contains(".git") || fileName.contains("BLOG.md")) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 创建 Blog Content
     *
     * @param file
     * @param antBlogDocTO
     * @return
     */
    public String createContent(File file, AntBlogDocTO antBlogDocTO) {

        AntBlogContent blogContent = new AntBlogContent();
        blogContent.setContentBodyType("MARKDOWN");
        blogContent.setContentBody(FileUtil.readString(file, "UTF-8"));
        if (antBlogDocTO == null) {
            blogContent.setContentTitle(file.getName());
            blogContent.setContentCode(file.getName());
            blogContent.setContentForeword(file.getName());
        } else {
            blogContent.setContentTitle(antBlogDocTO.getName());
            blogContent.setContentCode(antBlogDocTO.getCode());
            blogContent.setContentForeword(antBlogDocTO.getDesc());
        }


        AntBlogType blogType = getOrCreate(antBlogDocTO);

        blogContent.setBlogType(blogType.getTypeCode());
        blogContent.setCreateDate(new Date());

        AntBlogContent content = contentService.getOneByCode(blogContent.getContentCode());
        if (content != null) {
            blogContent.setId(content.getId());
        }

        contentService.saveOrUpdate(blogContent);
        return "";
    }

    /**
     * @param antBlogDocTO
     * @return
     */
    public AntBlogType getOrCreate(AntBlogDocTO antBlogDocTO) {
        String code = StringUtils.isEmpty(antBlogDocTO.getParentInfo().getCode()) ? "COMMON" : antBlogDocTO.getParentInfo().getCode();

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
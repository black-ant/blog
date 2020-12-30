package com.gang.blog.server.service.impl;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogType;
import com.gang.blog.server.to.AntBlogDocRequestTO;
import com.gang.blog.server.to.AntBlogDocTO;
import com.gang.blog.server.to.AntDocBuildTO;
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

    @Autowired
    private DocInfoService docInfoService;

    @Autowired
    private AntBlogFolderServiceImpl folderService;

    public abstract String pull(AntBlogDocRequestTO docRequestTO);

    /**
     * 递归处理 File 文件
     * 1 fileName -> contentCode (文件名避免了特殊字符)
     *
     * @param filePath
     * @return
     */
    public Boolean pullLogic(String filePath, AntBlogDocRequestTO docRequestTO) {

        logger.info("------> build Doc <-------");
        AntDocBuildTO buildTO = new AntDocBuildTO();
        buildTO.setFilePath(filePath);
        buildTO.setFindChild(Boolean.TRUE);
//        docInfoService.buildDocInfo(buildTO);

        logger.info("------> pullLogic :{} <-------", filePath);

        // Get folder Map Suffix
        File currentFile = FileUtil.file(filePath);
        // 构建根节点
        buildRootFile(filePath, docRequestTO);
        Map<String, File> files = FileUtils.getFilesMapNoSuffix(filePath);
        if (!CollectionUtils.isEmpty(files)) {
            folderService.createFolder(currentFile, docRequestTO);
            File settingFile = files.get(docRequestTO.getSettingFile());

            // 读取文件内容
            String config = FileUtil.isEmpty(settingFile) ? "" : FileUtil.readString(settingFile, "UTF-8");
            AntBlogDocTO antBlogDocTO = StringUtils.isNotEmpty(config) ? JSONObject.parseObject(config,
                    AntBlogDocTO.class) : null;

            // Get files
            files.keySet().forEach(item -> {
                File fileItem = files.get(item);

                // If it is a configuration file : BLOG.md
                if (checkFile(fileItem)) {

                    // If it is a folder, recursive query
                    if (FileUtil.isDirectory(fileItem)) {
                        pullLogic(fileItem.getPath(), docRequestTO);
                    } else {

                        if (antBlogDocTO != null && antBlogDocTO.getItemMap() != null) {
                            AntBlogDocTO blogDocTOChild =
                                    antBlogDocTO.getItemMap().get(BlogFileUtils.getFileName(fileItem.getName()));
                            if (blogDocTOChild != null) {
                                blogDocTOChild.setParentInfo(antBlogDocTO);
                                blogDocTOChild.setCode(BlogFileUtils.getFileName(fileItem.getName()));
                                contentService.createContent(fileItem, blogDocTOChild);
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
     * 设置根节点
     *
     * @param workSpace
     * @param docRequestTO
     */
    public void buildRootFile(String workSpace, AntBlogDocRequestTO docRequestTO) {
        if (StringUtils.isEmpty(docRequestTO.getRootPath())) {
            docRequestTO.setRootPath(workSpace);
        }
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


}

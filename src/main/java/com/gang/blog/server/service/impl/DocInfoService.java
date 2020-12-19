package com.gang.blog.server.service.impl;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.gang.blog.server.to.AntDocBuildTO;
import com.gang.common.lib.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

/**
 * @Classname DocInfoService
 * @Description TODO
 * @Date 2020/9/20 20:03
 * @Created by zengzg
 */
@Service
public class DocInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 构建 BLOG.md
     *
     * @param buildTO
     * @return
     */
    public Boolean buildDocInfo(AntDocBuildTO buildTO) {
        logger.info("------> DocInfoService - buildDocInfo Start <-------");
        buildFlow(buildTO.getFilePath(), buildTO.getFindChild());
        return Boolean.TRUE;
    }

    public Boolean buildFlow(String filePath, Boolean findChild) {

        logger.info("------> filePath :{} <-------", filePath);
        if (StringUtils.isNotEmpty(filePath) && !skipPath(filePath)) {

            // 获取当前路径下的所有
            Map<String, File> files = FileUtils.getFilesMapNoSuffix(filePath);

            JSONObject blogMD = files.containsKey("BLOG") ? getBlogMd(files.get("BLOG")) : new JSONObject();
            JSONObject itemArray = new JSONObject();
            files.keySet().forEach(itemKey -> {
                File fileItem = files.get(itemKey);
                if (findChild && FileUtil.isDirectory(files.get(itemKey))) {
                    buildFlow(fileItem.getPath(), findChild);
                } else {
                    if (!"BLOG".equals(itemKey)) {
                        JSONObject item = new JSONObject();
                        item.put("name", itemKey);
                        item.put("classType", "Doc");
                        item.put("status", "update");
                        itemArray.put(itemKey, item);
                    }

                }
            });

            logger.info("------> add Value :{} <-------", filePath);
            Integer collectionName = filePath.lastIndexOf("\\") > 0 ? filePath.lastIndexOf("\\") + 1 : 0;
            addValue(blogMD, "name", filePath.substring(collectionName, filePath.length()));
            addValue(blogMD, "desc", filePath.substring(collectionName, filePath.length()));
            addValue(blogMD, "code", filePath.substring(collectionName, filePath.length()));
            addValue(blogMD, "classType", "COLLECTION");
            addValue(blogMD, "status", "OPEN");

            blogMD.put("item", itemArray);

            buildBlogMd(filePath, blogMD.toJSONString());
        }

        logger.info("------> buildFlow over :{} <-------", filePath);
        return Boolean.TRUE;
    }

    public Boolean skipPath(String path) {
        return path.contains("images") || path.contains(".");
    }

    /**
     * 添加数据信息
     *
     * @param build
     * @param name
     * @param value
     */
    public void addValue(JSONObject build, String name, String value) {
        //        if (!build.containsKey(name)) {
        build.put(name, value);
        //        }
    }

    /**
     * 创建文件
     *
     * @param path
     * @param value
     */
    public void buildBlogMd(String path, String value) {
        FileUtil.writeString(value, path + "/BLOG.md", "UTF-8");
    }



    /**
     * 将 File 转换为 JSONObject
     *
     * @param file
     * @return
     */
    public JSONObject getBlogMd(File file) {
        //        logger.info("------> getBlogMd :{}  <-------", file.getPath());
        try {
            String docContent = FileUtils.getFileContent(file);
            return JSONObject.parseObject(docContent);
        } catch (Exception e) {
            logger.error("E----> getBlogMd error :{} -- content :{}", e.getClass(), e.getMessage());
            return new JSONObject();
        }
    }
}

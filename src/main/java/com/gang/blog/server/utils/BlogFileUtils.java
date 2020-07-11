package com.gang.blog.server.utils;

import cn.hutool.core.io.FileUtil;
import com.gang.blog.server.exception.AntBlogException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @Classname FileUtils
 * @Description TODO
 * @Date 2020/7/5 15:10
 * @Created by zengzg
 */
public class BlogFileUtils {

    private static Logger LOG = LoggerFactory.getLogger(BlogFileUtils.class);

    /**
     * 创建 Git File 文件
     */
    public static String createGitFile() {
        try {
            String path = getProgramPath();
            String fileSeparator = System.getProperty("file.separator");
            String newDir = path + fileSeparator + "blogDoc" + fileSeparator;
            FileUtil.mkdir(newDir);
            return newDir;
        } catch (Exception e) {
            throw new AntBlogException("Create Git File Error");
        }
    }

    /**
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = BlogFileUtils.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }

    public static String getFileName(String name) {
        name = StringUtils.replace(name, ".md", "");
        name = StringUtils.replace(name, ".txt", "");
//        name = StringUtils.replace(name, " ", "");
        return name;
    }
}

package com.gang.blog.server.utils;

import cn.hutool.core.io.FileUtil;
import com.gang.blog.server.exception.AntBlogException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
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
            String path = getJarPath();
            String fileSeparator = System.getProperty("file.separator");
            String newDir = path + fileSeparator + "blogDoc" + fileSeparator;
            FileUtil.mkdir(newDir);
            return newDir;
        } catch (Exception e) {
            throw new AntBlogException("Create Git File Error");
        }
    }


    /**
     * 获取当前 Jar 所在的路径 , 和 JAR 平级 , Linux 中不友好
     *
     * @return
     * @throws FileNotFoundException
     */
    public static String getJarPath() throws FileNotFoundException {
        return new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParent();
    }

    /**
     * 获取当前Target 所在的路径
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = BlogFileUtils.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }

    /**
     * @param file
     * @return
     */
    public static String getFileContent(File file) {
        return FileUtil.readString(file, "UTF-8");
    }

    /**
     * 通过名称获取 Doc
     *
     * @param name
     * @return
     */
    public static String getFileName(String name) {
        name = StringUtils.replace(name, ".md", "");
        name = StringUtils.replace(name, ".txt", "");
        //        name = StringUtils.replace(name, " ", "");
        return name;
    }

}

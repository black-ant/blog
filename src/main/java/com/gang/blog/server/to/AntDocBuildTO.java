package com.gang.blog.server.to;

import lombok.Data;

import java.util.List;

/**
 * @Classname AntDocBuildTO
 * @Description TODO
 * @Date 2020/9/20 19:21
 * @Created by zengzg
 */
@Data
public class AntDocBuildTO {

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 排除文件
     */
    private List<String> exclude;

    /**
     * 递归查询
     */
    private Boolean findChild;
}

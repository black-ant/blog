package com.gang.blog.server.exception;

import com.gang.common.lib.exception.CommonException;

/**
 * @Classname AntBlogException
 * @Description TODO
 * @Date 2020/7/5 19:27
 * @Created by zengzg
 */
public class AntBlogException  extends CommonException {

    public AntBlogException() {
        super();
    }

    public AntBlogException(String message) {
        super(message);
    }

    public AntBlogException(String code, String message) {
        super(message, code);
    }
}

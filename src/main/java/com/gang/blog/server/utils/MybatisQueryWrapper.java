package com.gang.blog.server.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @Classname MybatisQueryWrapper
 * @Description TODO
 * @Date 2020/6/21 16:16
 * @Created by zengzg
 */
public class MybatisQueryWrapper {

    public static QueryWrapper buildEq(String key, String value) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq(key, value);
        return wrapper;
    }
}

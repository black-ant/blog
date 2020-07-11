package com.gang.blog.server.config;

import com.gang.blog.server.cache.IBlogCache;
import com.gang.blog.server.cache.MemoryBlogCache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname CacheConfig
 * @Description TODO
 * @Date 2020/6/21 15:36
 * @Created by zengzg
 */
@Configuration
public class CacheConfig {

    //    @Bean
    //    public IBlogCache getBlogCache() {
    //        return new MemoryBlogCache();
    //    }
}

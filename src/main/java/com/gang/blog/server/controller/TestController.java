package com.gang.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.gang.blog.server.entity.AntBlogLog;
import com.gang.blog.server.to.AntBlogDocRequestTO;
import com.gang.common.lib.to.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2020/12/30 22:40
 * @Created by zengzg
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("post")
    public ResponseModel post(@RequestBody AntBlogDocRequestTO blogLog) {
        logger.info("------> this is post :{} <-------", JSONObject.toJSONString(blogLog));
        return ResponseModel.commonResponse("success");
    }
}

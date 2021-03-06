package com.gang.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.gang.blog.server.service.impl.AntProperties;
import com.gang.blog.server.service.impl.FilePullService;
import com.gang.blog.server.service.impl.GitPullService;
import com.gang.blog.server.to.AntBlogDocRequestTO;
import com.gang.common.lib.to.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AntBlogContentPullController
 * @Description TODO
 * @Date 2020/7/5 11:17
 * @Created by zengzg
 */
@RestController
@RequestMapping("/pull")
public class AntBlogContentPullController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GitPullService gitService;

    @Autowired
    private FilePullService filePullService;

    @Autowired
    private AntProperties antProperties;

    @PostMapping("bypath")
    public ResponseModel getBlogByPath(@RequestBody AntBlogDocRequestTO docRequestTO) {
        logger.info("------> this is post :{} <-------", JSONObject.toJSONString(docRequestTO));
        String back = "";
        if ("git".equals(docRequestTO.getType())) {
            back = gitService.pull(docRequestTO);
        } else if ("file".equals(docRequestTO.getType())) {
            filePullService.pull(docRequestTO);
        }

        return ResponseModel.commonResponse(back);
    }

    @PostMapping("post")
    public ResponseModel post(@org.springframework.web.bind.annotation.RequestBody AntBlogDocRequestTO blogLog) {
        logger.info("------> this is post :{} <-------", JSONObject.toJSONString(blogLog));
        return ResponseModel.commonResponse("success");
    }

    //    @Scheduled(cron = "0 0 22 1/1 * ? ")
    public void scheduledPullGitInfo() {
        logger.info("------> this is in  scheduledPullGitInfo<-------");
        if (antProperties.getAutoPullTurn()) {
            AntBlogDocRequestTO docRequestTO = new AntBlogDocRequestTO();
            docRequestTO.setProjectPath("https://github.com/black-ant/blogDoc.git");
            docRequestTO.setType("git");
            getBlogByPath(docRequestTO);
        }
    }

}

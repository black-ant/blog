package com.gang.blog.server.controller;

import com.gang.blog.server.service.impl.FilePullService;
import com.gang.blog.server.service.impl.GitPullService;
import com.gang.blog.server.to.AntBlogDocRequestTO;
import com.gang.common.lib.to.ResponseModel;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AntBlogContentPullController
 * @Description TODO
 * @Date 2020/7/5 11:17
 * @Created by zengzg
 */
@RequestMapping("/pull")
@RestController
public class AntBlogContentPullController {

    @Autowired
    private GitPullService gitService;

    @Autowired
    private FilePullService filePullService;

    @PostMapping(value = "/bypath")
    public ResponseModel getBlogByPath(@RequestBody AntBlogDocRequestTO docRequestTO) {

        String back = "";
        if ("git".equals(docRequestTO.getType())) {
            back = gitService.pull(docRequestTO);
        } else if ("file".equals(docRequestTO.getType())) {
            filePullService.pull(docRequestTO);
        }

        return ResponseModel.commonResponse(back);
    }

}

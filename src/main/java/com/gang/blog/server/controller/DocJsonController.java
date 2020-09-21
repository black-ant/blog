package com.gang.blog.server.controller;

import com.gang.blog.server.service.impl.DocInfoService;
import com.gang.blog.server.to.AntDocBuildTO;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname DocJsonController
 * @Description TODO
 * @Date 2020/9/20 19:09
 * @Created by zengzg
 */
@RestController
@RequestMapping("/docbuild")
public class DocJsonController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DocInfoService docInfoService;

    @GetMapping
    public void buildDocJSON(@RequestBody AntDocBuildTO antDocBuildTO) {
        logger.info("------> this is in docBuild <-------");
        docInfoService.buildDocInfo(antDocBuildTO);
    }
}

package com.gang.blog.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gang.blog.server.entity.AntBlogFolder;
import com.gang.blog.server.service.impl.AntBlogFolderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @Classname AntBlogFolderController
 * @Description TODO
 * @Date 2020/12/19 15:47
 * @Created by zengzg
 */
@Controller
@RequestMapping("/folder")
public class AntBlogFolderController extends AbstractControllerView<AntBlogFolderServiceImpl, AntBlogFolder> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ModelAndView getAll() {
        logger.info("this is getAll");
        ModelAndView modelAndView = getModelAndView("list");
        modelAndView.addObject("datalist", service.list());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", "0");
        List<AntBlogFolder> antBlogFolders = service.list(queryWrapper);
        modelAndView.addObject("folders", antBlogFolders);
        return modelAndView;
    }

    @GetMapping("folderList")
    @ResponseBody
    public JSONArray getByRoot(@RequestParam(name = "root") String root) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("root", new String(Base64Utils.decodeFromString(root)));
        List<AntBlogFolder> antBlogFolders = service.list(queryWrapper);
        JSONArray array = new JSONArray();
        antBlogFolders.forEach(item -> {
            JSONObject folderItem = new JSONObject();
            folderItem.put("id", item.getId());
            folderItem.put("parent", StringUtils.isEmpty(item.getParentId()) ? "#" : item.getParentId());
            folderItem.put("text", item.getFolderName());
            array.add(folderItem);
        });
        return array;
    }

    @GetMapping("rootList")
    @ResponseBody
    public List<AntBlogFolder> getRootList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", "0");
        List<AntBlogFolder> antBlogFolders = service.list(queryWrapper);
        return antBlogFolders;
    }

    @Override
    public String getMapping() {
        return "folder";
    }

    @Autowired
    public void setService(AntBlogFolderServiceImpl service) {
        super.service = service;
    }
}

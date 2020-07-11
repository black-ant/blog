package com.gang.blog.server.service.impl;

import com.gang.blog.server.to.AntBlogDocRequestTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Classname FilePullService
 * @Description TODO
 * @Date 2020/7/11 15:39
 * @Created by zengzg
 */
@Component
public class FilePullService extends BasePullService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String pull(AntBlogDocRequestTO docRequestTO) {

        if (StringUtils.isNotEmpty(docRequestTO.getProjectPath())) {
            try {
                String filePath = docRequestTO.getProjectPath();
                if (docRequestTO.getTreeMap() == null) {
                    docRequestTO.setTreeMap(new HashMap<>());
                }
                pullLogic(filePath, docRequestTO);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("E----> error :{} -- content :{}", e.getClass(), e.getMessage());
            }
        }
        return "ok";
    }

}

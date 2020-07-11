package com.gang.blog.server.service.impl;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gang.blog.server.entity.AntBlogContent;
import com.gang.blog.server.entity.AntBlogType;
import com.gang.blog.server.to.AntBlogDocRequestTO;
import com.gang.blog.server.to.AntBlogDocTO;
import com.gang.blog.server.utils.BlogFileUtils;
import com.gang.common.lib.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname AntBlogContentGitService
 * @Description TODO
 * @Date 2020/7/5 13:09
 * @Created by zengzg
 */
@Component
public class GitPullService extends BasePullService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 从 Git 中 pull 数据
     *
     * @param docRequestTO
     * @return
     */
    @Override
    public String pull(AntBlogDocRequestTO docRequestTO) {

        if (StringUtils.isNotEmpty(docRequestTO.getProjectPath())) {
            try {
                String filePath = cloneGit(docRequestTO);
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


    /**
     * 拉取远程仓库内容到本地
     */
    public void pullGit(String path) throws IOException, GitAPIException {

        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new
                UsernamePasswordCredentialsProvider("username", "password");
        String localPath = BlogFileUtils.createGitFile();

        //git仓库地址
        Git git = new Git(new FileRepository(localPath + "/.git"));
        git.pull().setRemoteBranchName("master").
                setCredentialsProvider(usernamePasswordCredentialsProvider).call();
    }


    /**
     * 克隆远程库
     *
     * @throws IOException
     * @throws GitAPIException
     */
    public String cloneGit(AntBlogDocRequestTO docRequestTO) throws IOException, GitAPIException {


        //设置远程服务器上的用户名和密码
        UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new
                UsernamePasswordCredentialsProvider("username", "password");
        String localPath = BlogFileUtils.createGitFile();

        if (FileUtil.isDirectory(localPath + ".git")) {
            Git git = new Git(new FileRepository(localPath + "/.git"));
            git.pull().call();
        } else {
            //克隆代码库命令
            CloneCommand cloneCommand = Git.cloneRepository();

            Git git = cloneCommand.setURI(docRequestTO.getProjectPath()) //设置远程URI
                    .setBranch("master") //设置clone下来的分支
                    .setDirectory(new File(localPath)) //设置下载存放路径
                    .setCredentialsProvider(usernamePasswordCredentialsProvider) //设置权限验证
                    .call();
        }
        return localPath;

    }
}

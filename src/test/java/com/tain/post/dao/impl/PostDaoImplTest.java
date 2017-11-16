package com.tain.post.dao.impl;

import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.post.dao.PostDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class PostDaoImplTest {

    @Resource
    private PostDao postDao;

    //查询所有
    @Test
    public void query(){
        System.out.println(postDao.query());
    }

    //更改
    @Test
    public void Update(){
        Post post = new Post();
        post.setPostName("暗");
        post.setPostId("2c9090cc5fb53eaf015fb53eb8110001");
        System.out.println(postDao.save(post));
    }

    //添加
    @Test
    public void save(){
        Post post = new Post();
        post.setPostName("雷部");
        post.setPostId("");
        postDao.save(post);
    }

}
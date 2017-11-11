package com.tain.post.dao.impl;

import com.tain.manpower.domain.Post;
import com.tain.post.dao.PostDao;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostDaoImplTest {
    @Resource
    private PostDao postDao;

    @Test
    public void test(){
        List<Post> query = postDao.query();
        for (Post post : query) {
            System.out.println(post.getPostName());
        }
    }

}
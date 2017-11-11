package com.tain.post.service.impl;

import com.tain.manpower.domain.Post;
import com.tain.post.dao.PostDao;
import com.tain.post.service.PostService;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */

public class PostServiceImpl implements PostService {
    private PostDao postDao;

    @Override
    public List<Post> query() {
        return postDao.query();
    }

    @Override
    public List<Post> save(Post post) {
        return postDao.save(post);
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}

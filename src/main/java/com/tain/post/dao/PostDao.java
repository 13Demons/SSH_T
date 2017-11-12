package com.tain.post.dao;

import com.tain.manpower.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface PostDao {

    List<Post>query();
    List<Post>save(Post post);
}

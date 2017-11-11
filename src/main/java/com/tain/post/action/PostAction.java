package com.tain.post.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.post.service.PostService;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostAction extends ActionSupport implements ModelDriven<Post> {
    private Post post = new Post();
    private Department department = new Department();

    @Resource
    private PostService postService;
    private List<Post> query;

    public String save(){
        List<Post> save = postService.save(post);
        ActionContext.getContext().put("post",save);
        return SUCCESS;
    }

    public String query(){
        query = postService.query();
        return SUCCESS;
    }


    public String hold(){



        return SUCCESS;
    }



    @Override
    public Post getModel() {
        return post;
    }


    public void setQuery(List<Post> query) {
        this.query = query;
    }

    public List<Post> getQuery() {
        return query;
    }


}

package com.tain.post.action;



import com.tain.manpower.Base.BaseAction;

import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.post.service.PostService;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dllo on 17/11/11.
 */
public class PostAction extends BaseAction<Post,PostService> {

    @Resource
    private PostService postService;
    private List<Post> query;
    private List<Post> save;

    public String query(){

        query = postService.query();
        return SUCCESS;
    }

    public String save(){
        save = postService.save(getModel());
        return SUCCESS;
    }

    public List<Post> getSave() {
        return save;
    }

    public void setSave(List<Post> save) {
        this.save = save;
    }

    public List<Post> getQuery() {
        return query;
    }

    public void setQuery(List<Post> query) {
        this.query = query;
    }
}

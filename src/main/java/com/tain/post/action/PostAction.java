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



    private String depId;
    private String depName;



    @Resource
    private PostService postService;
    private List<Post> query;
    private List<Post> save;


    public String query(){
        query = postService.query();
        return SUCCESS;
    }

    public String save(){
        post.setDepartment(new Department(depId,null));
        save = postService.save(post);
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

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }



    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Post> getSave() {
        return save;
    }

    public void setSave(List<Post> save) {
        this.save = save;
    }
}

package com.tain.post.action;



import com.opensymphony.xwork2.ActionContext;
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

    private List<Post> query;
    private List<Post> save;

    /**
     * 查询全部
     * @return
     */
    public String query(){
        query = service.query();
        return SUCCESS;
    }

    /**
     * 添加&编译
     * @return
     */
    public String save(){
        save = service.save(getModel());
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

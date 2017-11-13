package com.tain.department.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tain.department.service.DeptService;
import com.tain.manpower.domain.Department;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptAction extends ActionSupport implements ModelDriven<Department> {
    private Department dept=new Department();
    private String  postId;

    @Resource
    private DeptService deptService;
    private List<Department> query;

    //添加
    public String save(){
        List<Department> save = deptService.save(dept);
        ActionContext.getContext().put("deptService",save);
        return SUCCESS;
    }

    //查询
    public String query(){
        query = deptService.query();
//        ActionContext.getContext().put("deptService", query);
        return SUCCESS;

    }


    @Override
    public Department getModel() {
        return dept;
    }

    public List<Department> getQuery() {
        return query;
    }

    public void setQuery(List<Department> query) {
        this.query = query;
    }


    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}

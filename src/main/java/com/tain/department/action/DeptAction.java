package com.tain.department.action;

import com.opensymphony.xwork2.ActionContext;
import com.tain.department.service.DeptService;
import com.tain.manpower.Base.BaseAction;
import com.tain.manpower.domain.Department;
import com.tain.manpower.utils.PageBean;
import org.apache.struts2.interceptor.validation.SkipValidation;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptAction extends BaseAction<Department,DeptService> {


    private List<Department> query;
    private String postId;


    //添加&修改
    public String save(){
        service.save(getModel());
        return SUCCESS;
    }
    //显示部门

    public String query(){
        query = service.query();
        return SUCCESS;
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

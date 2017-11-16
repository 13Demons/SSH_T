package com.tain.department.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tain.department.service.DeptService;
import com.tain.manpower.domain.Department;
import com.tain.manpower.utils.PageBean;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptAction extends ActionSupport implements ModelDriven<Department> {
    private Department dept = new Department();
    String postId;
    private int pageNum;
    private int pageSize = 5;

    @Resource
    private DeptService deptService;
    private List<Department> query;

    //添加
    public String save() {
        deptService.save(dept);
        return SUCCESS;
    }

    //查询
    public String query() {
        query = deptService.query();
        return SUCCESS;
    }


    public String findDepartmentByPage() {
        if (pageNum == 0) {
            pageNum = 1;
        }
        PageBean<Department> all = deptService.findStaffByPage(dept, pageNum, pageSize);
        ActionContext.getContext().getSession().put("pageBean", all);
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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

package com.tain.department.action;

import com.opensymphony.xwork2.ActionContext;
import com.tain.department.service.DeptService;
import com.tain.manpower.Base.BaseAction;
import com.tain.manpower.domain.Department;
import com.tain.manpower.utils.PageBean;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptAction extends BaseAction<Department,DeptService> {

    @Resource
    private DeptService deptService;
    private List<Department> query;
    private String postId;
    private int pageNum;
    private int pageSize=5;

    //添加&修改
    public String save(){
        deptService.save(getModel());
        return SUCCESS;
    }
    //显示部门
    public String query(){
        query = deptService.query();
        return SUCCESS;
    }
    //分页
    public String findDeptPage(){
        if (pageNum==0){
            pageNum=1;
        }
        PageBean<Department> all = deptService.findDeptByPage(getModel(), pageNum, pageSize);
        ActionContext.getContext().getSession().put("pageBean",all);
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

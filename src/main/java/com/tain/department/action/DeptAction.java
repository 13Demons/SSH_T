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

    private int totalSize;
    private int length;
    private int pageSize;
    private int offSet;
    private List<Department> listByPage;

    /**
     * 添加&修改
     * @return
     */
    public String save(){
        service.save(getModel());
        return SUCCESS;
    }

    /**
     * 显示所有数据库
     * @return
     */
    public String query(){
        query = service.query();
        return SUCCESS;
    }

    /**
     * 分页
     * @return
     */
    public String paging(){
        List<Department>list = service.query();
        totalSize = list.size();
        length = 5;
        pageSize = totalSize/length+1;
        int overPlus = totalSize - totalSize%5;
        if (offSet<0){
            offSet =0;
        }else if (offSet>totalSize){
            offSet = overPlus;
        }
        ActionContext.getContext().getSession().put("overPlus",overPlus);
        ActionContext.getContext().getSession().put("offSet",offSet);
        ActionContext.getContext().getSession().put("pageSize",pageSize);
        listByPage = service.getListByPage(offSet, length);
        ActionContext.getContext().getSession().put("list_by_page",listByPage);

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

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffSet() {
        return offSet;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    public List<Department> getListByPage() {
        return listByPage;
    }

    public void setListByPage(List<Department> listByPage) {
        this.listByPage = listByPage;
    }
}

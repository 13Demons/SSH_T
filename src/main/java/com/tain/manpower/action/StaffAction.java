package com.tain.manpower.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.service.StaffService;
import org.apache.struts2.interceptor.validation.SkipValidation;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff = new Staff();

    @Resource
    private StaffService staffService;

    private List<Staff> staffs;
    private List<Department> departmentList;
    private List<Post> posts;
    private String staffId;



    //登录
    public String login() {
        List<Staff> staffs = staffService.login(staff.getLoginName(), staff.getLoginPwd());
        if (staffs.isEmpty()) {
            return ERROR;
        }
        ActionContext.getContext().getSession().put("username", staffs.get(0).getStaffName());
        return SUCCESS;
    }

    //显示全部
    @SkipValidation
    public String query() {
        //所有部门获取到
        staffs = staffService.query();
        ActionContext.getContext().getSession().put("staff",staffs);
        return SUCCESS;

    }

    //二级联动
    @SkipValidation
    public String findDepartment(){
        ActionContext.getContext().getSession().put("staffId",staffId);
        System.out.println(staffId);
        departmentList = staffService.findDepartment();
        staffs = (List<Staff>) ActionContext.getContext().getSession().get("staff");
        return SUCCESS;
    }


    //添加-修改
    @SkipValidation
    public String save(){
        System.out.println(staff.getStaffId()+"********");
        staff.setStaffId(staffId);
        staffService.save(staff);
        return SUCCESS;
    }

    @SkipValidation
    public String getPostByDeptId(){
        posts = staffService.getPostByDeptId(staff.getPost().getDepartment().getDepId());
        return SUCCESS;
    }



    //psotId depId staffName
    @SkipValidation
    public String queryAll(){
        String depId    = staff.getPost().getDepartment().getDepId();
        String postId   = staff.getPost().getPostId();
        String staffName = staff.getStaffName();
        staffs = staffService.queryAll(
                depId,
                postId,
                staffName);
        System.out.println("staffs.size():" + staffs.size());
        return SUCCESS;
    }


    @Override
    public Staff getModel() {
        return staff;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }


    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}

package com.tain.manpower.action;

import com.opensymphony.xwork2.ActionContext;

import com.tain.manpower.Base.BaseAction;
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
public class StaffAction extends BaseAction<Staff,StaffService> {

    private List<Staff> staffs;
    private List<Department> department;
    private List<Post> posts;


    private String password;
    private String Pwd;
    private String StaffPwd;


    public String login() {

        staffs = service.login(getModel().getLoginName(), getModel().getLoginPwd());
        //关于登录传值loginName
        ActionContext.getContext().getSession().put("loginName",getModel().getLoginName());
        if (staffs.isEmpty()) {
            return ERROR;
        }
        //关于更新密码的传值
        ActionContext.getContext().getSession().put("staff",staffs.get(0));
        return SUCCESS;
    }

    //显示
    @SkipValidation
    public String query() {
        staffs = service.query();
        ActionContext.getContext().getSession().put("staff", staffs);
        return SUCCESS;
    }

    //二级联动
    @SkipValidation
    public String findDepartment() {
        department = service.findDepartment();
        ActionContext.getContext().put("department", department);
        staffs = (List<Staff>) ActionContext.getContext().getSession().get("staff");
        return SUCCESS;
    }

    //添加修改
    @SkipValidation
    public String save() {
        service.save(getModel());
        return SUCCESS;
    }

    @SkipValidation
    public String getPostByDeptId() {
        posts = service.getPostByDeptId(getModel().getPost().getDepartment().getDepId());
        return SUCCESS;
    }

    @SkipValidation
    public String queryAll() {
        String depId = getModel().getPost().getDepartment().getDepId();
        String postId = getModel().getPost().getPostId();
        String staffName = getModel().getStaffName();
        staffs = service.queryAll(depId, postId, staffName);
        return SUCCESS;
    }

    //更改密码
    @SkipValidation
    public String updateLoginPwd(){
        Staff staff = (Staff) ActionContext.getContext().getSession().get("staff");
        if (!password.equals(staff.getLoginPwd())||!Pwd.equals(StaffPwd)){
            addActionError("密码输入错误");
            return ERROR;
        }else {
            service.LoginPwd(staff,StaffPwd);
            return SUCCESS;
        }
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getStaffPwd() {
        return StaffPwd;
    }

    public void setStaffPwd(String staffPwd) {
        StaffPwd = staffPwd;
    }
}
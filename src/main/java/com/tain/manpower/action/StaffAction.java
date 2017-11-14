package com.tain.manpower.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.service.StaffService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff = new Staff();

    private String loginName;
    private String loginPwd;
    private String depId;
    private String depName;

    @Resource
    private StaffService staffService;
    private List<Staff> staffs;
    private List<Department> departmentList;
    private List<Post> posts;
    private List<Staff> save;
    private List<Staff> staff_s;


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
    public String query() {
        staffs = staffService.query();
        ActionContext.getContext().getSession().put("staff",staffs);
        return SUCCESS;
    }

    //二级联动
    public String findDepartment(){
        departmentList = staffService.findDepartment();
        staff_s = (List<Staff>) ActionContext.getContext().getSession().get("staff");
        return SUCCESS;
    }


    //添加-修改
    public String save(){
        save = staffService.save(staff);
        staff_s = (List<Staff>) ActionContext.getContext().getSession().get("staff");
        return SUCCESS;
    }


    public String getPostByDeptId(){
        posts = staffService.getPostByDeptId(depId);
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Staff> getSave() {
        return save;
    }

    public void setSave(List<Staff> save) {
        this.save = save;
    }

    public List<Staff> getStaff_s() {
        return staff_s;
    }

    public void setStaff_s(List<Staff> staff_s) {
        this.staff_s = staff_s;
    }

}

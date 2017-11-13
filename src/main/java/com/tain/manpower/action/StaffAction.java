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


    private String loginName;
    private String loginPwd;
    private String depId;
    @Resource
    private StaffService staffService;
    private List<Staff> staffs;
    private List<Department> departmentList;
    private List<Post> deptId;


    //登录
    public String login() {
        List<Staff> staffs = staffService.login(staff.getLoginName(), staff.getLoginPwd());
        if (staffs.isEmpty()) {
            return ERROR;
        }
        ActionContext.getContext().getSession().put("username", staffs.get(0).getStaffName());
        return SUCCESS;
    }



    //无用---显示全部
    public String query() {
        staffs = staffService.query();
        return SUCCESS;
    }


    //添加
    public String save(){
        List<Staff> save = staffService.save(staff);
        ActionContext.getContext().put("staffService",save);
        return SUCCESS;
    }


    public String findDepartment(){
        departmentList = staffService.findDepartment();
        return SUCCESS;
    }

    public String getPostByDeptId(){
        deptId = staffService.getPostByDeptId(depId);
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

    public List<Post> getDeptId() {
        return deptId;
    }

    public void setDeptId(List<Post> deptId) {
        this.deptId = deptId;
    }
}

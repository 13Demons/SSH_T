package com.tain.manpower.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.service.StaffService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff = new Staff();

    @Resource
    private StaffService staffService;

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
    public String findAll() {
        List<Staff> staffs = staffService.findAll();
        ActionContext.getContext().put("staffs", staffs);
        return SUCCESS;
    }


    @Override
    public Staff getModel() {
        return staff;
    }

}

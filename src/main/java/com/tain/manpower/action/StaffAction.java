package com.tain.manpower.action;

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



    public String register(){
        List<Staff> staffs = staffService.register(staff.getLoginName(),staff.getLoginPwd());
        if (staffs.isEmpty()){
            return ERROR;
        }
        return SUCCESS;
    }



    @Override
    public Staff getModel() {
        return staff;
    }

}

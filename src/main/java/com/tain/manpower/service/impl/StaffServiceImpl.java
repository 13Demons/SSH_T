package com.tain.manpower.service.impl;

import com.tain.manpower.dao.StaffDao;
import com.tain.manpower.dao.impl.StaffDaoImpl;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.service.StaffService;

import java.util.List;


/**
 * Created by dllo on 17/11/9.
 */
public class StaffServiceImpl implements StaffService {


    private StaffDao staffDao;

    //登录
    @Override
    public List<Staff> login(String loginName, String loginPwd) {
        return staffDao.login(loginName,loginPwd);
    }



    //显示所有
    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }






    @Override
    public List<Staff> addStaff(Staff staff) {
        return null;
    }




    public void setStaffDao(StaffDaoImpl staffDao) {
        this.staffDao = staffDao;
    }

}


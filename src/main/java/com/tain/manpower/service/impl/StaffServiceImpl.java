package com.tain.manpower.service.impl;

import com.tain.manpower.dao.StaffDao;
import com.tain.manpower.dao.impl.StaffDaoImpl;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.service.StaffService;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dllo on 17/11/9.
 */
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDaoImpl staffDao;


//    public java.util.List<Staff> register(String loginName, String loginPwd) {
//
//        return staffDao.register(loginName,loginPwd);
//    }


    @Override
    public List<Staff> register(String loginName, String loginPwd) {
        return staffDao.register(loginName,loginPwd);
    }



//    public void setStaffDao(StaffDao staffDao) {
//        this.staffDao = staffDao;
//    }


    public void setStaffDao(StaffDaoImpl staffDao) {
        this.staffDao = staffDao;
    }

}


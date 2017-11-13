package com.tain.manpower.service.impl;

import com.tain.manpower.dao.StaffDao;
import com.tain.manpower.dao.impl.StaffDaoImpl;
import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
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

    //显示全部
    @Override
    public List<Staff> query() {
        return staffDao.query();
    }

    @Override
    public List<Staff> save(Staff staff) {
        return staffDao.save(staff);
    }

    @Override
    public List<Department> findDepartment() {
        return staffDao.findDepartment();
    }

    @Override
    public List<Post> getPostByDeptId(String deptId) {
        return staffDao.getPostByDeptId(deptId);
    }


    public void setStaffDao(StaffDaoImpl staffDao) {
        this.staffDao = staffDao;
    }

}


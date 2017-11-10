package com.tain.manpower.dao;

import com.tain.manpower.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao {
   //登录
    List<Staff>login(String loginName, String loginPwd);
    //添加
    List<Staff>addStaff(Staff staff);
    //显示
    List<Staff>findAll();


}

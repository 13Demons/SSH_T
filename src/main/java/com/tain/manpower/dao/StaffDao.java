package com.tain.manpower.dao;

import com.tain.manpower.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao {
    List<Staff> register(String loginName, String loginPwd);

}

package com.tain.manpower.service;

import com.tain.manpower.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService {
    List<Staff> register(String loginName, String loginPwd);
}


package com.tain.manpower.service;

import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService {
    List<Staff> login(String loginName, String loginPwd);

    List<Staff>query();

    List<Staff>save(Staff staff);

    List<Department> findDepartment();

    List<Post>getPostByDeptId(String deptId);


    List<Staff>queryAll(String depId,String postId,String staffName);

    void LoginPwd(Staff staff,String password);

}


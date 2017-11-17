package com.tain.manpower.dao;

import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.manpower.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao {
   //登录
    List<Staff>login(String loginName, String loginPwd);
    List<Staff>query();
    List<Staff>save(Staff staff);

    List<Department> findDepartment();
    List<Post>getPostByDeptId(String deptId);

    List<Staff>queryAll(String depId,String postId,String staffName);


    void LoginPwd(Staff staff,String password);

}



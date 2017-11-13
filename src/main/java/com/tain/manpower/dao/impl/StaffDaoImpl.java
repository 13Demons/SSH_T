package com.tain.manpower.dao.impl;

import com.tain.manpower.dao.StaffDao;
import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.manpower.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    //登录
    @Override
    public List<Staff> login(String loginName, String loginPwd) {

        Object[]value = {loginName,loginPwd};
        String sql = "from Staff T_STAFF where loginName=? and loginPwd =?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, value);
        return list;
    }

    //显示
    @Override
    public List<Staff> query() {
        String sql = "from Staff T_STAFF";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
        return list;
    }

    //添加
    @Override
    public List<Staff> save(Staff staff) {
        if (staff.getStaffId().isEmpty()){
            getHibernateTemplate().save(staff);
        }else {
            getHibernateTemplate().saveOrUpdate(staff);
        }
        return null;
    }

    @Override
    public List<Department> findDepartment() {
        String sql = "from Department T_DEPT";
        List<Department> list = (List<Department>) getHibernateTemplate().find(sql);
        return list;
    }

    @Override
    public List<Post> getPostByDeptId(String deptId) {
        String sql = "from Post T_POST where department.id=?";
        List<Post> list = (List<Post>) getHibernateTemplate().find(sql, deptId);
        return list;
    }


}


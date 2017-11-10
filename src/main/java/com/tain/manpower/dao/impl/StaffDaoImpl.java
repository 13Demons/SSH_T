package com.tain.manpower.dao.impl;

import com.tain.manpower.dao.StaffDao;
import com.tain.manpower.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {


    @Override
    public List<Staff> login(String loginName, String loginPwd) {

        Object[]value = {loginName,loginPwd};
        String sql = "from Staff T_STAFF where loginName=? and loginPwd =?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, value);
        return list;
    }


    @Override
    public List<Staff> findAll() {
        String sql = "from Staff T_STAFF";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
        return list;
    }

    @Override
    public List<Staff> addStaff(Staff staff) {
        return null;
    }



}


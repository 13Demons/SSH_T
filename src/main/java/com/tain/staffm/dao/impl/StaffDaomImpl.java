package com.tain.staffm.dao.impl;

import com.tain.manpower.domain.Staff;
import com.tain.staffm.dao.StaffDaom;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaomImpl extends HibernateDaoSupport implements StaffDaom {
    @Override
    public List<Staff> findAll() {
        String sql = "from Staff T_STAFF";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
        return list;
    }


}

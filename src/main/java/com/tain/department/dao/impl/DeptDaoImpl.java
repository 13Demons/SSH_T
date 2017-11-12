package com.tain.department.dao.impl;

import com.tain.department.dao.DeptDao;
import com.tain.manpower.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {

    //添加
    @Override
    public List<Department> save(Department department) {

        if (department.getDepId().isEmpty()){
            getHibernateTemplate().save(department);
        }else {
            getHibernateTemplate().saveOrUpdate(department);
        }
        return null;
    }

    //查询
    @Override
    public List<Department> query() {
        String sql ="from Department T_DEPT";
        List<Department> list = (List<Department>) getHibernateTemplate().find(sql);
        return list;

    }


}

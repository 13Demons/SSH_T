package com.tain.department.dao.impl;

import com.tain.department.dao.DeptDao;
import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.utils.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {

    //添加和更改
    //判断部门ID是否为空-添加或更改
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
    //查询所有部门数据库中内容
    @Override
    public List<Department> query() {
        String sql ="from Department T_DEPT";
        List<Department> list = (List<Department>) getHibernateTemplate().find(sql);
        return list;

    }

    @Override
    public int getTotalDepartment() {
        String sql = "select count(d) from Department d where 1=1";
        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);
        if (find!=null){
            return find.get(0).intValue();
        }
        return 0;
    }



    @Override
    public List<Department> findDepartmentByPage(int startIndex, int pageSize) {
        String sql = "from Department where 1=1";
        return getHibernateTemplate().execute(new PageHibernateCallback<Department>(sql,startIndex,pageSize));
    }


}

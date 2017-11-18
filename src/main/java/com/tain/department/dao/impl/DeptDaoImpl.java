package com.tain.department.dao.impl;

import com.tain.department.dao.DeptDao;
import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.utils.PageHibernateCallback;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {

    /**
     * 添加和更改
     * 判断部门ID是否为空-添加或更改
     * @param department
     * @return
     */
    @Override
    public List<Department> save(Department department) {
        if (department.getDepId().isEmpty()){
            getHibernateTemplate().save(department);
        }else {
            getHibernateTemplate().saveOrUpdate(department);
        }
        return null;
    }


    /**
     * 查询全部数据库中内容
     * @return
     */
    @Override
    public List<Department> query() {
        String sql ="from Department T_DEPT";
        List<Department> list = (List<Department>) getHibernateTemplate().find(sql);
        return list;

    }

    /**
     * 分页
     * @param offSet 总页数
     * @param length 一页多少个
     * @return
     */
    @Override
    public List<Department> getListByPage(int offSet, int length) {
        final String sql="from Department T_DEPT";
        List<Department> list =getHibernateTemplate().execute(new HibernateCallback<List<Department>>() {
            @Override
            public List<Department> doInHibernate(Session session) {
                Query query = session.createQuery(sql);
                query.setFirstResult(offSet);
                query.setMaxResults(length);
                List<Department> list1 = query.list();
                return list1;
            }
        });
        return list;
    }

}

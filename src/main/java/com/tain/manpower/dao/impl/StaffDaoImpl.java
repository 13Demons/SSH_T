package com.tain.manpower.dao.impl;

import com.tain.manpower.dao.StaffDao;
import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.utils.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
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
        if (staff.getStaffId()==null){
          getHibernateTemplate().save(staff);
        }else {
            getHibernateTemplate().saveOrUpdate(staff);
        }
        return null;
    }

    //二级联动(部门)
    @Override
    public List<Department> findDepartment() {
        String sql = "from Department T_DEPT";
        List<Department> list = (List<Department>) getHibernateTemplate().find(sql);
        return list;
    }

    //二级联动(职位Id)
    @Override
    public List<Post> getPostByDeptId(String deptId) {
        String sql = "from Post T_POST where department.id=?";
        List<Post> list = (List<Post>) getHibernateTemplate().find(sql, deptId);
        return list;
    }

    @Override
    public List<Staff> queryAll(String depId, String postId, String staffName) {
        if ("".equals(depId)||depId==null
                &&"".equals(postId)||postId==null
                &&"".equals(staffName)||staffName==null){
            String sql ="from Staff T_STAFF";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
            return list;
        }else if (depId!=null||!"".equals(depId)
                &&"".equals(postId)||postId==null
                &&"".equals(staffName)||staffName==null){
            String sql = "from Staff T_STAFF WHERE post.department.depId=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,depId);
            return list;
        }else if ("".equals(depId)||depId==null
                &&"".equals(postId)||postId==null
                &&staffName!=null||!"".equals(staffName)){
            String sql = "from Staff T_STAFF WHERE staffName=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,staffName);
            return list;
        }else if (postId!=null||!"".equals(postId)
                &&depId!=null||!"".equals(depId)
                &&"".equals(staffName)||staffName!=null){
            String sql ="from Staff T_STAFF WHERE post.department.depId=? and post.postId=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, depId, postId);
            return list;
        }else if (depId!=null||!"".equals(depId)
                &&"".equals(postId)||postId==null
                &&staffName!=null||!"".equals(staffName)){
            String sql="from Staff T_STAFF WHERE post.department.depId=? and staffName=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,depId,staffName);
            return list;
        } else if (depId!=null||!"".equals(depId)
                &&postId!=null||!"".equals(postId)
                &&staffName!=null||!"".equals(staffName)){
            String sql = "from Staff T_STAFF WHERE post.department.depId=? and post.postId=? and staffName=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,depId,postId,staffName);
            return list;
        }
        return null;
    }

}


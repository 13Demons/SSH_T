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
        if (depId.equals("-1")&&postId.equals("-1")&&staffName.equals("")){
            String sql ="from Staff T_STAFF";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
            return list;
        }
        if (postId.equals("-1")&&staffName.equals("")){
            String sql = "from Staff T_STAFF WHERE post.department.depId=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,depId);
            return list;
        }
        if (depId.equals("-1")&&postId.equals("-1")){
            String sql = "from Staff T_STAFF WHERE staffName=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,staffName);
            return list;
        }
        if (staffName.equals("")){
            String sql ="from Staff T_STAFF WHERE post.department.depId=? and post.postId=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, depId, postId);
            return list;
        }
        if (postId.equals("-1")){
            String sql="from Staff T_STAFF WHERE post.department.depId=? and staffName=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,depId,staffName);
            return list;
        }

        String sql = "from Staff T_STAFF WHERE post.department.depId=? and post.postId=? and staffName=?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,depId,postId,staffName);
        return list;

    }


    //更换密码
    @Override
    public void LoginPwd(Staff staff, String password) {
        List<Staff> staffList = (List<Staff>) getHibernateTemplate().find("from Staff staff where staff.loginName=?", staff.getLoginName());
        if (staffList.size()>0){
            Staff staff1 = staffList.get(0);
            staff1.setLoginPwd(password);
            getHibernateTemplate().update(staff1);
        }
    }




}


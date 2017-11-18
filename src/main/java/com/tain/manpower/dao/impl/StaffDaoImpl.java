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

    /**
     * 登录
     * @param loginName 账号
     * @param loginPwd  密码
     * @return
     */
    @Override
    public List<Staff> login(String loginName, String loginPwd) {

        Object[]value = {loginName,loginPwd};
        String sql = "from Staff T_STAFF where loginName=? and loginPwd =?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, value);
        return list;
    }

    /**
     * 显示全部
     * @return
     */
    @Override
    public List<Staff> query() {
        String sql = "from Staff T_STAFF";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
        return list;
    }

    /**
     * 添加&编辑
     * @param staff
     * @return
     */
    @Override
    public List<Staff> save(Staff staff) {
        if (staff.getStaffId()==null){
          getHibernateTemplate().save(staff);
        }else {
            getHibernateTemplate().saveOrUpdate(staff);
        }
        return null;
    }

    /**
     * 二级联动(部门)
     * 查询数据库中部门
     * @return
     */
    @Override
    public List<Department> findDepartment() {
        String sql = "from Department T_DEPT";
        List<Department> list = (List<Department>) getHibernateTemplate().find(sql);
        return list;
    }

    /**
     * 二级联动(职位Id)
     * 查询数据库中职务Id
     * @param deptId
     * @return
     */
    @Override
    public List<Post> getPostByDeptId(String deptId) {
        String sql = "from Post T_POST where department.id=?";
        List<Post> list = (List<Post>) getHibernateTemplate().find(sql, deptId);
        return list;
    }

    /**
     * 高级搜索
     * 二级联动
     * 通过部门\职务\员工进行查询
     * @param depId     部门Id
     * @param postId    职务Id
     * @param staffName 员工名字
     * @return
     */
    @Override
    public List<Staff> queryAll(String depId, String postId, String staffName) {
        if ("".equals(depId)
                &&"".equals(postId)
                &&"".equals(staffName)){
            String sql ="from Staff T_STAFF";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
            return list;
        }else if (!"".equals(depId)
                &&"".equals(postId)
                &&"".equals(staffName)){
            String sql = "from Staff T_STAFF WHERE post.department.depId=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,depId);
            return list;
        }else if ("".equals(depId)
                &&"".equals(postId)
                &&!"".equals(staffName)){
            String sql = "from Staff T_STAFF WHERE staffName like ?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,"%"+staffName+"%");
            return list;
        }else if (!"".equals(postId)
                &&!"".equals(depId)
                &&"".equals(staffName)){
            String sql ="from Staff T_STAFF WHERE post.department.depId=? and post.postId=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, depId, postId);
            return list;
        }else if (!"".equals(depId)
                &&"".equals(postId)
                &&!"".equals(staffName)){
            String sql="from Staff T_STAFF WHERE post.department.depId=? and staffName=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,depId,staffName);
            return list;
        } else if (!"".equals(depId)
                &&!"".equals(postId)
                &&!"".equals(staffName)){
            String sql = "from Staff T_STAFF WHERE post.department.depId=? and post.postId=? and staffName=?";
            List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,depId,postId,staffName);
            return list;
        }
        return null;

    }

    /**
     * 更改密码
     * @param staff
     * @param password
     */
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


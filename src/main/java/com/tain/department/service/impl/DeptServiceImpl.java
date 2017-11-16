package com.tain.department.service.impl;

import com.tain.department.dao.DeptDao;
import com.tain.department.service.DeptService;
import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.utils.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;

    @Override
    public List<Department>save(Department department) {return deptDao.save(department);}

    @Override
    public List<Department> query() {
        return deptDao.query();
    }

    @Override
    public PageBean<Department> findStaffByPage(Department department, int pageNum, int pageSize) {
        int totalStaff = deptDao.getTotalDepartment();
        PageBean<Department> pageBean = new PageBean<Department>(pageNum,pageSize,totalStaff);
        List<Department> data = deptDao.findDepartmentByPage(pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }


    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}

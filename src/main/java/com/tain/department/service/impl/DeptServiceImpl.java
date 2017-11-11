package com.tain.department.service.impl;

import com.tain.department.dao.DeptDao;
import com.tain.department.service.DeptService;
import com.tain.manpower.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptServiceImpl implements DeptService {

    private DeptDao deptDao;

    @Override
    public List<Department>save(Department department) {

        return deptDao.save(department);
    }

    @Override
    public List<Department> query() {
        return deptDao.query();
    }



    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}

package com.tain.department.dao;

import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Staff;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface DeptDao {

    List<Department>save(Department department);

    List<Department>query();

    List<Department>getListByPage(int offSet,int length);


}

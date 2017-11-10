package com.tain.department.service;

import com.tain.manpower.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface DeptService {

    List<Department>save(Department department);

    List<Department>query();



}

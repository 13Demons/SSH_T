package com.tain.department.dao.impl;

import com.tain.department.dao.DeptDao;
import com.tain.manpower.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dllo on 17/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class DeptDaoImplTest {

    @Resource
    private DeptDao deptDao;

    @Test
    public void save(){

        System.out.println("添加--------");
        Department department = new Department();
        department.setDepName("sss");
        department.setDepId("");
        deptDao.save(department);
    }

    @Test
    public void Update(){
        Department department = new Department();
        System.out.println("修改------");
        department.setDepId("2c9090cc5fbf66e9015fbf671ed90000");
        department.setDepName("哒哒哒");
        deptDao.save(department);
    }

    @Test
    public void query(){
        System.out.println("查询所有------");
        System.out.println(deptDao.query());
    }

}
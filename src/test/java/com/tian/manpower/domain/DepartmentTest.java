package com.tian.manpower.domain;

import com.tain.manpower.dao.StaffDao;
import com.tain.manpower.domain.Department;
import com.tain.manpower.domain.Post;
import com.tain.manpower.domain.Staff;
import com.tain.manpower.utils.HibernateUtil;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by dllo on 17/11/9.
 */

public class DepartmentTest {


    @Test
    public void test(){
        Session session = HibernateUtil.openSession();

        Department d1 = new Department("教学部");
        Department d2 = new Department("职规部");

        Post p1 = new Post("教学总监");
        Post p2 = new Post("教学主管");
        Post p3 = new Post("灵魂讲师");
        Post p4 = new Post("职业规划主管");
        Post p5 = new Post("职业规划讲师");

        p1.setDepartment(d1);
        p2.setDepartment(d1);
        p3.setDepartment(d1);
        p4.setDepartment(d2);
        p5.setDepartment(d2);

        Staff s1 = new Staff();
        s1.setStaffName("孟宪义");
        Staff s2 = new Staff();
        s2.setStaffName("大仁哥");
        Staff s3 = new Staff();
        s3.setStaffName("硕哥");
        Staff s4 = new Staff();
        s4.setStaffName("飞哥");
        Staff s5 = new Staff();
        s5.setStaffName("武神");

        Staff s6 = new Staff();
        s6.setStaffName("马琳");
        Staff s7 = new Staff();
        s7.setStaffName("欣姐");
        Staff s8 = new Staff();
        s8.setStaffName("大长腿");

        s1.setDepartment(d1);
        s1.setPost(p1);
        s2.setDepartment(d1);
        s2.setPost(p2);
        s3.setDepartment(d1);
        s3.setPost(p3);
        s4.setDepartment(d1);
        s4.setPost(p3);
        s5.setDepartment(d1);
        s5.setPost(p3);


        s6.setDepartment(d2);
        s6.setPost(p4);
        s7.setDepartment(d2);
        s7.setPost(p5);
        s8.setDepartment(d2);
        s8.setPost(p5);

        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);
        session.save(s7);
        session.save(s8);

        HibernateUtil.commit();
    }


}
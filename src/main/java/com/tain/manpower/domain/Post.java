package com.tain.manpower.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Post {

    private String postId;
    private String postName;

    //职务对部门:多对一
    private Department department;
    //职务对员工:一对多
    private Set<Staff> staffSet = new HashSet<>();


    public Post() {
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post(String postId, String postName) {
        this.postId = postId;
        this.postName = postName;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Staff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<Staff> staffSet) {
        this.staffSet = staffSet;
    }
}

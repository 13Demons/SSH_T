package com.tain.manpower.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
//部门
public class Department {
    private String depId;
    private String depName;

    //部门对职务:一对多,一个部门多个职务
    private Set<Post> postSet = new HashSet<>();
    //部门对员工:一对多,一个部门多个员工
    private Set<Staff>staffSet = new HashSet<>();

    public Department() {
    }
    public Department(String depName) {
        this.depName = depName;
    }

    public Department(String depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

    public Set<Staff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<Staff> staffSet) {
        this.staffSet = staffSet;
    }
}

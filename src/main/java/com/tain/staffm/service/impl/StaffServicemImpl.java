package com.tain.staffm.service.impl;

import com.tain.staffm.dao.StaffDaom;
import com.tain.staffm.dao.impl.StaffDaomImpl;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffServicemImpl {

    @Resource
    private StaffDaomImpl staffDaom;




    public void setStaffDaom(StaffDaomImpl staffDaom) {
        this.staffDaom = staffDaom;
    }
}

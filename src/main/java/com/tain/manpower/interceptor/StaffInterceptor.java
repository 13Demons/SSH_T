package com.tain.manpower.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/11/16.
 */
public class StaffInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object attribute = ServletActionContext.getServletContext().getAttribute("user");
        if (attribute==null){
            return "a";
        }
        return actionInvocation.invoke();
    }
}

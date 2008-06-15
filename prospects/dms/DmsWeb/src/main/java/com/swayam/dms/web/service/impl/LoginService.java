/*
 * LoginService.java
 *
 * Created on Jun 15, 2008 9:06:35 PM
 *
 * Copyright (c) 2002 - 2008 : Swayam Inc.
 *
 * P R O P R I E T A R Y & C O N F I D E N T I A L
 *
 * The copyright of this document is vested in Swayam Inc. without
 * whose prior written permission its contents must not be published,
 * adapted or reproduced in any form or disclosed or
 * issued to any third party.
 */

package com.swayam.dms.web.service.impl;

import com.swayam.dms.db.IDataAccessor;
import com.swayam.dms.db.model.Employee;
import com.swayam.dms.web.service.ILoginService;

/**
 * 
 * @author paawak
 */
public class LoginService implements ILoginService {

    private final IDataAccessor dataAccessor;

    public LoginService(IDataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public Employee doLogin(int empId, String password) {

        String hql = "FROM Employee emp WHERE emp.employeeId=" + empId
                + " AND emp.password='" + password + "'";

        return (Employee) dataAccessor.querySingle(hql);
    }

}

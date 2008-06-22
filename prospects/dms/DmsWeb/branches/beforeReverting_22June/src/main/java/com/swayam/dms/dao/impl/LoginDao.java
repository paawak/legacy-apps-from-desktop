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

package com.swayam.dms.dao.impl;

import java.util.List;

import com.swayam.dms.dao.ILoginDao;
import com.swayam.dms.db.GenericDaoHibernate;
import com.swayam.dms.db.model.Employee;

/**
 * 
 * @author paawak
 */
public class LoginDao extends GenericDaoHibernate<Employee, Long> implements
        ILoginDao {

    public LoginDao() {
        super(Employee.class);
    }

    @SuppressWarnings("unchecked")
    public Employee doLogin(int empId, String password) {

        List roles = getHibernateTemplate().find(
                "FROM Employee emp WHERE emp.employeeId=? AND emp.password=?",
                new Object[] { empId, password });

        if (roles.isEmpty()) {
            return null;
        } else {
            return (Employee) roles.get(0);
        }

    }

}

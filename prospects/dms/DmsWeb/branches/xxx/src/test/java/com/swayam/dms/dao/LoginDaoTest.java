/*
 * LoginServiceTest.java
 *
 * Created on Jun 15, 2008 10:20:26 PM
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

package com.swayam.dms.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.swayam.dms.dao.ILoginDao;
import com.swayam.dms.db.model.Employee;

/**
 * 
 * @author paawak
 */
public class LoginDaoTest {

    private ILoginDao loginDao;

    @Before
    public void setUp() throws Exception {
        String[] configFiles = new String[] {
                "applicationContext-resources.xml",
                "applicationContext-dao.xml" };
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                configFiles);
        loginDao = (ILoginDao) applicationContext.getBean("loginDao");
    }

    @Test
    public void testDoLogin_correct() {
        // java.naming.factory.initial=org.apache.xbean.spring.jndi.SpringInitialContextFactory
        Employee emp = loginDao.doLogin(1, "password");
        assertNotNull(emp);
        assertEquals(1, emp.getEmployeeId());
    }

    @Test
    public void testDoLogin_wrong() {
        Employee emp = loginDao.doLogin(1, " ");
        assertTrue(emp == null);
    }
}

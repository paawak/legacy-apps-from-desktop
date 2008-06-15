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

package com.swayam.dms.web.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.swayam.dms.db.model.Employee;
import com.swayam.dms.web.service.ILoginService;

/**
 * 
 * @author paawak
 */
public class LoginServiceTest {

    private ILoginService loginService;

    @Before
    public void setUp() throws Exception {
        String[] configFiles = new String[] { "applicationContext.xml" };
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                configFiles);
        loginService = (ILoginService) applicationContext
                .getBean("loginService");
    }

    @Test
    public void testDoLogin_correct() {
        Employee emp = loginService.doLogin(1, "password");
        assertNotNull(emp);
        assertEquals(1, emp.getEmployeeId());
    }

    @Test
    public void testDoLogin_wrong() {
        Employee emp = loginService.doLogin(1, " ");
        assertTrue(emp == null);
    }
}

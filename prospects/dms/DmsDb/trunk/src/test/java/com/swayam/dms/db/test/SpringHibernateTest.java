/*
 * SpringHibernateTest.java
 *
 * Created on May 12, 2008 1:33:32 AM
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

package com.swayam.dms.db.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.swayam.dms.db.IDataAccessor;
import com.swayam.dms.db.model.ComplaintStatus;

/**
 * 
 * @author paawak
 * 
 */
public class SpringHibernateTest {

    private IDataAccessor dao;

    @Before
    public void setUp() throws Exception {

        String[] configFiles = new String[] { "applicationContext.xml" };
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                configFiles);

        dao = (IDataAccessor) applicationContext.getBean("dataAccessor");

    }

    @Test
    public void insert() {
        ComplaintStatus status = new ComplaintStatus();
        status.setStatus("TMF");
        dao.saveOrUpdate(status);
    }

}

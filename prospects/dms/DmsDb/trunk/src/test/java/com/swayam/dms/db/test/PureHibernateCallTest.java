/*
 * PureHibernateCallTest.java
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
 * 
 */

package com.swayam.dms.db.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.swayam.dms.db.model.ComplaintStatus;

/**
 * 
 * @author paawak
 */
public class PureHibernateCallTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        Configuration conf = new AnnotationConfiguration();

        // Create the SessionFactory from hibernate.cfg.xml
        SessionFactory sessionFactory = conf.configure().buildSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @After
    public void teardown() {
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void insert() {
        ComplaintStatus status = new ComplaintStatus();
        status.setStatus("SSSS");
        session.save(status);
    }

}

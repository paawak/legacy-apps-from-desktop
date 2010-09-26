/*
 * TimestampTest.java
 *
 * Created on Sep 12, 2010 7:13:11 PM
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

package com.swayam.demo.oracle.hibernate.test;

import static com.swayam.demo.oracle.hibernate.util.DateUtil.getTimeWithZone;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.swayam.demo.oracle.hibernate.entity.TimestampDemo2;
import com.swayam.demo.oracle.hibernate.util.HibernateUtil;

/**
 * 
 * @author paawak
 */
public class TimestampTest2 {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getSession(/* new TimestampInterceptor() */);
    }

    @Test
    public void testInsert() {

        TimestampDemo2 demo2 = new TimestampDemo2();
        demo2.setName("TimestampTest2");

        Calendar cal = getTimeWithZone();

        demo2.setTimeWithZone(cal);

        Transaction trx = session.beginTransaction();
        session.save(demo2);
        trx.commit();

    }

    @Test
    @SuppressWarnings("unchecked")
    public void testSelect() {

        Query query = session.createQuery("FROM "
                + TimestampDemo2.class.getName());

        List<TimestampDemo2> list = query.list();

        for (TimestampDemo2 demo : list) {

            System.out.println(demo.getName() + ": " + demo.getId() + ", TIME="
                    + getTimeWithZone(demo.getTimeWithZone()));
        }

    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

}

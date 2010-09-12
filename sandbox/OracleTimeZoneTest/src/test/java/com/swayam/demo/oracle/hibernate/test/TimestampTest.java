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

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.swayam.demo.oracle.hibernate.HibernateUtil;
import com.swayam.demo.oracle.hibernate.TimestampDemo;

/**
 * 
 * @author paawak
 */
public class TimestampTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getSession();
    }

    @Test
    public void testInsert() {

        String timeZoneId = "Asia/Tokyo";
        TimeZone tz = TimeZone.getTimeZone(timeZoneId);
        Calendar now = new GregorianCalendar(tz);

        TimestampDemo demo = new TimestampDemo();
        demo.setName("B");
        demo.setTimeWithZone(now);
        demo.setTimeWithZoneLocal(now);

        Transaction trx = session.beginTransaction();
        // session.createSQLQuery(
        // "ALTER SESSION SET TIME_ZONE='" + timeZoneId + "'")
        // .executeUpdate();
        session.save(demo);
        trx.commit();

    }

    @Test
    @SuppressWarnings("unchecked")
    public void testSelect() {

        Query query = session.createQuery("FROM "
                + TimestampDemo.class.getName());

        List<TimestampDemo> list = query.list();

        for (TimestampDemo demo : list) {
            Calendar cal = demo.getTimeWithZone();
            System.out.println("TZ=" + cal.getTimeZone().getDisplayName()
                    + ", Time=" + cal);
        }

    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

}

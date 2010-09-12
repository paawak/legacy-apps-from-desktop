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

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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
        Timestamp ts = new Timestamp(now.getTimeInMillis());

        TimestampDemo demo = new TimestampDemo();
        // demo.setId(1);
        demo.setName("B");
        demo.setTimeWithZone(ts);
        demo.setTimeWithZoneLocal(ts);

        Transaction trx = session.beginTransaction();
        session.save(demo);
        trx.commit();

    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

}

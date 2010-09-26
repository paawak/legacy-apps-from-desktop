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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        // demo2.setId(13);
        demo2.setName("B");
        // "2010-09-25 18:59:30:424 Asia/Tokyo"
        // TO_TIMESTAMP_TZ('2010-09-25 18:59:30:424 Asia/Tokyo', 'YYYY-MM-DD
        // HH24:MI:SS:FF TZR')

        String timeZoneId = "Asia/Tokyo";
        TimeZone tz = TimeZone.getTimeZone(timeZoneId);
        Calendar now = new GregorianCalendar(tz);

        demo2.setTimeWithZone(now);

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
            Calendar cal = demo.getTimeWithZone();
            String dateFormat = "yyyy-MM-dd HH:mm:ss:SSS";
            DateFormat df = new SimpleDateFormat(dateFormat);
            String dateTime = df.format(cal.getTime());
            System.out.println("TZ=" + cal.getTimeZone().getDisplayName()
                    + ", Time=" + dateTime);
        }

    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

}

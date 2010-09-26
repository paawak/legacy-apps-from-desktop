/*
 * SimpleJdbcTest.java
 *
 * Created on Sep 25, 2010 10:22:00 PM
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author paawak
 */
public class SimpleJdbcTest {

    private Connection con;

    @Before
    public void init() throws SQLException {

        // Class.forName("oracle.jdbc.OracleDriver");
        con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE", "SWAYAM_TEST",
                "SWAYAM_TEST");

    }

    @After
    public void cleanUp() throws SQLException {
        con.close();
    }

    @Test
    public void insertFaulty() throws SQLException {

        PreparedStatement pStat = con
                .prepareStatement("INSERT INTO TIMESTAMP_DEMO "
                        + " (ID, NAME, TIME_WITH_ZONE, TIME_WITH_ZONE_LOCAL) "
                        + " VALUES " + " (?, ?, ?, ?)");

        int nextVal = getNextVal();

        pStat.setInt(1, nextVal);
        pStat.setString(2, "insertFaulty");

        String timeZoneId = "Asia/Tokyo";

        TimeZone tz = TimeZone.getTimeZone(timeZoneId);

        Calendar now = new GregorianCalendar(tz);

        Timestamp ts = new Timestamp(now.getTimeInMillis());

        pStat.setTimestamp(3, ts);

        pStat.setTimestamp(4, ts);

        pStat.execute();

        pStat.close();

    }

    @Test
    public void insertWorks1() throws SQLException {

        PreparedStatement pStat = con
                .prepareStatement("INSERT INTO TIMESTAMP_DEMO "
                        + " (ID, NAME, TIME_WITH_ZONE, TIME_WITH_ZONE_LOCAL) "
                        + " VALUES " + " (?, ?, ?, ?)");

        int nextVal = getNextVal();

        pStat.setInt(1, nextVal);
        pStat.setString(2, "insertWorks1");

        String timeZoneId = "Asia/Tokyo";

        TimeZone tz = TimeZone.getTimeZone(timeZoneId);

        Calendar now = new GregorianCalendar(tz);

        Timestamp ts = new Timestamp(now.getTimeInMillis());

        pStat.setTimestamp(3, ts, now);

        pStat.setTimestamp(4, ts, now);

        pStat.execute();

        pStat.close();

    }

    @Test
    public void insertWorks2() throws SQLException {

        String timeZoneId = "Asia/Tokyo";

        TimeZone tz = TimeZone.getTimeZone(timeZoneId);

        Calendar now = new GregorianCalendar(tz);

        String dateFormat = "yyyy-MM-dd HH:mm:ss:SSS";
        DateFormat df = new SimpleDateFormat(dateFormat);
        String dateTime = df.format(now.getTime());
        String tzId = now.getTimeZone().getID();
        dateTime += " " + tzId;

        System.out.println("dateTime before insertWorks2=" + dateTime);

        PreparedStatement pStat = con
                .prepareStatement("INSERT INTO TIMESTAMP_DEMO "
                        + " (ID, NAME, TIME_WITH_ZONE, TIME_WITH_ZONE_LOCAL) "
                        + " VALUES "
                        + " (?, ?, TO_TIMESTAMP_TZ(?, 'YYYY-MM-DD HH24:MI:SS:FF TZR'), ?)");

        int nextVal = getNextVal();

        pStat.setInt(1, nextVal);
        pStat.setString(2, "insertWorks2");

        Timestamp ts = new Timestamp(now.getTimeInMillis());

        pStat.setString(3, dateTime);

        pStat.setTimestamp(4, ts, now);

        pStat.execute();

        pStat.close();

    }

    @Test
    public void select1() throws SQLException {

        System.out
                .println("**********************    JDBC    *******************************");

        Statement stat = con.createStatement();

        ResultSet res = stat
                .executeQuery("SELECT * FROM TIMESTAMP_DEMO  ORDER BY ID");

        while (res.next()) {

            Timestamp timestamp = res.getTimestamp("TIME_WITH_ZONE");
            Calendar cal = new GregorianCalendar();
            cal.setTime(timestamp);
            String dateFormat = "yyyy-MM-dd HH:mm:ss:SSS z";
            DateFormat df = new SimpleDateFormat(dateFormat);
            String dateTime = df.format(cal.getTime());

            Timestamp timestampLocal = res.getTimestamp("TIME_WITH_ZONE_LOCAL",
                    new GregorianCalendar(TimeZone.getDefault()));

            System.out.println(res.getString("NAME") + ": TIME=" + dateTime
                    + ", TIME_LOCAL=" + timestampLocal);

        }

        stat.close();
        res.close();

    }

    @Test
    public void select2() throws SQLException {

        System.out
                .println("**********************    ORACLE_FUNCTION    *******************************");

        Statement stat = con.createStatement();

        ResultSet res = stat
                .executeQuery("SELECT ID, NAME, "
                        + " TO_CHAR(TIME_WITH_ZONE, 'YYYY-MM-DD HH24:MI:SS:FF TZR'), "
                        + " TO_CHAR(TIME_WITH_ZONE_LOCAL, 'YYYY-MM-DD HH24:MI:SS:FF TZR') "
                        + " FROM TIMESTAMP_DEMO  ORDER BY ID");

        while (res.next()) {

            String timestamp = res.getString(3);
            String timestampLocal = res.getString(4);

            System.out.println(res.getString("NAME") + ": TIME=" + timestamp
                    + ", TIME_LOCAL=" + timestampLocal);

        }

        stat.close();
        res.close();

    }

    private int getNextVal() throws SQLException {

        Statement stat = con.createStatement();

        ResultSet res = stat.executeQuery("SELECT MAX(ID) FROM TIMESTAMP_DEMO");

        int nextVal = 1;

        if (res.next()) {
            nextVal = res.getInt(1);
            nextVal++;
        }

        res.close();
        stat.close();

        return nextVal;

    }

}

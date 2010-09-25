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

    @Test
    public void insert() throws SQLException {

        Statement stat = con.createStatement();

        ResultSet res = stat.executeQuery("SELECT MAX(ID) FROM TIMESTAMP_DEMO");

        int nextVal = 1;

        if (res.next()) {
            nextVal = res.getInt(1);
            nextVal++;
        }

        res.close();
        stat.close();

        String timeZoneId = "Asia/Tokyo";
        // String timeZoneId = "Africa/Algeria";
        // String timeZoneId = "Asia/Kolkata";

        TimeZone tz = TimeZone.getTimeZone(timeZoneId);

        Calendar now = new GregorianCalendar(tz);

        String dateFormat = "yyyy-MM-dd HH:mm:ss:SSS";
        DateFormat df = new SimpleDateFormat(dateFormat);
        String dateTime = df.format(now.getTime());
        String tzId = now.getTimeZone().getID();
        dateTime += " " + tzId;

        String dateStr = "TO_TIMESTAMP_TZ('" + dateTime
                + "','YYYY-MM-DD HH24:MI:SS:FF TZR')";

        System.err.println("dateStr=" + dateStr + "\ndateTime=" + dateTime);

        // PreparedStatement pStat = con
        // .prepareStatement("INSERT INTO TIMESTAMP_DEMO (ID, NAME, TIME_WITH_ZONE, TIME_WITH_ZONE_LOCAL) VALUES (?, ?, TO_TIMESTAMP_TZ(?, ?), ?)");

        PreparedStatement pStat = con
                .prepareStatement("INSERT INTO TIMESTAMP_DEMO (ID, NAME, TIME_WITH_ZONE, TIME_WITH_ZONE_LOCAL) VALUES (?, ?, TO_TIMESTAMP_TZ(?, 'YYYY-MM-DD HH24:MI:SS:FF TZR'), ?)");

        pStat.setInt(1, nextVal);
        pStat.setString(2, "A" + nextVal);

        Timestamp ts = new Timestamp(now.getTimeInMillis());

        pStat.setString(3, dateTime);

        pStat.setTimestamp(4, ts, now);

        pStat.execute();

        pStat.close();

    }

    @Test
    public void select() throws SQLException {

        Statement stat = con.createStatement();

        ResultSet res = stat
                .executeQuery("SELECT * FROM TIMESTAMP_DEMO  ORDER BY ID");

        // ResultSetMetaData rsmdt = res.getMetaData();
        //
        // System.out.println(rsmdt.getColumnTypeName(3) + ", "
        // + rsmdt.getColumnTypeName(4));

        while (res.next()) {

            int id = res.getInt("ID");
            String name = res.getString("NAME");
            Timestamp timestamp = res.getTimestamp("TIME_WITH_ZONE");
            Calendar cal = new GregorianCalendar();
            cal.setTime(timestamp);
            Timestamp timestampLocal = res.getTimestamp("TIME_WITH_ZONE_LOCAL",
                    new GregorianCalendar(TimeZone.getDefault()));

            System.out.println("ID=" + id + ", NAME=" + name + ", TIME="
                    + timestamp + "/" + cal.getTimeZone().getID()
                    + ", TIME_LOCAL=" + timestampLocal);

        }

        stat.close();
        res.close();

    }

}

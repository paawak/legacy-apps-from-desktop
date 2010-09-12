/*
 * OracleTest.java
 *
 * Created on Sep 11, 2010 4:43:33 PM
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

package com.swayam.demo.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 
 * @author paawak
 */
public class OracleTest {

    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void main(String[] args) throws Exception {

        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE", "SWAYAM_TEST",
                "SWAYAM_TEST");

        Statement stat = con.createStatement();

        ResultSet res = stat.executeQuery("SELECT MAX(ID) FROM TIMESTAMP_DEMO");

        int nextVal = 1;

        if (res.next()) {
            nextVal = res.getInt(1);
            nextVal++;
        }

        res.close();

        PreparedStatement pStat = con
                .prepareStatement("INSERT INTO TIMESTAMP_DEMO (ID, NAME, TIME_WITH_ZONE) VALUES (?, ?, ?)");

        pStat.setInt(1, nextVal);
        pStat.setString(2, "A" + nextVal);
        Calendar today = getToday("Africa/Algeria");
        // Calendar today = getToday("Asia/Tokyo");
        // Calendar today = getToday("Asia/Kolkata");

        Timestamp ts = new Timestamp(today.getTimeInMillis());

        System.out.println("before insert, time zone="
                + today.getTimeZone().getDisplayName());

        pStat.setTimestamp(3, ts, today);

        pStat.execute();

        pStat.close();

        res = stat.executeQuery("SELECT * FROM TIMESTAMP_DEMO  ORDER BY ID");

        while (res.next()) {

            int id = res.getInt("ID");
            String name = res.getString("NAME");
            Timestamp timestamp = res.getTimestamp("TIME_WITH_ZONE");

            System.err.println("ID=" + id + ", NAME=" + name + ", TIMEZONE="
                    + getTimeZone(timestamp) + ", TIME=" + timestamp);

        }

        stat.close();
        res.close();
        con.close();

    }

    private static String getTimeZone(Date date) {

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.getTimeZone().getID();

    }

    private static Calendar getToday(String timeZone) {

        TimeZone tz = TimeZone.getTimeZone(timeZone);

        return new GregorianCalendar(tz);

    }

}

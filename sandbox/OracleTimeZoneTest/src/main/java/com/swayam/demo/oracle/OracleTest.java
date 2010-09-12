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

        // Class.forName("oracle.jdbc.OracleDriver");
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
                .prepareStatement("INSERT INTO TIMESTAMP_DEMO (ID, NAME, TIME_WITH_ZONE, TIME_WITH_ZONE_LOCAL) VALUES (?, ?, ?, ?)");

        pStat.setInt(1, nextVal);
        pStat.setString(2, "A" + nextVal);
        String timeZoneId = "Asia/Tokyo";
        // String timeZoneId = "Africa/Algeria";
        // String timeZoneId = "Asia/Kolkata";

        TimeZone tz = TimeZone.getTimeZone(timeZoneId);

        Calendar now = new GregorianCalendar(tz);

        Timestamp ts = new Timestamp(now.getTimeInMillis());

        pStat.setTimestamp(3, ts, now);

        pStat.setTimestamp(4, ts, now);

        pStat.execute();

        pStat.close();

        res = stat.executeQuery("SELECT * FROM TIMESTAMP_DEMO  ORDER BY ID");

        while (res.next()) {

            int id = res.getInt("ID");
            String name = res.getString("NAME");
            Timestamp timestamp = res.getTimestamp("TIME_WITH_ZONE");
            Timestamp timestampLocal = res.getTimestamp("TIME_WITH_ZONE_LOCAL",
                    new GregorianCalendar(TimeZone.getDefault()));

            System.out.println("ID=" + id + ", NAME=" + name + ", TIME="
                    + timestamp + ", TIME_LOCAL=" + timestampLocal);

        }

        stat.close();
        res.close();
        con.close();

    }

}

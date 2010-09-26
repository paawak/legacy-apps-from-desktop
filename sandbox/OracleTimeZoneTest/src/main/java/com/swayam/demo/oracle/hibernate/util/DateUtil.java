/*
 * DateUtil.java
 *
 * Created on Sep 26, 2010 5:57:24 PM
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

package com.swayam.demo.oracle.hibernate.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;

/**
 * 
 * @author paawak
 */
public class DateUtil {

    private static final Logger LOG = Logger.getLogger(DateUtil.class);

    private DateUtil() {

    }

    public static Calendar getTimeWithZone() {

        // CST - Central Standard Time(Australia/Adelaide): UTC/GMT +9:30 hours
        String timeZoneId = "Australia/Adelaide";

        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);

        Calendar cal = Calendar.getInstance(timeZone);

        cal.set(Calendar.HOUR_OF_DAY, 11);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal;

    }

    public static String getTimeWithZone(Timestamp timestamp) {

        Calendar cal = new GregorianCalendar();
        cal.setTime(timestamp);

        return getTimeWithZone(cal);

    }

    public static String getTimeWithZone(Calendar cal) {

        String dateFormat = "HH:mm:ss:SSS zzzz";
        DateFormat df = new SimpleDateFormat(dateFormat);

        // this is very important
        TimeZone timeZone = cal.getTimeZone();

        if (timeZone != null) {
            df.setTimeZone(timeZone);
        }

        String dateTime = df.format(cal.getTime());

        return dateTime;

    }

    public static String getOracleFormattedTimeWithZone(Calendar timeWithZone) {

        String dateFormat = "yyyy-MM-dd HH:mm:ss:SSS";
        DateFormat df = new SimpleDateFormat(dateFormat);

        // this is very important
        TimeZone timeZone = timeWithZone.getTimeZone();

        if (timeZone != null) {
            df.setTimeZone(timeZone);
        }

        String dateTime = df.format(timeWithZone.getTime());
        String tzId = timeWithZone.getTimeZone().getID();
        dateTime += " " + tzId;

        return dateTime;

    }

    /**
     * Converts raw time-stamp with time-zone string from Oracle to Calendar
     * containing the time-zone
     * 
     * @param rawTimestamp
     *            in the format 2010-9-26 11.30.0.0 Australia/Adelaide
     * @return
     */
    public static Calendar parseOracleTimestampWithZone(String rawTimestamp) {

        Calendar cal = null;

        String dateFormat = "yyyy-MM-dd HH.mm.ss.SSS";
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);

        try {

            Date date = df.parse(rawTimestamp);
            String timeZoneId = rawTimestamp.split("\\s")[2];
            TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
            cal = new GregorianCalendar(timeZone);
            cal.setTime(date);
            cal.setTimeZone(timeZone);

        } catch (ParseException e) {
            LOG.error("Could not convert string `" + rawTimestamp
                    + "` to Calendar", e);
        }

        return cal;

    }

}

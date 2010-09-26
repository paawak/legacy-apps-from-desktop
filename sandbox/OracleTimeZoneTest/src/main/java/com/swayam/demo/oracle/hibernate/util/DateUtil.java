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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 
 * @author paawak
 */
public class DateUtil {

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
        String dateTime = df.format(cal.getTime());

        return dateTime;

    }

}

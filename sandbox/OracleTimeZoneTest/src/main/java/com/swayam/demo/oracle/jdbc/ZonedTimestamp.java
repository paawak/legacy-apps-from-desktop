/*
 * ZonedTimestamp.java
 *
 * Created on Sep 12, 2010 11:08:24 PM
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

package com.swayam.demo.oracle.jdbc;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

/**
 * 
 * @author paawak
 */
public class ZonedTimestamp extends GregorianCalendar implements SQLData {

    private static final long serialVersionUID = 4706029554566400011L;

    private static final Logger LOG = Logger.getLogger(ZonedTimestamp.class);

    private String typeName = "TIMESTAMP";

    @Override
    public String getSQLTypeName() throws SQLException {
        return typeName;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.typeName = typeName;

        LOG.info("typeName=" + typeName);
        String dateTime = stream.readString();
        LOG.info("dateTime=" + dateTime);

    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {

        String dateFormat = "yyyy-MM-dd HH:mm:ss:SSS";
        DateFormat df = new SimpleDateFormat(dateFormat);
        String dateTime = df.format(getTime());
        String tzId = getTimeZone().getID();
        dateTime += " " + tzId;

        LOG.info("dateTime=" + dateTime);

        String value = "TO_TIMESTAMP_TZ('" + dateTime
                + "','YYYY-MM-DD HH24:MI:SS TZR')";

        stream.writeString(value);

    }

}

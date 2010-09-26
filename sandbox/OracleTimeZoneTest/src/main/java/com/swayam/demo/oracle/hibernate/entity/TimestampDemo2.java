/*
 * TimestampDemo.java
 *
 * Created on Sep 12, 2010 6:43:45 PM
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

package com.swayam.demo.oracle.hibernate.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.Type;

/**
 * 
 * @author paawak
 */
@SQLInsert(sql = "INSERT INTO TIMESTAMP_DEMO (NAME, TIME_WITH_ZONE, TIME_WITH_ZONE_LOCAL, ID) values (?, TO_TIMESTAMP_TZ(?, 'YYYY-MM-DD HH24:MI:SS:FF TZR'), ?, ?)")
// @Loader(namedQuery = "customSelect")
// @NamedNativeQuery(name = "customSelect", resultClass = TimestampDemo2.class,
// query =
// "SELECT NAME, TO_CHAR(TIME_WITH_ZONE, 'YYYY-MM-DD HH24:MI:SS:FF_TZR') AS TIME_WITH_ZONE, TIME_WITH_ZONE_LOCAL, ID FROM TIMESTAMP_DEMO WHERE ID=?")
@Table(name = "TIMESTAMP_DEMO")
@Entity
public class TimestampDemo2 extends TimestampDemoTemplate implements
        Serializable {

    private static final long serialVersionUID = 4940963602672391841L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Override
    public long getId() {
        return id;
    }

    @Column
    @Override
    public String getName() {
        return name;
    }

    @Column(name = "TIME_WITH_ZONE")
    @Type(type = "com.swayam.demo.oracle.hibernate.custom.TimestampType2")
    @Override
    public Calendar getTimeWithZone() {
        return super.getTimeWithZone();
    }

    @Column(name = "TIME_WITH_ZONE_LOCAL")
    @Type(type = "com.swayam.demo.oracle.hibernate.custom.TimestampType")
    @Override
    public Calendar getTimeWithZoneLocal() {
        return timeWithZoneLocal;
    }

}

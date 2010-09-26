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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

/**
 * 
 * @author paawak
 */
@Entity
@Table(name = "TIMESTAMP_DEMO")
public class TimestampDemo implements Serializable {

    private static final long serialVersionUID = 4940963602672391841L;

    private long id;

    private String name;

    private Calendar timeWithZone;

    private Calendar timeWithZoneLocal;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "TIME_WITH_ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getTimeWithZone() {
        return timeWithZone;
    }

    public void setTimeWithZone(Calendar timeWithZone) {
        this.timeWithZone = timeWithZone;
    }

    @Column(name = "TIME_WITH_ZONE_LOCAL")
    @Type(type = "com.swayam.demo.oracle.hibernate.custom.TimestampType")
    public Calendar getTimeWithZoneLocal() {
        return timeWithZoneLocal;
    }

    public void setTimeWithZoneLocal(Calendar timeWithZoneLocal) {
        this.timeWithZoneLocal = timeWithZoneLocal;
    }

}

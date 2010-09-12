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

package com.swayam.demo.oracle.hibernate;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author paawak
 */
@Entity
@Table(name = "TIMESTAMP_DEMO")
public class TimestampDemo implements Serializable {

    private static final long serialVersionUID = 4940963602672391841L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String name;

    @Column(name = "TIME_WITH_ZONE")
    private Timestamp timeWithZone;

    @Column(name = "TIME_WITH_ZONE_LOCAL")
    private Timestamp timeWithZoneLocal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTimeWithZone() {
        return timeWithZone;
    }

    public void setTimeWithZone(Timestamp timeWithZone) {
        this.timeWithZone = timeWithZone;
    }

    public Timestamp getTimeWithZoneLocal() {
        return timeWithZoneLocal;
    }

    public void setTimeWithZoneLocal(Timestamp timeWithZoneLocal) {
        this.timeWithZoneLocal = timeWithZoneLocal;
    }

}

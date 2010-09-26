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

import java.util.Calendar;

/**
 * 
 * @author paawak
 */
class TimestampDemoTemplate {

    long id;

    String name;

    Calendar timeWithZone;

    Calendar timeWithZoneLocal;

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

    public Calendar getTimeWithZone() {
        return timeWithZone;
    }

    public void setTimeWithZone(Calendar timeWithZone) {
        this.timeWithZone = timeWithZone;
    }

    public Calendar getTimeWithZoneLocal() {
        return timeWithZoneLocal;
    }

    public void setTimeWithZoneLocal(Calendar timeWithZoneLocal) {
        this.timeWithZoneLocal = timeWithZoneLocal;
    }

}

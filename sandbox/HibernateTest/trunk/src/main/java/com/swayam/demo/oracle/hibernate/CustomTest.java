/*
 * CustomTest.java
 *
 * Created on Oct 31, 2010 3:37:24 PM
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

import java.util.Calendar;

/**
 * 
 * @author paawak
 */
public class CustomTest {

    private long id;

    private String name;

    private Calendar timeWithZone;

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

}

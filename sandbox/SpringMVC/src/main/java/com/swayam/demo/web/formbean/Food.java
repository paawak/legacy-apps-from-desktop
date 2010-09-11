/*
 * Food.java
 *
 * Created on Sep 11, 2010 12:24:15 PM
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

package com.swayam.demo.web.formbean;


/**
 * 
 * @author paawak
 */
public enum Food {

    ALL(null, "All"),

    RICE(ALL, "Rice"), AUS(RICE, "Aus"), BASMATI(RICE, "Basmati"), SONAMASURI(
            RICE, "SonaMasuri"), BORO(RICE, "Boro"),

    MANGOES(ALL, "Mangoes"), LANGDA(MANGOES, "Langda"), FOJLI(MANGOES, "Fojli"), DUSSERI(
            MANGOES, "Dusseri"), ALFONSO(MANGOES, "Alfonso"),

    ORANGES(ALL, "Oranges"), NAGPUR(ORANGES, "Nagpur"), DARJEELING(ORANGES,
            "Darjeeling"), WELLINGTON(ORANGES, "Wellington");

    public final Food parent;
    public final String label;

    private Food(Food parent, String label) {
        this.parent = parent;
        this.label = label;
    }

    public static Food parse(String food) {
        return Enum.valueOf(Food.class, food.toUpperCase());
    }

    @Override
    public String toString() {
        return label;
    }

}

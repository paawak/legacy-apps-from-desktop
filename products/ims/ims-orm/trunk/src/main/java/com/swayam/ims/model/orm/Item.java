/*
 * Item.java
 *
 * Created on Jun 1, 2009 12:50:10 AM
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

package com.swayam.ims.model.orm;

import java.io.Serializable;

/**
 * 
 * @author paawak
 */
public class Item implements Serializable {

    private static final long serialVersionUID = 5729868965288261711L;

    private Long id;

    private String code;

    private String name;

    private ItemGroup group;

}

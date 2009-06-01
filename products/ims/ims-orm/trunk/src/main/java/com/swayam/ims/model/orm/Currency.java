/*
 * Currency.java
 *
 * Created on Jun 1, 2009 4:01:41 PM
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
public class Currency implements Serializable {

    private static final long serialVersionUID = -7806468599798972546L;

    private Integer id;

    private String name;

    private String symbol;

}

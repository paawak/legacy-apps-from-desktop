/*
 * ItemGroupController.java
 *
 * Created on May 31, 2009 12:45:39 AM
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

package com.swayam.ims.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author paawak
 */
public class ItemGroupController extends BaseFormController {

    public ModelAndView handleRequest(HttpServletRequest request,

    HttpServletResponse response) throws Exception {

        ModelAndView view = new ModelAndView("masters/itemGroup");

        return view;

    }

}

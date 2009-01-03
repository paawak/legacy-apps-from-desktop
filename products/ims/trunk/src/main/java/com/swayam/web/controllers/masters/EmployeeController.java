/*
 * EmployeeController.java
 *
 * Created on Jan 3, 2009 10:31:15 PM
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

package com.swayam.web.controllers.masters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.swayam.web.webapp.controller.BaseFormController;

/**
 * 
 * @author paawak
 */
public class EmployeeController extends BaseFormController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView view = new ModelAndView("masters/employee");

        return view;

    }

}

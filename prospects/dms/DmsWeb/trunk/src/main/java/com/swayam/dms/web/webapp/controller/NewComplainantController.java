/*
 * NewComplainantController.java
 *
 * Created on Jun 28, 2008 1:15:03 PM
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

package com.swayam.dms.web.webapp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.swayam.dms.web.model.Complainant;

/**
 * 
 * @author paawak
 */
public class NewComplainantController extends BaseFormController {

    public NewComplainantController() {
        setCommandName("comp");
        setCommandClass(Complainant.class);
    }

    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request)
            throws ServletException {
        Complainant complainant = new Complainant();
        return complainant;
    }

}

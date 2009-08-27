/*
 * PurchaseOrderFormController.java
 *
 * Created on Aug 9, 2009 9:36:24 PM
 *
 * Copyright (c) 2002 - 2009 : Swayam Inc.
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

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.swayam.ims.model.orm.Trade;

/**
 * 
 * @author paawak
 */
public class PurchaseOrderFormController extends BaseFormController {

    public PurchaseOrderFormController() {
        setCommandClass(Trade.class);
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

}

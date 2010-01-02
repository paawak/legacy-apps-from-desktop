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

package com.swayam.ims.webapp.controller.trx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 
 * @author paawak
 */
public class PurchaseOrderFormController implements Controller {

    private String formView;

    public PurchaseOrderFormController() {

    }

    public final void setFormView(String formView) {
        this.formView = formView;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView(formView);
    }

}

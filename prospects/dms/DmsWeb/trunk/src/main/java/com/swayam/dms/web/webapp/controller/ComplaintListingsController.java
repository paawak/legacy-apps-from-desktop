/*
 * ListingsController.java
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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author paawak
 */
public class ComplaintListingsController extends BaseFormController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView view = new ModelAndView("complaintListings");
        List<String> strings = new ArrayList<String>();
        strings.add("AAAAAAAA");
        strings.add("BBBBBBB");
        strings.add("CCCCCCCC");
        strings.add("EEEEEEEE");
        strings.add("FFFFFFFFF");
        view.addObject("testStrings", strings);

        return view;

    }

}

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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.swayam.dms.web.dao.GenericDao;
import com.swayam.dms.web.model.Complaint;

/**
 * 
 * @author paawak
 */
public class ComplaintListingsController extends BaseFormController {

    private final GenericDao<Complaint, Integer> complaintDao;

    public ComplaintListingsController(
            GenericDao<Complaint, Integer> complaintDao) {
        this.complaintDao = complaintDao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        List<Complaint> complaints = complaintDao.getAll();

        ModelAndView view = new ModelAndView("complaintListings");

        view.addObject("complaints", complaints);

        return view;

    }

}

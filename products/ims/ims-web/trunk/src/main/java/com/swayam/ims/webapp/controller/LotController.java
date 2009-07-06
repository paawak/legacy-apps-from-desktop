/*
 * LotController.java
 *
 * Created on Jul 7, 2009 12:12:33 AM
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

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.swayam.ims.core.dao.GenericDao;
import com.swayam.ims.core.service.UserManager;
import com.swayam.ims.model.orm.Item;
import com.swayam.ims.model.orm.Lot;
import com.swayam.ims.model.orm.User;

/**
 * 
 * @author paawak
 */
public class LotController extends BaseFormController {

    private final GenericDao<Lot, Long> lotDao;
    private final GenericDao<Item, Long> itemDao;
    private final UserManager userManager;

    public LotController(GenericDao<Lot, Long> lotDao,
            GenericDao<Item, Long> itemDao, UserManager userManager) {
        this.lotDao = lotDao;
        this.itemDao = itemDao;
        this.userManager = userManager;

        setCommandName("lot");
        setCommandClass(Lot.class);

    }

    @Override
    protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Item.class,
                new EntityPropertyEditorSupport<Item>(itemDao));

        super.initBinder(request, binder);

    }

    // @Override
    // public ModelAndView onSubmit(Object command) throws ServletException {
    //
    // Lot lot = (Lot) command;
    //
    // // get logged in user
    //
    // lotDao.save(lot);
    //
    // return new ModelAndView(new RedirectView(getSuccessView()));
    //
    // }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {

        Lot lot = (Lot) command;

        // get logged in user
        String userName = request.getRemoteUser();
        User enteredBy = userManager.getUserByUsername(userName);
        lot.setEnteredBy(enteredBy);
        lot.setProcuredOn(new Date());

        lotDao.save(lot);

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request)
            throws ServletException {
        Lot lot = new Lot();
        return lot;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView view = super.handleRequest(request, response);

        // set the object to view
        view.addObject("itemList", itemDao.getAll());

        return view;

    }

}

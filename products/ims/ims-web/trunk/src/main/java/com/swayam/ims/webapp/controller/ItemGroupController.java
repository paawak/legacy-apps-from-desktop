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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.swayam.ims.core.dao.GenericDao;
import com.swayam.ims.model.orm.ItemGroup;

/**
 * 
 * @author paawak
 */
public class ItemGroupController extends BaseFormController {

    private final GenericDao<ItemGroup, Long> itemGroupDao;

    public ItemGroupController(GenericDao<ItemGroup, Long> itemGroupDao) {

        this.itemGroupDao = itemGroupDao;
        setCommandName("itemGroup");
        setCommandClass(ItemGroup.class);

    }

    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {

        ItemGroup itemGroup = (ItemGroup) command;
        itemGroupDao.save(itemGroup);
        return new ModelAndView(new RedirectView(getSuccessView()));

    }

    @Override
    protected Object formBackingObject(HttpServletRequest request)
            throws ServletException {
        ItemGroup itemGroup = new ItemGroup();
        return itemGroup;
    }

}

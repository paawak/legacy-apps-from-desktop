/*
 * ItemController.java
 *
 * Created on Aug 28, 2010 8:37:34 PM
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

package com.swayam.demo.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.formbean.ItemBean;
import com.swayam.demo.web.formbean.ItemBean.ItemRow;

/**
 * 
 * @author paawak
 */
@Controller
public class ItemController {

    private static final Logger LOG = Logger.getLogger(ItemController.class);

    @RequestMapping(value = "/showItems.htm", method = RequestMethod.GET)
    public ModelAndView showItemsPage() {

        ModelAndView model = new ModelAndView("Item");

        ItemBean bean = getMockBean();

        LOG.info(bean.getItems());

        model.addObject("command", bean);

        return model;

    }

    private ItemBean getMockBean() {

        List<ItemRow> items = new ArrayList<ItemBean.ItemRow>();

        ItemRow row1 = new ItemRow();
        row1.setSelected(true);
        row1.setItemName("Jhumroo CD");
        row1.setPrice(88.5f);
        row1.setQuantity(5);
        items.add(row1);

        ItemRow row2 = new ItemRow();
        row2.setItemName("Hum Sab Ustad Hain DVD");
        row2.setPrice(100);
        items.add(row2);

        ItemRow row3 = new ItemRow();
        row3.setItemName("Guide DVD");
        row3.setPrice(150.9f);
        items.add(row3);

        ItemBean bean = new ItemBean();

        bean.setItems(items);

        return bean;

    }

}

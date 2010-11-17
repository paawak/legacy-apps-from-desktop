/*
 * CheckBoxDemoController.java
 *
 * Created on Sep 11, 2010 12:06:58 PM
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

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.formbean.CheckBoxDemoBean;
import com.swayam.demo.web.formbean.Food;
import com.swayam.demo.web.orm.dao.UnitTypeDao;
import com.swayam.demo.web.orm.model.UnitType;

/**
 * 
 * @author paawak
 */
@Controller
public class CheckBoxDemoController {

    private static final Logger LOG = Logger
            .getLogger(CheckBoxDemoController.class);

    @Autowired
    @Qualifier("unitTypeDao")
    private UnitTypeDao unitTypeDao;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest webRequest) {

        binder.registerCustomEditor(Food.class, new PropertyEditorSupport() {

            public void setAsText(String text) {

                setValue(Food.parse(text));

            }

        });

    }

    @RequestMapping("/checkboxdemo.htm")
    public ModelAndView show(CheckBoxDemoBean checkBoxDemoBean) {

        ModelAndView model = new ModelAndView("CheckBoxDemo");

        if (checkBoxDemoBean.getSelectedFoodItems() == null) {
            List<Food> foods = new ArrayList<Food>();
            foods.add(Food.LANGDA);
            foods.add(Food.BORO);
            checkBoxDemoBean.setSelectedFoodItems(foods);
        }

        LOG.info("Selected Items = " + checkBoxDemoBean.getSelectedFoodItems());

        model.addObject("command", checkBoxDemoBean);

        UnitType unitType = new UnitType();
        unitType.setName("hi there");
        unitType.setDescription("just checking, halka");
        unitTypeDao.save(unitType);

        return model;

    }

}

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

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swayam.demo.web.formbean.CheckBoxDemoBean;
import com.swayam.demo.web.formbean.Food;

/**
 * 
 * @author paawak
 */
@Controller
public class CheckBoxDemoController {

    @RequestMapping("/checkboxdemo.htm")
    public ModelAndView show() {

        ModelAndView model = new ModelAndView("CheckBoxDemo");

        List<Food> foods = new ArrayList<Food>();
        foods.add(Food.ALL);

        CheckBoxDemoBean checkBoxDemoBean = new CheckBoxDemoBean();
        checkBoxDemoBean.setSelectedFoodItems(foods);

        model.addObject("command", checkBoxDemoBean);

        return model;

    }

}

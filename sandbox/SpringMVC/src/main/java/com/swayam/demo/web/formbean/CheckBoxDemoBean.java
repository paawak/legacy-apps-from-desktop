/*
 * CheckBoxDemoBean.java
 *
 * Created on Sep 11, 2010 12:41:12 PM
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

package com.swayam.demo.web.formbean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author paawak
 */
public class CheckBoxDemoBean implements Serializable {

    private static final long serialVersionUID = 3072696541901103695L;

    private List<Food> selectedFoodItems;

    public List<Food> getSelectedFoodItems() {
        return selectedFoodItems;
    }

    public void setSelectedFoodItems(List<Food> selectedFoodItems) {
        this.selectedFoodItems = selectedFoodItems;
    }

}

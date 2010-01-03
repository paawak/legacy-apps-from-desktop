/*
 * PurchaseOrderHelper.java
 *
 * Created on Jan 2, 2010 10:21:03 PM
 *
 * Copyright (c) 2002 - 2010 : Swayam Inc.
 *
 * P R O P R I E T A R Y & C O N F I D E N T I A L
 *
 * The copyright of this document is vested in Swayam Inc. without
 * whose prior written permission its contents must not be published,
 * adapted or reproduced in any form or disclosed or
 * issued to any third party.
 */

package com.swayam.ims.webapp.controller.trx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.swayam.ims.core.service.impl.PurchaseOrderService;

import flex.messaging.io.amf.ASObject;

/**
 * 
 * @author paawak
 */
public class PurchaseOrderHelper {

    private final PurchaseOrderService service;

    public PurchaseOrderHelper(PurchaseOrderService service) {
        this.service = service;
    }

    public boolean savePurchaseOrder(Integer partyId, List<ASObject> items) {

        Map<Long, Integer> itemQtyMap = new HashMap<Long, Integer>();

        for (ASObject asObj : items) {

            Long id = new Long((Integer) asObj.get("id"));

            Object rawQty = asObj.get("qty");

            Integer qty;

            if (rawQty instanceof String) {
                qty = Integer.parseInt((String) rawQty);
            } else {
                qty = (Integer) rawQty;
            }

            itemQtyMap.put(id, qty);

        }

        return service.savePurchaseOrder(partyId, itemQtyMap);

    }

}

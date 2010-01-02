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

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import com.swayam.ims.core.dao.GenericDao;
import com.swayam.ims.model.orm.Currency;
import com.swayam.ims.model.orm.Party;
import com.swayam.ims.model.orm.Trade;
import com.swayam.ims.model.orm.TradeDetails;
import com.swayam.ims.model.orm.TransactionCategory;

import flex.messaging.io.amf.ASObject;

/**
 * 
 * @author paawak
 */
public class PurchaseOrderHelper {

    private GenericDao<Trade, Long> tradeDao;

    private GenericDao<TradeDetails, Long> tradeDetailsDao;

    @SuppressWarnings("unchecked")
    public long getNewPurchaseOrderId() {

        long id = 1;

        List results = tradeDao.findByNamedQuery(Trade.NAMED_QUERY_FIND_MAX_ID,
                Collections.EMPTY_MAP);

        if (results != null && !results.isEmpty()) {

            Long maxId = (Long) results.get(0);

            if (maxId != null) {

                id = maxId + 1;

            }

        }

        return id;

    }

    public void savePurchaseOrder(Integer partyId, List<ASObject> items)
            throws NotSupportedException, SystemException {

        Trade trade = new Trade();
        // trade.setId(getNewPurchaseOrderId());
        TransactionCategory trxCat = new TransactionCategory();
        trxCat.setId(new Long(1));
        trade.setCategory(trxCat);
        Currency curr = new Currency();
        curr.setId(new Long(1));
        trade.setCurrency(curr);
        Party party = new Party();
        party.setId(partyId.longValue());
        trade.setCustomer(party);
        trade.setNetAmount(100);
        trade.setNetAmount(200);
        trade.setTradeDate(new Date());

        tradeDao.save(trade);

        for (ASObject asObj : items) {

            Integer id = (Integer) asObj.get("id");

            Object rawQty = asObj.get("qty");

            Integer qty;

            if (rawQty instanceof String) {
                qty = Integer.parseInt((String) rawQty);
            } else {
                qty = (Integer) rawQty;
            }

        }

    }

    public void setTradeDao(GenericDao<Trade, Long> tradeDao) {
        this.tradeDao = tradeDao;
    }

    public void setTradeDetailsDao(
            GenericDao<TradeDetails, Long> tradeDetailsDao) {
        this.tradeDetailsDao = tradeDetailsDao;
    }

}

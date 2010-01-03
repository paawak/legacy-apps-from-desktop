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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import com.swayam.ims.core.dao.GenericDao;
import com.swayam.ims.model.orm.Currency;
import com.swayam.ims.model.orm.Item;
import com.swayam.ims.model.orm.Lot;
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

    private GenericDao<TransactionCategory, Long> trxCatDao;

    private GenericDao<Currency, Long> currencyDao;

    private GenericDao<Party, Long> partyDao;

    private GenericDao<Lot, Long> lotDao;

    private GenericDao<Item, Long> itemDao;

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

    public boolean savePurchaseOrder(Integer partyId, List<ASObject> items)
            throws NotSupportedException, SystemException {

        boolean success = false;

        TransactionCategory trxCat = trxCatDao.get(1l);
        Currency curr = currencyDao.get(1l);
        Party party = partyDao.get(partyId.longValue());

        Trade trade = new Trade();
        trade.setCategory(trxCat);
        trade.setCurrency(curr);
        trade.setCustomer(party);
        trade.setNetAmount(100);
        trade.setNetAmount(200);
        trade.setTradeDate(new Date());

        trade = tradeDao.save(trade);

        for (ASObject asObj : items) {

            Long id = new Long((Integer) asObj.get("id"));

            Object rawQty = asObj.get("qty");

            Integer qty;

            if (rawQty instanceof String) {
                qty = Integer.parseInt((String) rawQty);
            } else {
                qty = (Integer) rawQty;
            }

            Map<String, Object> lotParams = new HashMap<String, Object>(1);
            lotParams.put("itemId", id);
            // get the latest lot and the price
            List<Lot> lotList = lotDao.findByNamedQuery(
                    Lot.FIND_LATEST_LOT_FOR_ITEM, lotParams);

            if (lotList == null || lotList.isEmpty()) {
                throw new IllegalArgumentException("Not lot found for item id "
                        + id);
            }

            Lot itemLot = lotList.get(0);

            float totalPrice = itemLot.getPrice() * qty;

            TradeDetails tradeDetails = new TradeDetails();
            tradeDetails.setItem(itemDao.get(id));
            tradeDetails.setItemLot(itemLot);
            tradeDetails.setQuantity(qty);
            tradeDetails.setTotalPrice(totalPrice);
            tradeDetails.setTradeHeader(trade);

            tradeDetailsDao.save(tradeDetails);

        }

        success = true;

        return success;

    }

    public void setTradeDao(GenericDao<Trade, Long> tradeDao) {
        this.tradeDao = tradeDao;
    }

    public void setTradeDetailsDao(
            GenericDao<TradeDetails, Long> tradeDetailsDao) {
        this.tradeDetailsDao = tradeDetailsDao;
    }

    public void setTrxCatDao(GenericDao<TransactionCategory, Long> trxCatDao) {
        this.trxCatDao = trxCatDao;
    }

    public void setCurrencyDao(GenericDao<Currency, Long> currencyDao) {
        this.currencyDao = currencyDao;
    }

    public void setPartyDao(GenericDao<Party, Long> partyDao) {
        this.partyDao = partyDao;
    }

    public void setLotDao(GenericDao<Lot, Long> lotDao) {
        this.lotDao = lotDao;
    }

    public void setItemDao(GenericDao<Item, Long> itemDao) {
        this.itemDao = itemDao;
    }

}

/*
 * PurchaseOrderService.java
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

package com.swayam.ims.core.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.swayam.ims.core.dao.GenericDao;
import com.swayam.ims.model.orm.Currency;
import com.swayam.ims.model.orm.Item;
import com.swayam.ims.model.orm.Lot;
import com.swayam.ims.model.orm.Party;
import com.swayam.ims.model.orm.Trade;
import com.swayam.ims.model.orm.TradeDetails;
import com.swayam.ims.model.orm.TransactionCategory;

/**
 * 
 * @author paawak
 */
public class PurchaseOrderService {

    private GenericDao<Trade, Long> tradeDao;

    private GenericDao<TradeDetails, Long> tradeDetailsDao;

    private GenericDao<TransactionCategory, Long> trxCatDao;

    private GenericDao<Currency, Long> currencyDao;

    private GenericDao<Party, Long> partyDao;

    private GenericDao<Lot, Long> lotDao;

    private GenericDao<Item, Long> itemDao;

    // @SuppressWarnings("unchecked")
    // public long getNewPurchaseOrderId() {
    //
    // long id = 1;
    //
    // List results = tradeDao.findByNamedQuery(Trade.NAMED_QUERY_FIND_MAX_ID,
    // Collections.EMPTY_MAP);
    //
    // if (results != null && !results.isEmpty()) {
    //
    // Long maxId = (Long) results.get(0);
    //
    // if (maxId != null) {
    //
    // id = maxId + 1;
    //
    // }
    //
    // }
    //
    // return id;
    //
    // }

    public Lot getLot(long itemId) {

        Map<String, Object> lotParams = new HashMap<String, Object>(1);
        lotParams.put(Lot.PARAM_ITEM_ID, itemId);
        // get the latest lot and the price
        List<Lot> lotList = lotDao.findByNamedQuery(
                Lot.FIND_LATEST_LOT_FOR_ITEM, lotParams);

        if (lotList == null || lotList.isEmpty()) {

            // for human readable message
            Item item = itemDao.get(itemId);

            throw new IllegalArgumentException("No lot found for item `"
                    + item.getName() + "`, code : `" + item.getCode()
                    + "`. Please make sure there is enough stock!");
        }

        return lotList.get(0);

    }

    public boolean savePurchaseOrder(long partyId, float totalPrice,
            float discount, Map<Long, TradeDetailsLean> itemQtyMap) {

        // FIXME: do not hard-code
        TransactionCategory trxCat = trxCatDao.get(1l);

        // FIXME: do not hard-code
        Currency curr = currencyDao.get(1l);

        Party party = partyDao.get(partyId);

        Trade trade = new Trade();
        trade.setCategory(trxCat);
        trade.setCurrency(curr);
        trade.setCustomer(party);
        trade.setTotalAmount(totalPrice);
        trade.setNetAmount(totalPrice - discount);
        trade.setTradeDate(new Date());

        trade = tradeDao.save(trade);

        Iterator<Long> itemIdItr = itemQtyMap.keySet().iterator();

        while (itemIdItr.hasNext()) {

            Long id = itemIdItr.next();

            TradeDetailsLean tdLean = itemQtyMap.get(id);

            TradeDetails tradeDetails = new TradeDetails();
            tradeDetails.setItem(itemDao.get(id));
            tradeDetails.setItemLot(lotDao.get(tdLean.getLotId()));
            tradeDetails.setQuantity(tdLean.getQuantity());
            tradeDetails.setTotalPrice(tdLean.getTotalPrice());
            tradeDetails.setTradeHeader(trade);

            tradeDetailsDao.save(tradeDetails);

        }

        return true;

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

    public static class TradeDetailsLean {

        private int quantity;
        private long lotId;
        private float totalPrice;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public long getLotId() {
            return lotId;
        }

        public void setLotId(long lotId) {
            this.lotId = lotId;
        }

        public float getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(float totalPrice) {
            this.totalPrice = totalPrice;
        }

    }

}

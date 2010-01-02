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
import java.util.List;

import com.swayam.ims.core.dao.GenericDao;
import com.swayam.ims.model.orm.Trade;
import com.swayam.ims.model.orm.TradeDetails;

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

    public void setTradeDao(GenericDao<Trade, Long> tradeDao) {
        this.tradeDao = tradeDao;
    }

    public void setTradeDetailsDao(
            GenericDao<TradeDetails, Long> tradeDetailsDao) {
        this.tradeDetailsDao = tradeDetailsDao;
    }

}

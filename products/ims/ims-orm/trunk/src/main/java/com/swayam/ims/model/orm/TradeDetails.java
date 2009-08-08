/*
 * TradeDetails.java
 *
 * Created on Aug 8, 2009 5:34:04 PM
 *
 * Copyright (c) 2002 - 2009 : Swayam Inc.
 *
 * P R O P R I E T A R Y & C O N F I D E N T I A L
 *
 * The copyright of this document is vested in Swayam Inc. without
 * whose prior written permission its contents must not be published,
 * adapted or reproduced in any form or disclosed or
 * issued to any third party.
 */

package com.swayam.ims.model.orm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author paawak
 */
@Entity
@Table
public class TradeDetails extends BaseObject {

    private static final long serialVersionUID = 1694240781234093096L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trade_header")
    private Trade tradeHeader;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Item item;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_lot")
    private Lot itemLot;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private float totalPrice;

    public Trade getTradeHeader() {
        return tradeHeader;
    }

    public void setTradeHeader(Trade tradeHeader) {
        this.tradeHeader = tradeHeader;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Lot getItemLot() {
        return itemLot;
    }

    public void setItemLot(Lot itemLot) {
        this.itemLot = itemLot;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (getClass() != obj.getClass())
            return false;
        TradeDetails other = (TradeDetails) obj;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (itemLot == null) {
            if (other.itemLot != null)
                return false;
        } else if (!itemLot.equals(other.itemLot))
            return false;
        if (quantity != other.quantity)
            return false;
        if (Float.floatToIntBits(totalPrice) != Float
                .floatToIntBits(other.totalPrice))
            return false;
        if (tradeHeader == null) {
            if (other.tradeHeader != null)
                return false;
        } else if (!tradeHeader.equals(other.tradeHeader))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = System.identityHashCode(this);
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result + ((itemLot == null) ? 0 : itemLot.hashCode());
        result = prime * result + quantity;
        result = prime * result + Float.floatToIntBits(totalPrice);
        result = prime * result
                + ((tradeHeader == null) ? 0 : tradeHeader.hashCode());
        return result;
    }

}

/*
 * Transaction.java
 *
 * Created on Jul 31, 2009 11:50:08 PM
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

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author paawak
 */
@Entity
@Table
public class Transaction implements Serializable {

    private static final long serialVersionUID = -9116362232532341855L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date transactionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Party party;

    @Column(nullable = false)
    private Currency currency;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private TransactionCategory category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public TransactionCategory getCategory() {
        return category;
    }

    public void setCategory(TransactionCategory category) {
        this.category = category;
    }

}

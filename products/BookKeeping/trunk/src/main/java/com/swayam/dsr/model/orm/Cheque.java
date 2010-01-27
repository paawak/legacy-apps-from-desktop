/*
 * Cheque.java
 *
 * Created on Jan 28, 2010 1:31:25 AM
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

package com.swayam.dsr.model.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author paawak
 */
@Embeddable
public class Cheque implements Serializable {

    private static final long serialVersionUID = 5942128218826292458L;

    @Column(length = 10)
    private String chequeNo;

    @Column(length = 100)
    private String bank;

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

}

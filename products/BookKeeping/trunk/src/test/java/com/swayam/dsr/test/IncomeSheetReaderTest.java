/*
 * IncomeSheetReaderTest.java
 *
 * Created on Jan 28, 2010 1:49:37 PM
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

package com.swayam.dsr.test;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.swayam.dsr.migration.xls.read.IncomeSheetReader;
import com.swayam.dsr.model.orm.FundCollection;

/**
 * 
 * @author paawak
 */
public class IncomeSheetReaderTest {

    private IncomeSheetReader incomeSheetReader;

    @Before
    public void setUp() throws Exception {

        incomeSheetReader = new IncomeSheetReader(
                new FileInputStream(
                        "/bhandar/dsr-fairmont/accounts/TEST_FAIRMONT_COLLECTION_2008.xls"));

    }

    @Test
    public void testRead() {

        List<FundCollection> fundCollectionList = incomeSheetReader.read("205");

        for (FundCollection fundCollection : fundCollectionList) {
            System.out.println(fundCollection.getPaidOn());
        }

        assertTrue(true);

    }

}

/*
 * FundCollectionMigrator.java
 *
 * Created on Jan 28, 2010 2:13:34 AM
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

package com.swayam.dsr.migration.xls;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

import com.swayam.dsr.migration.xls.read.IncomeSheetReader;
import com.swayam.dsr.model.orm.FundCollection;
import com.swayam.dsr.util.HibernateUtil;

/**
 * 
 * @author paawak
 */
public class FundCollectionMigrator {

    private static final String[] FLAT_PREFIX = { "G", "10", "20", "30" };

    // private static final String FUND_COLLECTION_EXCEL_PATH = "/bhandar/dsr-fairmont/accounts/FAIRMONT_COLLECTION_";
    private static final String FUND_COLLECTION_EXCEL_PATH = "/home/paawak/Desktop/fairmont/FAIRMONT_COLLECTION_";

    public void saveToDB() throws IOException {
        saveYear(2008);
        saveYear(2009);
    }

    private void saveYear(int year) throws IOException {

        IncomeSheetReader incomeSheetReader = new IncomeSheetReader(
                new FileInputStream(FUND_COLLECTION_EXCEL_PATH + year + ".xls"));

        for (String pref : FLAT_PREFIX) {

            for (int i = 1; i <= 6; i++) {

                String flat = pref + i;

                readFlat(incomeSheetReader, year, flat);

            }

        }

        readFlat(incomeSheetReader, year, "404");

        readFlat(incomeSheetReader, year, "405");

        readFlat(incomeSheetReader, year, "406");

    }

    private void readFlat(IncomeSheetReader incomeSheetReader, int year,
            String flat) {

        try {

            List<FundCollection> fundCollectionList = incomeSheetReader
                    .read(flat);

            for (FundCollection fundCollection : fundCollectionList) {

                Session session = HibernateUtil.getSession();

                fundCollection.setFlat(flat);

                if (fundCollection.getPaidOn() == null) {

                    fundCollection.setPaidOn(new GregorianCalendar(year, 0, 1)
                            .getTime());

                }

                session.save(fundCollection);
                session.flush();
                session.close();

            }

        } catch (Exception e) {
            System.err.println("could not read " + flat + " for year " + year);
            e.printStackTrace();
        }

    }

    public static void main(String[] a) throws IOException {

        new FundCollectionMigrator().saveToDB();

    }

}

/*
 * ExpensesMigrator.java
 *
 * Created on Jan 28, 2010 7:16:28 PM
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
import java.util.List;

import org.hibernate.Session;

import com.swayam.dsr.migration.xls.read.ExpenseSheetReader;
import com.swayam.dsr.model.orm.Expenses;
import com.swayam.dsr.util.HibernateUtil;

/**
 * 
 * @author paawak
 */
public class ExpensesMigrator {

    private static final String EXPENSES_EXCEL_PATH = "/bhandar/dsr-fairmont/accounts/FAIRMONT_EXPENSES_MASTER.xls";

    public void saveToDB() throws IOException {

        ExpenseSheetReader expenseSheetReader = new ExpenseSheetReader(
                new FileInputStream(EXPENSES_EXCEL_PATH));

        List<Expenses> expensesList = expenseSheetReader.read();

        for (Expenses expenses : expensesList) {

            Session session = HibernateUtil.getSession();

            session.save(expenses);
            session.flush();
            session.close();

        }

    }

    public static void main(String[] a) throws IOException {
        new ExpensesMigrator().saveToDB();
    }

}

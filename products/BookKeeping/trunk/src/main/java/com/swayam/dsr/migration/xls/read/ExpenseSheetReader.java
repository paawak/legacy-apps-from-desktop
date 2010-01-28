/*
 * ExpenseSheetReader.java
 *
 * Created on Jan 28, 2010 6:50:43 PM
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

package com.swayam.dsr.migration.xls.read;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.swayam.dsr.model.orm.Cheque;
import com.swayam.dsr.model.orm.Expenses;

/**
 * 
 * @author paawak
 */
public class ExpenseSheetReader extends SheetReader {

    public ExpenseSheetReader(InputStream excelSheetContents)
            throws IOException {
        super(excelSheetContents, 2);
    }

    public List<Expenses> read() {

        List<Expenses> expensesList = new ArrayList<Expenses>();

        HSSFSheet sheet = excelBook.getSheetAt(0);

        for (int rowNum = startFromRow;; rowNum++) {

            HSSFRow row = sheet.getRow(rowNum);

            if (row == null) {
                break;
            }

            Expenses expenses = new Expenses();

            String date = getCellContent(row, 1);

            if (date == null) {
                break;
            }

            try {
                expenses.setExpenseDate(getDate(date));
            } catch (NumberFormatException e) {
                System.err.println("Could not parse date: rowNum=" + rowNum);
            }

            String description = getCellContent(row, 2);
            expenses.setDescription(description);

            String amount = getCellContent(row, 3);
            expenses.setAmount(Float.parseFloat(amount));

            String chequeNum = getCellContent(row, 5);

            if (chequeNum != null) {

                Cheque cheque = new Cheque();
                cheque.setChequeNo(chequeNum);
                expenses.setCheque(cheque);

            }

            String payableTo = getCellContent(row, 6);
            expenses.setPayableTo(payableTo);

            String billNum = getCellContent(row, 7);
            expenses.setBillNum(billNum);

            String comments = getCellContent(row, 8);
            expenses.setComments(comments);

            expensesList.add(expenses);

        }

        return expensesList;

    }

}

/*
 * IncomeSheetReader.java
 *
 * Created on Jan 27, 2010 11:37:52 PM
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
import com.swayam.dsr.model.orm.FundCollection;

/**
 * 
 * @author paawak
 */
public class IncomeSheetReader extends SheetReader {

    public IncomeSheetReader(InputStream excelSheetContents) throws IOException {

        super(excelSheetContents, 6);

    }

    public List<FundCollection> read(String sheetName) {

        List<FundCollection> fundCollectionList = new ArrayList<FundCollection>(
                4);

        HSSFSheet sheet = excelBook.getSheet(sheetName);

        for (int rowNum = startFromRow;; rowNum++) {

            FundCollection fundCollection = new FundCollection();

            HSSFRow row = sheet.getRow(rowNum);

            String date = getCellContent(row, 1);

            try {
                fundCollection.setPaidOn(getDate(date));
            } catch (NumberFormatException e) {
                System.err.println("Could not parse date: sheet=" + sheetName
                        + ", rowNum=" + rowNum);
            }

            String description = getCellContent(row, 2);
            fundCollection.setDescription(description);

            String amount = getCellContent(row, 3);

            if (amount == null || "".equals(amount.trim())) {
                break;
            }

            fundCollection.setAmountPaid(Float.parseFloat(amount));

            // String mode = getCellContent(row, 4);

            String chequeNum = getCellContent(row, 5);

            if (chequeNum != null && !"".equals(chequeNum.trim())) {

                Cheque cheque = new Cheque();
                cheque.setChequeNo(chequeNum);
                String bankDetails = getCellContent(row, 6);
                cheque.setBank(bankDetails);

                fundCollection.setCheque(cheque);

            }

            fundCollectionList.add(fundCollection);

        }

        return fundCollectionList;

    }

}

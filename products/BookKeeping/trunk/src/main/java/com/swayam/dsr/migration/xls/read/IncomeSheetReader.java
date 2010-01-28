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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.swayam.dsr.model.orm.Cheque;
import com.swayam.dsr.model.orm.FundCollection;

/**
 * 
 * @author paawak
 */
public class IncomeSheetReader {

    private final HSSFWorkbook excelBook;

    private int startFromRow;

    public IncomeSheetReader(InputStream excelSheetContents) throws IOException {

        excelBook = new HSSFWorkbook(excelSheetContents);
        startFromRow = 6;

    }

    public List<FundCollection> read(String sheetName) {

        List<FundCollection> fundCollectionList = new ArrayList<FundCollection>(
                4);

        HSSFSheet sheet = excelBook.getSheet(sheetName);

        for (int rowNum = startFromRow;; rowNum++) {

            FundCollection fundCollection = new FundCollection();

            HSSFRow row = sheet.getRow(rowNum);

            String date = getCellContent(row, 1);

            if (date != null && !"".equals(date.trim())) {

                // hack to have date in readble format
                int dateInt = (int) Float.parseFloat(date);

                Calendar cal = new GregorianCalendar(1899, 11, 30);

                cal.add(Calendar.DATE, dateInt);

                fundCollection.setPaidOn(cal.getTime());

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

    private String getCellContent(HSSFRow row, int index) {

        HSSFCell cell = row.getCell(index);

        String content = null;

        if (cell != null) {

            int cellType = cell.getCellType();

            switch (cellType) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                content = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_STRING:
                content = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                content = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                break;
            default:
                throw new UnsupportedOperationException("HssfCellType "
                        + cellType + " not yet supported");
            }

        }

        return content;

    }

}

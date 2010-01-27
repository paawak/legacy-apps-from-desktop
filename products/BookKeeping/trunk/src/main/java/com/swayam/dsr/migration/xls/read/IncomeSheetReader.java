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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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

    public void read(String sheetName) {

        HSSFSheet sheet = excelBook.getSheet(sheetName);

        for (int rowNum = startFromRow;; rowNum++) {

            HSSFRow row = sheet.getRow(rowNum);

            String date = getCellContent(row, 1);

            String description = getCellContent(row, 2);

            String amount = getCellContent(row, 3);

            if (amount == null || "".equals(amount.trim())) {
                break;
            }

            String mode = getCellContent(row, 4);

            String chequeNum = getCellContent(row, 5);

            String bankDetails = getCellContent(row, 6);

            System.out.println("date=" + date + ", description=" + description
                    + ", " + amount + ", mode=" + mode + ", chequeNum="
                    + chequeNum + ", bankDetails=" + bankDetails);

        }

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

    public static void main(String[] a) throws IOException {

        // String file = "2008_FAIRMONT_COLLECTION.xls";
        String file = "2009_FAIRMONT_COLLECTION.xls";

        IncomeSheetReader incomeSheetReader = new IncomeSheetReader(
                new FileInputStream("/bhandar/dsr-fairmont/accounts/" + file));

        incomeSheetReader.read("306");

    }

}

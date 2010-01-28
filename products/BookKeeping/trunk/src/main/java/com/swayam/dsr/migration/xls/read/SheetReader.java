/*
 * SheetReader.java
 *
 * Created on Jan 28, 2010 6:46:25 PM
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 * @author paawak
 */
abstract class SheetReader {

    final HSSFWorkbook excelBook;

    final int startFromRow;

    SheetReader(InputStream excelSheetContents, int startFromRow)
            throws IOException {

        excelBook = new HSSFWorkbook(excelSheetContents);
        this.startFromRow = startFromRow;

    }

    String getCellContent(HSSFRow row, int index) {

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

    Date getDate(String date) throws NumberFormatException {

        Date givenDate = null;

        if (date != null && !"".equals(date.trim())) {

            // hack to have date in readble format
            int dateInt = (int) Float.parseFloat(date);

            Calendar cal = new GregorianCalendar(1899, 11, 30);

            cal.add(Calendar.DATE, dateInt);

            givenDate = cal.getTime();

        }

        return givenDate;

    }

}

package com.swayam.dms.web.util;

import java.util.Date;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtilTest extends TestCase {
    // ~ Instance fields
    // ========================================================

    private final Log log = LogFactory.getLog(DateUtilTest.class);

    // ~ Constructors
    // ===========================================================

    public DateUtilTest(String name) {
        super(name);
    }

    // public void testGetInternationalDatePattern() {
    // LocaleContextHolder.setLocale(new Locale("nl"));
    // assertEquals("dd-MMM-yyyy", DateUtil.getDatePattern());
    //       
    // LocaleContextHolder.setLocale(Locale.FRANCE);
    // assertEquals("dd/MM/yyyy", DateUtil.getDatePattern());
    //        
    // LocaleContextHolder.setLocale(Locale.GERMANY);
    // assertEquals("dd.MM.yyyy", DateUtil.getDatePattern());
    //        
    // // non-existant bundle should default to default locale
    // LocaleContextHolder.setLocale(new Locale("fi"));
    // String fiPattern = DateUtil.getDatePattern();
    // LocaleContextHolder.setLocale(Locale.getDefault());
    // String defaultPattern = DateUtil.getDatePattern();
    //        
    // assertEquals(defaultPattern, fiPattern);
    // }

    public void testGetDate() throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("db date to convert: " + new Date());
        }

        String date = DateUtil.getDate(new Date());

        if (log.isDebugEnabled()) {
            log.debug("converted ui date: " + date);
        }

        assertTrue(date != null);
    }

    public void testGetDateTime() {
        if (log.isDebugEnabled()) {
            log.debug("entered 'testGetDateTime' method");
        }
        String now = DateUtil.getTimeNow(new Date());
        assertTrue(now != null);
        log.debug(now);
    }
}

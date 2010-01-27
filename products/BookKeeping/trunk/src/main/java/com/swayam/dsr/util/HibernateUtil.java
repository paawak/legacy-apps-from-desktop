/*
 * HibernateUtil.java
 *
 * Created on Jan 28, 2010 2:10:06 AM
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

package com.swayam.dsr.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author paawak
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");

        sessionFactory = (SessionFactory) applicationContext
                .getBean("sessionFactory");

    }

    private HibernateUtil() {

    }

    public static Session getSession() throws HibernateException {

        return sessionFactory.openSession();

    }

}

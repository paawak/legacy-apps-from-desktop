/*
 * UnitTypeDao.java
 *
 * Created on Nov 17, 2010 2:11:48 PM
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

package com.swayam.demo.web.orm.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.swayam.demo.web.orm.model.UnitType;

/**
 * 
 * @author paawak
 */
public class UnitTypeDao extends HibernateDaoSupport {

    private final Class<?> clazz;

    public UnitTypeDao() {
        clazz = UnitType.class;
    }

    public Object save(Object o) {
        return getHibernateTemplate().merge(o);
    }

    public Object get(Serializable id) {
        Object o = getHibernateTemplate().get(clazz, id);

        if (o == null) {
            throw new ObjectRetrievalFailureException(clazz, id);
        }

        return o;
    }

    @SuppressWarnings("unchecked")
    public List<UnitType> getAll() {
        return (List<UnitType>) getHibernateTemplate().loadAll(clazz);
    }

    public void remove(Serializable id) {
        getHibernateTemplate().delete(get(id));
    }

}

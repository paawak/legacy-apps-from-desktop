/*
 * DataAccessor.java
 *
 * Created on May 12, 2008 1:30:31 AM
 *
 * Copyright (c) 2002 - 2008 : Swayam Inc.
 *
 * P R O P R I E T A R Y & C O N F I D E N T I A L
 *
 * The copyright of this document is vested in Swayam Inc. without
 * whose prior written permission its contents must not be published,
 * adapted or reproduced in any form or disclosed or
 * issued to any third party.
 */

package com.swayam.dms.db;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Copied from <a
 * href="http://www.javabeat.net/articles/42-integrating-spring-framework-with-hibernate-orm-framewo-4.html">http://www.javabeat.net/articles/42-integrating-spring-framework-with-hibernate-orm-framewo-4.html</a>
 * 
 * @author paawak
 * 
 */
public class DataAccessor implements IDataAccessor {

    private final HibernateTemplate hibernateTemplate;

    public DataAccessor(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @SuppressWarnings("unchecked")
    public <K> List<K> query(final String hql, final String entityKey,
            final Class<K> entityClass) {

        HibernateCallback callback = new HibernateCallback() {

            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {

                SQLQuery sqlQuery = session.createSQLQuery(hql);
                sqlQuery.addEntity(entityKey, entityClass);

                return sqlQuery.list();
            }

        };

        return (List<K>) hibernateTemplate.execute(callback);

    }

    public Object querySingle(final String hql) {

        HibernateCallback callback = new HibernateCallback() {

            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {

                Query sqlQuery = session.createQuery(hql);

                return sqlQuery.uniqueResult();

            }

        };

        return hibernateTemplate.execute(callback);

    }

    public void saveOrUpdate(final Object entity) {

        HibernateCallback callback = new HibernateCallback() {

            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                session.saveOrUpdate(entity);
                return null;
            }

        };

        hibernateTemplate.execute(callback);
    }

}

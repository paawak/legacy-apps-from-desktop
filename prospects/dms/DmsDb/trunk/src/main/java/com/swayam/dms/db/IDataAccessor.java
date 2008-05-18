/*
 * IDataAccessor.java
 *
 * Created on May 12, 2008 1:33:32 AM
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

import java.util.List;

/**
 * 
 * @author paawak
 * 
 */
public interface IDataAccessor {

    void saveOrUpdate(Object entity);

    <K> List<K> query(String hql, String entityKey, Class<K> entityClass);

}
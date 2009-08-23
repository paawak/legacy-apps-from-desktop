/*
 * AccountGroupManage.java
 *
 * Created on Aug 23, 2009 12:25:55 AM
 *
 * Copyright (c) 2002 - 2009 : Swayam Inc.
 *
 * P R O P R I E T A R Y & C O N F I D E N T I A L
 *
 * The copyright of this document is vested in Swayam Inc. without
 * whose prior written permission its contents must not be published,
 * adapted or reproduced in any form or disclosed or
 * issued to any third party.
 */

package com.swayam.ims.core.service.impl;

import java.util.Collections;
import java.util.List;

import com.swayam.ims.core.dao.GenericDao;
import com.swayam.ims.model.orm.AccountGroup;

/**
 * 
 * @author paawak
 */
public class AccountGroupManager {

    private final GenericDao<AccountGroup, Long> accountGroupDao;

    public AccountGroupManager(GenericDao<AccountGroup, Long> accountGroupDao) {
        this.accountGroupDao = accountGroupDao;
        System.out
                .println("*****************AccountGroupManager.AccountGroupManager()");
    }

    @SuppressWarnings("unchecked")
    public AccountGroup save(AccountGroup accountGroup) {

        System.out.println("############AccountGroupManager.save()");

        List maxId = accountGroupDao.findByNamedQuery(
                AccountGroup.NAMED_QUERY_FIND_MAX_ID, Collections.EMPTY_MAP);

        long id = 1;

        if (!maxId.isEmpty()) {
            id = (Long) maxId.get(0) + 1;
        }

        accountGroup.setId(id);

        return accountGroupDao.save(accountGroup);

    }

    public String save(String name, String desc) {

        AccountGroup accountGroup = new AccountGroup();
        accountGroup.setName(name);
        accountGroup.setDescription(desc);

        accountGroup = save(accountGroup);

        return accountGroup.getId().toString();

    }

    public GenericDao<AccountGroup, Long> getAccountGroupDao() {
        return accountGroupDao;
    }

}

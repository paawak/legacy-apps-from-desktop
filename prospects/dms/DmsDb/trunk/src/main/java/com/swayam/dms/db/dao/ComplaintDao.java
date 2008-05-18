/*
 * ComplaintDao.java
 *
 * Created on May 13, 2008 11:57:46 PM
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

package com.swayam.dms.db.dao;

import java.util.List;

import com.swayam.dms.db.IDataAccessor;
import com.swayam.dms.db.model.Complaint;
import com.swayam.dms.db.model.Employee;

/**
 * 
 * @author paawak
 */
public class ComplaintDao {

    private final IDataAccessor dataAccessor;

    public ComplaintDao(IDataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public List<Complaint> getComplaints(Employee assignedTo) {

        String query = "SELECT {complaint.*} FROM complaint complaint WHERE complaint.assigned_to="
                + assignedTo.getEmployeeId();

        return dataAccessor.query(query, "complaint", Complaint.class);

    }

}

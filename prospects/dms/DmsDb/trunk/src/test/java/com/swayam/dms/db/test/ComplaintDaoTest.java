/*
 * ComplaintDaoTest.java
 *
 * Created on May 14, 2008 12:48:12 AM
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

package com.swayam.dms.db.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.swayam.dms.db.dao.ComplaintDao;
import com.swayam.dms.db.model.Complaint;
import com.swayam.dms.db.model.Employee;

/**
 * 
 * @author paawak
 */
public class ComplaintDaoTest {

    private ComplaintDao complaintDao;

    @Before
    public void setUp() throws Exception {
        String[] configFiles = new String[] { "applicationContext.xml" };
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                configFiles);
        complaintDao = (ComplaintDao) applicationContext
                .getBean("complaintDao");
    }

    @Test
    public void testGetComplaints() {
        int assignedToId = 1;
        Employee emp = new Employee();
        emp.setEmployeeId(assignedToId);
        List<Complaint> comps = complaintDao.getComplaints(emp);
        assertNotNull(comps);
        assertFalse(comps.isEmpty());

        for (Complaint complaint : comps) {
            Employee assignedTo = complaint.getEmployeeByAssignedTo();
            assertNotNull(assignedTo);
            assertEquals(assignedToId, assignedTo.getEmployeeId());
            System.out.println("ComplaintDaoTest.testGetComplaints() details: "
                    + complaint.getDetails());
        }
    }
}

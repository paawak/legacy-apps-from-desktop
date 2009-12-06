/*
 * ConnectionManagerTest.java
 *
 * Created on Dec 5, 2009 5:43:10 PM
 *
 * Copyright (c) 2002 - 2009 : Swayam Inc.
 *
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.swayam.chat.client.test.core;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.RosterPacket.ItemStatus;
import org.junit.Before;
import org.junit.Test;

import com.swayam.chat.client.core.ConnectionManager;
import com.swayam.chat.client.core.model.Credentials;

/**
 * 
 * @author paawak
 */
public class ConnectionManagerTest {

    private ConnectionManager manager;

    @Before
    public void setup() {

        Credentials creds = new Credentials("localhost", 5222, "palash", "ray");
        manager = new ConnectionManager(creds);

    }

    @Test
    public void test_getConnection() throws XMPPException {

        XMPPConnection con = manager.getConnection();
        assertNotNull(con);
        Roster roster = con.getRoster();
        assertNotNull(roster);

        Collection<RosterGroup> groups = roster.getGroups();

        for (RosterGroup group : groups) {

            System.out.println("--------------------" + group.getName() + "--------------------");

            Collection<RosterEntry> entries = group.getEntries();

            for (RosterEntry entry : entries) {

                String name = entry.getName();
                String user = entry.getUser();
                ItemStatus status = entry.getStatus();

                System.out.println("name = " + name + ", user = " + user + ", status = " + status);

            }

        }

    }

}

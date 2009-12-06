/*
 * ConnectionManager.java
 *
 * Created on Dec 5, 2009 4:43:51 PM
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

package com.swayam.chat.client.core.util;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import com.swayam.chat.client.core.model.Credentials;

/**
 * 
 * @author paawak
 */
public class ConnectionManager {

    private final Credentials credentials;

    private XMPPConnection con;

    public ConnectionManager(Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * Establishes connection to the remote server and logs in the user, if not already logged in.
     * 
     * @return
     * @throws XMPPException
     */
    public XMPPConnection getConnection() throws XMPPException {

        if (con == null) {

            ConnectionConfiguration conf = new ConnectionConfiguration(credentials.getServer(),
                    credentials.getPort());

            conf.setReconnectionAllowed(true);
            // conf.setSendPresence(true);

            con = new XMPPConnection(conf);

        }

        // if its disconnected, reconnect
        if (!con.isConnected()) {
            con.connect();
        }

        // login
        if (!con.isAuthenticated()) {
            con.login(credentials.getUserName(), credentials.getPassword());
        }

        return con;

    }

}

/*
 * Credentials.java
 *
 * Created on Dec 5, 2009 4:31:08 PM
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

package com.swayam.chat.client;

/**
 * 
 * @author paawak
 */
public class Credentials {

    private static final int DEFAULT_PORT = 5222;

    private final String server;

    private final int port;

    private final String userName;

    private final String password;

    public Credentials(String server, int port, String userName, String password) {
        this.server = server;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    public Credentials(String server, String userName, String password) {
        this(server, DEFAULT_PORT, userName, password);
    }

    public static int getDefaultPort() {
        return DEFAULT_PORT;
    }

    public String getServer() {
        return server;
    }

    public int getPort() {
        return port;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}

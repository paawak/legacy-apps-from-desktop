/*
 * Contact.java
 *
 * Created on Dec 6, 2009 9:39:20 PM
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

package com.swayam.chat.client.core.model;

/**
 * 
 * @author paawak
 */
public interface Contact {

    String getDisplayName();

    Status getStatus();

    enum Status {

        OFFLINE, AVAILABLE, BUSY, AWAY, EXTENDED_AWAY;

    }

}

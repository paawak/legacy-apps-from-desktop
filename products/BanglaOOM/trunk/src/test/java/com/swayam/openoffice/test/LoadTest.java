/*
 * LoadTest.java
 *
 * Created on Jan 15, 2010 6:00:40 PM
 *
 * Copyright (c) 2002 - 2010 : Swayam Inc.
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

package com.swayam.openoffice.test;

import junit.framework.TestCase;

import com.sun.star.lib.loader.Loader;
import com.swayam.openoffice.FirstUnoContact;

/**
 * 
 * @author paawak
 */
public class LoadTest extends TestCase {

    public void testMain() {

        try {
            Loader.main(new String[] { FirstUnoContact.class.getName() });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

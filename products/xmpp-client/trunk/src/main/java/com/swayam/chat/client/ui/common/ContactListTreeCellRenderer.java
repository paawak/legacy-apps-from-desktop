/*
 * ContactListTreeCellRenderer.java
 *
 * Created on Dec 7, 2009 1:55:12 AM
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

package com.swayam.chat.client.ui.common;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * 
 * @author paawak
 */
public class ContactListTreeCellRenderer extends DefaultTreeCellRenderer {

    private static final long serialVersionUID = -6844158441533404757L;

    private Object value;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
            boolean expanded, boolean leaf, int row, boolean hasFocus) {

        this.value = value;

        return super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row,
                hasFocus);

    }

    @Override
    public Icon getLeafIcon() {
        System.out.println("******ContactListTreeCellRenderer.getLeafIcon() " + value);
        return leafIcon;
    }

}

/*
 * FontMapper.java
 * 
 * Created on Sep 29, 2007, 10:34:19 PM
 *
 * Copyright (c) 2002 - 2008 : Swayam Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
package com.swayam.bhasha.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 
 * Maps the <code>java.awt.Font</code>s to the actual font-file on the disk.
 * 
 * @author paawak
 * 
 * @deprecated Not the correct thing to do
 * 
 */
@Deprecated
public class FontMapper {

    private static final String FONT_PROPS = "props/Font";
    private static final String WIN = "win";
    private static final String MAC = "mac";
    private static final String LINUX = "linux";

    public static final FontMapper INSTANCE = new FontMapper();

    private final FileFilter ttfFontFilter = new FileFilter() {

        public boolean accept(File pathname) {
            return pathname.isFile() && pathname.getName().toLowerCase().endsWith(".ttf");
        }

    };

    private final Map<String, String> fontToFileMap = new HashMap<String, String>();

    private FontMapper() {
        mapFonts();
    }

    public String getFontFile(String fontFamily) {
        return fontToFileMap.get(fontFamily);
    }

    private void mapFonts() {

        ResourceBundle res = ResourceBundle.getBundle(FONT_PROPS);
        String fontFolders = res.getString(getOSKey());
        String[] fontFolderArray;

        if (fontFolders.contains(",")) {
            fontFolderArray = fontFolders.split(",");
        } else {
            fontFolderArray = new String[] { fontFolders };
        }

        for (String fontFolderName : fontFolderArray) {
            mapFontsForFolder(fontFolderName.trim());
        }

    }

    private void mapFontsForFolder(String folderName) {

        File fontFolder = new File(folderName);
        File[] fontFiles = fontFolder.listFiles(ttfFontFilter);

        if (fontFiles == null) {
            return;
        }

        for (File fontFile : fontFiles) {
            try {
                String fontName = Font.createFont(Font.TRUETYPE_FONT, fontFile).getFamily();
                fontToFileMap.put(fontName, fontFile.getAbsolutePath());
            } catch (FontFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String getOSKey() {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains(MAC)) {
            return MAC;
        } else if (os.contains(WIN)) {
            return WIN;
        } else if (os.contains(LINUX)) {
            return LINUX;
        }

        throw new UnsupportedOperationException("This OS " + os + " is not supported as yet: add the FontFolder for this OS in the " + FONT_PROPS + ".properties file");

    }

    /** For testing */
    public static void main(String[] a) {

        System.out.println("FontMapper.main() fontToFile :");
        System.out.println(FontMapper.INSTANCE.fontToFileMap);

    }

}

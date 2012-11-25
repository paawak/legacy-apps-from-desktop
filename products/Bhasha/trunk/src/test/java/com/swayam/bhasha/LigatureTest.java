package com.swayam.bhasha;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphMetrics;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class LigatureTest {

    @Test
    public void testApp() throws FontFormatException, IOException {
        // Font font = new Font("Lohit Bengali", Font.PLAIN, 30);
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File("/usr/share/fonts/lohit-bengali/Lohit-Bengali.ttf"));
        FontRenderContext context = new FontRenderContext(new AffineTransform(), true, true);
        GlyphVector glyphVector = font.createGlyphVector(context, "ক্ষী");
        System.out.println(glyphVector.getNumGlyphs());
        for (int i = 0; i < glyphVector.getNumGlyphs(); i++) {
            GlyphMetrics metrics = glyphVector.getGlyphMetrics(glyphVector.getGlyphCharIndex(i));
            System.out.println(i + " : " + metrics.isLigature());
        }
    }
}

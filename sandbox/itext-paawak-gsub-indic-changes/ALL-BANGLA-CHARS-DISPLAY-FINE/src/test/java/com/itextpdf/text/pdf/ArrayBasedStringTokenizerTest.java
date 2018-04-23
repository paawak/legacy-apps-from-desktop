package com.itextpdf.text.pdf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *  
 * @author <a href="mailto:paawak@gmail.com">Palash Ray</a>
 */
public class ArrayBasedStringTokenizerTest {
    
    @Test
    public void testTokenize_happyPath() {
        //given
        ArrayBasedStringTokenizer tokenizer = new ArrayBasedStringTokenizer(new String[]{"aZx", "b2c", "bc2"});
        String text = "12345aZxxabbccb2cxxxcfb1245678bc2889000";
        
        //when
        List<String> tokens = Arrays.asList(tokenizer.tokenize(text));
        
        //then
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            sb.append(token);
        }
        
        assertEquals(text, sb.toString());
        assertEquals(tokens, Arrays.asList("12345", "aZx", "xabbcc", "b2c", "xxxcfb1245678", "bc2", "889000"));
    }
    
    @Test
    public void testTokenize_regexAtStart() {
        //given
        ArrayBasedStringTokenizer tokenizer = new ArrayBasedStringTokenizer(new String[]{"aZx", "b2c", "bc2"});
        String text = "bc2e12345aZxxabbccb2cxxxcfb1245678bc2889000";
        
        //when
        String[] tokens = tokenizer.tokenize(text);
        
        //then
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            sb.append(token);
        }
        
        assertEquals(text, sb.toString());
        
        List<String> tokenList = Arrays.asList(tokens);
        
        assertEquals(0, tokenList.indexOf("bc2")); 
    }
    
    @Test
    public void testTokenize_regexAtEnd() {
        //given
        ArrayBasedStringTokenizer tokenizer = new ArrayBasedStringTokenizer(new String[]{"aZx", "b2c", "bc2"});
        String text = "bc2e12345aZxxabbccb2cxxxcfb1245678bc2889000aZx";
        
        //when
        List<String> tokens = Arrays.asList(tokenizer.tokenize(text));
        
        //then
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            sb.append(token);
        }
        
        assertEquals(text, sb.toString());
        assertEquals(0, tokens.indexOf("bc2")); 
        assertEquals(2, tokens.indexOf("aZx"));
        assertEquals(tokens.size() - 1, tokens.lastIndexOf("aZx"));
    }
    
    @Test
    public void testTokenize_Bangla() {
        //given
        ArrayBasedStringTokenizer tokenizer = new ArrayBasedStringTokenizer(new String[]{"\u0995\u09cd\u09b7", "\u09aa\u09c1\u09a4\u09c1"});
        String text = "\u0986\u09ae\u09bf \u0995\u09cb\u09a8 \u09aa\u09a5\u09c7  \u0995\u09cd\u09b7\u09c0\u09b0\u09c7\u09b0 \u09b7\u09a8\u09cd\u09a1  \u09aa\u09c1\u09a4\u09c1\u09b2 \u09b0\u09c1\u09aa\u09cb  \u0997\u0999\u09cd\u0997\u09be \u098b\u09b7\u09bf";
        
        //when
        String[] tokens = tokenizer.tokenize(text);
        
        //then
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            sb.append(token);
        }
        
        assertEquals(text, sb.toString());
        
        List<String> tokenList = Arrays.asList(tokens);
        
        assertTrue(tokenList.contains("\u0995\u09cd\u09b7"));
        assertTrue(tokenList.contains("\u09aa\u09c1\u09a4\u09c1")); 
    }

}

/*
 * IndicPane.java
 *
 * Created on July 31, 2005, 11:17 AM
 */

package com.swayam.bhasha.utils.page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import org.apache.log4j.Logger;

import com.swayam.bhasha.utils.PropertyFileUtils;

/**
 * 
 * @author paawak
 */
public class IndicPane extends JTextPane {

    private static final long serialVersionUID = 1L;
    private final Logger logger = Logger.getLogger(getClass());

    public IndicPane() {
        this(null, null, null);
    }

    public IndicPane(Locale defaultLocale, Dimension pageDim, Insets insets) {
        super(new DefaultStyledDocument());

        if (pageDim != null && insets != null) {
            setSize(pageDim);
            setPreferredSize(pageDim);
            setMaximumSize(pageDim);
            setMinimumSize(pageDim);
            setMargin(insets);
        }

        if (defaultLocale == null) {
            defaultLocale = BANGLA_LOCALE;
        }

        this.currentLocale = defaultLocale;
        setFont((Font) LOCALE_TO_FONT.get(currentLocale));

        /*
         * A small comment: the order of events recieved is:keyPressed, keyTyped
         * and then keyReleased. So, this last keyReleasedis not called when you
         * keep a key pressed. It is enough to set the char ofthe event in
         * keyTyped so that Roman chars are not displayed
         */
        // this is not really needed
        // addKeyListener(new KeyAdapter() {
        // public void keyPressed(KeyEvent evt) {
        // setEventKeyChar(evt);
        // }
        // });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (!currentLocale.equals(ENGLISH_LOCALE)) {
                    setEventKeyChar(evt);
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (!currentLocale.equals(ENGLISH_LOCALE)) {
                    replaceRomanChars(evt);
                } else {
                    // this is very important since the attributes must be set
                    // so, any word character should be replaced only by the
                    // replace method
                    // if this is not done, the attributes of English character
                    // are not at all set and this leads to nasty jpeg image
                    // with
                    // squares in place of Roman chars
                    String keyStr = Character.toString(evt.getKeyChar());
                    final String REGEX_FOR_VALID_ROMAN_KEY = "[\\.\\w]";
                    Pattern pattern = Pattern.compile(REGEX_FOR_VALID_ROMAN_KEY);
                    if (pattern != null) {
                        Matcher matcher = pattern.matcher(keyStr);
                        if (matcher.matches()) {
                            charStore.add(evt.getKeyChar());
                            replace(keyStr, getCaretPosition() - 1);
                        }
                    }
                }
            }
        });

        /**
         *this is very important: reset characterHistory on mouse click: when
         * the cursor is placed at different position by mouse; as it may lead
         * to printing of undesirable characters
         */

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                charStore.purge();
            }
        });

    }

    /** current locale: for displaying the labels */
    private Locale currentLocale = null;
    /** contains default fonts for each locale */
    public static final Hashtable LOCALE_TO_FONT = new Hashtable(1);
    public static final Locale BANGLA_LOCALE = new Locale("bn", "IN");
    public static final Locale HINDI_LOCALE = new Locale("hi", "IN");
    public static final Locale ENGLISH_LOCALE = Locale.getDefault();
    public static final int STANDARD_FONT_SIZE = 18;
    public static final Font BANGLA_FONT_DEF = new Font("SolaimanLipi", Font.PLAIN, STANDARD_FONT_SIZE);
    public static final Font HINDI_FONT_DEF = new Font("Mangal", Font.PLAIN, STANDARD_FONT_SIZE);
    public static final Font ENGLISH_FONT_DEF = new Font("Arial", Font.PLAIN, STANDARD_FONT_SIZE);
    /** Set containing the matras of Bangla and Hindi */
    private static final TreeSet MATRAS = new TreeSet();
    /** Set containing the SwarVarnas of Bangla and Hindi */
    private static final TreeSet SWAR_VARNAS = new TreeSet();
    /**
     * the ofset by which Bangla unicode differs from their Devnagari
     * counterpart
     */
    private static final int BANGLA_OFFSET = 0x80;
    /** the offset by which the Matras differ from the Swar Varnas */
    private static final int MATRA_OFFSET = 0x38;
    /** Map containing mapping from English to Indic chars */
    private Map indicMap = null;
    /** the no. of previous key charactes to be stored */
    private final int CHAR_LENGTH_MONITORED = 3;
    private final CharStore charStore = new CharStore(CHAR_LENGTH_MONITORED);
    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isUnderline = false;
    public static final String[] FONT_SIZE_ARRAY = { "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "40", "48", "52", "60", "72" };
    public static final Color[] COLOR_ARRAY = { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange,
            Color.pink, Color.red, Color.yellow };
    public static final String[] COLOR_STR_ARRAY = { "Black", "Blue", "Cyan", "Darkgray", "Gray", "Green", "Lightgray", "Magenta", "Orange", "Pink", "Red", "Yellow" };
    private String fontFamily = BANGLA_FONT_DEF.getFamily();
    private String fontSize = String.valueOf(STANDARD_FONT_SIZE);
    private int colorIndex = 0;

    // initialise the hashtable
    static {
        LOCALE_TO_FONT.put(BANGLA_LOCALE, BANGLA_FONT_DEF);
        LOCALE_TO_FONT.put(HINDI_LOCALE, HINDI_FONT_DEF);
        LOCALE_TO_FONT.put(ENGLISH_LOCALE, ENGLISH_FONT_DEF);

        // add Matras in Hindi: 0x93e to 0x94c: these are mapped to their
        // corresponding Swar Varnas: 0x906 to 0x914: an offset diffrence of
        // 0x38
        for (int i = 0x93e; i <= 0x94c; i++) {
            // Devnagari
            MATRAS.add(String.valueOf((char) i));
            SWAR_VARNAS.add(String.valueOf((char) (i - MATRA_OFFSET)));
            // Bangla
            MATRAS.add(String.valueOf((char) (i + BANGLA_OFFSET)));
            SWAR_VARNAS.add(String.valueOf((char) (i - MATRA_OFFSET + BANGLA_OFFSET)));
        }
    }

    public void setIndicMap(Map indicMap) {
        this.indicMap = indicMap;
    }

    public void setFontName(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public void setColorIndex(int colorIndex) {
        this.colorIndex = colorIndex;
    }

    public void setAllAttributes(String fontFamily, String fontSize, int colorIndex) {
        setFontName(fontFamily);
        setFontSize(fontSize);
        setColorIndex(colorIndex);
    }

    @Override
    public void setLocale(Locale locale) {
        currentLocale = locale;
    }

    private void replaceRomanChars(KeyEvent evt) {
        // double check for locale: return if EnglishLocale
        if (currentLocale.equals(ENGLISH_LOCALE)) {
            return;
        }

        String keyStr = Character.toString(evt.getKeyChar());
        /**
         * REGEX to check whether the input key char is valid and eligible for
         * Indic replacement: NOTE: the numbers 1-9 are already replaced in
         * keyTypeEvent
         */
        // include '.' and all Roman alphabets only
        final String REGEX_FOR_VALID_KEY = "[\\.a-zA-Z]";
        Pattern pattern = Pattern.compile(REGEX_FOR_VALID_KEY);
        if (pattern != null) {
            Matcher matcher = pattern.matcher(keyStr);
            if (matcher.matches()) {
                charStore.add(evt.getKeyChar());
                replaceWithIndics();
            } else {
                charStore.purge();
            }
        }
    }

    private void replaceWithIndics() {
        String matchingIndicStr = charStore.getMatchingIndic();
        if (matchingIndicStr == null) {
            logger.error("No matching Indic string found for the input Roman string");
            return;
        }

        int replaceIndex = -1;
        List<CharStore.CharacterWithPosition> characterHistory = charStore.characterHistory;
        logger.debug("characterHistory = " + characterHistory);
        String currentRomanStr = (characterHistory.get(0)).strRoman;
        // compare the previous string with the current one for every next
        // element
        // to prevent cases like k, k, kh: here the k at the last position is
        // taken, which is not correct
        String prevRomanStrTemp = null;
        if (currentRomanStr.length() > 1) {
            for (int i = 1; i < characterHistory.size(); i++) {
                String romanStr = (characterHistory.get(i)).strRoman;

                if (currentRomanStr.indexOf(romanStr) != -1 && !romanStr.equals(prevRomanStrTemp)) {
                    prevRomanStrTemp = romanStr;
                    replaceIndex = (characterHistory.get(i)).caretPos;
                }
            }
        }

        if (replaceIndex == -1) {
            replaceIndex = getCaretPosition() - currentRomanStr.length();
        }

        replace(matchingIndicStr, replaceIndex);
        logger.debug("Roman " + currentRomanStr + " replaced with Indic " + PropertyFileUtils.getHexCodeFromIndics(matchingIndicStr));
        // double check after replacement
        // display SwarVarna from matra for 1st char
        int cursorPos = getCaretPosition();

        if (matchingIndicStr.length() == 1 && MATRAS.contains(matchingIndicStr)) {
            boolean shouldReplaceMatraBySwar = false;
            if (cursorPos >= 2) {
                try {
                    String prevToMatra = getText(cursorPos - 2, 1);
                    if (prevToMatra.equals(" ") || prevToMatra.equals("\n") || MATRAS.contains(prevToMatra) || SWAR_VARNAS.contains(prevToMatra)) {
                        shouldReplaceMatraBySwar = true;
                    }
                } catch (BadLocationException e) {
                }
            } else {
                shouldReplaceMatraBySwar = true;
            }

            if (shouldReplaceMatraBySwar) {
                logger.debug("Replacing Matras: " + PropertyFileUtils.getHexCodeFromIndics(matchingIndicStr));
                matchingIndicStr = String.valueOf((char) (matchingIndicStr.charAt(0) - MATRA_OFFSET));
                replace(matchingIndicStr, replaceIndex);
                // update the characterHistory
                (characterHistory.get(0)).strIndic = matchingIndicStr;
            }

        }
    }

    private void replace(String str, int prevCaretPos) {
        select(prevCaretPos, getCaretPosition());
        replaceSelection("");
        initStyle(str);
    }

    /**
     *this method sets the txt pn with the desired font family, font size, etc.
     * 
     */
    public void initStyle(String text) {
        int cursorPos = getCaretPosition();
        SimpleAttributeSet a = getCurrentAttributeSet();
        try {
            getDocument().insertString(cursorPos, text, a);
        } catch (BadLocationException e) {
            logger.error("Cant insert string", e);
        } catch (Exception e) {
            logger.error("Cant insert string", e);
        }

        requestFocus();
    }

    /**
     *gets the current Attr set selected by the user
     */
    SimpleAttributeSet getCurrentAttributeSet() {
        SimpleAttributeSet a = new SimpleAttributeSet();
        // handle the condition when no fonts of the current locale are
        // available
        // if(fontFamily == null){
        // JOptionPane.showMessageDialog(this, "Suitable fonts not found",
        // "Could not find font to display characters from the current language. Please install appropriate fonts"
        // ,
        // JOptionPane.ERROR_MESSAGE);
        // return a;
        // }

        String currentFontFamily = fontFamily.toString();
        StyleConstants.setFontFamily(a, currentFontFamily);

        int currentFontSize = Integer.parseInt(fontSize.toString());
        StyleConstants.setFontSize(a, currentFontSize);

        Color currentColor = COLOR_ARRAY[colorIndex];
        StyleConstants.setForeground(a, currentColor);

        StyleConstants.setBold(a, isBold);

        StyleConstants.setItalic(a, isItalic);

        StyleConstants.setUnderline(a, isUnderline);

        return a;
    }

    /**
     *Sets the key-character of the KeyEvent to the corresponding mapped Indic
     * char
     */
    private void setEventKeyChar(KeyEvent ke) {
        String keyChar = String.valueOf(ke.getKeyChar());
        // take the first char only
        Object indicStr = indicMap == null ? null : indicMap.get(keyChar);
        if (indicStr == null) {
            return;
        }
        char indicChar = indicStr.toString().charAt(0);
        ke.setKeyChar(indicChar);
    }

    public void toggleItalicAction() {
        isItalic = !isItalic;
        requestFocus();
    }

    public void toggleBoldAction() {
        isBold = !isBold;
        requestFocus();
    }

    public void toggleUnderlineAction() {
        isUnderline = !isUnderline;
        requestFocus();
    }

    /**
     *an inner class with a stack-like structure: it has a maximum capacity
     * which, if exceeded, deletes char from the end.
     */
    private class CharStore {
        private CharStore(int maxLength) {
            this.maxLength = maxLength;
        }

        /** never use this directly */
        private final StringBuffer charBuffer = new StringBuffer(1);
        private final int maxLength;
        private final List<CharStore.CharacterWithPosition> characterHistory = new LimitedVector();

        private class LimitedVector extends Vector<CharacterWithPosition> {

            private static final long serialVersionUID = -3962068561552682343L;

            @Override
            public void add(int index, CharacterWithPosition obj) {
                super.add(0, obj);
                if (size() > maxLength) {
                    remove(size() - 1);
                }
            }

            @Override
            public boolean add(CharacterWithPosition obj) {
                add(0, obj);
                return true;
            }

            @Override
            public boolean addAll(Collection<? extends CharacterWithPosition> c) {
                throw new UnsupportedOperationException("not supported");
            }

            @Override
            public boolean addAll(int index, Collection<? extends CharacterWithPosition> c) {
                throw new UnsupportedOperationException("not supported");
            }

            @Override
            public void addElement(CharacterWithPosition obj) {
                throw new UnsupportedOperationException("not supported");
            }

        }

        /** Inner class to store characters and their caret position */
        private class CharacterWithPosition {

            private String strRoman = null;
            private String strIndic = null;
            private int caretPos = -1;

            private CharacterWithPosition(String strRoman, String strIndic, int caretPos) {
                this.strRoman = strRoman;
                this.strIndic = strIndic;
                this.caretPos = caretPos;
            }

            @Override
            public String toString() {
                return "{strRoman=" + strRoman + ", strIndic=" + PropertyFileUtils.getHexCodeFromIndics(strIndic) + ", caretPos=" + caretPos + "}";
            }

        }

        /**
         * adds char to array call just before the RomanChar from key input is
         * to be replaced by IndicChar
         */
        public void add(char c) {
            charBuffer.append(c);
            if (charBuffer.length() > maxLength)
                charBuffer.deleteCharAt(0);
        }

        public String getMatchingIndic() {
            char[] romans = charBuffer.toString().toCharArray();
            String[] theMapStrings = new String[maxLength];
            for (int i = 0; i < romans.length; i++) {
                theMapStrings[i] = "";
                for (int j = i; j < romans.length; j++) {
                    theMapStrings[i] += romans[j];
                }

                logger.debug("theMapStrings[" + i + "] = " + theMapStrings[i]);
                // try to find a match
                Object indicMatch = indicMap.get(theMapStrings[i]);
                if (indicMatch != null) {
                    characterHistory.add(new CharacterWithPosition(theMapStrings[i], indicMatch.toString(), getCaretPosition() - 1));

                    return indicMatch.toString();
                }
            }

            return null;

        }

        /**
         *always use this to retrieve the contents as a char array this returns
         * the keys in order in which they were entered thus, the most recent
         * key is at the end
         */
        public char[] getPrevKeysAsArray() {
            return getPrevKeysAsString().toCharArray();
        }

        public String getPrevKeysAsString() {
            return charBuffer.toString();
        }

        /** resets the chars to zero */
        public void purge() {
            charBuffer.setLength(0);
            characterHistory.clear();
        }

    }

}

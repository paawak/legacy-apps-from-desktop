package com.itextpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Inspired from http://itextpdf.com/examples/iia.php?id=158
 * 
 * @author paawak
 */
public class BanglaPdfGenerationTestForIText {

    /**
     * The unicode of this is given below:
     * 
     * u0986u09aeu09bf u0995u09cbu09a8 u09aau09a5u09c7
     * u0995u09cdu09b7u09c0u09b0u09c7u09b0 u09b7u09a8u09cdu09a1
     * u09aau09c1u09a4u09c1u09b2 u09b0u09c1u09aau09cb u0997u0999u09cdu0997u09be
     * u098bu09b7u09bf
     * 
     */
    private static final String BANGLA_TEXT = "আমি কোন পথে ক্ষীরের লক্ষ্মী ষন্ড পুতুল রুপো গঙ্গা ঋষি";

    public void createPdf(String filename) throws DocumentException, IOException, URISyntaxException {
	// step 1
	Document document = new Document();
	// step 2
	PdfWriter.getInstance(document, new FileOutputStream(filename));
	// step 3
	document.open();
	// step 4
	Paragraph paragraph = new Paragraph();
	paragraph.add(
		new Phrase(BANGLA_TEXT, new Font(BaseFont.createFont(BanglaPdfGenerationTestForIText.class.getResource("/fonts/ttf/Lohit-Bengali.ttf").toURI().getPath(), BaseFont.IDENTITY_H, true))));
	document.add(paragraph);
	// step 5
	document.close();
    }

    @Test
    public void testGenerate() throws IOException, DocumentException, URISyntaxException {
	String fileName = System.getProperty("user.home") + "/a.pdf";
	new BanglaPdfGenerationTestForIText().createPdf(fileName);
    }

}

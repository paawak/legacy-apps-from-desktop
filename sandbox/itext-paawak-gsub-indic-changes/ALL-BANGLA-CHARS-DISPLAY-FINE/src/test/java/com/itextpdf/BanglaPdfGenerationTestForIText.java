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
     * \u0986\u09ae\u09bf \u0995\u09cb\u09a8 \u09aa\u09a5\u09c7 \u0995\u09cd\u09b7\u09c0\u09b0\u09c7\u09b0
     * \u09b7\u09a8\u09cd\u09a1 \u09aa\u09c1\u09a4\u09c1\u09b2 \u09b0\u09c1\u09aa\u09cb \u0997\u0999\u09cd\u0997\u09be
     * \u098b\u09b7\u09bf
     * 
     */
    private static final String BANGLA_TEXT = "ব্যাস ব্যাশ আমি কোন পথে ক্ষীরের লক্ষ্মী ষন্ড পুতুল রুপো গঙ্গা ঋষি ভাগাড়ে ফেলে দেওয়া পশুর ছাল ছাড়িয়ে, পিস পিস করা মাংস চলে যাচ্ছে গাড়িতে চেপে। কলকাতার দিকে। ধরে ফেলার পর চমকে উঠেছিলেন বজবজের সুভাষ উদ্যান এলাকার লোকজন। এ-ও সম্ভব! তার পর জানা গেল, সেই মাংস খাস কলকাতার বাজারেই টাটকা কাটা মাংসের মধ্যে মিশে যায় ‘নিঃশব্দে’। দেখে-শুনে শিউরে উঠছে সবাই!";

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

package com.itextpdf.text.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.parser.*;
import com.itextpdf.text.xml.XMLUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaggedPDFTest {
    private Document document;
    private PdfWriter writer;
    private Paragraph h1;

    private static final String text = new String("Lorem ipsum dolor sit amet," +
            "consectetur adipiscing elit." +
            "Pellentesque a lectus sit amet lectus accumsan aliquam." +
            "Quisque facilisis ullamcorper dolor, quis gravida leo faucibus in. Donec a dolor ligula, quis placerat nunc. Etiam enim velit, egestas in lacinia at, ultricies eu massa." +
            "Cras ornare felis id quam vehicula lobortis. Ut semper malesuada nulla, in vulputate dui eleifend at. Phasellus pulvinar nisl a lorem volutpat pellentesque. In vitae" +
            "ligula et quam vestibulum iaculis eget vitae massa. Fusce vitae leo ut diam suscipit dictum in id sapien. Praesent mi ligula, auctor vitae ultrices in, venenatis non" +
            "odio. Nullam sit amet velit pellentesque lectus consectetur lacinia nec quis mi. In hac habitasse platea dictumst." +
            "Quisque facilisis ullamcorper dolor, quis gravida leo faucibus in." +
            "Donec a dolor ligula, quis placerat nunc.\n" +
            "1. Etiam enim velit, egestas in lacinia at, ultricies eu massa. Cras ornare felis id quam vehicula lobortis. Ut semper malesuada nulla, in vulputate dui eleifend at." +
            "Phasellus pulvinar nisl a lorem volutpat pellentesque. In vitae ligula et quam vestibulum iaculis eget vitae massa. Fusce vitae leo ut diam suscipit dictum in id" +
            "sapien. Praesent mi ligula, auctor vitae ultrices in, venenatis non odio. Nullam sit amet velit pellentesque lectus consectetur lacinia nec quis mi. In hac" +
            "habitasse platea dictumst.\n" +
            "2. Morbi euismod, nunc quis malesuada feugiat, dui nibh rhoncus leo, quis cursus erat tellus vel tortor. Mauris nibh dolor, iaculis et pharetra pretium," +
            "pellentesque vitae erat. Aenean enim nisi, euismod quis ultricies vel, convallis nec nulla. Suspendisse nisl purus, molestie et egestas ac, cursus in mauris." +
            "Aliquam erat volutpat. Donec at nulla in elit faucibus mollis ac vel enim. Nullam dapibus dui sit amet sem consectetur ac vulputate est sagittis. Aliquam luctus" +
            "ornare nulla. Mauris adipiscing congue pharetra. Proin tempus, nibh sed pretium tempor, arcu est hendrerit est, et dignissim odio leo non purus." +
            "Suspendisse non elit massa. Vestibulum tincidunt ipsum vitae dui congue sagittis. Aenean porttitor tristique euismod. Nulla id justo in quam imperdiet" +
            "facilisis ut non turpis. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
            "3. Aliquam non elit ligula, nec hendrerit urna. Mauris ut velit sapien. Sed in convallis diam. Nulla faucibus, purus a porttitor ultrices, est quam convallis magna," +
            "molestie aliquam sapien nulla eget metus. Integer nec enim mi, eu mattis massa. Integer quis sapien vel purus pretium ullamcorper ac id dui. Suspendisse" +
            "pellentesque tellus sit amet neque pulvinar egestas lacinia diam imperdiet.\n" +
            "4. Curabitur hendrerit, sem et facilisis vestibulum, massa felis vestibulum ligula, ut faucibus massa nisi in neque. Nulla facilisi. Etiam diam mauris, pellentesque" +
            "lacinia dapibus at, lobortis non quam. Nullam et neque quis diam vestibulum scelerisque ullamcorper non mauris. Cras massa enim, commodo malesuada" +
            "tincidunt ac, lobortis eu erat. Sed sed risus velit. Suspendisse tellus tortor, ullamcorper nec tristique ac, semper non nulla. Maecenas vitae diam orci, sed" +
            "fermentum enim. Curabitur a libero nisl, vel laoreet nulla. Integer id volutpat sem. Pellentesque blandit, tellus at consequat dictum, urna sem elementum nisi," +
            "a bibendum nisi ipsum sit amet felis. Donec mattis ipsum nec metus lobortis eget volutpat nisl volutpat.\n" +
            "5. Fusce in aliquet nibh. Etiam quis varius ipsum. Vivamus sit amet mauris a libero iaculis semper in a neque. Nam faucibus congue posuere. Cras vitae nibh" +
            "sed magna ultricies pretium. Proin eget lacus quis dui ullamcorper cursus commodo in lacus. Quisque et sem id leo venenatis dictum dignissim et felis." +
            "Vestibulum enim urna, vehicula vel dictum in, congue quis sapien. Quisque ac mauris tellus. Nulla cursus pellentesque mauris viverra bibendum. Fusce" +
            "molestie dui id sem blandit in convallis justo euismod. Curabitur velit nisi, adipiscing sed consequat et, dignissim eget dolor. Aenean malesuada quam id mi" +
            "vestibulum pulvinar. Nullam diam quam, lobortis sit amet semper vitae, tempus eget dolor.");

    private void initializeDocument(String path) throws DocumentException, FileNotFoundException {
        new File("./target/com/itextpdf/test/pdf/TaggedPDFTest/").mkdirs();
        Document.compress = false;
        document = new Document();
        writer = PdfWriter.getInstance(document, new FileOutputStream(path));
        writer.setTagged();
        document.open();

        //Required for PDF/UA
        writer.setViewerPreferences(PdfWriter.DisplayDocTitle);
        writer.createXmpMetadata();
        document.addLanguage("en-US");
        document.addTitle("Some title");
        Chunk c = new Chunk("Document Header", new Font(Font.FontFamily.HELVETICA,14,Font.BOLD,BaseColor.BLUE));
        c.setRole(null);
        h1 = new Paragraph(c);
        h1.setRole(PdfName.H1);

    }

    @Test
    public void createTaggedPDF0() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out0.pdf");
        Paragraph paragraph = new Paragraph();
        Chunk c = new Chunk(" Hello ");
        paragraph.add(c);
        c = new Chunk("  world\n\n");
        paragraph.add(c);
        ColumnText columnText = new ColumnText(writer.getDirectContent());
        columnText.setSimpleColumn(36, 36, 250, 800);
        columnText.addElement(paragraph);
        columnText.go();
        document.close();

        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out0.pdf");
        paragraph = new Paragraph();
        c = new Chunk("  ");
        paragraph.add(c);
        columnText = new ColumnText(writer.getDirectContent());
        columnText.setSimpleColumn(36, 36, 250, 800);
        columnText.addElement(paragraph);
        columnText.go();
        document.close();

        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out0.pdf");
        paragraph = new Paragraph();
        c = new Chunk("Hello World");
        paragraph.add(c);
        columnText = new ColumnText(writer.getDirectContent());
        columnText.setSimpleColumn(36, 36, 250, 800);
        columnText.addElement(paragraph);
        columnText.go();
        document.close();

        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out0.pdf");
        paragraph = new Paragraph();
        c = new Chunk("Hello World");
        paragraph.add(c);
        document.add(paragraph);
        document.close();

        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out0.pdf");
        paragraph = new Paragraph();
        c = new Chunk(" Hello ");
        paragraph.add(c);
        c = new Chunk("  world\n");
        paragraph.add(c);
        paragraph.setFont(new Font(Font.FontFamily.HELVETICA,8,Font.NORMAL,BaseColor.RED));
        document.add(paragraph);
        document.close();

    }


    @Test
    public void createTaggedPDF1() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out1.pdf");
        Paragraph paragraph = new Paragraph(text);
        paragraph.setFont(new Font(Font.FontFamily.HELVETICA,8,Font.NORMAL,BaseColor.RED));
        ColumnText columnText = new ColumnText(writer.getDirectContent());
        columnText.setSimpleColumn(36, 36, 250, 800);
        columnText.addElement(h1);
        columnText.addElement(paragraph);
        columnText.go();
        columnText.setSimpleColumn(300, 36, 500, 800);
        columnText.go();
        document.close();

        compareResults("1");
    }

    @Test
    public void createTaggedPDF2() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out2.pdf");
        Paragraph paragraph = new Paragraph(text);
        ColumnText columnText = new ColumnText(writer.getDirectContent());

        columnText.setSimpleColumn(36,36,400,800);
        columnText.addElement(h1);
        columnText.addElement(paragraph);
        columnText.go();
        document.newPage();
        columnText.setSimpleColumn(36,36,400,800);
        columnText.go();
        document.close();

        compareResults("2");
    }

    @Test
    public void createTaggedPDF3() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out3.pdf");
        Paragraph paragraph = new Paragraph(text);
        document.add(h1);
        document.add(paragraph);
        document.close();

        compareResults("3");
    }

    @Test
    public void createTaggedPDF4() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out4.pdf");
        Paragraph p = new Paragraph();
        PdfName nParagraph = new PdfName("Paragraph");
        p.setRole(nParagraph);
        writer.getStructureTreeRoot().mapRole(nParagraph, PdfName.P);

        try {
            Chunk c = new Chunk("Quick brown ");
            PdfName nTextBlock = new PdfName("TextBlock");
            c.setRole(nTextBlock);
            writer.getStructureTreeRoot().mapRole(nTextBlock, PdfName.SPAN);
            p.add(c);
            Image i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/fox.bmp");
            c = new Chunk(i, 0, 0);
            PdfName nImage = new PdfName("Image");
            c.setRole(nImage);
            writer.getStructureTreeRoot().mapRole(nImage, PdfName.FIGURE);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Fox image"));
            p.add(c);
            p.add(new Chunk(" jumped over a lazy "));
            i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/dog.bmp");
            c = new Chunk(i, 0, 0);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Dog image"));
            p.add(c);

        } catch (Exception e) {

        }
        document.add(h1);
        document.add(p);
        document.close();

        compareResults("4");
    }

    @Test
    public void createTaggedPDF5() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out5.pdf");
        List list = new List(true);
        try {
            list = new List(true);
            ListItem listItem = new ListItem(new Chunk("Quick brown fox jumped over a lazy dog. A very long line appears here because we need new line."));
            list.add(listItem);
            Image i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/fox.bmp");
            Chunk c = new Chunk(i, 0, 0);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Fox image"));
            listItem = new ListItem(c);
            list.add(listItem);
            listItem = new ListItem(new Chunk("jumped over a lazy"));
            listItem.getListLabel().setTagLabelContent(false);
            list.add(listItem);
            i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/dog.bmp");
            c = new Chunk(i, 0, 0);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Dog image"));
            listItem = new ListItem(c);
            listItem.getListLabel().setTagLabelContent(false);
            list.add(listItem);
        } catch (Exception e) {

        }
        document.add(h1);
        document.add(list);
        document.close();


        compareResults("5");
    }

    @Test
    public void createTaggedPDF6() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out6.pdf");

        ColumnText columnText = new ColumnText(writer.getDirectContent());

        List list = new List(true);
        try {
            list = new List(true);
            ListItem listItem = new ListItem(new Chunk("Quick brown fox jumped over a lazy dog. A very long line appears here because we need new line."));
            list.add(listItem);
            Image i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/fox.bmp");
            Chunk c = new Chunk(i, 0, 0);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Fox image"));
            listItem = new ListItem(c);
            list.add(listItem);
            listItem = new ListItem(new Chunk("jumped over a lazy"));
            list.add(listItem);
            i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/dog.bmp");
            c = new Chunk(i, 0, 0);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Dog image"));
            listItem = new ListItem(c);
            list.add(listItem);
        } catch (Exception e) {

        }
        columnText.setSimpleColumn(36,36,400,800);
        columnText.addElement(h1);
        columnText.addElement(list);
        columnText.go();
        document.close();

        compareResults("6");
    }

    @Test
    public void createTaggedPDF7() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out7.pdf");
        List list = new List(true);
        try {
            list = new List(true);
            ListItem listItem = new ListItem(new Chunk("Quick brown fox jumped over a lazy dog. A very long line appears here because we need new line."));
            list.add(listItem);
            Image i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/fox.bmp");
            Chunk c = new Chunk(i, 0, 0);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Fox image"));
            listItem = new ListItem(c);
            list.add(listItem);
            listItem = new ListItem(new Chunk("jumped over a lazy"));
            list.add(listItem);
            i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/dog.bmp");
            c = new Chunk(i, 0, 0);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Dog image"));
            listItem = new ListItem(c);
            list.add(listItem);
            Paragraph p = new Paragraph(text);
            listItem = new ListItem(new Paragraph(text));
            list.add(listItem);
        } catch (Exception e) {

        }
        document.add(h1);
        document.add(list);
        document.close();


        compareResults("7");
    }

    @Test
    public void createTaggedPDF8() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out8.pdf");

        ColumnText columnText = new ColumnText(writer.getDirectContent());

        List list = new List(true);
        try {
            list = new List(true);
            ListItem listItem = new ListItem(new Chunk("Quick brown fox jumped over a lazy dog. A very long line appears here because we need new line."));
            list.add(listItem);
            Image i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/fox.bmp");
            Chunk c = new Chunk(i, 0, 0);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Fox image"));
            listItem = new ListItem(c);
            list.add(listItem);
            listItem = new ListItem(new Chunk("jumped over a lazy"));
            list.add(listItem);
            i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/dog.bmp");
            c = new Chunk(i, 0, 0);
            c.setAccessibleAttribute(PdfName.ALT, new PdfString("Dog image"));
            listItem = new ListItem(c);
            list.add(listItem);
            Paragraph p = new Paragraph(text);
            listItem = new ListItem(new Paragraph(text));
            list.add(listItem);
        } catch (Exception e) {

        }
        columnText.setSimpleColumn(36,36,400,800);
        columnText.addElement(h1);
        columnText.addElement(list);
        columnText.go();
        document.newPage();
        columnText.setSimpleColumn(36,36,400,800);
        columnText.go();
        document.close();


        compareResults("8");
    }

    @Test
    public void createTaggedPDF9() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out9.pdf");
        PdfPTable table = new PdfPTable(2);
        try {
            table.addCell("Quick brown fox jumped over a lazy dog. A very long line appears here because we need new line.");
            Image i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/fox.bmp");
            i.setAccessibleAttribute(PdfName.ALT, new PdfString("Fox image"));
            table.addCell(i);
            table.addCell("jumped over a lazy");
            i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/dog.bmp");
            i.setAccessibleAttribute(PdfName.ALT, new PdfString("Dog image"));
            table.addCell(i);
            table.addCell("Hello World");
            Paragraph p = new Paragraph(text);
            table.addCell(p);
        } catch (Exception e) {

        }
        document.add(h1);
        document.add(table);
        document.add(new Paragraph("Extra paragraph at the end of the document. Please make sure that this is really last portion of page content."));
        document.close();

        compareResults("9");
    }

    @Test
    public void createTaggedPDF10() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out10.pdf");
        PdfPTable table = new PdfPTable(2);
        try {
            table.addCell("Quick brown fox jumped over a lazy dog. A very long line appears here because we need new line.");
            Image i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/fox.bmp");
            i.setAccessibleAttribute(PdfName.ALT, new PdfString("Fox image"));
            table.addCell(i);
            table.addCell("jumped over a lazy");
            i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/dog.bmp");
            i.setAccessibleAttribute(PdfName.ALT, new PdfString("Dog image"));
            table.addCell(i);

            PdfPTable t = new PdfPTable(2);
            t.addCell("Quick brown fox jumped over a lazy dog. A very long line appears here because we need new line.");
            i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/fox.bmp");
            i.setAccessibleAttribute(PdfName.ALT, new PdfString("Fox image"));
            t.addCell(i);
            t.addCell("jumped over a lazy");
            i = Image.getInstance("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/dog.bmp");
            i.setAccessibleAttribute(PdfName.ALT, new PdfString("Dog image"));
            t.addCell(i);
            t.addCell(text);
            t.addCell("Hello World");
            table.addCell(t);


            Paragraph p = new Paragraph(text);
            table.addCell(p);
        } catch (Exception e) {

        }
        document.add(h1);
        document.add(table);
        document.close();


        compareResults("10");
    }

    @Test
    public void createTaggedPDF11() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out11.pdf");

        Chapter c = new Chapter(new Paragraph("First chapter", new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE)), 1);
        c.setTriggerNewPage(false);
        c.setIndentation(40);
        Section s1 = c.addSection(new Paragraph("First section of a first chapter", new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE)));
        s1.setIndentation(20);
        Section s2 = s1.addSection(new Paragraph("First subsection of a first section of a first chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Second subsection of a first section of a first chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Third subsection of a first section of a first chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s1 = c.addSection(new Paragraph("Second section of a first chapter", new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE)));
        s1.setIndentation(20);
        s2 = s1.addSection(new Paragraph("First subsection of a second section of a first chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Second subsection of a second section of a first chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Third subsection of a second section of a first chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s1 = c.addSection(new Paragraph("Third section of a first chapter", new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE)));
        s1.setIndentation(20);
        s2 = s1.addSection(new Paragraph("First subsection of a third section of a first chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Second subsection of a third section of a first chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Third subsection of a third section of a first chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        document.add(c);

        c = new Chapter(new Paragraph("Second chapter", new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE)), 2);
        c.setTriggerNewPage(false);
        c.setIndentation(40);
        s1 = c.addSection(new Paragraph("First section of a second chapter", new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE)));
        s1.setIndentation(20);
        s2 = s1.addSection(new Paragraph("First subsection of a first section of a second chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Second subsection of a first section of a second chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Third subsection of a first section of a second chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s1 = c.addSection(new Paragraph("Second section of a second chapter", new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE)));
        s1.setIndentation(20);
        s2 = s1.addSection(new Paragraph("First subsection of a second section of a second chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Second subsection of a second section of a second chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Third subsection of a second section of a second chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s1 = c.addSection(new Paragraph("Third section of a second chapter", new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE)));
        s1.setIndentation(20);
        s2 = s1.addSection(new Paragraph("First subsection of a third section of a second chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Second subsection of a third section of a second chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Third subsection of a third section of a second chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        document.add(c);

        c = new Chapter(new Paragraph("Third chapter", new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE)), 3);
        c.setTriggerNewPage(false);
        c.setIndentation(40);
        s1 = c.addSection(new Paragraph("First section of a third chapter", new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE)));
        s1.setIndentation(20);
        s2 = s1.addSection(new Paragraph("First subsection of a first section of a third chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Second subsection of a first section of a third chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Third subsection of a first section of a third chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s1 = c.addSection(new Paragraph("Second section of a third chapter", new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE)));
        s1.setIndentation(20);
        s2 = s1.addSection(new Paragraph("First subsection of a second section of a third chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Second subsection of a second section of a third chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Third subsection of a second section of a third chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s1 = c.addSection(new Paragraph("Third section of a third chapter", new Font(Font.FontFamily.HELVETICA,13,Font.BOLD,BaseColor.BLUE)));
        s1.setIndentation(20);
        s2 = s1.addSection(new Paragraph("First subsection of a third section of a third chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Second subsection of a third section of a third chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        s2 = s1.addSection(new Paragraph("Third subsection of a third section of a third chapter", new Font(Font.FontFamily.HELVETICA,10,Font.BOLD,BaseColor.BLUE)));
        s2.setIndentation(10);
        s2.add(new Paragraph("Some text..."));
        document.add(c);

        document.close();


        compareResults("11");
    }

    @Test
    public void createTaggedPDF12() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out12.pdf");

        PdfPTable table = new PdfPTable(2);
        PdfPCell cell = new PdfPCell(new Paragraph("header 1"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("header 2"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("footer 1"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("footer 2"));
        cell.setColspan(2);
        table.addCell(cell);
        table.setHeaderRows(4);
        table.setFooterRows(2);
        try {
            for (int i = 1; i <= 50; i++) {
                table.addCell("row " + i + ", coumn 1");
                table.addCell("row " + i + ", coumn 2");
            }
        } catch (Exception e) {

        }
        document.add(table);
        document.close();


        compareResults("12");
    }

    @Test
    public void createTaggedPDF13() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out13.pdf");

        Paragraph p = new Paragraph();
        Chunk chunk = new Chunk("Please visit ");
        p.add(chunk);

        PdfAction action = new PdfAction("http://itextpdf.com");
        chunk = new Chunk("http://itextpdf.com", new Font(Font.FontFamily.HELVETICA,Font.UNDEFINED,Font.UNDERLINE,BaseColor.BLUE));
        chunk.setAction(action);
        p.add(chunk);
        p.add(new Chunk(" for more details."));
        document.add(p);
        document.close();

        compareResults("13");
    }

    @Test
    public void createTaggedPDF14() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out14.pdf");
        Paragraph paragraph = new Paragraph("Document MUST contain 1 page only!");
        document.newPage();
        ColumnText columnText = new ColumnText(writer.getDirectContent());
        columnText.setSimpleColumn(36, 36, 250, 800);
        columnText.addElement(paragraph);
        columnText.go();
        document.close();

        PdfReader reader = new PdfReader("./target/com/itextpdf/test/pdf/TaggedPDFTest/out14.pdf");
        Assert.assertEquals(1, reader.getNumberOfPages());
    }

    @Test
    public void createTaggedPDF15() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out15.pdf");

        Paragraph p = new Paragraph();
        Chunk chunk = new Chunk("Hello tagged world!");
        chunk.setBackground(new BaseColor(255,0,255));
        chunk.setFont(FontFactory.getFont("TimesNewRoman", 20, BaseColor.ORANGE));
        chunk.setUnderline(BaseColor.PINK, 1.2f, 1, 1, 1, 0);
        p.add(chunk);

        document.add(p);
        document.close();
        compareResults("15");
    }

    @Test
    public void createTaggedPDF16() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out16.pdf");

        Paragraph p = new Paragraph();
        Chunk chunk = new Chunk("Hello tagged world!");
        chunk.setBackground(new BaseColor(255,0,255));
        chunk.setFont(FontFactory.getFont("TimesNewRoman", 20, BaseColor.ORANGE));
        chunk.setUnderline(BaseColor.PINK, 1.2f, 1, 1, 1, 0);
        p.add(chunk);
        PdfDiv div = new PdfDiv();
        div.addElement(p);
        document.add(div);

        document.add(new Paragraph("This paragraph appears between 2 div blocks"));

        div = new PdfDiv();
        div.addElement(new Paragraph(text));
        document.add(div);


        document.close();
        compareResults("16");
    }

    @Test
    public void createTaggedPDF17() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out17.pdf");

        PdfPTable table = new PdfPTable(2);
        PdfPCell cell = new PdfPCell(new Paragraph("h1"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("h2"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("footer 1"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("footer 2"));
        cell.setColspan(2);
        table.addCell(cell);
        table.setHeaderRows(4);
        table.setFooterRows(2);

        try {
            PdfPHeaderCell headerCell = null, headerCell2 = null;
            cell = null;
            for (int i = 1; i <= 2; i++) {
                if (i == 1){
                    headerCell = new PdfPHeaderCell();
                    headerCell.setScope(PdfPHeaderCell.ROW);
                    headerCell.setPhrase(new Phrase("header1"));
                    headerCell.setName("header1");
                    table.addCell(headerCell);

                    headerCell2 = new PdfPHeaderCell();
                    headerCell2.setScope(PdfPHeaderCell.ROW);
                    headerCell2.setPhrase(new Phrase("header2"));
                    headerCell2.setName("header2");
                    table.addCell(headerCell2);
                }
                else
                {
                    cell = new PdfPCell(new Phrase("row " + i + ", coumn 1"));
                    cell.addHeader(headerCell);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase("row " + i + ", coumn 2"));
                    cell.addHeader(headerCell2);
                    cell.addHeader(headerCell2);

                    table.addCell(cell);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        document.add(table);
        document.close();
        compareResults("17");
    }

    @Test
    public void createTaggedPDF18() throws DocumentException, IOException, ParserConfigurationException, SAXException {
        initializeDocument("./target/com/itextpdf/test/pdf/TaggedPDFTest/out18.pdf");

        PdfDiv div = new PdfDiv();

        Paragraph paragraph = new Paragraph(text);
        paragraph.setFont(new Font(Font.FontFamily.HELVETICA,8,Font.NORMAL,BaseColor.RED));

        div.setBackgroundColor(BaseColor.MAGENTA);
        div.setTextAlignment(Element.ALIGN_CENTER);
        div.addElement(paragraph);
        document.add(div);
        document.close();
        compareResults("18");
    }

    private boolean compareXmls(String xml1, String xml2) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setCoalescing(true);
        dbf.setIgnoringElementContentWhitespace(true);
        dbf.setIgnoringComments(true);
        DocumentBuilder db = dbf.newDocumentBuilder();

        org.w3c.dom.Document doc1 = db.parse(new File(xml1));
        doc1.normalizeDocument();

        org.w3c.dom.Document doc2 = db.parse(new File(xml2));
        doc2.normalizeDocument();

        return doc2.isEqualNode(doc1);
    }

    static class MyTaggedPdfReaderTool extends TaggedPdfReaderTool {

        @Override
        public void parseTag(String tag, PdfObject object, PdfDictionary page)
                throws IOException {
            if (object instanceof PdfNumber) {
                PdfNumber mcid = (PdfNumber) object;
                RenderFilter filter = new MyMarkedContentRenderFilter(mcid.intValue());
                TextExtractionStrategy strategy = new SimpleTextExtractionStrategy();
                FilteredTextRenderListener listener = new FilteredTextRenderListener(
                        strategy, filter);
                PdfContentStreamProcessor processor = new PdfContentStreamProcessor(
                        listener);
                processor.processContent(PdfReader.getPageContent(page), page
                        .getAsDict(PdfName.RESOURCES));
                out.print(XMLUtil.escapeXML(listener.getResultantText(), true));
            } else {
                super.parseTag(tag, object, page);
            }
        }

        @Override
        public void inspectChildDictionary(PdfDictionary k) throws IOException {
            inspectChildDictionary(k, true);
        }


    }

    static class MyMarkedContentRenderFilter extends MarkedContentRenderFilter {

        int mcid;

        public MyMarkedContentRenderFilter(int mcid) {
            super(mcid);
            this.mcid = mcid;
        }

        @Override
        public boolean allowText(TextRenderInfo renderInfo){
            return renderInfo.hasMcid(mcid, true);
        }

    }

    @After
    public void finalize() {
    	Document.compress = true;
    }

    private void compareResults(String name) throws IOException, ParserConfigurationException, SAXException {
        PdfReader reader = new PdfReader("./target/com/itextpdf/test/pdf/TaggedPDFTest/out"+ name +".pdf");
        FileOutputStream xmlOut = new FileOutputStream("./target/com/itextpdf/test/pdf/TaggedPDFTest/test"+ name +".xml");
        new MyTaggedPdfReaderTool().convertToXml(reader, xmlOut);
        xmlOut.close();
        Assert.assertTrue(compareXmls("./src/test/resources/com/itextpdf/text/pdf/TaggedPdfTest/test"+ name +".xml", "./target/com/itextpdf/test/pdf/TaggedPDFTest/test"+ name +".xml"));
    }

}

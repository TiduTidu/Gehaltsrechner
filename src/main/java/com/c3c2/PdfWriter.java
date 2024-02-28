package com.c3c2;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;


import java.io.IOException;

public class PdfWriter {
    public static void write(float lohn, float[] content, float abzuege, float versicherungsAbzuege, float netto) {
        System.setProperty("org.apache.commons.logging.Log",
        "org.apache.commons.logging.impl.NoOpLog");
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDFont pdfFont = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
            
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(pdfFont, 16);
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Sozialversicherungsbeiträge");
            contentStream.newLineAtOffset(15, -20);
            contentStream.setFont(pdfFont, 12);
            contentStream.showText("Krankenversicherung: " + Utils.currFormat(content[0]));
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Rentenversicherung: " + Utils.currFormat(content[1]));
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Pflegeversicherung: " + Utils.currFormat(content[2]));
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Arbeitslosenversicherung: " +  Utils.currFormat(content[3]));
            contentStream.newLineAtOffset(-15, -20);
            contentStream.setFont(pdfFont, 16);
            contentStream.showText("Lohnsteuer");
            contentStream.newLineAtOffset(15, -20);
            contentStream.setFont(pdfFont, 12);
            contentStream.showText("Ihre Lohnsteuer beträgt: " + Utils.currFormat(abzuege));
            contentStream.newLineAtOffset(-15, -20);
            contentStream.setFont(pdfFont, 16);
            contentStream.showText("Auswertung");
            contentStream.setFont(pdfFont, 12);
            contentStream.newLineAtOffset(15, -20);
            contentStream.showText("Ihre Sozialversicherungsbeiträge betragen insgesamt: " + Utils.currFormat(versicherungsAbzuege));
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Ihr Nettolohn beträgt: " + Utils.currFormat(netto));
            contentStream.newLineAtOffset(0, -15);

            contentStream.endText();

            contentStream.close();

            document.save("output.pdf");
            document.close();
        } catch (IOException e) {

        }
    }
}
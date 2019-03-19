package API;

//import org.apache.pdfbox.*;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;
//import org.apache.pdfbox.rendering.ImageType;
//import org.apache.pdfbox.rendering.PDFRenderer;

//import java.awt.*;
//import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.List;

public class main {
public main(){


    /**
     *Erstellt ein API.UserInteraction Objekt.
     *Das API.UserInteraction Objekt erstellt ein API.APIOutput Objekt, das es zusammen mit alles Parametern an API.Connection weiterreicht.
     *API.Connection ruft API.Translator auf.
     *API.Translator uebersetzt die Antwort der externen API und fuellt API.APIOutput ueber die setter Methoden.
     *API.UserInteraction kennt die ganze Zeit das API.APIOutput Objekt, darum kann die Klasse das auch zurueck geben.
     */
    }
    public static void main(String[] args)throws Exception{



        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
        String pdfFilename = "C:\\Users\\user\\test.pdf";

        PDFStreamParser parser = new PDFStreamParser();
        parser.parse();
        List<Object> tokens = parser.getTokens();

        System.out.println(tokens);

        /*
        String pdfFilename = "C:\\Users\\user\\test.pdf";
        PDDocument document = PDDocument.load(new File(pdfFilename));
        PDFPrintable pdfRenderer = new PDFPrintable(document);
        int pageCounter = 0;


        //pdfRenderer.print(null, null, 0);




        //PDImageXObject.createFromFile(document);


        document.close();



        //PrinterJob job = PrinterJob.getPrinterJob();
        //job.setPageable(new PDFPageable(document));
        //job.print();
        /*
        for (PDPage page : document.getPages())
        {
            // note that the page number parameter is zero based
            BufferedImage bim = pdfRenderer.renderImageWithDPI(pageCounter, 300, ImageType.RGB);

            // suffix in filename will be used as the file format
            ImageIOUtil.writeImage(bim, pdfFilename + "-" + (pageCounter++) + ".png", 300);
        }

        document.close();
        */

    }


}

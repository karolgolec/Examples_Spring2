package pl.karolgolec.examples.scheduled.reports.generators;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.karolgolec.examples.scheduled.reports.configurations.IPdfPathConfiguration;
import pl.karolgolec.examples.scheduled.reports.models.Report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * The type Pdf report generator.
 */
@Service(value = "PdfReportGenerator")
public class PdfReportGenerator {

    /**
     * The Pdf path configuration.
     */
    @Autowired
    @Qualifier("PdfPathConfiguration")
    protected IPdfPathConfiguration pdfPathConfiguration;

    /**
     * Create.
     *
     * @param report the report
     * @throws FileNotFoundException the file not found exception
     * @throws DocumentException     the document exception
     * @throws InterruptedException  the interrupted exception
     */
    public void create(Report report) throws FileNotFoundException, DocumentException, InterruptedException {
        mkDirs();
        Document document = new Document( PageSize.A4, 20, 20, 20, 20 );
        PdfWriter.getInstance(document, new FileOutputStream(new File(pdfPathConfiguration.getPath().toFile(), report.getUuid() + ".pdf")));
        document.open();
        Font font16 = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Font font14 = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        document.add(new Paragraph("Report for the year " + report.getYear(), font16));
        document.add( Chunk.NEWLINE );
        document.add(new Paragraph("First name: " + report.getRecipient().getFirstName(), font14));
        document.add(new Paragraph("Last name: " + report.getRecipient().getLastName(), font14));

        // simulate create report
        Thread.sleep(10000);

        document.add( Chunk.NEWLINE );
        document.add(new Paragraph("{{Big report}}", font14));
        document.add( Chunk.NEWLINE );
        document.add(new Paragraph("Created at: " + report.getCreatedAt().getTime(), font14));
        document.close();
    }

    private void mkDirs() {
        if (pdfPathConfiguration.getPath().toFile().exists() == false){
            pdfPathConfiguration.getPath().toFile().mkdirs();
        }
    }

    /**
     * Sets pdf path configuration.
     *
     * @param pdfPathConfiguration the pdf path configuration
     */
    public void setPdfPathConfiguration(IPdfPathConfiguration pdfPathConfiguration) {
        this.pdfPathConfiguration = pdfPathConfiguration;
    }
}

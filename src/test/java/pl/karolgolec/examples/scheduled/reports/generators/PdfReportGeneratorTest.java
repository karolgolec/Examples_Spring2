package pl.karolgolec.examples.scheduled.reports.generators;

import com.itextpdf.text.DocumentException;
import org.junit.Assert;
import org.junit.Test;
import pl.karolgolec.examples.scheduled.reports.models.Recipient;
import pl.karolgolec.examples.scheduled.reports.models.Report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * The type PdfFactoryTest.
 */
public class PdfReportGeneratorTest {

    @Test
    public void shouldCreatePdfFile() throws IOException, InterruptedException, DocumentException {
        File temp = Files.createTempDirectory("pdfs").toFile();
        PdfReportGenerator factory = new PdfReportGenerator();
        factory.setSaveToDir(temp);
        Report report = new Report(new Recipient("John", "Doe"), 2013);
        factory.create(report);
        File file = new File(temp, report.getUuid() + ".pdf");
        Assert.assertTrue(file.exists());
    }
}
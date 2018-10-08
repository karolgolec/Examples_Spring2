package pl.karolgolec.examples.scheduled.reports.schedules;

import com.itextpdf.text.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.karolgolec.examples.scheduled.reports.generators.PdfReportGenerator;
import pl.karolgolec.examples.scheduled.reports.models.Report;
import pl.karolgolec.examples.scheduled.reports.repositories.ReportRepository;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * The type Report generate schedule.
 */
@Component
public class ReportGenerateSchedule {

    private static final Logger log = LoggerFactory.getLogger(ReportGenerateSchedule.class);

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private PdfReportGenerator pdfReportGenerator;

    /**
     * Generate reports.
     */
    @Scheduled(fixedDelay = 1000)
    public void generateReports() {
        List<Report> reports = reportRepository.findByGeneratedFalse();
        try {
            for (Report report : reports) {
                pdfReportGenerator.create(report);
                report.setGenerated(true);
                reportRepository.save(report);
            }
        } catch (FileNotFoundException | DocumentException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }
}

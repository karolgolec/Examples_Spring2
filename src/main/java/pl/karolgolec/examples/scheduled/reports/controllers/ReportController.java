package pl.karolgolec.examples.scheduled.reports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.karolgolec.examples.scheduled.mains.services.BaseUrlService;
import pl.karolgolec.examples.scheduled.reports.configurations.IPdfPathConfiguration;
import pl.karolgolec.examples.scheduled.reports.models.Report;
import pl.karolgolec.examples.scheduled.reports.repositories.RecipientRepository;
import pl.karolgolec.examples.scheduled.reports.repositories.ReportRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * The type PdfController.
 */
@Controller
public class ReportController {

    @Autowired
    private BaseUrlService baseUrlService;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    @Autowired
    @Qualifier("PdfPathConfiguration")
    protected IPdfPathConfiguration pdfPathConfiguration;

    @GetMapping(value = "/reports")
    public String newReport(Model model) {
        model.addAttribute("report", new Report());
        return "reports/new_report";
    }

    @PostMapping(value = "/reports")
    public String addReport(@Valid @ModelAttribute("report") Report report, RedirectAttributes redirectAttributes) {
        recipientRepository.save(report.getRecipient());
        reportRepository.save(report);
        return "redirect:reports/" + report.getUuid();
    }

    @GetMapping(value = "/reports/{uuid}")
    public String getReport(Model model, @PathVariable("uuid") String uuid) {
        Report report = reportRepository.findByUuid(uuid).get(0);
        model.addAttribute("report", report);
        model.addAttribute("report_link", baseUrlService.getBaseUrl() + "/reports/" + uuid + "/download");
        return "reports/get_report";
    }

    @GetMapping(value = "/reports/{uuid}/download")
    public ResponseEntity<InputStreamResource> downloadReport(@PathVariable("uuid") String uuid) throws FileNotFoundException {
        File pdf = new File(pdfPathConfiguration.getPath().toFile(), uuid+ ".pdf");
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentType(MediaType.APPLICATION_PDF);
        respHeaders.setContentLength(pdf.length());
        respHeaders.setContentDispositionFormData("attachment", pdf.getName());
        InputStreamResource isr = new InputStreamResource(new FileInputStream(pdf));
        return new ResponseEntity<>(isr, respHeaders, HttpStatus.OK);
    }

}

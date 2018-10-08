package pl.karolgolec.examples.scheduled.reports.configurations;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type Pdf path configuration.
 */
@Component("PdfPathConfiguration")
public class PdfPathConfiguration implements IPdfPathConfiguration {

    private static final String PATH = "data/storage/pdfs";

    /**
     * Get path path.
     *
     * @return the path
     */
    public Path getPath() {
        return Paths.get(PATH);
    }
}

package pl.karolgolec.examples.scheduled.reports.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.karolgolec.examples.scheduled.reports.models.Report;

import java.util.List;

/**
 * The interface Category repository.
 */
@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

    List<Report> findByUuid(String uuid);

    List<Report> findByGeneratedFalse();
}

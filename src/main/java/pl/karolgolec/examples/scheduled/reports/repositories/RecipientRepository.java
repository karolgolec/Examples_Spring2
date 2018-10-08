package pl.karolgolec.examples.scheduled.reports.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.karolgolec.examples.scheduled.reports.models.Recipient;

/**
 * The interface Category repository.
 */
@Repository
public interface RecipientRepository extends CrudRepository<Recipient, Long> {

}

package pl.edu.repository.catering.availability;

import pl.edu.model.catering.availability.CateringAvailability;
import pl.edu.repository.IRepository;

public interface ICateringAvailabilityRepository extends IRepository<CateringAvailability, Long> {

    CateringAvailabilities findAll();
}

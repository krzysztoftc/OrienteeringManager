package pl.edu.repository.catering.availability;

import pl.edu.model.catering.availability.AccommodationAvailability;
import pl.edu.repository.IRepository;

public interface ICateringAvailabilityRepository extends IRepository<AccommodationAvailability, Long> {

    CateringAvailabilities findAll();
}

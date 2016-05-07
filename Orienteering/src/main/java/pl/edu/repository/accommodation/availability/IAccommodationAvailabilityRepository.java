package pl.edu.repository.accommodation.availability;

import pl.edu.model.accommodation.availability.AccommodationAvailability;
import pl.edu.repository.IRepository;

public interface IAccommodationAvailabilityRepository extends IRepository<AccommodationAvailability, Long> {

    AccommodationAvailabilities findAll();
}

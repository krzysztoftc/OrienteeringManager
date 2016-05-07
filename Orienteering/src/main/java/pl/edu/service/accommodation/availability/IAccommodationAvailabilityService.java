package pl.edu.service.accommodation.availability;

import pl.edu.model.accommodation.availability.AccommodationAvailability;
import pl.edu.model.club.Club;
import pl.edu.repository.accommodation.availability.AccommodationAvailabilities;
import pl.edu.repository.club.Clubs;
import pl.edu.service.IService;

import java.util.List;

public interface IAccommodationAvailabilityService extends IService {

	void delete(AccommodationAvailability accommodationAvailability);

	void update(AccommodationAvailability accommodationAvailability);
	
	boolean exists(AccommodationAvailabilities accommodationAvailabilities);
	
	void saveOrUpdate(AccommodationAvailability accommodationAvailability);
	
	void save(AccommodationAvailability accommodationAvailability);
	
	boolean saveIfNew(AccommodationAvailability accommodationAvailability);

	List<AccommodationAvailability> list(AccommodationAvailabilities accommodationAvailabilities);

	long count(AccommodationAvailabilities accommodationAvailabilities);

    AccommodationAvailability uniqueObject(AccommodationAvailabilities accommodationAvailabilities);
}

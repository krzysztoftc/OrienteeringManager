package pl.edu.service.accommodation;

import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.club.Club;
import pl.edu.repository.accommodation.Accommodations;
import pl.edu.repository.club.Clubs;
import pl.edu.service.IService;

import java.util.List;

public interface IAccommodationService extends IService {

	void delete(Accommodation accommodation);

	void update(Accommodation accommodation);
	
	boolean exists(Accommodations accommodations);
	
	void saveOrUpdate(Accommodation accommodation);
	
	void save(Accommodation accommodation);
	
	boolean saveIfNew(Accommodation accommodation);

	List<Accommodation> list(Accommodations accommodations);

	long count(Accommodations accommodations);

    Accommodation uniqueObject(Accommodations accommodations);
}

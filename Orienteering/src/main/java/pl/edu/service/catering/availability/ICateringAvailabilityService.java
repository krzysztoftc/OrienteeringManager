package pl.edu.service.catering.availability;

import pl.edu.model.catering.availability.CateringAvailability;
import pl.edu.model.club.Club;
import pl.edu.repository.catering.availability.CateringAvailabilities;
import pl.edu.repository.club.Clubs;
import pl.edu.service.IService;

import java.util.List;

public interface ICateringAvailabilityService extends IService {

	void delete(CateringAvailability cateringAvailability);

	void update(CateringAvailability cateringAvailability);
	
	boolean exists(CateringAvailabilities cateringAvailabilities);
	
	void saveOrUpdate(CateringAvailability cateringAvailability);
	
	void save(CateringAvailability cateringAvailability);
	
	boolean saveIfNew(CateringAvailability cateringAvailability);

	List<CateringAvailability> list(CateringAvailabilities cateringAvailabilities);

	long count(CateringAvailabilities cateringAvailabilities);

    CateringAvailability uniqueObject(CateringAvailabilities cateringAvailabilities);
}

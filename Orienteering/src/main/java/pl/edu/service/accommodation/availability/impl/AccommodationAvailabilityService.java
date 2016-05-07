package pl.edu.service.accommodation.availability.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.accommodation.availability.AccommodationAvailability;
import pl.edu.model.club.Club;
import pl.edu.repository.accommodation.availability.AccommodationAvailabilities;
import pl.edu.repository.accommodation.availability.IAccommodationAvailabilityRepository;
import pl.edu.repository.club.Clubs;
import pl.edu.service.accommodation.availability.IAccommodationAvailabilityService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccommodationAvailabilityService implements IAccommodationAvailabilityService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private IAccommodationAvailabilityRepository accommodationAvailabilityRepository;

	@Override
	public void delete(AccommodationAvailability accommodationAvailability) {
		accommodationAvailabilityRepository.delete(accommodationAvailability);
	}

	@Override
	public void saveOrUpdate(AccommodationAvailability accommodationAvailability) {
		accommodationAvailabilityRepository.saveOrUpdate(accommodationAvailability);
	}

	@Override
	public void save(AccommodationAvailability accommodationAvailability) {
		accommodationAvailabilityRepository.save(accommodationAvailability);
	}

	@Override
	public boolean saveIfNew(AccommodationAvailability accommodationAvailability) {
		return false;
	}

	@Override
	public List<AccommodationAvailability> list(AccommodationAvailabilities accommodationAvailabilities) {
		return accommodationAvailabilityRepository.findAll().merge(accommodationAvailabilities).list();
	}

	@Override
	public long count(AccommodationAvailabilities accommodationAvailabilities) {
		return accommodationAvailabilityRepository.findAll().merge(accommodationAvailabilities).count();
	}

	@Override
	public AccommodationAvailability uniqueObject(AccommodationAvailabilities accommodationAvailabilities) {
		return accommodationAvailabilityRepository.findAll().merge(accommodationAvailabilities).uniqueObject();
	}

	@Override
	public void update(AccommodationAvailability accommodationAvailability) {
		accommodationAvailabilityRepository.update(accommodationAvailability);
	}

	@Override
	public boolean exists(AccommodationAvailabilities accommodationAvailabilities) {
        AccommodationAvailability club = accommodationAvailabilityRepository
                .findAll().merge(accommodationAvailabilities).uniqueObject();
		accommodationAvailabilityRepository.evict(club);
		return club != null;
	}
}

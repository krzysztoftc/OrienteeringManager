package pl.edu.service.accommodation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.club.Club;
import pl.edu.repository.accommodation.Accommodations;
import pl.edu.repository.accommodation.IAccommodationRepository;
import pl.edu.repository.club.Clubs;
import pl.edu.service.accommodation.IAccommodationService;
import pl.edu.service.club.IClubService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccommodationService implements IAccommodationService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private IAccommodationRepository accommodationRepository;

	@Override
	public void delete(Accommodation accommodation) {
		accommodationRepository.delete(accommodation);
	}

	@Override
	public void saveOrUpdate(Accommodation accommodation) {
		accommodationRepository.saveOrUpdate(accommodation);
	}

	@Override
	public void save(Accommodation accommodation) {
		accommodationRepository.save(accommodation);
	}

	@Override
	public boolean saveIfNew(Accommodation accommodation) {
		return false;
	}

	@Override
	public List<Accommodation> list(Accommodations accommodations) {
		return accommodationRepository.findAll().merge(accommodations).list();
	}

	@Override
	public long count(Accommodations accommodations) {
		return accommodationRepository.findAll().merge(accommodations).count();
	}

	@Override
	public Accommodation uniqueObject(Accommodations accommodations) {
		return accommodationRepository.findAll().merge(accommodations).uniqueObject();
	}


	@Override
	public void update(Accommodation accommodation) {
		accommodationRepository.update(accommodation);
	}

	@Override
	public boolean exists(Accommodations accommodations) {
        Accommodation accommodation = accommodationRepository.findAll().merge(accommodations).uniqueObject();
		accommodationRepository.evict(accommodation);
		return accommodation != null;
	}
}

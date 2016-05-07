package pl.edu.service.accommodation.reservation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.repository.accommodation.reservation.AccommodationReservations;
import pl.edu.repository.accommodation.reservation.IAccommodationReservationRepository;
import pl.edu.service.accommodation.reservation.IAccommodationReservationService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccommodationReservationService implements IAccommodationReservationService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private IAccommodationReservationRepository accommodationReservationRepository;

	@Override
	public void delete(AccommodationReservation accommodationReservation) {
		accommodationReservationRepository.delete(accommodationReservation);
	}

	@Override
	public void saveOrUpdate(AccommodationReservation accommodationReservation) {
		accommodationReservationRepository.saveOrUpdate(accommodationReservation);
	}

	@Override
	public void save(AccommodationReservation accommodationReservation) {
		accommodationReservationRepository.save(accommodationReservation);
	}

	@Override
	public boolean saveIfNew(AccommodationReservation accommodationReservation) {
		return false;
	}

	@Override
	public List<AccommodationReservation> list(AccommodationReservations accommodationReservations) {
		return accommodationReservationRepository.findAll().merge(accommodationReservations).list();
	}

	@Override
	public long count(AccommodationReservations accommodationReservations) {
		return accommodationReservationRepository.findAll().merge(accommodationReservations).count();
	}

	@Override
	public AccommodationReservation uniqueObject(AccommodationReservations accommodationReservations) {
		return accommodationReservationRepository.findAll().merge(accommodationReservations).uniqueObject();
	}

	@Override
	public void update(AccommodationReservation accommodationReservation) {
		accommodationReservationRepository.update(accommodationReservation);
	}

	@Override
	public boolean exists(AccommodationReservations accommodationReservations) {
        AccommodationReservation accommodationReservation = accommodationReservationRepository.findAll().merge(accommodationReservations).uniqueObject();
		accommodationReservationRepository.evict(accommodationReservation);
		return accommodationReservation != null;
	}
}

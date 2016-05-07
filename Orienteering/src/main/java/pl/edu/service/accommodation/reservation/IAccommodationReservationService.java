package pl.edu.service.accommodation.reservation;

import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.repository.accommodation.reservation.AccommodationReservations;
import pl.edu.service.IService;

import java.util.List;

public interface IAccommodationReservationService extends IService {

	void delete(AccommodationReservation accommodationReservation);

	void update(AccommodationReservation accommodationReservation);
	
	boolean exists(AccommodationReservations accommodationReservations);
	
	void saveOrUpdate(AccommodationReservation accommodationReservation);
	
	void save(AccommodationReservation accommodationReservation);
	
	boolean saveIfNew(AccommodationReservation accommodationReservation);

	List<AccommodationReservation> list(AccommodationReservations accommodationReservations);

	long count(AccommodationReservations accommodationReservations);

    AccommodationReservation uniqueObject(AccommodationReservations accommodationReservations);
}

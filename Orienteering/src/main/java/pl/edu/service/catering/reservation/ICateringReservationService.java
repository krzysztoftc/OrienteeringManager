package pl.edu.service.catering.reservation;

import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.model.club.Club;
import pl.edu.repository.catering.reservation.CateringReservations;
import pl.edu.repository.club.Clubs;
import pl.edu.service.IService;

import java.util.List;

public interface ICateringReservationService extends IService {

	void delete(CateringReservation cateringReservation);

	void update(CateringReservation cateringReservation);
	
	boolean exists(CateringReservations cateringReservations);
	
	void saveOrUpdate(CateringReservation cateringReservation);
	
	void save(CateringReservation cateringReservation);
	
	boolean saveIfNew(CateringReservation cateringReservation);

	List<CateringReservation> list(CateringReservations cateringReservations);

	long count(CateringReservations cateringReservations);

    CateringReservation uniqueObject(CateringReservations cateringReservations);
}

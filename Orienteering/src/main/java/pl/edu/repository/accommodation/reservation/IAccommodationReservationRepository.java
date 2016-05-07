package pl.edu.repository.accommodation.reservation;

import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.repository.IRepository;

public interface IAccommodationReservationRepository extends IRepository<AccommodationReservation, Long> {

    AccommodationReservations findAll();
}

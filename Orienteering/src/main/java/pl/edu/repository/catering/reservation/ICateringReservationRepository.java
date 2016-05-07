package pl.edu.repository.catering.reservation;

import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.repository.IRepository;

public interface ICateringReservationRepository extends IRepository<CateringReservation, Long> {

    CateringReservations findAll();
}

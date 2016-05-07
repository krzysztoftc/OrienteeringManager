package pl.edu.repository.accommodation.reservation;

import org.springframework.stereotype.Repository;
import pl.edu.model.BaseEntity;
import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.model.catering.Catering;
import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.repository.StandardDatabaseRepository;

@Repository
public class DatabaseAccommodationReservationRepository
        extends StandardDatabaseRepository<AccommodationReservation, Long>
        implements IAccommodationReservationRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522593563237649316L;

	@Override
	public AccommodationReservations findAll() {
		return new CriteriaAccommodationReservations(createCriteria(),
                createCriteria());
	}

	@Override
	public Class<? extends BaseEntity<Long>> getEntityClass() {
		return AccommodationReservation.class;
	}
}

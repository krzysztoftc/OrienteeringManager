package pl.edu.repository.catering.reservation;

import org.springframework.stereotype.Repository;
import pl.edu.model.BaseEntity;
import pl.edu.model.catering.Catering;
import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.repository.StandardDatabaseRepository;

@Repository
public class DatabaseCateringReservationRepository
        extends StandardDatabaseRepository<CateringReservation, Long>
        implements ICateringReservationRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522593563237649316L;

	@Override
	public CateringReservations findAll() {
		return new CriteriaCateringReservations(createCriteria(),
                createCriteria());
	}

	@Override
	public Class<? extends BaseEntity<Long>> getEntityClass() {
		return CateringReservation.class;
	}
}

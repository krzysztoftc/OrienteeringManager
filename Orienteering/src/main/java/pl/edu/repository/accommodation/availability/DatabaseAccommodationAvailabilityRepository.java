package pl.edu.repository.accommodation.availability;

import org.springframework.stereotype.Repository;
import pl.edu.model.BaseEntity;
import pl.edu.model.accommodation.availability.AccommodationAvailability;
import pl.edu.repository.StandardDatabaseRepository;

@Repository
public class DatabaseAccommodationAvailabilityRepository
        extends StandardDatabaseRepository<AccommodationAvailability, Long>
        implements IAccommodationAvailabilityRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522593563237649316L;

	@Override
	public AccommodationAvailabilities findAll() {
		return new CriteriaAccommodationAvailabilities(createCriteria(),
                createCriteria());
	}

	@Override
	public Class<? extends BaseEntity<Long>> getEntityClass() {
		return AccommodationAvailability.class;
	}
}

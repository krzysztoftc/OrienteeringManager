package pl.edu.repository.accommodation;

import org.springframework.stereotype.Repository;
import pl.edu.model.BaseEntity;
import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.catering.Catering;
import pl.edu.repository.StandardDatabaseRepository;

@Repository
public class DatabaseAccommodationRepository
        extends StandardDatabaseRepository<Accommodation, Long>
        implements IAccommodationRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522593563237649316L;

	@Override
	public Accommodations findAll() {
		return new CriteriaAccommodations(createCriteria(), createCriteria());
	}

	@Override
	public Class<? extends BaseEntity<Long>> getEntityClass() {
		return Accommodation.class;
	}
}

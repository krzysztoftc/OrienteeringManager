package pl.edu.repository.catering;

import org.springframework.stereotype.Repository;
import pl.edu.model.BaseEntity;
import pl.edu.model.catering.Catering;
import pl.edu.repository.StandardDatabaseRepository;

@Repository
public class DatabaseCateringRepository
        extends StandardDatabaseRepository<Catering, Long>
        implements ICateringRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522593563237649316L;

	@Override
	public Caterings findAll() {
		return new CriteriaCaterings(createCriteria(), createCriteria());
	}

	@Override
	public Class<? extends BaseEntity<Long>> getEntityClass() {
		return Catering.class;
	}
}

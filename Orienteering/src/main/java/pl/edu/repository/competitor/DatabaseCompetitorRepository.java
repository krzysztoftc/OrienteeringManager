package pl.edu.repository.competitor;

import org.springframework.stereotype.Repository;
import pl.edu.model.BaseEntity;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.StandardDatabaseRepository;

@Repository
public class DatabaseCompetitorRepository extends StandardDatabaseRepository<Competitor, Long> implements ICompetitorRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522593563237649316L;

	@Override
	public Competitors findAll() {
		return new CriteriaCompetitors(createCriteria(), createCriteria());
	}

	@Override
	public Class<? extends BaseEntity<Long>> getEntityClass() {
		return Competitor.class;
	}
}

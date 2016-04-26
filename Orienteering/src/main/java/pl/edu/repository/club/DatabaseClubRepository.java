package pl.edu.repository.club;

import org.springframework.stereotype.Repository;
import pl.edu.model.BaseEntity;
import pl.edu.model.club.Club;
import pl.edu.repository.StandardDatabaseRepository;

@Repository
public class DatabaseClubRepository extends StandardDatabaseRepository<Club, Long> implements IClubRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522593563237649316L;

	@Override
	public Clubs findAll() {
		return new CriteriaClubs(createCriteria(), createCriteria());
	}

	@Override
	public Class<? extends BaseEntity<Long>> getEntityClass() {
		return Club.class;
	}
}

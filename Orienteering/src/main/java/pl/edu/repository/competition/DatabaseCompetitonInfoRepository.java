package pl.edu.repository.competition;

import org.springframework.stereotype.Repository;
import pl.edu.model.BaseEntity;
import pl.edu.model.competition.CompetitionInfo;
import pl.edu.repository.StandardDatabaseRepository;

@Repository
public class DatabaseCompetitonInfoRepository extends StandardDatabaseRepository<CompetitionInfo, Long> implements ICompetitonInfoRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522593563237649316L;

	@Override
	public CompetitonInfos findAll() {
		return new CriteriaCompetitonInfos(createCriteria(), createCriteria());
	}

	@Override
	public Class<? extends BaseEntity<Long>> getEntityClass() {
		return CompetitionInfo.class;
	}
}

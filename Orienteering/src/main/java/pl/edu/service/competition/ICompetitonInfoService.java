package pl.edu.service.competition;

import pl.edu.model.competition.CompetitionInfo;
import pl.edu.repository.competition.CompetitonInfos;
import pl.edu.service.IService;

import java.util.List;

public interface ICompetitonInfoService extends IService {

	void delete(CompetitionInfo competitionInfo);

	/**
	 * Metoda zapisująca zmiany danych klubu.
	 * @param competitionInfo
	 */
	void update(CompetitionInfo competitionInfo);
	
	boolean exists(CompetitonInfos competitonInfos);
	
	void saveOrUpdate(CompetitionInfo competitionInfo);
	
	void save(CompetitionInfo competitionInfo);
	
	boolean saveIfNew(CompetitionInfo competitionInfo);

	List<CompetitionInfo> list(CompetitonInfos competitonInfos);

	long count(CompetitonInfos competitonInfos);

    CompetitionInfo uniqueObject(CompetitonInfos competitonInfos);
}

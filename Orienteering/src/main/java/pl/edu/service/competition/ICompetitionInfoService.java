package pl.edu.service.competition;

import pl.edu.model.competition.CompetitionInfo;
import pl.edu.repository.competition.CompetitionInfos;
import pl.edu.service.IService;

import java.util.List;

public interface ICompetitionInfoService extends IService {

	void delete(CompetitionInfo competitionInfo);

	/**
	 * Metoda zapisująca zmiany danych klubu.
	 * @param competitionInfo
	 */
	void update(CompetitionInfo competitionInfo);
	
	boolean exists(CompetitionInfos competitonInfos);
	
	void saveOrUpdate(CompetitionInfo competitionInfo);
	
	void save(CompetitionInfo competitionInfo);
	
	boolean saveIfNew(CompetitionInfo competitionInfo);

	List<CompetitionInfo> list(CompetitionInfos competitonInfos);

	long count(CompetitionInfos competitonInfos);

    CompetitionInfo uniqueObject(CompetitionInfos competitonInfos);
}

package pl.edu.service.competition;

import pl.edu.model.competition.CompetitonInfo;
import pl.edu.repository.competition.CompetitonInfos;
import pl.edu.service.IService;

import java.util.List;

public interface ICompetitonInfoService extends IService {

	void delete(CompetitonInfo competitonInfo);

	/**
	 * Metoda zapisująca zmiany danych klubu.
	 * @param competitonInfo
	 */
	void update(CompetitonInfo competitonInfo);
	
	boolean exists(CompetitonInfos competitonInfos);
	
	void saveOrUpdate(CompetitonInfo competitonInfo);
	
	void save(CompetitonInfo competitonInfo);
	
	boolean saveIfNew(CompetitonInfo competitonInfo);

	List<CompetitonInfo> list(CompetitonInfos competitonInfos);

	long count(CompetitonInfos competitonInfos);

    CompetitonInfo uniqueObject(CompetitonInfos competitonInfos);
}

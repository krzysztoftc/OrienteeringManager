package pl.edu.service.competitor;

import pl.edu.model.competitor.Competitor;
import pl.edu.repository.competitor.Competitors;
import pl.edu.service.IService;

import java.util.List;

public interface ICompetitorService extends IService {

	void delete(Competitor competitor);

	/**
	 * Metoda zapisująca nowego użytkownika do repozytorium. 
	 * Wywoływana podczas jego rejestrowania.
	 * @param competitor
	 */
	void register(Competitor competitor);
	
	/**
	 * Metoda zapisująca zmiany danych klubu.
	 * @param competitor
	 */
	void update(Competitor competitor);
	
	boolean exists(Competitors competitors);
	
	void saveOrUpdate(Competitor competitor);
	
	void save(Competitor competitor);
	
	boolean saveIfNew(Competitor competitor);

	List<Competitor> list(Competitors competitors);

	long count(Competitors competitors);

    Competitor uniqueObject(Competitors competitors);
}

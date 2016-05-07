package pl.edu.service.category;

import pl.edu.model.club.Club;
import pl.edu.repository.club.Clubs;
import pl.edu.service.IService;

import java.util.List;

public interface ICategoryService extends IService {

	void delete(Club club);

	/**
	 * Metoda zapisująca nowego użytkownika do repozytorium. 
	 * Wywoływana podczas jego rejestrowania.
	 * @param club
	 */
	void register(Club club);
	
	/**
	 * Metoda zapisująca zmiany danych klubu.
	 * @param club
	 */
	void update(Club club);
	
	boolean exists(Clubs clubs);
	
	void saveOrUpdate(Club user);
	
	void save(Club user);
	
	boolean saveIfNew(Club user);

	List<Club> list(Clubs clubs);

	long count(Clubs clubs);
	
	Club uniqueObject(Clubs clubs);
}

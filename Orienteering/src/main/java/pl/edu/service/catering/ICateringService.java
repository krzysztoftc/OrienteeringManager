package pl.edu.service.catering;

import pl.edu.model.catering.Catering;
import pl.edu.model.club.Club;
import pl.edu.repository.catering.Caterings;
import pl.edu.repository.club.Clubs;
import pl.edu.service.IService;

import java.util.List;

public interface ICateringService extends IService {

	void delete(Catering catering);

	void update(Catering catering);
	
	boolean exists(Caterings caterings);
	
	void saveOrUpdate(Catering catering);
	
	void save(Catering catering);
	
	boolean saveIfNew(Catering catering);

	List<Catering> list(Caterings caterings);

	long count(Caterings caterings);

    Catering uniqueObject(Caterings caterings);
}

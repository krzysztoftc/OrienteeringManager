package pl.edu.repository.accommodation;


import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.catering.Catering;
import pl.edu.repository.IRepository;

public interface IAccommodationRepository extends IRepository<Accommodation, Long> {

	Accommodations findAll();
}

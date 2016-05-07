package pl.edu.repository.catering;


import pl.edu.model.catering.Catering;
import pl.edu.repository.IRepository;

public interface ICateringRepository extends IRepository<Catering, Long> {

	Caterings findAll();
}

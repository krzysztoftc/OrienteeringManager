package pl.edu.repository.category;


import pl.edu.model.category.Category;
import pl.edu.model.catering.Catering;
import pl.edu.repository.IRepository;

public interface ICategoryRepository extends IRepository<Category, Long> {

	Categories findAll();
}

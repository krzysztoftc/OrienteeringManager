package pl.edu.service.category;

import pl.edu.model.category.Category;
import pl.edu.model.club.Club;
import pl.edu.repository.category.Categories;
import pl.edu.repository.club.Clubs;
import pl.edu.service.IService;

import java.util.List;

public interface ICategoryService extends IService {

	void delete(Category category);

	void update(Category category);
	
	boolean exists(Categories categories);
	
	void saveOrUpdate(Category category);
	
	void save(Category category);
	
	boolean saveIfNew(Category category);

	List<Category> list(Categories categories);

	long count(Categories categories);

    Category uniqueObject(Categories categories);
}

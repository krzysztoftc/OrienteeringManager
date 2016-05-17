package pl.edu.repository.category;

import org.springframework.stereotype.Repository;
import pl.edu.model.BaseEntity;
import pl.edu.model.category.Category;
import pl.edu.model.catering.Catering;
import pl.edu.repository.StandardDatabaseRepository;

@Repository
public class DatabaseCategoryRepository
        extends StandardDatabaseRepository<Category, Long>
        implements ICategoryRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522593563237649316L;

	@Override
	public Categories findAll() {
		return new CriteriaCategories(createCriteria(), createCriteria());
	}

	@Override
	public Class<? extends BaseEntity<Long>> getEntityClass() {
		return Category.class;
	}
}

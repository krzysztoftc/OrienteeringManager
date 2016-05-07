package pl.edu.service.category.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.model.category.Category;
import pl.edu.model.club.Club;
import pl.edu.repository.category.Categories;
import pl.edu.repository.category.ICategoryRepository;
import pl.edu.repository.club.Clubs;
import pl.edu.service.category.ICategoryService;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryService implements ICategoryService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public void saveOrUpdate(Category category) {
		categoryRepository.saveOrUpdate(category);
	}

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public boolean saveIfNew(Category category) {
		return false;
	}

	@Override
	public List<Category> list(Categories categories) {
		return categoryRepository.findAll().merge(categories).list();
	}

	@Override
	public long count(Categories categories) {
		return categoryRepository.findAll().merge(categories).count();
	}

	@Override
	public Category uniqueObject(Categories categories) {
		return categoryRepository.findAll().merge(categories).uniqueObject();
	}

	@Override
	public void update(Category category) {
		categoryRepository.update(category);
	}

	@Override
	public boolean exists(Categories categories) {
        Category category = categoryRepository.findAll().merge(categories).uniqueObject();
		categoryRepository.evict(category);
		return category != null;
	}
}

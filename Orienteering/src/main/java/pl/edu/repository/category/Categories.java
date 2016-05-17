package pl.edu.repository.category;

import pl.edu.model.category.Category;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class Categories extends Queryable<Category, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

    protected String name;

	protected Categories() {
	}

	public Categories withId(Long id) {
		return (Categories) super.withId(id);
	}

    public Categories withName(String name){
        this.name = name;
        return this;
    }

	public Categories addOrder(OrderType orderType, String sortProperty) {
		return (Categories) super.addOrder(orderType, sortProperty);
	}

	public Categories loadWith(String... propertyNames) {
		return (Categories) super.loadWith(propertyNames);
	}

	public Categories paginate(int startingAt, int maxResults) {
		return (Categories) super.paginate(startingAt, maxResults);
	}

	public Categories randomOrder() {
		return (Categories) super.randomOrder();
	}

	public Categories merge(Categories other) {
		super.merge(other);
		return this;
	}

	public static Categories findAll() {
		return new Categories() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public Category uniqueObject() {
				return null;
			}

			@Override
			public List<Category> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

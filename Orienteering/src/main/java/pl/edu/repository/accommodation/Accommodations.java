package pl.edu.repository.accommodation;

import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.catering.Catering;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class Accommodations extends Queryable<Accommodation, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

	protected Accommodations() {
	}

	public Accommodations withId(Long id) {
		return (Accommodations) super.withId(id);
	}

	public Accommodations addOrder(OrderType orderType, String sortProperty) {
		return (Accommodations) super.addOrder(orderType, sortProperty);
	}

	public Accommodations loadWith(String... propertyNames) {
		return (Accommodations) super.loadWith(propertyNames);
	}

	public Accommodations paginate(int startingAt, int maxResults) {
		return (Accommodations) super.paginate(startingAt, maxResults);
	}

	public Accommodations randomOrder() {
		return (Accommodations) super.randomOrder();
	}

	public Accommodations merge(Accommodations other) {
		super.merge(other);
		return this;
	}

	public static Accommodations findAll() {
		return new Accommodations() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public Accommodation uniqueObject() {
				return null;
			}

			@Override
			public List<Accommodation> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

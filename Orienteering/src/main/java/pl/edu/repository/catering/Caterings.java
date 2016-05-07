package pl.edu.repository.catering;

import org.apache.commons.lang3.StringUtils;
import pl.edu.model.catering.Catering;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class Caterings extends Queryable<Catering, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

	protected Caterings() {
	}

	public Caterings withId(Long id) {
		return (Caterings) super.withId(id);
	}

	public Caterings addOrder(OrderType orderType, String sortProperty) {
		return (Caterings) super.addOrder(orderType, sortProperty);
	}

	public Caterings loadWith(String... propertyNames) {
		return (Caterings) super.loadWith(propertyNames);
	}

	public Caterings paginate(int startingAt, int maxResults) {
		return (Caterings) super.paginate(startingAt, maxResults);
	}

	public Caterings randomOrder() {
		return (Caterings) super.randomOrder();
	}

	public Caterings merge(Caterings other) {
		super.merge(other);
		return this;
	}

	public static Caterings findAll() {
		return new Caterings() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public Catering uniqueObject() {
				return null;
			}

			@Override
			public List<Catering> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

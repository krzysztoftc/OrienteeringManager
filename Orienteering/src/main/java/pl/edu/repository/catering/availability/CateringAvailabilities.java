package pl.edu.repository.catering.availability;

import pl.edu.model.catering.availability.AccommodationAvailability;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class CateringAvailabilities extends Queryable<AccommodationAvailability, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

	protected CateringAvailabilities() {
	}

	public CateringAvailabilities withId(Long id) {
		return (CateringAvailabilities) super.withId(id);
	}

	public CateringAvailabilities addOrder(OrderType orderType, String sortProperty) {
		return (CateringAvailabilities) super.addOrder(orderType, sortProperty);
	}

	public CateringAvailabilities loadWith(String... propertyNames) {
		return (CateringAvailabilities) super.loadWith(propertyNames);
	}

	public CateringAvailabilities paginate(int startingAt, int maxResults) {
		return (CateringAvailabilities) super.paginate(startingAt, maxResults);
	}

	public CateringAvailabilities randomOrder() {
		return (CateringAvailabilities) super.randomOrder();
	}

	public CateringAvailabilities merge(CateringAvailabilities other) {
		super.merge(other);
		return this;
	}

	public static CateringAvailabilities findAll() {
		return new CateringAvailabilities() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public AccommodationAvailability uniqueObject() {
				return null;
			}

			@Override
			public List<AccommodationAvailability> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

package pl.edu.repository.accommodation.availability;

import pl.edu.model.catering.availability.AccommodationAvailability;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class AccommodationAvailabilities extends Queryable<AccommodationAvailability, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

	protected AccommodationAvailabilities() {
	}

	public AccommodationAvailabilities withId(Long id) {
		return (AccommodationAvailabilities) super.withId(id);
	}

	public AccommodationAvailabilities addOrder(OrderType orderType, String sortProperty) {
		return (AccommodationAvailabilities) super.addOrder(orderType, sortProperty);
	}

	public AccommodationAvailabilities loadWith(String... propertyNames) {
		return (AccommodationAvailabilities) super.loadWith(propertyNames);
	}

	public AccommodationAvailabilities paginate(int startingAt, int maxResults) {
		return (AccommodationAvailabilities) super.paginate(startingAt, maxResults);
	}

	public AccommodationAvailabilities randomOrder() {
		return (AccommodationAvailabilities) super.randomOrder();
	}

	public AccommodationAvailabilities merge(AccommodationAvailabilities other) {
		super.merge(other);
		return this;
	}

	public static AccommodationAvailabilities findAll() {
		return new AccommodationAvailabilities() {

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

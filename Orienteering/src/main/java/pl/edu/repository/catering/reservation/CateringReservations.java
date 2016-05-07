package pl.edu.repository.catering.reservation;

import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class CateringReservations extends Queryable<CateringReservation, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

	protected CateringReservations() {
	}

	public CateringReservations withId(Long id) {
		return (CateringReservations) super.withId(id);
	}

	public CateringReservations addOrder(OrderType orderType, String sortProperty) {
		return (CateringReservations) super.addOrder(orderType, sortProperty);
	}

	public CateringReservations loadWith(String... propertyNames) {
		return (CateringReservations) super.loadWith(propertyNames);
	}

	public CateringReservations paginate(int startingAt, int maxResults) {
		return (CateringReservations) super.paginate(startingAt, maxResults);
	}

	public CateringReservations randomOrder() {
		return (CateringReservations) super.randomOrder();
	}

	public CateringReservations merge(CateringReservations other) {
		super.merge(other);
		return this;
	}

	public static CateringReservations findAll() {
		return new CateringReservations() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public CateringReservation uniqueObject() {
				return null;
			}

			@Override
			public List<CateringReservation> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

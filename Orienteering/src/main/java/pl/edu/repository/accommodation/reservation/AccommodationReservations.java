package pl.edu.repository.accommodation.reservation;

import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class AccommodationReservations extends Queryable<AccommodationReservation, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

    protected Long competitorId;

	protected AccommodationReservations() {
	}

	public AccommodationReservations withId(Long id) {
		return (AccommodationReservations) super.withId(id);
	}

    public AccommodationReservations withCompetitorId(Long competitorId){
        this.competitorId = competitorId;
        return this;
    }

	public AccommodationReservations addOrder(OrderType orderType, String sortProperty) {
		return (AccommodationReservations) super.addOrder(orderType, sortProperty);
	}

	public AccommodationReservations loadWith(String... propertyNames) {
		return (AccommodationReservations) super.loadWith(propertyNames);
	}

	public AccommodationReservations paginate(int startingAt, int maxResults) {
		return (AccommodationReservations) super.paginate(startingAt, maxResults);
	}

	public AccommodationReservations randomOrder() {
		return (AccommodationReservations) super.randomOrder();
	}

	public AccommodationReservations merge(AccommodationReservations other) {
		super.merge(other);
        if(other.competitorId != null){
            competitorId = other.competitorId;
        }
		return this;
	}

	public static AccommodationReservations findAll() {
		return new AccommodationReservations() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public AccommodationReservation uniqueObject() {
				return null;
			}

			@Override
			public List<AccommodationReservation> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

package pl.edu.repository.accommodation.reservation;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.repository.CommonCriteriaQueryable;
import pl.edu.utils.ClassUtils;

import java.util.List;

public class CriteriaAccommodationReservations extends AccommodationReservations {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3544776035574497650L;
	protected Criteria criteria;
	protected Criteria criteria2;

	public CriteriaAccommodationReservations(Criteria criteria, Criteria criteria2) {
		this.criteria = criteria;
		this.criteria2 = criteria2;
	}

	public Criteria modifyCriteria(Criteria criteria) {
        if (competitorId != null) {
            criteria.add(Restrictions.eq("competitorId", competitorId));
        }
        return criteria;
	}

	@Override
	public long count() {
		return CommonCriteriaQueryable.count(this, modifyCriteria(criteria));
	}

	@Override
	public List<AccommodationReservation> list() {
		return CommonCriteriaQueryable.list(this,
                modifyCriteria(criteria),
                criteria2,
                ClassUtils.getMapAndCollectionsFrom(AccommodationReservation.class));
	}

	@Override
	public AccommodationReservation uniqueObject() {
		return CommonCriteriaQueryable.uniqueObject(this, modifyCriteria(criteria));
	}
}

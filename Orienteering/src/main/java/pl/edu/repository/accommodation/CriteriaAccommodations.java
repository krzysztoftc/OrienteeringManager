package pl.edu.repository.accommodation;

import org.hibernate.Criteria;
import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.catering.Catering;
import pl.edu.repository.CommonCriteriaQueryable;
import pl.edu.utils.ClassUtils;

import java.util.List;

public class CriteriaAccommodations extends Accommodations {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3544776035574497650L;
	protected Criteria criteria;
	protected Criteria criteria2;

	public CriteriaAccommodations(Criteria criteria, Criteria criteria2) {
		this.criteria = criteria;
		this.criteria2 = criteria2;
	}

	public Criteria modifyCriteria(Criteria criteria) {
		return criteria;
	}

	@Override
	public long count() {
		return CommonCriteriaQueryable.count(this, modifyCriteria(criteria));
	}

	@Override
	public List<Accommodation> list() {
		return CommonCriteriaQueryable.list(this, modifyCriteria(criteria), criteria2, ClassUtils.getMapAndCollectionsFrom(Accommodation.class));
	}

	@Override
	public Accommodation uniqueObject() {
		return CommonCriteriaQueryable.uniqueObject(this, modifyCriteria(criteria));
	}
}

package pl.edu.repository.competitor;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.CommonCriteriaQueryable;
import pl.edu.utils.ClassUtils;

import java.util.List;

public class CriteriaCompetitors extends Competitors {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3544776035574497650L;
	protected Criteria criteria;
	protected Criteria criteria2;

	public CriteriaCompetitors(Criteria criteria, Criteria criteria2) {
		this.criteria = criteria;
		this.criteria2 = criteria2;
	}

	public Criteria modifyCriteria(Criteria criteria) {
        if (StringUtils.isNotBlank(name)) {
            criteria.add(Restrictions.eq("name", name));
        }
        if (StringUtils.isNotBlank(surname)) {
            criteria.add(Restrictions.eq("surname", surname));
        }
        if (StringUtils.isNotBlank(licenceNumber)) {
            criteria.add(Restrictions.eq("licenceNumber", licenceNumber));
        }
        if (chipNumber != null) {
            criteria.add(Restrictions.eq("chipNumber", chipNumber));
        }
        if (club != null) {
            criteria.add(Restrictions.eq("club", club));
        }
        if (birthYear != null) {
            criteria.add(Restrictions.eq("birthYear", birthYear));
        }
        if (gender != null) {
            criteria.add(Restrictions.eq("gender", gender));
        }
        if (category != null) {
            criteria.add(Restrictions.eq("category", category));
        }

		return criteria;
	}

	@Override
	public long count() {
		return CommonCriteriaQueryable.count(this, modifyCriteria(criteria));
	}

	@Override
	public List<Competitor> list() {
		return CommonCriteriaQueryable.list(this,
                modifyCriteria(criteria),
                criteria2,
                ClassUtils.getMapAndCollectionsFrom(Competitor.class));
	}

	@Override
	public Competitor uniqueObject() {
		return CommonCriteriaQueryable.uniqueObject(this, modifyCriteria(criteria));
	}
}

package pl.edu.repository.club;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pl.edu.model.club.Club;
import pl.edu.repository.CommonCriteriaQueryable;
import pl.edu.utils.ClassUtils;

import java.util.List;

public class CriteriaClubs extends Clubs {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3544776035574497650L;
	protected Criteria criteria;
	protected Criteria criteria2;

	public CriteriaClubs(Criteria criteria, Criteria criteria2) {
		this.criteria = criteria;
		this.criteria2 = criteria2;
	}

	public Criteria modifyCriteria(Criteria criteria) {
		if (StringUtils.isNotBlank(clubNumber)) {
			criteria.add(Restrictions.eq("clubNumber", clubNumber));
		}
        if (StringUtils.isNotBlank(clubName)) {
            criteria.add(Restrictions.eq("name", clubName));
        }
		return criteria;
	}

	@Override
	public long count() {
		return CommonCriteriaQueryable.count(this, modifyCriteria(criteria));
	}

	@Override
	public List<Club> list() {
		return CommonCriteriaQueryable.list(this, modifyCriteria(criteria), criteria2, ClassUtils.getMapAndCollectionsFrom(Club.class));
	}

	@Override
	public Club uniqueObject() {
		return CommonCriteriaQueryable.uniqueObject(this, modifyCriteria(criteria));
	}
}

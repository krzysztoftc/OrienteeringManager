package pl.edu.repository.competition;

import org.hibernate.Criteria;
import pl.edu.model.competition.CompetitionInfo;
import pl.edu.repository.CommonCriteriaQueryable;
import pl.edu.utils.ClassUtils;

import java.util.List;

public class CriteriaCompetitionInfos extends CompetitionInfos {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3544776035574497650L;
	protected Criteria criteria;
	protected Criteria criteria2;

	public CriteriaCompetitionInfos(Criteria criteria, Criteria criteria2) {
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
	public List<CompetitionInfo> list() {
		return CommonCriteriaQueryable.list(this,
                modifyCriteria(criteria),
                criteria2,
                ClassUtils.getMapAndCollectionsFrom(CompetitionInfo.class));
	}

	@Override
	public CompetitionInfo uniqueObject() {
		return CommonCriteriaQueryable.uniqueObject(this, modifyCriteria(criteria));
	}
}

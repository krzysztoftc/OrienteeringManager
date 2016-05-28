package pl.edu.repository.competition;

import pl.edu.model.competition.CompetitionInfo;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class CompetitionInfos extends Queryable<CompetitionInfo, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

    protected Long id;

	protected CompetitionInfos() {
	}

	public CompetitionInfos withId(Long id) {
		return (CompetitionInfos) super.withId(id);
	}

	public CompetitionInfos addOrder(OrderType orderType, String sortProperty) {
		return (CompetitionInfos) super.addOrder(orderType, sortProperty);
	}

	public CompetitionInfos loadWith(String... propertyNames) {
		return (CompetitionInfos) super.loadWith(propertyNames);
	}

	public CompetitionInfos paginate(int startingAt, int maxResults) {
		return (CompetitionInfos) super.paginate(startingAt, maxResults);
	}

	public CompetitionInfos randomOrder() {
		return (CompetitionInfos) super.randomOrder();
	}

	public CompetitionInfos merge(CompetitionInfos other) {
		super.merge(other);
		return this;
	}

	public static CompetitionInfos findAll() {
		return new CompetitionInfos() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public CompetitionInfo uniqueObject() {
				return null;
			}

			@Override
			public List<CompetitionInfo> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

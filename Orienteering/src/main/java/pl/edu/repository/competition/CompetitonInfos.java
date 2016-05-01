package pl.edu.repository.competition;

import org.apache.commons.lang3.StringUtils;
import pl.edu.model.competition.CompetitonInfo;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.Date;
import java.util.List;

public abstract class CompetitonInfos extends Queryable<CompetitonInfo, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

    protected Long id;

	protected CompetitonInfos() {
	}

	public CompetitonInfos withId(Long id) {
		return (CompetitonInfos) super.withId(id);
	}

	public CompetitonInfos addOrder(OrderType orderType, String sortProperty) {
		return (CompetitonInfos) super.addOrder(orderType, sortProperty);
	}

	public CompetitonInfos loadWith(String... propertyNames) {
		return (CompetitonInfos) super.loadWith(propertyNames);
	}

	public CompetitonInfos paginate(int startingAt, int maxResults) {
		return (CompetitonInfos) super.paginate(startingAt, maxResults);
	}

	public CompetitonInfos randomOrder() {
		return (CompetitonInfos) super.randomOrder();
	}

	public CompetitonInfos merge(CompetitonInfos other) {
		super.merge(other);
		return this;
	}

	public static CompetitonInfos findAll() {
		return new CompetitonInfos() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public CompetitonInfo uniqueObject() {
				return null;
			}

			@Override
			public List<CompetitonInfo> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

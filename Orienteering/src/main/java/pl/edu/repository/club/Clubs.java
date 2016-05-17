package pl.edu.repository.club;

import org.apache.commons.lang3.StringUtils;
import pl.edu.model.club.Club;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class Clubs extends Queryable<Club, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

	protected String clubNumber;
    protected String clubName;

	protected Clubs() {
	}

	public Clubs withClubNumber(String clubNumber) {
		this.clubNumber = clubNumber;
		return this;
	}

    public Clubs withClubName(String clubName) {
        this.clubName = clubName;
        return this;
    }

	public Clubs withId(Long id) {
		return (Clubs) super.withId(id);
	}

	public Clubs addOrder(OrderType orderType, String sortProperty) {
		return (Clubs) super.addOrder(orderType, sortProperty);
	}

	public Clubs loadWith(String... propertyNames) {
		return (Clubs) super.loadWith(propertyNames);
	}

	public Clubs paginate(int startingAt, int maxResults) {
		return (Clubs) super.paginate(startingAt, maxResults);
	}

	public Clubs randomOrder() {
		return (Clubs) super.randomOrder();
	}

	public Clubs merge(Clubs other) {
		super.merge(other);
		if (StringUtils.isNotBlank(other.clubNumber)) {
			this.clubNumber = other.clubNumber;
		}
		return this;
	}

	public static Clubs findAll() {
		return new Clubs() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public Club uniqueObject() {
				return null;
			}

			@Override
			public List<Club> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

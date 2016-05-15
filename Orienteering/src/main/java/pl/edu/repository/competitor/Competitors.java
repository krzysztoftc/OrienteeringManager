package pl.edu.repository.competitor;

import org.apache.commons.lang3.StringUtils;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.OrderType;
import pl.edu.repository.Queryable;

import java.util.List;

public abstract class Competitors extends Queryable<Competitor, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

    protected String name;
    protected String surname;
    protected String licenceNumber;
    protected Long chipNumber;
    protected Long clubId;
    protected Long birthYear;
    protected Character gender;
    protected Long category;

	protected Competitors() {
	}

	public Competitors withName(String name) {
		this.name = name;
		return this;
	}

    public Competitors withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Competitors withLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
        return this;
    }

    public Competitors withChipNumber(Long chipNumber) {
        this.chipNumber = chipNumber;
        return this;
    }

    public Competitors withClubId(Long clubId) {
        this.clubId = clubId;
        return this;
    }

    public Competitors withBirthYear(Long birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public Competitors withGender(Character gender) {
        this.gender = gender;
        return this;
    }

    public Competitors withCategory(Long category) {
        this.category = category;
        return this;
    }

	public Competitors withId(Long id) {
		return (Competitors) super.withId(id);
	}

	public Competitors addOrder(OrderType orderType, String sortProperty) {
		return (Competitors) super.addOrder(orderType, sortProperty);
	}

	public Competitors loadWith(String... propertyNames) {
		return (Competitors) super.loadWith(propertyNames);
	}

	public Competitors paginate(int startingAt, int maxResults) {
		return (Competitors) super.paginate(startingAt, maxResults);
	}

	public Competitors randomOrder() {
		return (Competitors) super.randomOrder();
	}

	public Competitors merge(Competitors other) {
		super.merge(other);
		if (StringUtils.isNotBlank(other.name)) {
			this.name = other.name;
		}
        if (StringUtils.isNotBlank(other.surname)) {
            this.surname = other.surname;
        }
        if (StringUtils.isNotBlank(other.licenceNumber)) {
            this.licenceNumber = other.licenceNumber;
        }
        if (other.chipNumber != null) {
            this.chipNumber = other.chipNumber;
        }
        if (other.clubId != null) {
            this.clubId = other.clubId;
        }
        if (other.birthYear != null) {
            this.birthYear = other.birthYear;
        }
        if (other.gender != null) {
            this.gender = other.gender;
        }
        if (other.category != null) {
            this.category = other.category;
        }
		return this;
	}

	public static Competitors findAll() {
		return new Competitors() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public Competitor uniqueObject() {
				return null;
			}

			@Override
			public List<Competitor> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

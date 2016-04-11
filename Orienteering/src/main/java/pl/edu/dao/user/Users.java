package pl.edu.dao.user;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import pl.edu.dao.OrderType;
import pl.edu.dao.Queryable;
import pl.edu.model.user.User;

public abstract class Users extends Queryable<User, Long> {

	private static final long serialVersionUID = -5848249886489304600L;

	protected String username;

	protected Users() {
	}


	public Users withUsername(String username) {
		this.username = username;
		return this;
	}

	public Users withId(Long id) {
		return (Users) super.withId(id);
	}

	public Users addOrder(OrderType orderType, String sortProperty) {
		return (Users) super.addOrder(orderType, sortProperty);
	}

	public Users loadWith(String... propertyNames) {
		return (Users) super.loadWith(propertyNames);
	}

	public Users paginate(int startingAt, int maxResults) {
		return (Users) super.paginate(startingAt, maxResults);
	}

	public Users randomOrder() {
		return (Users) super.randomOrder();
	}

	public Users merge(Users other) {
		super.merge(other);
		if (StringUtils.isNotBlank(other.username)) {
			this.username = other.username;
		}
		return this;
	}

	public static Users findAll() {
		return new Users() {

			private static final long serialVersionUID = -6804576481886404146L;

			@Override
			public User uniqueObject() {
				return null;
			}

			@Override
			public List<User> list() {
				return null;
			}

			@Override
			public long count() {
				return 0;
			}
		};
	}
}

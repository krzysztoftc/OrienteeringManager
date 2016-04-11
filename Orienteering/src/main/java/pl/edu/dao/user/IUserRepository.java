package pl.edu.dao.user;

import pl.edu.dao.IRepository;
import pl.edu.model.user.User;

public interface IUserRepository extends IRepository<User, Long> {

	Users findAll();
}

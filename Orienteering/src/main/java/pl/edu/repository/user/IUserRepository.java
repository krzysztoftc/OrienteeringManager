package pl.edu.repository.user;

import pl.edu.model.user.User;
import pl.edu.repository.IRepository;

public interface IUserRepository extends IRepository<User, Long> {

	Users findAll();
}

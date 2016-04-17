package pl.edu.repository.user;

import pl.edu.repository.IRepository;
import pl.edu.model.user.User;

public interface IUserRepository extends IRepository<User, Long> {

	Users findAll();
}

package pl.edu.service.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.edu.model.user.User;
import pl.edu.repository.user.Users;
import pl.edu.service.IService;

public interface IUserService extends UserDetailsService, IService {

	void delete(User user);
	

	/**
	 * Metoda zapisująca nowego użytkownika do repozytorium. 
	 * Wywoływana podczas jego rejestrowania.
	 * @param user
	 */
	void register(User user);
	
	/**
	 * Metoda zapisująca zmiany danych użytkownika. 
	 * @param user
	 */
	void update(User user);
	

	/**
	 * Metoda wywoływana po poprawnym zalogowaniu się użytkownika.
	 * @param username
	 * @param inquiry 
	 * @return user 
	 */
    User afterAuthentication(String username);
	
	boolean exists(Users users);
	
	void saveOrUpdate(User user);
	
	void save(User user);
	
	boolean saveIfNew(User user);

	List<User> list(Users users);

	long count(Users users);

    User uniqueObject(Users users);
}

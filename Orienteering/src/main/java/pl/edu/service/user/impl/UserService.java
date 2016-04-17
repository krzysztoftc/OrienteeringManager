package pl.edu.service.user.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.repository.user.IUserRepository;
import pl.edu.repository.user.Users;
import pl.edu.model.user.Role;
import pl.edu.model.user.User;
import pl.edu.service.user.IUserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService implements IUserService {

	private static final long serialVersionUID = -7007444203780713873L;

	@Autowired
	private IUserRepository userRepository;

	@Override
	public void delete(User user) {
		userRepository.delete(user);

	}

	@Override
	public void saveOrUpdate(User user) {
		userRepository.saveOrUpdate(user);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public boolean saveIfNew(User user) {
		return false;
	}

	@Override
	public List<User> list(Users users) {
		return userRepository.findAll().merge(users).list();
	}

	@Override
	public long count(Users users) {
		return userRepository.findAll().merge(users).count();
	}

	@Override
	public User uniqueObject(Users users) {
		return userRepository.findAll().merge(users).uniqueObject();
	}


	@Override
	public void register(User user) {
		//encryptPasswords(user);
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	private User getByEmail(String email) {
		Users u = userRepository.findAll().withEmail(email);
        User usr = u.uniqueObject();
        String str = "usr == null";
        if(usr != null){
            str = "email: "
                    + usr.getEmail()
                    + ", password: "
                    + usr.getPassword();
        }

        System.out.println(str);

        return usr;
	}

	/**
	 * Zwraca implementację {@link UserDetails} za pomocą loginu
	 */
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
		User user = getByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("");
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(),
				true,
				true,
				true,
				true,
				getAuthorities(user));
	}

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return loadUserByEmail(email);
	}

	/**
	 * Zwraca kolekcję {@link GrantedAuthority} na bazie zbioru {@link Role}
	 * użytkownika
	 * 
	 * @param user
	 * @return
	 */
	private Collection<? extends GrantedAuthority> getAuthorities(User user) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(Role.ROLE_USER.getCode()));
		return authorities;
	}

	@Override
	public User afterAuthentication(String email) {
		User user = userRepository.findAll().withEmail(email).uniqueObject();
		return user;
	}

	@Override
	public boolean exists(Users users) {
		User user = userRepository.findAll().merge(users).uniqueObject();
		userRepository.evict(user);
		return user != null;
	}
}

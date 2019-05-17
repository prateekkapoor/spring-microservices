package com.restful.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

	private static List<User> users = new ArrayList<User>();
	private static int userCount = 3;
	static {
		users.add(new User(1, "Prateek", new Date()));
		users.add(new User(2, "Vipn", new Date()));
		users.add(new User(3, "Nigam", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(Integer id) {
		Optional<User> useOptional = users.stream().filter(e -> e.getId().equals(id)).findAny();
		if (!useOptional.isPresent()) {
			throw new UserNotPresentException(String.format("userId- %s", id));
		}
		return useOptional.get();
	}

	public User deleteOne(Integer id) {
		Optional<User> useOptional = users.stream().filter(e -> e.getId().equals(id)).findAny();
		if (!useOptional.isPresent()) {
			throw new UserNotPresentException(String.format("userId- %s", id));
		}
		User deletedUser = useOptional.get();
		users.remove(deletedUser);
		return deletedUser;
	}
}

package eCommerceDemo.dataAccess.abstracts;

import java.util.List;

import eCommerceDemo.entites.concretes.User;

public interface UserDao {
	
	void add(User user);
	void delete(User user);
	void update(User user);
	List<User> getAll();
	boolean emailExist(User user);
}

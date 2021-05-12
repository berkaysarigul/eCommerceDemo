package eCommerceDemo.business.abstracts;

import java.util.List;

import eCommerceDemo.entites.concretes.User;

public interface UserService {
	void register(User user);
	void login(String email,String password);
	void registerGoogle();
	List<User> getAll();

}

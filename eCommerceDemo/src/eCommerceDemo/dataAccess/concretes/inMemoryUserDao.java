package eCommerceDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entites.concretes.User;

public class inMemoryUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();
	

	@Override
	public void add(User user) {
		users.add(user); 
		System.out.println("Kullanýcý eklendi : " + user.getName());
		
	}

	@Override
	public void delete(User user) {
		for (User _user : users) {
			if (_user.getId() == user.getId()) {
				users.remove(user);
				System.out.println("Kullanýcý silindi");
			}else {
				System.out.println("Böyle bir kullanýcý bulunamadý");
			}
		}
		
	}

	@Override
	public void update(User user) {
		
		
		
		
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

	@Override
	public boolean emailExist(User user) {
		for (User _user : users) {
			if (user.getEmail() == _user.getEmail()) {
				return false;
			}
		}
		return true;
	}
	

}

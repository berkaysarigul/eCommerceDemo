package eCommerceDemo.business.concretes;

import java.util.List;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.abstracts.CheckService;
import eCommerceDemo.core.abstracts.RegisterService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entites.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private CheckService checkService;
	private RegisterService registerService;
	
	

	public UserManager(UserDao userDao,CheckService checkService, RegisterService registerService) {
		super();
		this.userDao = userDao;
		this.checkService = checkService;
		this.registerService = registerService;
	}

	@Override
	public void register(User user) {
		if (checkService.checkPassword(user.getPassword()) == false) {
			System.out.println("Parolan�z�n 6 veya daha uzun karakterden olu�mas� gerekmektedir");
			return;
		}
		
		if (checkService.checkName(user.getName(), user.getLastName()) == false) {
			System.out.println("Ad ve soyad�n�z�n 2 veya daha uzun karakterden olu�mas� gerekmektedir");
			return;
		}
		
		if (checkService.checkEmail(user.getEmail()) == false) {
			System.out.println("L�tfen ge�erli bir Email adresi giriniz.");
			return;
		}
		if (userDao.emailExist(user) == false) {
			System.out.println("Bu e-posta adresi daha �nce kullan�lm��. L�tfen ba�ka bir e-posta adresi ile deneyiniz");
			return;
		}
		userDao.add(user);
		
	}

	@Override
	public void login(String email, String password) {
		for (User user : userDao.getAll()) {
			if (user.getEmail() == email && user.getPassword() == password) {
				System.out.println("giri� ba�ar�l� : " + user.getName());
				return;
			}
		}
		System.out.println("Hatal� e-posta veya �ifre girdiniz");
		
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void registerGoogle() {
		registerService.registerToSystem();
		
	}

}

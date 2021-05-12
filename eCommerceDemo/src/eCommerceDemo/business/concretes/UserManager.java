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
			System.out.println("Parolanýzýn 6 veya daha uzun karakterden oluþmasý gerekmektedir");
			return;
		}
		
		if (checkService.checkName(user.getName(), user.getLastName()) == false) {
			System.out.println("Ad ve soyadýnýzýn 2 veya daha uzun karakterden oluþmasý gerekmektedir");
			return;
		}
		
		if (checkService.checkEmail(user.getEmail()) == false) {
			System.out.println("Lütfen geçerli bir Email adresi giriniz.");
			return;
		}
		if (userDao.emailExist(user) == false) {
			System.out.println("Bu e-posta adresi daha önce kullanýlmýþ. Lütfen baþka bir e-posta adresi ile deneyiniz");
			return;
		}
		userDao.add(user);
		
	}

	@Override
	public void login(String email, String password) {
		for (User user : userDao.getAll()) {
			if (user.getEmail() == email && user.getPassword() == password) {
				System.out.println("giriþ baþarýlý : " + user.getName());
				return;
			}
		}
		System.out.println("Hatalý e-posta veya þifre girdiniz");
		
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

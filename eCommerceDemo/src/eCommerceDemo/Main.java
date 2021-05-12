package eCommerceDemo;


import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.concretes.CheckManager;
import eCommerceDemo.core.concretes.GoogleManagerAdapter;
import eCommerceDemo.dataAccess.concretes.inMemoryUserDao;
import eCommerceDemo.entites.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new inMemoryUserDao(), new CheckManager(), new GoogleManagerAdapter());
		
		
		System.out.println("############## Kay�t i�lemleri ###################");
		userService.register(new User(1,"Berkay","Sar�g�l","berkay@gmail.com","berkay000"));
		userService.register(new User(1,"Berkay","Sar�g�l","xkraltr","berkay"));
		userService.register(new User(1,"Engin","Demiro�","berkay@gmail.com","engin00"));
		userService.registerGoogle();
		
		System.out.println("############## giri� i�lemleri #################");
		userService.login("berkay@gmail.com", "berkay000");
		
	}

}

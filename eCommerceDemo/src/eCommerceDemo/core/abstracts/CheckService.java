package eCommerceDemo.core.abstracts;

public interface CheckService {
	
	boolean checkPassword(String password);
	boolean checkName(String name,String lastName);
	boolean checkEmail(String email);

}

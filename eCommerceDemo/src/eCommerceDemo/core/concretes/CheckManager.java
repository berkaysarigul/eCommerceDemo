package eCommerceDemo.core.concretes;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import eCommerceDemo.core.abstracts.CheckService;

public class CheckManager implements CheckService{
	
	public static final String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	@Override
	public boolean checkPassword(String password) {
		if (password.length() < 6) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkName(String name, String lastName) {
		if (name.length() < 2 || lastName.length() < 2) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkEmail(String email) {
		
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(!matcher.matches()) {
			return false;
		}
		return true;
	}

}

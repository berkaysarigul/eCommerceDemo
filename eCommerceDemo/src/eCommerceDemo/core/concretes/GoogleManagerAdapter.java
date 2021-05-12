package eCommerceDemo.core.concretes;

import eCommerceDemo.AuthGoogle.GoogleManager;
import eCommerceDemo.core.abstracts.RegisterService;

public class GoogleManagerAdapter implements RegisterService {

	@Override
	public void registerToSystem() {
		GoogleManager googleManager = new GoogleManager();
		googleManager.register();
		
	}

}

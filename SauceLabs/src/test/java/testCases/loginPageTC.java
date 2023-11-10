package testCases;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.loginPageMethods;

public class loginPageTC extends loginPageMethods{
	
	//loginPageMethods 
	
	@BeforeSuite()
	public void initialSetup() {
		setup();
	}
	
	@Test()
	public void loginTC_01() {
		new loginPageMethods()
		.inputEmaildId()
		.inputPassword()
		.login()
		.verifySuccessLogin();
	}
	

}

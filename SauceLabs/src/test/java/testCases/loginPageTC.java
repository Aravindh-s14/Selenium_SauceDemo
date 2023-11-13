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
	
	@Test(priority = 0)
	public void loginTC_01() {
		new loginPageMethods()
		.inputPassword("secret_sauce")
		.login()
		.noUsername();
	}
	
	@Test(priority=2)
	public void loginTC_02(){
		new loginPageMethods()
		.inputEmaild("standard_user")
		.inputPassword("")
		.login()
		.noPassword();
	}
	
	

}

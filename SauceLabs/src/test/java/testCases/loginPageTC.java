package testCases;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.loginPageMethods;

public class loginPageTC extends loginPageMethods{
	
	//loginPageMethods 
	
	@BeforeSuite()
	public void initialSetup() {
		setup();
	}
	
	//Able to login without username
	@Test(priority = 0)
	public void loginTC_01() {
		new loginPageMethods()
		.inputPassword("secret_sauce")
		.login()
		.noUsername();
	}
	
	//able to login without password
	@Test(priority=2)
	public void loginTC_02(){
		new loginPageMethods()
		.inputEmaild("standard_user")
		.inputPassword("")
		.login()
		.noPassword();
	}
	
	//able to login with invalid password
	@Test(priority=3)
	public void loginTC_03() {
		new loginPageMethods()
		.inputPassword("Password@123")
		.login()
		.invalidPassword();
	}
	
	//locked out user login
	@Test(priority=4)
	public void loginTC_04() {
		new loginPageMethods()
		.inputEmaild("locked_out_user")
		.inputPassword("secret_sauce")
		.login()
		.lockedOutUser();
		
	}
	
	//successfull login
	@Test(priority=5)
	public void loginTC_05() {
		new loginPageMethods()
		.inputEmaild("standard_user")
		.inputPassword("secret_sauce")
		.login();
	}
	
//	@AfterSuite()
//	public void close() {
//		driver.close();	
//	}

}

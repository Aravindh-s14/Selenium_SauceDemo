package testCases;

import org.testng.annotations.Test;

import pages.herokuApp;

public class herokuTestCase extends herokuApp{
	
	
	//login using the basic auth
	@Test(priority=0)
	public void Basic_Auth_Checking(){
		new herokuApp()
		.BasicAuth();
	}
	
	//login using the basic auth
	@Test(priority=1)
	public void Broken_Image_Checking(){
		new herokuApp()
		.brokenImage();
	}
	
	
}

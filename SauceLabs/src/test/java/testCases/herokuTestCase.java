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
	
	//login using the basic auth - This test case will fail
	@Test(priority=1)
	public void Broken_Image_Checking(){
		new herokuApp()
		.brokenImage();
	}
	
	//selecting a checkbox
	@Test(priority=2)
	public void checkbox_checking(){
		new herokuApp()
		.checkBox()
		.context_Alert();
	}
	
	//selecting a checkbox
	@Test(priority=3)
	public void contextAlert() {
		new herokuApp()
		.context_Alert();
	}
}

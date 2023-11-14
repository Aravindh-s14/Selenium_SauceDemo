package testCases;

import org.testng.annotations.Test;

import pages.herokuApp;

public class herokuTestCase extends herokuApp{
	
	@Test
	public void TC_01() throws InterruptedException {
		new herokuApp()
		.BasicAuth();
	}
	
}

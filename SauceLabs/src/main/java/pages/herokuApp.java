package pages;

import org.openqa.selenium.By;
import utitlities.commonUtilities;

public class herokuApp extends commonUtilities{
	
	public herokuApp BasicAuth() throws InterruptedException {
		String username = "admin";
		String password = "admin";
		
		String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
		driver.get(URL);
		System.out.println(URL);
		Thread.sleep(5000);
		return this;
	}
}



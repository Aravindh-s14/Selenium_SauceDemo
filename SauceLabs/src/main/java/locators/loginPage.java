package locators;

import org.openqa.selenium.By;

public class loginPage {
	public By emailId   = By.xpath("//input[@id='user-name']");
	public By password  = By.xpath("//input[@id='password']");
	public By sign_in   = By.xpath("//input[@id='login-button']");
}

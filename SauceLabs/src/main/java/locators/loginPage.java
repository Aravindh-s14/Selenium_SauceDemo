package locators;

import org.openqa.selenium.By;

public class loginPage {
	public By emailId   = By.xpath("//input[@id='user-name']");
	public By password  = By.xpath("//input[@id='password']");
	public By sign_in   = By.xpath("//input[@id='login-button']");
	
	public By error = By.xpath("//h3[@data-test='error']");
	public By productTitle = By.xpath("//span[text()='Products']");
	
	
}

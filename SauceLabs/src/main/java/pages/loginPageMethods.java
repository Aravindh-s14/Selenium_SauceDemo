package pages;

import org.testng.Assert;

import locators.loginPage;
import utitlities.commonUtilities;

public class loginPageMethods extends commonUtilities {
	loginPage loc = new loginPage();

	// input email
	public loginPageMethods inputEmaildId() {
		driver.findElement(loc.emailId).sendKeys("standard_user");
		return this;
	}

	public loginPageMethods inputPassword() {
		driver.findElement(loc.password).sendKeys("secret_sauce");
		return this;
	}

	public loginPageMethods login() {
		driver.findElement(loc.sign_in).click();
		return this;
	}
////////////////////////Assertion Methods///////////////////////////

	public loginPageMethods verifySuccessLogin() {
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/inventory.htm";
		Assert.assertEquals(actual, expected);
		return this;
	}
}

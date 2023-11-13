package pages;

import org.testng.Assert;

import locators.loginPage;
import utitlities.commonUtilities;
import java.awt.*;
import java.awt.event.KeyEvent;

public class loginPageMethods extends commonUtilities {
	loginPage loc = new loginPage();

	// input email
	public loginPageMethods inputEmaild(String emailId) {
		driver.findElement(loc.emailId).clear();
		driver.findElement(loc.emailId).sendKeys(emailId);
		return this;
	}

	public loginPageMethods inputPassword(String password) {

		driver.findElement(loc.password).click();
		try {
            Robot robot = new Robot();
            
            // Simulate Ctrl+A (select all)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Simulate Backspace (delete)
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);

            // Now, enter the new password
            driver.findElement(loc.password).sendKeys(password);

        } catch (AWTException e) {
            e.printStackTrace();
        }
		
		driver.findElement(loc.password).sendKeys(password);
		return this;
	}

	public loginPageMethods login() {
		driver.findElement(loc.sign_in).click();
		return this;
	}
	
////////////////////////Assertion Methods///////////////////////////

	public loginPageMethods verifySuccessLogin() {
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual, expected);
		return this;
	}
	
	public loginPageMethods noUsername() {
		String actual = driver.findElement(loc.noUsername).getText();
		String expected = "Epic sadface: Username is required";
		Assert.assertEquals(actual, expected);
		return this;
	}
	
	public loginPageMethods noPassword(){
		waitForElement(loc.error);
		String actual = driver.findElement(loc.error).getText();
		Assert.assertTrue(actual.contains("Password is required"));
		return this;
	}
}

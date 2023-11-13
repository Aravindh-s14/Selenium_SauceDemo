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
		driver.findElement(loc.emailId).click();
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
            driver.findElement(loc.emailId).sendKeys(emailId);

        } catch (AWTException e) {
            e.printStackTrace();
        }
		
		//driver.findElement(loc.emailId).sendKeys(emailId);
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
		
		//driver.findElement(loc.password).sendKeys(password);
		return this;
	}

	public loginPageMethods login() {
		driver.findElement(loc.sign_in).click();
		return this;
	}
	
////////////////////////Assertion Methods///////////////////////////
	
	public loginPageMethods successLogin() {
		waitForElement(loc.productTitle);
		String actual = driver.findElement(loc.productTitle).getText();
		String expected = "Products";
		Assert.assertEquals(actual, expected);
		return this;
	}
	
	public loginPageMethods verifySuccessLogin() {
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual, expected);
		return this;
	}
	
	public loginPageMethods noUsername() {
		String actual = driver.findElement(loc.error).getText();
		String expected = "Epic sadface: Username is required";
		Assert.assertTrue(actual.contains("Username is required"));
		return this;
	}
	
	public loginPageMethods noPassword(){
		waitForElement(loc.error);
		String actual = driver.findElement(loc.error).getText();
		Assert.assertTrue(actual.contains("Password is required"));
		return this;
	}
	
	public loginPageMethods invalidPassword() {
		waitForElement(loc.error);
		String actual = driver.findElement(loc.error).getText();
		Assert.assertTrue(actual.contains("Username and password do not match any user in this service"));
		return this;
	}
	
	public loginPageMethods lockedOutUser() {
		waitForElement(loc.error);
		String actual = driver.findElement(loc.error).getText();
		Assert.assertTrue(actual.contains("Sorry, this user has been locked out."));
		return this;
	}
}

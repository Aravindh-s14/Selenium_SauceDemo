package utitlities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class commonUtilities {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public static void setup() {
		ChromeOptions c = new ChromeOptions();
		//c.addArguments("--headless");
		c.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(c);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public WebElement waitForElement(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}

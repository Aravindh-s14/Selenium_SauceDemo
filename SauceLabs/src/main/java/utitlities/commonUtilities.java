package utitlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class commonUtilities {
	public static WebDriver driver;
	
	
	public static void setup() {
		ChromeOptions c = new ChromeOptions();
		//c.addArguments("--headless");
		c.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(c);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

}

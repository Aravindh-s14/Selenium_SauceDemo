package pages;

import java.util.Arrays;
import java.util.List;
import locators.productPage;
import utitlities.commonUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class productMethods extends commonUtilities {

	productPage loc = new productPage();
	
	//print all product name
	public productMethods allProduct() {
		List<WebElement> names = driver.findElements(loc.productName);
		for (WebElement each : names) {
			String currentName = each.getText();
			//System.out.println(currentName);
		}
		return this;
	}
	
	//verify whether all the products are listed or not
	public productMethods verifyAll() {
		List<WebElement> names = driver.findElements(loc.productName);
		String[] expected = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};
		int T=1;
		for(int i=0;i<names.size();i++) {
			String actual = names.get(i).getText();
			System.out.println(actual);
			
			List finql = Arrays.asList(expected);
			
			if(!finql.contains(actual)) {
				T=2;
				Assert.assertEquals(T, 1);
			}
		}
		Assert.assertEquals(T, 1);
		return this;
	}
	
	public productMethods addToCart(String productName) {
		List<WebElement> names = driver.findElements(loc.productName);
		for(int i=0;i<names.size();i++) {
			String currentName = names.get(i).getText();
			if(currentName.equals(productName)) {
				driver.findElements(By.xpath("//button[text()='Add to cart']")).get(i).click();
			}
		}
		return this;
	}
	
	public productMethods testethod() {
		int i;
		for(i=0;i<3;i++) {
			//String currentName = names.get(i).getText();
			//if(currentName.equals(productName)) {
				driver.findElements(By.xpath("//button[text()='Add to cart']")).get(i).click();
			//}
				
				
		}
		int count = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		System.out.println(count);
		if(count==4) {
			System.out.println("Same value");
		}
		else {
			System.out.println(i+1);
		}
		return this;
	}
}

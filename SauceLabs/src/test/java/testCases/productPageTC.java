package testCases;

import org.testng.annotations.Test;

import pages.productMethods;

public class productPageTC extends productMethods{
	
	//list all products in the page
	@Test(priority=0)
	public void productTC_01(){
		new productMethods()
		.allProduct();
	}
	
	@Test(priority=1)
	public void productTC_02(){
		new productMethods()
		.verifyAll();
	}
	
	//add specific product to cart
	@Test(priority=2)
	public void productTC_03() {
		new productMethods()
		.addToCart("Sauce Labs Fleece Jacket");
	}
	
	@Test(priority=3)
	public void productTC_04() {
		new productMethods()
		.removefromCart();
	}
}

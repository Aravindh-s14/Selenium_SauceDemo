package testCases;

import org.testng.annotations.Test;

import pages.productMethods;

public class productPageTC extends productMethods{
	
	//list all products in the page
	@Test(priority=0)
	public void productTC_01(){
		new productMethods()
		.allProduct()
		.verifyAll();
	}
	
	//add specific product to cart
	@Test(priority=1)
	public void productTC_02() {
		new productMethods()
		.addToCart("Sauce Labs Fleece Jacket")
		.removefromCart();
	}
}

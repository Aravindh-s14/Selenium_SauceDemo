package pages;

import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import utitlities.commonUtilities;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class herokuApp extends commonUtilities {

	// accessing page using basic login
	public herokuApp BasicAuth() {
		String username = "admin";
		String password = "admin";

		String URL = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
		driver.get(URL);
		waitForElement(By.xpath("//h3[text()='Basic Auth']"));
		String expected = "Congratulations! You must have the proper credentials.";
		String actual = driver.findElement(By.xpath("//p")).getText();
		Assert.assertEquals(expected, actual);
		return this;
	}

	// Checking if there are any broken images in a page, using the reponse code of
	// all the images SRC
	public herokuApp brokenImage() {
		driver.get("https://the-internet.herokuapp.com/broken_images");
		waitForElement(By.xpath("//h3"));
		int iBrokenImageCount = 0;
		String status;

		try {
			iBrokenImageCount = 0;
			List<WebElement> image_list = driver.findElements(By.xpath("//img"));
			for (WebElement img : image_list) {
				if (img != null) {
					CloseableHttpClient client = HttpClients.createDefault();
					HttpGet request = new HttpGet(img.getAttribute("src"));

					try (CloseableHttpResponse response = client.execute(request)) {
						// For valid images, the HttpStatus will be 200
						if (response.getStatusLine().getStatusCode() != 200) {
							System.out.println(img.getAttribute("outerHTML") + " is broken.");
							iBrokenImageCount++;
							Assert.assertEquals(iBrokenImageCount, 0);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failed";
			System.out.println(e.getMessage());
		}
		status = "passed";
		System.out.println("The page " + iBrokenImageCount + "broken images");
		return this;
	}

	public herokuApp checkBox() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		waitForElement(By.xpath("//h3[normalize-space()='Checkboxes']"));

		WebElement checkBox1 = driver.findElement(By.xpath("//form//input[1]"));
		// boolean isSelected = checkBox1.isSelected();
		checkBox1.click();
		if (checkBox1.isSelected()) {
			System.out.println("Clicked");
			Assert.assertEquals("Checkbox Checked", "Checkbox Checked");
		} else {
			Assert.assertEquals("Unchecked", "Checked");
		}
		return this;
	}

	// context menu clicking and handling the alert
	public herokuApp context_Alert() {
		driver.get("https://the-internet.herokuapp.com/context_menu");
		waitForElement(By.xpath("//h3"));

		Actions actions = new Actions(driver);
		WebElement div_box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		actions.contextClick(div_box).perform();
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
		return this;
	}

	public herokuApp handling_ad() {
		driver.get("https://the-internet.herokuapp.com/entry_ad");
		waitForElement(By.xpath("//h3"));
		driver.findElement(By.xpath("//p[text()='Close']")).click();
		return this;
	}

	// Method to drag an element from one location to another.

	public herokuApp drag_drop() {
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		WebElement from = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement to = driver.findElement(By.xpath("//div[@id='column-b']"));

		/* Method 1 to drag and drop */
		/*
		 * Actions action = new Actions(driver); action.dragAndDrop(from,
		 * to).build().perform(); Assert.assertEquals(from.getText(), "B");
		 */

		/* Method 2 to drag and drop */
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
		dragAndDrop.perform();
		Assert.assertEquals(from.getText(), "B");

		return this;
	}

	//to fetch value from a dropdown and assert.
	public herokuApp dropdown() {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement drop = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select dropdown = new Select(drop);
		dropdown.selectByVisibleText("Option 2");
		String actual = dropdown.getFirstSelectedOption().getText();
		System.out.println(actual);
		Assert.assertEquals(actual, "Option 2");
		return this;
	}
}

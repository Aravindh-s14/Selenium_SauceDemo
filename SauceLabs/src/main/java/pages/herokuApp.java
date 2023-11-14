package pages;

import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.HttpClient;
import org.testng.Assert;
import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import utitlities.commonUtilities;

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
}

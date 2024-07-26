package maven.test.Bhaane;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
	
	WebDriver driver;
    String url = "https://www.bhaane.com/";
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProductDetails(String productName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement product = driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]/parent::div"));
		product.click();
	
		//verify product details webpage opens
		WebElement productHeading = driver.findElement(By.tagName("h1"));
		System.out.println(productHeading.getText() +" pr-"+productName);
		assertTrue(productHeading.getText().equals(productName));
	
		
	}

}

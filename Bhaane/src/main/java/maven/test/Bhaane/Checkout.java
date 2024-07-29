package maven.test.Bhaane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout {
	WebDriver driver;
	public Checkout(WebDriver driver) {
		this.driver = driver;
	}
	
	public void proceedCheckout() {
		WebElement bagIcon= driver.findElement(By.xpath("//li[@data-modal=\"#modal-bag\"]"));
		bagIcon.click();
		WebElement gotocart = driver.findElement(By.xpath("//a[text()='go to cart']"));
		gotocart.click();
		
		
	}
}

package maven.test.Bhaane;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToBag {

	WebDriver driver;
	public AddToBag(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void selectSize(String size) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement wbSize = driver.findElement(By.xpath("//div[contains(@class,'variants')]//span[contains(text(),'"+size+"')]"));
		wbSize.click();
		
	}
	
	public void clickaddToBag() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[1])[5]")));
		WebElement element = driver.findElement(By.xpath("(//button[1])[5]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		element.click();
		Thread.sleep(3000);
	}
	
	public void verifyGoToCart() {
		WebElement btnGoToCart = driver.findElement(By.xpath("//a[text()='go to cart']"));
		assertTrue(btnGoToCart.isDisplayed());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(btnGoToCart));
		btnGoToCart.click();
		
		
	}
}

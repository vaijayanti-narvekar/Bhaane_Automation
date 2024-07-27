package maven.test.Bhaane;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CartPage {

	WebDriver driver;
    String url = "https://www.bhaane.com/";
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickgoToCart() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		WebElement carticon = driver.findElement(By.xpath("//li[@data-modal='#modal-bag']"));
		carticon.click();
		Thread.sleep(2000);
		WebElement btngotocart = driver.findElement(By.xpath("//a[contains(@href,'cart')]"));
		btngotocart.click();
	}
	
	public void changeQuantity(int quantity, String product) throws InterruptedException {
		Thread.sleep(2000);
		WebElement webQty = driver.findElement(By.xpath("(//div[text()='"+product+"']/ancestor::div[2])[2]//input"));
		WebElement increment = driver.findElement(By.xpath("(//div[text()='"+product+"']/ancestor::div[2])[2]//div[contains(@class,'increment')]"));
		WebElement decrement = driver.findElement(By.xpath("(//div[text()='"+product+"']/ancestor::div[2])[2]//div[contains(@class,'decrement')]"));
		
		int qty = Integer.parseInt(webQty.getAttribute("value"));
		if(quantity > qty) {
			while(qty!=quantity) {
				increment.click();
				Thread.sleep(2000);
				qty++;
			}
			
			
		}
		else {
			while(qty!=quantity) {
				decrement.click();
				Thread.sleep(2000);
				qty--;
			}
		}
		
		assertEquals(Integer.parseInt(webQty.getAttribute("value")), quantity);
	}
	
	public void clickOnCheck() {
		WebElement btnCheckout = driver.findElement(By.xpath("//button[text()='checkout']"));
		btnCheckout.click();
				
	}
	
}


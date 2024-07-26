package maven.test.Bhaane;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckFilter {
	
	WebDriver driver;
    String url = "https://www.bhaane.com/";
	public CheckFilter(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyFilterPage(String filter) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		WebElement filterName = driver.findElement(By.xpath("//a/span[text()='"+filter+"']"));
		filterName.click();
		assertTrue(driver.getCurrentUrl().endsWith(filter));
		
	}

}

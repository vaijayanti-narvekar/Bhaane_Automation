package maven.test.Bhaane;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {
	 WebDriver driver;
	    
		public Logout(WebDriver driver) {
			this.driver = driver;
		}
		
		public void userLogout() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement logout = driver.findElement(By.xpath("//a[text()='log out']"));
			logout.click();
			assertTrue(driver.findElement(By.xpath("//li[text()='account']")).isDisplayed());
		}
}

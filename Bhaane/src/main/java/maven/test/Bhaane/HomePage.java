package maven.test.Bhaane;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    String url = "https://www.bhaane.com/";
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateWebPage() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
	
	public void verifyUserLogin(String first) {
		// TODO Auto-generated method stub
				
		WebElement userID = driver.findElement(By.xpath("(//a[contains(@href,'customer/account')])[2]"));
		System.out.println(userID.getText());
		assertTrue(userID.getText().equalsIgnoreCase(first));
		
		
	}

}

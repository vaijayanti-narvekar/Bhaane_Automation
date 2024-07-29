package maven.test.Bhaane;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    WebDriver driver;
    
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	String url = "https://www.bhaane.com/";
	public void navigateWebPage() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
	
	
	
	public void login(String mail, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(driver.findElement(By.cssSelector(".cross_sign.md")).isDisplayed()) {
    		driver.findElement(By.cssSelector(".cross_sign.md")).click();
    	} 
		
		WebElement account = driver.findElement(By.xpath("//li[text()='account']"));
		account.click();
		
		WebElement email = driver.findElement(By.cssSelector("input[type='email']"));
		email.sendKeys(mail);
		
		WebElement pass = driver.findElement(By.cssSelector("input[type='password']"));
		pass.sendKeys(password);
		
		WebElement btnSubmit = driver.findElement(By.cssSelector("button[type='submit']"));
		btnSubmit.click();
	
	}
}

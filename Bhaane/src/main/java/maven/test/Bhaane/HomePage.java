package maven.test.Bhaane;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

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
	
	public void checkSocialMedia(String media) throws InterruptedException {
		
		if(driver.findElement(By.cssSelector(".cross_sign.md")).isDisplayed()) {
    		driver.findElement(By.cssSelector(".cross_sign.md")).click();
    	}
		WebElement social = driver.findElement(By.xpath("//a[contains(@href,'"+media+"')]"));
		social.click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String nextWindow="";
		if(it.hasNext()) {
			     nextWindow = it.next();
			     System.out.println("window "+nextWindow);
		}
		
		
		driver.switchTo().window(nextWindow);
		System.out.println(driver.getCurrentUrl());
		assertTrue(driver.getCurrentUrl().contains(media));
		driver.close();
		driver.switchTo().window(parent);
		
		
	}

}

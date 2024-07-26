package maven.test.Bhaane;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signup {

    WebDriver driver;
    String url = "https://www.bhaane.com/";
	public Signup(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateWebPage() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
	
	public void signupUser(String first, String last, String mail, String mobNo, String pass,boolean makeUsernameDynamic) throws InterruptedException {
		// TODO Auto-generated method stub
		
    	
    	if(driver.findElement(By.cssSelector(".cross_sign.md")).isDisplayed()) {
    		driver.findElement(By.cssSelector(".cross_sign.md")).click();
    	} 	
    			
    	String test_data_email;
        if (makeUsernameDynamic)
            // Concatenate the timestamp to string to form unique timestamp
            test_data_email = String.valueOf(java.time.LocalTime.now())+mail;
        else
            test_data_email = mail;
    	
		WebElement account = driver.findElement(By.xpath("//li[text()='account']"));
		account.click();
		
		WebElement signupbtn = driver.findElement(By.xpath("//div[text()='sign up >']"));
		signupbtn.click();
		
		WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));
		WebElement lastName = driver.findElement(By.cssSelector("input[name='last_name']"));
		WebElement email = driver.findElement(By.xpath("(//input[@name='email'])[3]"));
		WebElement mob = driver.findElement(By.cssSelector("input[name='mobile']"));
		WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[2]"));
		
		firstName.sendKeys(first);
		lastName.sendKeys(last);
		email.sendKeys(test_data_email.split(":")[2]);
		Thread.sleep(2000);
		mob.sendKeys(mobNo);
		Thread.sleep(2000);
		password.sendKeys(pass);
		
		WebElement submit = driver.findElement(By.xpath("(//button[text()='submit'][1])[2]"));
		submit.click();
		
		WebElement userID = driver.findElement(By.xpath("(//a[contains(@href,'customer/account')])[2]"));
		System.out.println(userID.getText());
		assertTrue(userID.getText().equalsIgnoreCase(first));
		
		
	}

}

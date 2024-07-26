package maven.test.Bhaane;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
	static WebDriver driver;
	
	public App(WebDriver driver){
		this.driver = driver;
	}
	
    public static void homepage()
    {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
    }
}

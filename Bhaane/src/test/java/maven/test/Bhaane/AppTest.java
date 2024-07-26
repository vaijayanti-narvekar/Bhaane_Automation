package maven.test.Bhaane;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AppTest {
	
	static WebDriver driver;
	
	@BeforeSuite	
	 public WebDriver createDriver() throws MalformedURLException {
	     
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();

	        return driver;
	    }
	String firstname = "FirstName"; 
	String lastname =" lastName";
	String mail= "testSample@mail.com";
	String mobNo = "9876543210"; 
	String password = "password234";
	String filter = "bottoms";
	String productName = "ecole pants";
	String size = "30";
	
	@Test(priority =1,description = "Verify Sign Up")
	public void TestCase01() throws InterruptedException {	
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 Signup signup = new Signup(driver);
		 signup.navigateWebPage();
		 signup.signupUser(firstname, lastname, mail, mobNo, password,true);
		 
		 HomePage homepage = new HomePage(driver);
		 homepage.verifyUserLogin(firstname);
		 
 	    }
	
	@Test(priority=2,description = "Verify Login")
	public void TestCase02() {
		
		Login login = new Login(driver);
		login.navigateWebPage();
		
		login.login(mail, password);	
		
	}
	
	@Test(priority = 3, description = "Verify Filter Page")
	public void TestCase03() throws InterruptedException {
		
		CheckFilter check = new CheckFilter(driver);
		check.verifyFilterPage(filter);
		
				
	}
	
	@Test(priority = 4, description = "Verify Product Details Page")
	public void TestCase04() throws InterruptedException {
		
		ProductDetailsPage details = new ProductDetailsPage(driver);
		details.openProductDetails(productName);
				
	}
	
	@Test(priority = 5, description = "Verify Product Details Page")
	public void TestCase05() throws InterruptedException {
		
		AddToBag addtobag = new AddToBag(driver);
		addtobag.selectSize(size);
		addtobag.clickaddToBag();
		addtobag.verifyGoToCart();
				
	}
	
	@Test(priority = 6, description = "Verify Logout")
	public void TestCase06() throws InterruptedException {
		
		Logout logout = new Logout(driver);
		logout.userLogout();
				
	}
	
	
	 @AfterSuite
	    public void closeDriver() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	 
	 
	
   }

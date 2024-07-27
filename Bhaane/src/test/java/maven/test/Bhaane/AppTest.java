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
	String firstname = "FirstName"; 
	String lastname =" lastName";
	String mail= "testSample@mail.com";
	String mobNo = "9876543210"; 
	String password = "password234";
	String filter = "dresses";
	String productName = "daphne dress";
	String size = "l";
	
	
	@BeforeSuite	
	 public WebDriver createDriver() throws MalformedURLException {
	     
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	        return driver;
	    }
	
	
	@Test(priority =1,description = "Verify Sign Up")
	public void TestCase01() throws InterruptedException {	
			 
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
	
	@Test(priority = 5, description = "Check Go to Cart")
	public void TestCase05() throws InterruptedException {
		
		AddToBag addtobag = new AddToBag(driver);
		addtobag.selectSize(size);
		addtobag.clickaddToBag();
		addtobag.verifyGoToCart();
				
	}
	@Test(priority = 6, description= "Increment the product quantity on cart page")
	public void TestCase06() throws InterruptedException {
		
		CartPage cartpage = new CartPage(driver);
		cartpage.clickgoToCart();
		cartpage.changeQuantity(3, productName);	
		
	}
	
	@Test(priority = 7, description= "Decrement the product quantity on cart page")
	public void TestCase07() throws InterruptedException {
		
		CartPage cartpage = new CartPage(driver);
		cartpage.clickgoToCart();
		cartpage.changeQuantity(1, productName);	
		
	}
	
	
	@Test(priority = 8, description = "Verify Logout")
	public void TestCase08() throws InterruptedException {
		
		Logout logout = new Logout(driver);
		logout.userLogout();
				
	}
	
	
     @Test(priority = 9,description = "Check Facebook page")
    public void TestCase09() throws InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		homepage.navigateWebPage();
		homepage.checkSocialMedia("facebook");
		
	}

    @Test(priority = 10,description = "Check Instagram page")
    public void TestCase10() throws InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		homepage.navigateWebPage();
		homepage.checkSocialMedia("instagram");
		
	}
	
   	 @AfterSuite
	    public void closeDriver() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	 
	 
	
   }

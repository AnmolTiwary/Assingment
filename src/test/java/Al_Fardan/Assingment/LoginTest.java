package Al_Fardan.Assingment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	    WebDriver driver;
	    LoginPage loginPage;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        loginPage = new LoginPage(driver);
	        loginPage.gotoLoginPage();
	    }

	    @Test(dataProviderClass = LoginTestData.class, dataProvider = "validCredentials")
	    public void testValidLogin(String username, String password) throws InterruptedException {
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        loginPage.clickSigninButton();
	        String title = driver.getTitle();
	        Assert.assertEquals(title,"Alfardan");
	        Thread.sleep(5000);
	        loginPage.logOut();
	        
	    }

	    @Test(dataProviderClass = LoginTestData.class, dataProvider = "invalidCredentials")
	    public void testInvalidLogin(String username, String password) {
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        loginPage.clickSigninButton();
	        String errorMessage = loginPage.getErrorMessage();
	        Assert.assertTrue(
	            errorMessage.contains("Incorrect username or password.") || 
	            errorMessage.contains("The username field is required.") ||
	            errorMessage.contains("The username field is required.") ||
	            errorMessage.contains("The username field must not be greater than 25 characters.")
	        );
	        loginPage.clearUserPass();

	    }

	   @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}




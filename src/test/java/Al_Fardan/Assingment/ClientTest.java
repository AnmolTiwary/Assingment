package Al_Fardan.Assingment;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClientTest {
	WebDriver driver;
	ClientAndBoiler home;
	ClientPage client;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Listners listener = new Listners(driver);
		home = new ClientAndBoiler(driver);
		client = new ClientPage(driver);
		home.gotoLoginPage();

		home.login();
		home.gotoClient();
		
	}

	@Test(dataProviderClass = ClientTestData.class, dataProvider = "allInfo", description = "Test adding a client with all information")
	public void validInfo(Map<String, String> clientData) {
		home.gotoClient();
		home.add();
		client.addClient(clientData);
		client.saveClient();
		List<String> companyNames = client.getCompanyNames();
		String expectedCompanyName = clientData.get("Company");
		boolean isCompanyPresent = false;

		for (String companyName : companyNames) {
			if (companyName.equals(expectedCompanyName)) {
				isCompanyPresent = true;
				break;
			}
		}

		Assert.assertTrue(isCompanyPresent, "Company name not found in the list: " + expectedCompanyName);
	}

	@Test(dataProviderClass = ClientTestData.class, dataProvider = "mandatoryInfo", description = "Test adding a client with mandatory information")
	public void mandatoryInfo(Map<String, String> clientData) {
		home.gotoClient();
		home.add();
		client.addClient(clientData);
		client.saveClient();
		List<String> companyNames = client.getCompanyNames();
		String expectedCompanyName = clientData.get("Company");
		boolean isCompanyPresent = false;

		for (String companyName : companyNames) {
			if (companyName.equals(expectedCompanyName)) {
				isCompanyPresent = true;
				break;
			}
		}

		Assert.assertTrue(isCompanyPresent, "Company name not found in the list: " + expectedCompanyName);
	}
	
	@Test(dataProviderClass = ClientTestData.class, dataProvider = "allInfo")
	public void testAddDuplicateClient(Map<String, String> clientData) {
	    home.gotoClient();
	    home.add();
	    client.addClient(clientData);
	    client.saveClient();
	    Assert.assertTrue(client.errorMessage().contains("been taken"));
	}
	
	@Test(dataProviderClass = ClientTestData.class, dataProvider = "specialCharacters")
	public void testSpecialCharacters(Map<String, String> clientData) {
	    home.gotoClient();
	    home.add();
	    client.addClient(clientData);
	    client.saveClient();
	    Assert.assertTrue(client.errorMessage().contains("Please enter"));	}

	@Test(dataProviderClass = ClientTestData.class, dataProvider = "longFieldsData")
	public void testLongFields(Map<String, String> clientData) {
	    home.gotoClient();
	    client.addClient(clientData);
	    client.saveClient();
	    Assert.assertTrue(client.isErrorMessageVisible(), "Error message for long fields is not visible.");
	}

	
	// Test Case 07: Add Client (with Empty Fields)
		@Test
		public void testAddClientWithEmptyFields() {
		    home.gotoClient();
		    home.add();
		    client.saveClient();
		    Assert.assertTrue(client.errorMessage().contains("Please enter"));
		}
	
	@Test
	public void editClient() throws InterruptedException {
		home.gotoClient();
		client.checkBox();
		home.edit();
		client.companyNameInput.clear();
		client.companyNameInput.sendKeys("randomcompa");
		client.saveClient();
		Thread.sleep(3000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement successMessage = (WebElement) jsExecutor.executeScript
        		("return document.querySelector('strong.fl-title');");
		Assert.assertTrue(successMessage.isDisplayed(), "Element is not visible.");
	}
	
	@Test
	public void editDuplicateClient() {
		home.gotoClient();
		client.checkBox();
		home.edit();
		client.companyNameInput.clear();
		client.companyNameInput.sendKeys("vcasycoas");
		client.saveClient();		
		Assert.assertEquals(client.errorMessage(), "The company name has already been taken.");
	}
	
	// Test Case 12: Edit Client (Special Characters)
	@Test
	public void testEditClientWithSpecialCharacters() {
	    home.gotoClient();
	    client.checkBox();
	    home.edit();
	    String specialCharacters = "!@#$%^";
	    client.companyNameInput.sendKeys(specialCharacters);
	    client.saveClient();
	    Assert.assertTrue(client.errorMessage.isDisplayed(), "Error message for special characters is not visible.");
	}
	
	// Test Case 13: Edit Client (Long Fields)
		@Test
		public void testEditClientWithLongFields() {
		    home.gotoClient();
		    client.checkBox();
		    home.edit();
		    String longText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit..."; // Replace with a long text
		    client.companyNameInput.sendKeys(longText);
		    client.saveClient();
		    Assert.assertTrue(client.errorMessage.isDisplayed(), "Error message for long fields is not visible.");
		}
	
	@Test
	public void clientStatusChange1() throws InterruptedException {
		home.gotoClient();
		client.checkBox();
		home.edit();
		client.clientStatusChange();
		client.saveClient();
		Thread.sleep(3000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement successMessage = (WebElement) jsExecutor.executeScript
        		("return document.querySelector('strong.fl-title');");
		Assert.assertTrue(successMessage.isDisplayed(), "Element is not visible.");
		}
	
	@Test
	public void deleteClient() throws InterruptedException {
		home.gotoClient();
		client.checkBox();
		home.delete();
		client.delconfermation.click();
		Thread.sleep(3000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement delMessage = (WebElement) jsExecutor.executeScript
        		("return document.getElementById('swal2-html-container');");		
		Assert.assertTrue(delMessage.getText().
				contains("Client has been deleted."), "Element is not visible.");
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void deleteMultipleClient() throws InterruptedException {
		home.gotoClient();
		client.checkBox();
		home.groupDel.click();
		client.delconfermation.click();
		Thread.sleep(3000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement delMessage = (WebElement) jsExecutor.executeScript
        		("return document.getElementById('swal2-html-container');");		
		Assert.assertTrue(delMessage.getText().
				contains("Client has been deleted."), "Element is not visible.");
		driver.switchTo().alert().dismiss();
	}

	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

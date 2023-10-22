package Al_Fardan.Assingment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientAndBoiler extends LoginPage{
	
	WebDriver driver;
	public ClientAndBoiler(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"navbar-nav\"]/li[1]/a/span")
	WebElement client;
	
	@FindBy(xpath = "//*[@id=\"navbar-nav\"]/li[2]/a/span")
	WebElement boiler;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/a")
	WebElement addButton;
	
	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[2]/td/ul/li/span[2]/span[2]/a")
	WebElement editButton;
	
	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[8]/span[3]/a")
	WebElement deleteButton;
	
	@FindBy(xpath = "//*[@id=\"active-btn-common\"]/a[1]")
	WebElement groupDel;
	
	public void login () {
		enterUsername("Automationuser");
		enterPassword("Testing@123");
		clickSigninButton();
	}
	
	public void gotoClient() {
		client.click();
	}
	
	public void gotoBoiler() {
		boiler.click();
	}
	
	public void add() {
		addButton.click();
	}
	
	public void edit() {
		editButton.click();
	}
	
	public void delete() {
		deleteButton.click();
	}
}


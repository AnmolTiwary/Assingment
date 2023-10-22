package Al_Fardan.Assingment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClientPage {

	    WebDriver driver;

	    @FindBy(id = "company_name")//imp
	    WebElement companyNameInput;

	    @FindBy(name = "first_name")//imp
	    WebElement firstNameInput;

	    @FindBy(id = "last_name")
	    WebElement lastNameInput;

	    @FindBy(id = "email")//imp
	    WebElement emailInput;

	    @FindBy(id = "mobile_number")//imp
	    WebElement mobileInput;

	    @FindBy(id = "trn")//imp
	    WebElement trnInput;

	    @FindBy(id = "address")
	    WebElement addressInput;

	    @FindBy(id = "city")
	    WebElement cityInput;

	    @FindBy(id = "select2-country-container")
	    WebElement countryInput;
	    
	    @FindBy(id ="select2-country-result-2gwm-1")
	    WebElement uae;

	    @FindBy(id = "select2-state-container")
	    WebElement stateInput;

	    @FindBy(id = "zipcode")
	    WebElement zipCodeInput;
	    
	    @FindBy(id ="save_client")
	    WebElement save;
	    
	    @FindBy(css ="a.btn.cancel-btn")
	    WebElement cancel;
	    
	    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[2]")
	    List<WebElement> companyNames;
	    
	    @FindBy(xpath = "//*[@id=\"DataTables_Table_0_next\"]/a")
	    WebElement nextButton;

	    @FindBy(css= "span.text-danger")
	    WebElement errorMessage;
	    
	    @FindBy(id ="select2-is_status-container")
	    WebElement status;
	    
	    @FindBy(xpath = "//*[@id=\"select2-is_status-result-ave1-0\"]")
	    WebElement inactive;
	    
	    @FindBy(xpath = "/html/body/div[6]/div/div[6]/button[1]")
	    WebElement delconfermation;
	    
	    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td/input")
	    WebElement checkbox;
	    
	    public ClientPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void addClient(Map<String, String> clientData) {
	        companyNameInput.sendKeys(clientData.get("Company"));
	        firstNameInput.sendKeys(clientData.get("First Name"));
	        lastNameInput.sendKeys(clientData.get("Last Name"));
	        emailInput.sendKeys(clientData.get("Email"));
	        mobileInput.sendKeys(clientData.get("Mobile"));
	        trnInput.sendKeys(clientData.get("TRN"));
	        addressInput.sendKeys(clientData.get("Address"));
	        cityInput.sendKeys(clientData.get("City"));
	        
	        zipCodeInput.sendKeys(clientData.get("ZIP Code"));
	    }
	    
	    public boolean isErrorMessageVisible() {
	        try {
	            return errorMessage.isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
	    
	    public void clientStatusChange() {
	        Select statusDropdown = new Select(status);
	        statusDropdown.selectByIndex(1);
	    }
	    
	    public void checkBox() {
	    	checkbox.click();
	    }
	    
	    public String errorMessage()
	    {
	    	String message = errorMessage.getText();
	    	return message;
	    }
	    
	    public void selectCountry()
	    {
	    	countryInput.click();
	    	uae.click();
	    	
	    }
	    
	    public void saveClient()
	    {
	    	save.click();
	    }
	    
	    public void cancleSave() {
	    	cancel.click();
	    }
	    
	    public List<String> getCompanyNames() {
	        List<String> names = new ArrayList<>();

	        for (WebElement element : companyNames) {
	            names.add(element.getText());
	        }

	        return names;
	    }

	}


package Al_Fardan.Assingment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	    @FindBy(id = "username")
	    WebElement usernameInput;

	    @FindBy(id = "password-input")
	    WebElement passwordInput;

	    @FindBy(xpath = "//div[3]/button")
	    WebElement signinButton;

	    @FindBy(xpath = "//div[4]/a[2]")
	    WebElement resetPassword;
	    
	    @FindBy(xpath = "//div[4]/a[1]")
	    WebElement forgotPassword;
	    
	    @FindBy(css = ".text-danger")
	    WebElement errorMessage;
	    
	    @FindBy(xpath = "//*[@id=\"page-header-user-dropdown\"]/span[1]")
	    WebElement automation;
	    
	    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/div[3]/div/form")
	    WebElement logout;

	    public void gotoLoginPage() {
	    	driver.get("https://alfardantest.hexagon.tools/public/");
	    }

	    public void enterUsername(String username) {
	        usernameInput.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        passwordInput.sendKeys(password);
	    }
	    
	    public void clearUserPass() {
	    	usernameInput.clear();
	    	passwordInput.clear();
	    }

	    public void clickSigninButton() {
	    	signinButton.click();
	    }

	    public String getErrorMessage() {
	        return errorMessage.getText();
	    }
	    
	    public void logOut() {
	    	automation.click();
	    	logout.click();
	    }
	    
	}



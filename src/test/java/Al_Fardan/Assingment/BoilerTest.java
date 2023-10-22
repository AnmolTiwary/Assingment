package Al_Fardan.Assingment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BoilerTest {
	WebDriver driver;
	ClientAndBoiler boiler;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        boiler = new ClientAndBoiler(driver);
        boiler.gotoLoginPage();
    }

}

package Al_Fardan.Assingment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {
    

	WebDriver driver;
	public Listners(WebDriver driver) {
		this.driver =driver;
	}
	
    //@Override
    public void onTestStart(ITestResult result) {
        // Code to be executed before the test starts
    }

    //@Override
    public void onTestSuccess(ITestResult result) {
        // Code to be executed if the test succeeds
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot sc = (TakesScreenshot) driver;
        File source = sc.getScreenshotAs(OutputType.FILE);
        
        String testCaseName = result.getName(); // Get the test case name
        
        File dest = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
    }


    //@Override
    public void onTestSkipped(ITestResult result) {
        // Code to be executed if the test is skipped
    }


    //@Override
    public void onStart(ITestContext context) {
        // Code to be executed when the test suite starts
    }

    //@Override
    public void onFinish(ITestContext context) {
        // Code to be executed when the test suite finishes
    }
}

package Al_Fardan.Assingment;

import org.testng.annotations.DataProvider;

public class LoginTestData {
	

    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentialsProvider() {
        return new Object[][] {
            {"Automationuser", "Testing@123"},
            {" Automationuser  ", "Testing@123"},
            {"AutomationUser", "Testing@123"},//To check case insensitivity
            {"automationuser", "Testing@123"},
            {"AUTOMATIONUSER", "Testing@123"}
            
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentialsProvider() {
        return new Object[][] {
        	{"  ", "  "},
        	{"Automationuser", "Testing @123"},//whitespace in password
        	{"Automationuser", " Testing@123"},
            {"invalidUsername1", "Testing@123"},
            {"Automationuser", "invalidPassword2"},
            {"invalidUsername1ghvkjbicjvhkjfuyv,..kjfyujhvivuvhv", "Testing@123"},
            
        };
    }
}



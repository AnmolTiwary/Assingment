package Al_Fardan.Assingment;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class ClientTestData {
	
	@DataProvider(name = "allInfo")
	public static Object[][] allInfoDataProvider() {
	    Map<String, String> allInfo = new HashMap<>();
	    allInfo.put("Company", "ropandom Company");
	    allInfo.put("First Name", "fpo Name");
	    allInfo.put("Last Name", "lipa Name");
	    allInfo.put("Email", "onlmmail1@gmail.com");
	    allInfo.put("Mobile", "5762537895");
	    allInfo.put("TRN", "166956");
	    allInfo.put("Address", "1235 Maine St Dubai");
	    allInfo.put("City", "UAE12");
	    allInfo.put("Country", " ");
	    allInfo.put("ZIP Code", "125246");

	    return new Object[][]{{allInfo}};
	}

	@DataProvider(name = "mandatoryInfo")
	public static Object[][] mandatoryInfoDataProvider() {
	    Map<String, String> mandatoryInfo = new HashMap<>();
	    mandatoryInfo.put("Company", "Companyo b12");
	    mandatoryInfo.put("First Name", "Joohny");
	    mandatoryInfo.put("Last Name", " ");
	    mandatoryInfo.put("Email", "mohnmapl2@gmail.com");
	    mandatoryInfo.put("Mobile", "4676563270");
	    mandatoryInfo.put("TRN", "754133");
	    mandatoryInfo.put("Address", " ");
	    mandatoryInfo.put("City", "  ");
	    mandatoryInfo.put("Country", "  ");
	    mandatoryInfo.put("ZIP Code", " ");

	    return new Object[][]{{mandatoryInfo}};
	}
	
	@DataProvider(name = "specialCharacters")
	public static Object[][] specialCharactersData() {
	    Map<String, String> specialCharactersData = new HashMap<>();
	    specialCharactersData.put("Company", "@#$%&@$");
	    specialCharactersData.put("First Name", "FirstName12@#");
	    specialCharactersData.put("Last Name", "hfdgv ukbfk");
	    specialCharactersData.put("Email", "cmail2@gmail.com");
	    specialCharactersData.put("Mobile", "9874543270");
	    specialCharactersData.put("TRN", "6521456");
	    specialCharactersData.put("Address", " ");
	    specialCharactersData.put("City", "  ");
	    specialCharactersData.put("Country", "  ");
	    specialCharactersData.put("ZIP Code", " ");

	    return new Object[][]{{specialCharactersData}};
	}
	@DataProvider(name = "longFieldsData")
	public static Object[][] longFieldsData() {
	    Map<String, String> longFieldsData = new HashMap<>();
	    longFieldsData.put("Company", "some un natural long data which");
	    longFieldsData.put("First Name", "consectetur adipiscing elit...");
	    longFieldsData.put("Last Name", "should be elimineted by the computer");
	    longFieldsData.put("Email", "lorem@example.com");
	    longFieldsData.put("Mobile", "1234567890");
	    longFieldsData.put("TRN", "654321");
	    longFieldsData.put("Address", "  ");
	    longFieldsData.put("City", "  ");
	    longFieldsData.put("Country", "  ");
	    longFieldsData.put("ZIP Code", "12345453115325");

	    return new Object[][]{{longFieldsData}};
	}


}

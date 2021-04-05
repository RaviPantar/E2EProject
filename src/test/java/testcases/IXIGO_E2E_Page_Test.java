package testcases;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import driversUtility.BaseTest;
import driversUtility.DriverManager;
import pages.IXIGO_E2E_Page;

public class IXIGO_E2E_Page_Test extends BaseTest{
	
	@Test(dataProvider="DP")
	public static void LoginPageTest(HashMap<String, String> b) throws Exception
	{
		IXIGO_E2E_Page lp =new IXIGO_E2E_Page(DriverManager.getDriver());
		lp.LaunchPage();
		lp.ValidatPage();
		lp.TravelDeatils(b.get("from"),b.get("to"),b.get("travellers"));
		lp.ValidateResultPage();
		lp.ValidateFilterOption();
		lp.ListOfAirlineDetails();
		
		
	}
	@DataProvider(name="DP")
    public Object[][] hashdata() {

          HashMap<String, String> hash_map = new HashMap<String, String>();
          hash_map.put("from", "Delhi"); 
          hash_map.put("to", "Bengaluru"); 
          hash_map.put("travellers", "2"); 
          return new Object[][]{
              {hash_map}
          };

    }

}

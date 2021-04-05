
package driversUtility;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest  {

	protected BaseTest()
	{

	}

	@BeforeMethod
	public void setup() throws Exception
	{
		Driver.initialization();                       	
	}

	@AfterMethod
	public void tearup() throws InterruptedException
	{
		Driver.quit();
		
	}

}



/*@BeforeSuite
public void beforeSuite()
{
	ExtentReport.initReport();
}

@AfterSuite
public void afterSuite()
{
	ExtentReport.extentFlush();
}*/

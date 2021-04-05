package driversUtility;

import java.util.Objects;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import Enum.Browsers;
import Enum.ConfigProperties;

import frameworkConstants.ReadProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import frameworkConstants.Path;

public class Driver {


	public static void initialization() throws Exception
	{

		if(Objects.isNull(DriverManager.getDriver()))
		{	
			if(ReadProperty.get(ConfigProperties.BROWSERS.toString()).equalsIgnoreCase(Browsers.Chrome.toString()))
			{	
				WebDriverManager.chromedriver().setup(); 	
				DriverManager.setDriver(new ChromeDriver());
				DriverManager.getDriver().manage().deleteAllCookies();
			}
			else if(ReadProperty.get(ConfigProperties.BROWSERS.toString()).equalsIgnoreCase(Browsers.Firefox.toString()))
			{

				WebDriverManager.firefoxdriver().setup();	
				DriverManager.setDriver(new FirefoxDriver());
				DriverManager.getDriver().manage().deleteAllCookies();	
			}
			else if(ReadProperty.get(ConfigProperties.BROWSERS.toString()).equalsIgnoreCase(Browsers.IE.toString()))
			{
				WebDriverManager.iedriver().setup();
				DriverManager.setDriver(new InternetExplorerDriver());
				DriverManager.getDriver().manage().deleteAllCookies();	
			}
			//DriverManager.getDriver().get(ReadProperty.get("url"));


		}
	}

	public static void quit() throws InterruptedException
	{
		if(Objects.nonNull(DriverManager.getDriver()))         
		{	
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}

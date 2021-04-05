package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driversUtility.DriverManager;

public class SeleniumUtility {
	
	
	public static void wait1()
	{
		DriverManager.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	public static void wait2() throws InterruptedException
	{
		Thread.sleep(3000);
		
	}
	public static void wait3(WebElement element) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
}

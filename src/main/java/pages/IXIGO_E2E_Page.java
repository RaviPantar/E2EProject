package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Utility.SeleniumUtility;
import driversUtility.DriverManager;
import frameworkConstants.ReadProperty;

public class IXIGO_E2E_Page {

	WebDriver driver;

	@FindBy(xpath="//span[contains(text(),'Round Trip')]")
	WebElement label_roundtrip;

	@FindBy(xpath="//*[starts-with(text(),'From')]//following::input[1]")
	WebElement txt_from;

	@FindBy(xpath="//*[starts-with(text(),'To')]//following::input[1]")
	WebElement txt_to;

	@FindBy(xpath="//table[@class='rd-days'][1]//tbody//tr[5]//td[@data-date='27042021']")
	WebElement txt_departure;

	@FindBy(xpath="//div[contains(text(),'Return')]//following::input[1]")
	WebElement txt_return;

	@FindBy(xpath="//*[@class='rd-container flight-ret-cal extra-bottom rd-container-attachment arrow-animation']//following::button[2]")
	WebElement txt_next;

	@FindBy(xpath="//*[@class='rd-container flight-ret-cal extra-bottom rd-container-attachment arrow-animation']//following::button[2]//following::tbody//tr[4]//td[5]")
	WebElement select_date;

	////*[contains(text(),'June 2021')]//following::table//tr[4]//td[5]

	@FindBy(xpath="//div[contains(text(),'Adult')]//following::div[2]//span")
	List<WebElement> label_travellers;

	@FindBy(xpath="//div[starts-with(text(),'Class')]//following::div//span[2]")
	List<WebElement> label_class;

	@FindBy(xpath="//*[@class='search u-ib u-v-align-bottom']//button")
	WebElement btn_search;

	@FindBy(xpath="//*[contains(text(),'Stops')]//following::div[2]//span[2]")
	List<WebElement> checkbox_stops;

	@FindBy(xpath="//*[contains(text(),'Departure from DEL')]//following::button")
	List<WebElement> checkbox_dept;

	@FindBy(xpath="//*[contains(text(),'Airlines')]//following::span[@class='checkbox-list']//div[@class='arln-nm']")
	List<WebElement> checkbox_airlines;

	@FindBy(xpath="//*[contains(text(),'Reset Filters')]")
	WebElement label_resetfilters;

	@FindBy(xpath="//div[@class='result-col outr']//div[contains(@class,'hide-detail')]")
	List<WebElement> label_details;

	@FindBy(xpath="//div[@class='result-col outr']//div[contains(@class,'hide-detail')]//div[@class='price']//span[2]")
	List<WebElement> label_price;

	@FindBy(xpath="//div[@class='result-col outr']//div[contains(@class,'hide-detail')]//div[@class='time-group']//div[@class='time'][1]")
	List<WebElement> label_deptime;

	@FindBy(xpath="//div[@class='result-col outr']//div[contains(@class,'hide-detail')]//div[@class='time-group']//div[@class='airline-text']")
	List<WebElement> label_airlinenumber;
	
	@FindBy(xpath="//div[@class='result-col']//div[contains(@class,'hide-detail')]")
	List<WebElement> label_details1;

	@FindBy(xpath="//div[@class='result-col']//div[contains(@class,'hide-detail')]//div[@class='price']//span[2]")
	List<WebElement> label_price1;

	@FindBy(xpath="//div[@class='result-col']//div[contains(@class,'hide-detail')]//div[@class='time-group']//div[@class='time'][1]")
	List<WebElement> label_deptime1;

	@FindBy(xpath="//div[@class='result-col']//div[contains(@class,'hide-detail')]//div[@class='time-group']//div[@class='airline-text']")
	List<WebElement> label_airlinenumber1;
	SoftAssert softassert = new SoftAssert();

	public IXIGO_E2E_Page(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(DriverManager.getDriver(),this);
	}

	public void LaunchPage() throws Exception
	{   
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(ReadProperty.get("url"));
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);


	}

	public void ValidatPage() throws Exception
	{ 
		String title=DriverManager.getDriver().getTitle();
		if(title.equals("ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels"))
		{
			System.out.println("IXIGO page validated successfully");
			softassert.assertTrue(title.contains("ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels"));
		}
		else
		{
			System.out.println("IXIGO Page is not validated successfully");
		}	
	}
	public void TravelDeatils(String from,String to,String travellers) throws Exception
	{
		label_roundtrip.click();
		SeleniumUtility.wait2();
		txt_from.sendKeys(Keys.chord(Keys.CONTROL,"a"),from);
		SeleniumUtility.wait2();
		txt_from.sendKeys(Keys.ENTER);
		SeleniumUtility.wait2();
		txt_to.clear();
		txt_to.sendKeys(to);
		SeleniumUtility.wait2();
		txt_to.sendKeys(Keys.ENTER);
		SeleniumUtility.wait3(txt_departure);
		txt_departure.click();
		SeleniumUtility.wait3(txt_return);
		txt_return.click();
		SeleniumUtility.wait3(txt_next);
		txt_next.click();
		SeleniumUtility.wait3(select_date);
		select_date.click();
		SeleniumUtility.wait2();
		for(int i=0;i<label_travellers.size();i++)
		{	
			String text=label_travellers.get(i).getText();
			if(text.contains(travellers))
			{
				SeleniumUtility.wait3(label_travellers.get(i));
				label_travellers.get(i).click();
                break;
			}

		}

		for(int i=0;i<label_class.size();i++) 
		{  
			String text1=label_class.get(i).getText(); Thread.sleep(2000);
			if(text1.equals("Economy")) 
			{ 
				SeleniumUtility.wait3(label_class.get(i));
				label_class.get(i).click();
				break;
			}

		}

		SeleniumUtility.wait3(btn_search);
		btn_search.click();
		SeleniumUtility.wait1();
	}
	public void ValidateResultPage()
	{
		String title1=DriverManager.getDriver().getTitle();
		System.out.println(title1);
		if(title1.contains("ixigo - Flights"))
		{
			softassert.assertTrue(title1.contains("ixigo - Flights"));
			System.out.println("Result Page is displyed and verified successfully");
		}
		else
		{
			System.out.println("No Flights avaible for this date");
		}
	}
	public void ValidateFilterOption() throws InterruptedException
	{
		for(int i=0;i<checkbox_stops.size();i++)
		{
			String checkbox1=checkbox_stops.get(i).getText();
			if(checkbox1.equals("Non stop"))
			{
				//softassert.assertTrue(checkbox_stops.get(i).isDisplayed());
				SeleniumUtility.wait3(checkbox_stops.get(i));
				checkbox_stops.get(i).click(); 
				softassert.assertTrue(checkbox_stops.get(i).isSelected(), checkbox1+" is selected");
				break;

			}
			else
			{
				softassert.assertFalse(false,checkbox1 +" is not seleceted");
			}
		}

		for(int i=0;i<checkbox_dept.size();i++)
		{
			String checkbox2=checkbox_dept.get(i).getText();
			if(checkbox2.contains("00:00 - 06:00"))
			{
				softassert.assertTrue(checkbox_dept.get(i).isDisplayed());
				SeleniumUtility.wait3(checkbox_dept.get(i));
				checkbox_dept.get(i).click();
				softassert.assertTrue(checkbox_dept.get(i).isSelected(), checkbox2 +" is selected");
				break;

			}
			else
			{
				softassert.assertFalse(false,checkbox2 +" is not seleceted");
			}

		}

		for(int i=0;i<checkbox_airlines.size();i++)
		{
			String checkbox3=checkbox_airlines.get(i).getAttribute("title");
			if(checkbox3.contains("SpiceJet"))
			{
				softassert.assertTrue(checkbox_airlines.get(i).isDisplayed());
				SeleniumUtility.wait3(checkbox_airlines.get(i));
				checkbox_airlines.get(i).click();	
				softassert.assertTrue(checkbox_airlines.get(i).isSelected(),checkbox3+" is selected");
				break;

			}
			else
			{
				softassert.assertFalse(false,checkbox3 +" is not seleceted");
			}
		}
	}


	public void ListOfAirlineDetails() throws InterruptedException
	{
		SeleniumUtility.wait3(label_resetfilters);
		label_resetfilters.click();
		for(int i=0;i<checkbox_stops.size();i++)
		{
			String checkbox=checkbox_stops.get(i).getText();
			if(checkbox.equals("Non stop"))
			{
				SeleniumUtility.wait3(checkbox_stops.get(i));
				checkbox_stops.get(i).click(); 

			}
		}
		ArrayList<String> price=new ArrayList<>();
		ArrayList<String> deptime=new ArrayList<>();
		ArrayList<String> airlinenumber=new ArrayList<>();
		for(int i=1;i<label_details.size();i++)
		{
			int fare=Integer.parseInt(label_price.get(i).getText().trim());
			String fare1=label_price.get(i).getText().trim();
			String time=label_deptime.get(i).getText();
			String airnumber=label_airlinenumber.get(i).getText().replaceAll("Air India  ", " ").replaceAll("SpiceJet "," ").replaceAll("IndiGo "," ").replaceAll("Go Air ", " ").replaceAll("Vistara "," ").replaceAll("AirAsia India  "," ").trim();

			if(fare<7000)
			{
				price.add(fare1);
				deptime.add(time);
				airlinenumber.add(airnumber);
			}
		}
		System.out.println(" ");
		System.out.println("Airline Details - Departure from DEL");
		System.out.println("Airline:"+""+"Departure:"+""+"Fare:");
		System.out.println("======  =======  ====");
		for(int i=0;i<price.size();i++)
		{
			System.out.println(airlinenumber.get(i)+"   "+deptime.get(i)+"    "+price.get(i));
		}
		ArrayList<String> price1=new ArrayList<>();
		ArrayList<String> deptime1=new ArrayList<>();
		ArrayList<String> airlinenumber1=new ArrayList<>();
		for(int i=1;i<label_details1.size();i++)
		{
			int fare=Integer.parseInt(label_price1.get(i).getText().trim());
			String fare1=label_price1.get(i).getText().trim();
			String time=label_deptime1.get(i).getText();
			String airnumber=label_airlinenumber1.get(i).getText().replaceAll("Air India  ", " ").replaceAll("SpiceJet "," ").replaceAll("IndiGo "," ").replaceAll("Go Air ", " ").replaceAll("Vistara "," ").replaceAll("AirAsia India  "," ").trim();

			if(fare<7000)
			{
				price1.add(fare1);
				deptime1.add(time);
				airlinenumber1.add(airnumber);
			}
		}
		System.out.println(" ");
		System.out.println("Airline Details - Departure from BLR");
		System.out.println("Airline:"+""+"Departure:"+""+"Fare:");
		System.out.println("======  =======  ====");
		for(int i=0;i<price1.size();i++)
		{
			System.out.println(airlinenumber1.get(i)+"   "+deptime1.get(i)+"    "+price1.get(i));
		}
	}

}












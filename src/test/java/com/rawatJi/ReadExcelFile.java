package com.rawatJi;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Database.ExcelDataProvider;

public class ReadExcelFile {

	
	
WebDriver driver;
DesiredCapabilities cap;

@BeforeTest
public void setup()
{
	
	

	cap = DesiredCapabilities.firefox();

	cap.setCapability("marionette", true);
	System.setProperty("webdriver.gecko.driver","/Users/parawat/Downloads/geckodriver");
	//cap.setCapability("firefox_binary", "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin");
	cap.setPlatform(Platform.MAC);
	
}	
	
	
@BeforeTest

public void setExcel() throws Exception
{
	ExcelDataProvider.setExcelFile("ExcelRepo/Book1.xlsx","Sheet1");	
}


	@Test()
	public void test() throws Exception
	{
		
		driver=new FirefoxDriver(cap);
		
		
		//Row number should be plus one as first is header
		int rownumber=2;
		int columnnumber=5;
		String CACHED_PNR;
		
		
		driver.get("http://prawat:Egencia$1@cheiwbtect001.karmalab.net:8080/cc/companyresult/819490");

		while (!(ExcelDataProvider.getCellData(rownumber, columnnumber).equals("")))
		{
			
			
			CACHED_PNR=ExcelDataProvider.getCellData(rownumber, columnnumber);
			
			
			driver.get("http://prawat:Egencia$1@cheiwbtect001.karmalab.net:8080/cc/companyresult/819490");
			driver.findElement(By.xpath("//select[@id='lang']/option[@value='en_']")).click();
			
			if (!(driver.findElement(By.xpath("//input[@id='synchroCheckBox']")).isSelected()))
			{
			
				driver.findElement(By.xpath("//input[@id='synchroCheckBox']")).click();	
				
			}
			
			driver.findElement(By.xpath("//input[@id='fileTextField']")).sendKeys(CACHED_PNR);
			
			driver.findElement(By.xpath("//a[@id='summary']/span")).click();
		
			++rownumber;
			
		}
	
			

		
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		
		
		//driver.dispose();
		driver.close();
		
		driver.quit();
		
	}
	
	
}

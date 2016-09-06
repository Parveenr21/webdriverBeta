package com.rawatJi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class localhost_driverclose_copy4 {

	
WebDriver driver;
DesiredCapabilities cap;
@BeforeTest
public void setup(){
	
	 cap = DesiredCapabilities.firefox();
	cap.setCapability("marionette", true);
	System.setProperty("webdriver.gecko.driver","/Users/parawat/Downloads/geckodriver");
	cap.setCapability("firefox_binary", "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin");

}
	
	
	@Test
	public void test() throws InterruptedException
	{
		System.out.println("Inside Test method");
		FirefoxProfile profile = new FirefoxProfile();
		
		
		driver=new FirefoxDriver(cap);
		
		
		
			
		driver.get("http://technosoftconsultants.co.in/");
		
			
	}
	
	@AfterTest
	public void tearDown()
	{
		
		driver.close();
		
		//driver.quit();
		
	}
	
	
	
	
	
	

}

package com.rawatJi;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class e2_MoveVerticalScrollBar {

	WebDriver driver;
	DesiredCapabilities cap;
	
	@BeforeTest
	public void setup()
	{
		
		

		cap = DesiredCapabilities.firefox();

		cap.setCapability("marionette", true);
		System.setProperty("webdriver.gecko.driver","/Users/parawat/Downloads/geckodriver");
		cap.setCapability("firefox_binary", "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin");
	
	
		
		
	}
	
	@Test
	public void test() throws InterruptedException
	{
		driver= new FirefoxDriver(cap);
		
		
		driver.get("http://www.w3schools.com/");
			
		driver.manage().window().maximize(); //maximize the window
	

		//WAY 1
		
		/*
		 * 
		 * See to run any java script on a web page using webdriver..
		 * 
		 * we hold the DRIVER instance reference in java script executer using CASTING
		 * 
		 */
		JavascriptExecutor executer= (JavascriptExecutor) driver;  //hold the driver instance in java script executor Interface REFerence
		
		executer.executeScript("scroll(0,250)");
		
		Thread.sleep(5000);
		
		executer.executeScript("scroll(250,0)");
		Thread.sleep(5000);
		
		executer.executeScript("scroll(250,0)");
		Thread.sleep(5000);
		
		
	/*	
	 * 
	 * 
	 * The below ways are not working...
		
		
		//WAY2
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.tagName("body"))).perform();
		
		action.click().perform();
		
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

		action.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).perform();

		
		
		
		//WAY3
		
		for(int i=0;i<3;i++	)
			
		{
			
			action.sendKeys(Keys.ARROW_DOWN).perform();
			
		}
	for(int i=0;i<3;i++	)
			
		{
			
			action.sendKeys(Keys.ARROW_UP).perform();
			
		}	*/
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		
		
		driver.quit();
		
	}
	
	
	
	
	
	
}
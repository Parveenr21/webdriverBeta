package com.rawatJi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class f2_WaitImplcitExplicit {

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
	
	
	@Test
	public void test()
	{
		driver=new FirefoxDriver(cap);
		
		
		driver.get("https://www.irctc.co.in/");
			
		
		/*
		 * 
		 * before send keys always do clear first
		 * 99% it is like that
		 * 
		 */
	
		driver.findElement(By.xpath("//*[@id='usernameId']")).clear();
		driver.findElement(By.xpath("//*[@id='usernameId']")).sendKeys("prawat6");
	/*	driver.findElement(By.xpath("//td//input[@name='password']")).clear();
		driver.findElement(By.xpath("//td//input[@name='password']")).sendKeys("pcq997");
	*/
		
		
		/*
		 * 
		 * Implicit Wait
		 * 
		 * 
		 * Remember to set IT before opening the Web Application or simply a domain.
		 * This works for all the elements.. It is like.. In Web driver.. the execution for any data object or web element happens only once a page 
		 * get loaded completely.. but If some element is not present then this imlicit waut will work for all the pages and all the
		 * elements for the set time. which is say 10..
		 * 
		 * so there is NOT any polling.. period.. element will be checked after timeout second time.
		 * 
		 * so every half second webdriver checkcs for the element presence till 10 seconds after that it will throw element not found exception.
		 * 
		 * 
		 * 
		 * 
		 */
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		/*
		 * 
		 * Explicit wait
		 * 
		 * It is exclusively for a conditon .. while for rest of the code.it does not work... 
		 * If we want to set a default timeout then use implicit wait too
		 * 
		 *  here we can set 2 things
		 *  
		 *  1. Ignore specific types of exception waiting such as NoSuchElementExceptions while searching for an element on the page.
		 *  
		 *  
		 *  new WebDriverWait(driver, 15).ignoring(NoSuchElementException.class);
		 *  
		 *  2.Maximum amount of time to wait for a condition  15 sec here
 
		 * new WebDriverWait(driver, 15)
		 */
		
		
		//default polling second.. whih is 500 milli second or simply .5 second
		/*
		 * Wait will ignore instances of NotFoundException that are encountered (thrown) by default in
   * the 'until' condition	
   * 
   * here 15 is timout for the element to be found
		 * 
		 */
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		
		WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='usernameId']"))));
		
		//wait.until(ExpectedConditions.elementToBeClickable(element));
	//driverInstance=	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("frmae xpath")));
		element.clear();
		element.sendKeys("111111111");
		
		
		
		/*
		 * 
		 * Fluent wait:- its just like explicit wait.. with the addition of custom polling frequency
		 * 
		 * 
		 * here we have 3 things
		 * 
		 * 
		 * 	1.Frequency with which FluentWait has to check the conditions defined.
			2. Ignore specific types of exception waiting such as NoSuchElementExceptions while searching for an element on the page.
			3. Maximum amount of time to wait for a condition
		 * 
		 * 
		 */
		
		FluentWait<WebDriver> fluwait = new FluentWait<WebDriver>(driver)
			    .withTimeout(30, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

		 element = fluwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='usernameId']"))));
		 
		 element.clear();
			element.sendKeys("111111111");
			
			
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		
		driver.close();
		
		
	}
	
	
	
	
	
	
}
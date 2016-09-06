package com.rawatJi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class a3_DoubleClick {

	WebDriver driver;


	@Test
	public void test() throws InterruptedException
	{

		DesiredCapabilities cap= DesiredCapabilities.firefox();
		cap.setCapability("marionette", true);	//RUN by keeping it true only
		cap.setCapability("firefox_binary", "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin");
		System.setProperty("webdriver.gecko.driver","/Users/parawat/Downloads/geckodriver");



		driver=new FirefoxDriver(cap);


		//driver.get("http://blog.codinghorror.com/double-click-must-die/");

		driver.get("http://www.google.com");

		Thread.sleep(5000);

		Actions action = new Actions(driver);

		//Double click statement written there
		//action.doubleClick(driver.findElement(By.xpath("//*[@id='gbqfba']"))).perform();


		//WebElement a= driver.findElement(By.linkText("dd"));


	}

	@AfterTest
	public void tearDown()
	{

		driver.close();


	}






}
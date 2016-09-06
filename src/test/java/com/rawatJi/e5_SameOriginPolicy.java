package com.rawatJi;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class e5_SameOriginPolicy {

	
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
	public void tess1(){
		
		
		driver = new FirefoxDriver(cap);
		
		
		/*DesiredCapabilities capabilty = DesiredCapabilities.internetExplorer();
		
		DesiredCapabilities capability1 = new DesiredCapabilities();
		capability1.setBrowserName(BrowserType.IE);
		*/
		driver.get("http://www.euttaranchal.com/");
		
		//driver.findElement(By.xpath("//div[4]/div/ul/li[10]/a")).click();
		
		
		
		
		//The below find by tag name is not working with webdriver 3
		
		//System.out.println(driver.findElement(By.tagName("body")).getText());
		
		
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		
		/*
		driver.get("http://www.sacredyatra.com/");
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//*[@rel='country6']")).click();
		
		*/
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.quit();
	}
	
}

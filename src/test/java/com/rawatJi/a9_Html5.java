package com.rawatJi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class a9_Html5 {

	WebDriver driver;
	
	@Test
	public void test(){
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability("marionette", true);
		System.setProperty("webdriver.gecko.driver","/Users/parawat/Downloads/geckodriver");
		cap.setCapability("firefox_binary", "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin");

		
		driver= new FirefoxDriver(cap);

		
		//This page has HTML 5
		
		driver.get("http://www.google.com/");
		
		
		
		System.out.println(driver.findElements(By.xpath("//section[@id='explain']/div[@*]")).size());
		
		
	}
	
}

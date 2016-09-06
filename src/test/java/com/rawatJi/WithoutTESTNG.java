package com.rawatJi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WithoutTESTNG {

	
	static WebDriver driver;
	
	public static void main(String ...ccc)
	{
		FirefoxProfile profile = new FirefoxProfile();
		
	 driver = new FirefoxDriver(profile);
	 
		driver.get("http://localhost:8080/jquery/www.tutorialspoint.com/jquery/jquery-basics.html");
		
		
		
		
	}
	
}


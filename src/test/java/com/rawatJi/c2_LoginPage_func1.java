package com.rawatJi;

import java.io.IOException;
import java.net.MalformedURLException;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ActionUtil.Util;
import site1.LoginPage;


public class c2_LoginPage_func1 {

	
	WebDriver driverInstance;
	DesiredCapabilities cap= new DesiredCapabilities();
	
	@BeforeTest
	public void setup(){
		
		 cap = DesiredCapabilities.firefox();
		cap.setCapability("marionette", true);
		System.setProperty("webdriver.gecko.driver","/Users/parawat/Downloads/geckodriver");
		cap.setCapability("firefox_binary", "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin");

	}
	
	@Test
	public void testmethod1() throws MalformedURLException, IOException{
		
		driverInstance=new FirefoxDriver(cap);
		
		
		
		
		//Initializing LoginPage class and passing webdriver instance to it ..this also insitialize proxy of webelements
		LoginPage LP=	PageFactory.initElements(driverInstance, LoginPage.class);

		//In Ajax Element locator factory.. timeout in seconds..
		
//		ElementLocatorFactory finder=new AjaxElementLocatorFactory(driverInstance, 100);
//		PageFactory.initElements(finder, this);

		
//	    PageFactory.initElements(new AjaxElementLocatorFactory(driverInstance, 100), this);
//	  //  or
//	    PageFactory.initElements(new AjaxElementLocatorFactory(driverInstance, 100), LP);

		
		
		
	/*	The belw line of code will always be in Page class so that all findBy webelemts
		will get checked at the timeof their use only with a timeout..very helpful 
		for ajax.
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driverInstance, 100), this);
		
		*/
		
		System.out.println(LP.getAllLinksCount());
		
		LP.getTextOrURLName();
	//	LP.CheckALLURL();
		
		
		
		
		
		System.out.println(System.getProperty("favorite.berry"));
			
			System.out.println(System.getProperty("propertyName"));
			System.out.println(System.getProperty("buildDirectory"));
				
			Assert.assertEquals("PASS",true, true);
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException{
		
	
		Thread.sleep(5000);
		driverInstance.quit();
		Thread.sleep(5000);
	

		
	}
}

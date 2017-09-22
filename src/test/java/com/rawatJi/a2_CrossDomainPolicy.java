package com.rawatJi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import bsh.Capabilities;

public class a2_CrossDomainPolicy {

	WebDriver driver;

	@Test
	public void test() throws InterruptedException {

		/*
		 * IF we have created a firefox profile say "webdriverProfile" to be
		 * used while running automation then we can access or read that in code
		 * by using following code
		 * 
		 * ProfilesIni profile = new ProfilesIni(); 
		 * FirefoxProfile myprofile =profile.getProfile("webdriverProfile"); //Settting a prefernce
		 * myprofile.setAcceptUntrustedCertificates(true); 
		 * driver=new FirefoxDriver(myprofile);
		 *
		 * 
		 */

		// IMP!!!!!!! The below command will not create a new profile but it
		// will create an object of the current profile to
		// set the preferences so that we can run the test as per our need

		
		  FirefoxProfile objectOfCurrentProfile = new FirefoxProfile();
		  objectOfCurrentProfile.setAcceptUntrustedCertificates(true);
		 

		DesiredCapabilities cap = DesiredCapabilities.firefox();

		cap.setCapability("marionette", true); // RUN by keeping it true only..though..implicitly it is TRUE only.
		cap.setCapability("firefox_binary", "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin");
		
		//Setting profile as one of the capability
		cap.setCapability(FirefoxDriver.PROFILE, objectOfCurrentProfile);

		
		System.setProperty("webdriver.gecko.driver", "/Users/parawat/Downloads/geckodriver");

		try {

			
			
			driver = new FirefoxDriver(cap);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// ((RemoteWebDriver)driver)

			System.out.println(((RemoteWebDriver) driver).getCapabilities());

			// driver.get("http://blog.codinghorror.com/double-click-must-die/");

			driver.get("https://www.muscleguru.in/product_detail.php?pid=184");
			Actions acc= new Actions(driver);
			
			//acc.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Categories')]"))).perform();
			acc.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Categories')]"))).click().perform();
			
			
			//new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[contains(.,'Categories')]"))).perform();

			driver.findElement(By.xpath("//a[contains(@href,'Grenade')]")).click();

			driver.findElement(By.xpath("//input[@name='txtnesletetr']")).clear();
			driver.findElement(By.xpath("//input[@name='txtnesletetr']")).sendKeys(Keys.getKeyFromUnicode('a'));
			
			
			
			driver.findElement(By.xpath("//input[@value='Subscribe']")).click();

			Alert alt = driver.switchTo().alert();

			alt.accept();

			// Thread.sleep..here timein milliseconds..
			// Thread.sleep(33333);

			// now it will click on TWITTTER image and redirected to twitter
			// domain
			// I was able to move to another domain easily

			// Webdriver has overcome the same origin policy issue

			driver.findElement(By.xpath("//img[@alt='twitter_icon']")).click();

			for (String currentWindow : driver.getWindowHandles()) {
				driver.switchTo().window(currentWindow);

				if (driver.getTitle().contains("Twitter"))
					break;

			}

			driver.findElement(
					By.xpath("//button[@class='user-actions-follow-button js-follow-btn follow-button btn']")).click();

			Thread.sleep(15000);
		}

		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		finally {

			driver.quit();	//quit here as exception .. is there and close will not work to close it
		}

	}

	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.close();

		// driver.quit();

	}

}

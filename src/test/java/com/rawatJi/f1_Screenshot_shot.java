package com.rawatJi;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.codehaus.plexus.util.IOUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 

public class f1_Screenshot_shot {

	
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
	public void test() throws InterruptedException, IOException
	{
		
		//FirefoxProfile profile = new FirefoxProfile();
		
		
		driver=new FirefoxDriver(cap);
		
		
		//driver.get("http://blog.codinghorror.com/double-click-must-die/");
			
		
		driver.get("http://www.vresorts.in/resorts/v-resorts-pauri");
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		File scr= ts.getScreenshotAs(OutputType.FILE);
		
		//String baseDir=${project.basedir};
		//System.getProperty()
		
		//new File(System.getProperty(${project.basedir}/Snapssss));
	
		
		
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("Project.properties"));
		String basedir = (String) props.get("project.basedir");
		
		String dir=basedir+"/webdriversnapshot";
		
		
		FileUtils.copyFile(scr, new File(dir+"/"+System.currentTimeMillis()+".png"));
		
		
		WebElement we1=driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[3]/a"));
		
		
		
		
		
		/*
		we1.click();
		
		Iterator<String> itr = driver.getWindowHandles().iterator();
		
		while(itr.hasNext())
		{
			
			String temphandle=itr.next();
			driver.switchTo().window(temphandle);
			
			System.out.println(driver.getTitle());
			
			
		}
		
		
		
		
		
		 scr= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scr, new File("D:\\postClick.png"));
		*/
	}
		
	
	@AfterTest
	public void tearDown()
	{
		
		
		driver.quit();
		
	}
	
	
}

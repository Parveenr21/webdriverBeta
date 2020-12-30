           package com.rawatJi;


		   import org.openqa.selenium.By;
		   import org.openqa.selenium.JavascriptExecutor;
		   import org.openqa.selenium.WebDriver;
		   import org.openqa.selenium.WebElement;
		   import org.openqa.selenium.firefox.FirefoxDriver;
		   import org.openqa.selenium.remote.DesiredCapabilities;
		   import org.testng.annotations.AfterTest;
		   import org.testng.annotations.Test;

		   public class A5_FbFriendList {


	public WebDriver driver;




		JavascriptExecutor executor= (JavascriptExecutor) driver;  //hold the driver instance in java script executor


		/*
		 * There is one more javascriptexecutor.. check the correctone should from selenium side.
		 */


		@Test
		public void getFrndList() throws InterruptedException
		{



			/*
			 *webdriver 3 allows us to use marionette driver or not
			 *
			 *If we choose to use marionette we specify using capabilities .. and by default this is TRUE.
			 and then we have t o set the path of gecko driver using property

			 IF we set the use marionette driver to FALSE then old driver will work and we
			 do not have to set the property..just normal flow will work
			 *
			 *Here you will get null pointer as firefox driver could not be instantiated
			 *The exception object says .. it has to be set as gecko driver in path
			 *
			 *
			 */


			DesiredCapabilities cap = DesiredCapabilities.firefox();
			System.setProperty("webdriver.gecko.driver","/Users/parawat/Downloads/geckodriver");
			cap.setCapability("firefox_binary", "/Applications/FirefoxDeveloperEdition.app/Contents/MacOS/firefox-bin");



			driver = new FirefoxDriver(cap);

			//driver= new FirefoxDriver();

			driver.get("https://www.facebook.com/");

			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("parveen.techno@gmail.com");
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("stvcmnpcnmocratfoene");

			driver.findElement(By.xpath("//*[@type='submit']")).click();;


			Thread.sleep(5000);

			//Logged in now.. clicking on loggedin User's profile or Timeline
			driver.findElement(By.xpath("//a[contains(@data-gt,'timeline')]")).click();
			//driver.findElement(By.xpath("//a[contains(@data-gt,'timeline')]")).click();

			Thread.sleep(2000);




			driver.manage().window().maximize();


	//Clicking on the friends tab
			driver.findElement(By.xpath("//a[@data-tab-key='friends']")).click();


			//Prepare Java scriot executor and cast driver instance to it

			executor= (JavascriptExecutor) driver;



			while(true)
			{
				executor.executeScript("scroll(0,2500000)"); //pixel specification
				Thread.sleep(2000);

				try{

//					if(driver.findElement(By.xpath("//h3[contains(.,'More About')]")).getText().contains("More About"))

					if(driver.findElement(By.xpath("//h3[contains(.,'More About')]")).isDisplayed())

					{
						break;
					}


				}

				catch(Throwable t)
				{

					//Catch block.. beacuse ..when object will not be found.. catch block will keep on the iteration

	System.out.println("inside CATCH block");
				}


			}




	//Finding all friends .. counts of the logged inuser
			//Either try to check for a generic xxpath locator which will find for all user
			//OR
			//INSPECT one ELEMENT and check for something generic and then create xpath on your own


			System.out.println(driver.findElements(By.xpath("//*[@class='fsl fwb fcb']")).size());



			for(WebElement s: driver.findElements(By.xpath("//*[@class='fsl fwb fcb']")))
			{
				System.out.println(s.getText());  //Printing the name of Friends

			}
		}


		@AfterTest
		public void teardown(){

			driver.quit();
		}




}

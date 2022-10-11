package com.demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserTest {
	
	WebDriver driver=null;
	
	//Check whether different browsers and screen resolutions render it the same way 
	
	@Test(groups = "Chrome")
	//Chrome Browser
	public void launchChrome() {
		boolean chromeLaunched = false;
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\SimpliLearn\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("https://www.flipkart.com/");
		
			Thread.sleep(3000);
			chromeLaunched = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			chromeLaunched = false;
			e.printStackTrace();
		}
		
		if(chromeLaunched) {
			System.out.println("Chrome Launched Successfully");
		}
		else {
			System.out.println("Chrome Launched Unsuccessfully");

		}
	}
	
	
	
	@Test(groups = "Firefox")
	//Firefox Browser
	public void launchFireFox() {
		boolean firefoxLaunched = false;
		try {
		System.setProperty("webdriver.gecko.driver", "D:\\SimpliLearn\\selenium drivers\\geckodriver-v0.31.0-win64_new\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("https://www.flipkart.com/");

			Thread.sleep(3000);
			firefoxLaunched = true;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			firefoxLaunched = true;
			e.printStackTrace();
		}
		if(firefoxLaunched) {
			System.out.println("Firefox Launched Successfully");
		}
		else {
			System.out.println("Firefox Launched Unsuccessfully");

		}
	}
	
	
  
}
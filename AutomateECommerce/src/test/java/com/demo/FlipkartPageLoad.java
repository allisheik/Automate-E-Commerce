package com.demo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class FlipkartPageLoad {
	
	WebDriver driver;
	@Test
	
	//Finding Page Load Time
	public void pageload() {
		long start = System.currentTimeMillis();
		driver.get("https://www.flipkart.com/");

		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+(totalTime*0.001)+" Seconds"); 
		driver.findElement(By.cssSelector("body > div._2Sn47c > div > div > button")).click();	
	
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\SimpliLearn\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	@AfterMethod
	public void afterMethod() {
		//driver.close();
		driver=null;
	}
	
	
}
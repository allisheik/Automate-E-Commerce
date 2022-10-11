package com.demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class FlipkartSearch {
	
	WebDriver driver;
	@Test
	public void facebook() throws InterruptedException {
		
		driver.get("https://www.flipkart.com/");
		
		//Login
		//Used my own credentials to login
		driver.findElement(By.cssSelector("body > div._2Sn47c > div > div > div > div > div._36HLxm.col.col-3-5 > div > form > div:nth-child(1) > input")).sendKeys("###########");
		driver.findElement(By.cssSelector("body > div._2Sn47c > div > div > div > div > div._36HLxm.col.col-3-5 > div > form > div:nth-child(2) > input")).sendKeys("**********");
		driver.findElement(By.cssSelector("body > div._2Sn47c > div > div > div > div > div._36HLxm.col.col-3-5 > div > form > div._1D1L_j > button")).submit();	
		Thread.sleep(8000);
		
		//Searching iphone 13
		driver.findElement(By.name("q")).sendKeys("iPhone 13");
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div._1cmsER > form > div > button")).click();
		Thread.sleep(5000);
        
		
		//Check page has a scroll feature
        WebElement element= driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[5]/div/div/div/a/div[2]/div[1]/div[1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        
        System.out.println(element.getText());
		Thread.sleep(5000);

        //Check if the images are loaded
        WebElement i = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[5]/div/div/div/a/div[1]/div[1]/div/div/img"));
        Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
        if (p) {
           System.out.println("Image is present");
        } else {
           System.out.println("Image is not present");
        }
        
        //Verify that it navigates to the bottom of the page
        boolean isPageScrollBottom = (Boolean) ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);\r\n"
        		+ "    if ((window.innerHeight + window.scrollY) >= document.body.scrollHeight) {\r\n"
        		+ "      // you're at the bottom of the page\r\n"
        		+ "      return true;\r\n"
        		+ "};");
        if (isPageScrollBottom) {
            System.out.println("Navigated to buttom successfully");
         } else {
            System.out.println("Failed to navigate bottom of the page");
         }        
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
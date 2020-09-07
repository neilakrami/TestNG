package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HrmsTestCases {

	public static WebDriver driver;
	
	@BeforeMethod
	public void oepnBrowser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		//driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	@Test(priority = 2)
	public void validation() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		String welecomText = driver.findElement(By.id("welcome")).getText();
			if(welecomText.contains("Admin")) {
				System.out.println("Admin is logged in: Test pass");
			}else {
				System.out.println("Admin is NOT logged in. Test failed");
			}
	}

	@Test(priority = 1)
	public void titleValidation() {
		String expectedTitile = "Human Management System";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitile)) {
			System.out.println("Titles ar matched. Test Pass");
		}else {
			System.out.println("Title do not matched. Test Failed");
		}
	}
	
	@Test(priority = 3, enabled = false)
	public void invalidLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		WebElement message = driver.findElement(By.id("spanMessage"));
		String expectedMsg = "Password Cannot be empty";
		String actualMesg = message.getText();
		if(actualMesg.equals(expectedMsg)) {
			System.out.println("Test PASS");
		}else {
			System.out.println("Test FAIL");
		}
		
	}
}

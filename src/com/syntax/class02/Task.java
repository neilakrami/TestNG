package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task {
	public static WebDriver driver;
		
		@BeforeClass
		public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
			driver = new ChromeDriver();
			driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
			//driver.manage().window().maximize();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@Test
	public void Login() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}
	
	@Test
	public void labelsDisplayed() {
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		WebElement fullName = driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']"));
		WebElement employeeId = driver.findElement(By.xpath("//label[@for='employeeId']"));
		WebElement phptograph = driver.findElement(By.xpath("//label[@for='photofile']"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(fullName.isDisplayed());
		softAssert.assertTrue(employeeId.isDisplayed());
		softAssert.assertTrue(phptograph.isDisplayed());
		
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Ball");
		driver.findElement(By.id("photofile")).sendKeys("/neilamrami/Desktop/Image from iOS.jpg");
		driver.findElement(By.id("btnSave")).click();
		WebElement picOfEmp = driver.findElement(By.id("empPic"));
		softAssert.assertTrue(picOfEmp.isDisplayed());
		softAssert.assertAll();
		
	}
		
}

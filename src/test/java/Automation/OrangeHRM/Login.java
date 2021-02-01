package Automation.OrangeHRM;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Automation.OrangeHRM.baseClass;
import Automation.OrangeHRM.PageObject.LoginPO;


public class Login extends baseClass{
	public LoginPO loginPageObjects;
	@BeforeTest
	public void navigateToAdminLogin() throws IOException{
		
		driver = initializeDriver();
		driver.get(getProperties("url"));
		System.out.println("The title of the page is "+driver.getCurrentUrl());
		
	}
	
	@Test(priority=1)
	public void login(){
		loginPageObjects = new LoginPO(driver);
		String errorMsg = "";
		loginPageObjects.adminUsername().sendKeys("Admin");;
		loginPageObjects.adminPassword().sendKeys("admin123");
		loginPageObjects.adminloginBtn().click();
		
		WebElement username = driver.findElement(By.xpath("//a[@id='welcome']"));
		String usernameText = username.getText();
		if(usernameText.contains("Welcome")){
			System.out.println("Successfully Logged in");
		}else{
			try {
				WebElement error =  driver.findElement(By.xpath("//span[@id='spanMessage']"));
				errorMsg = error.getText();
			} catch (Exception e) {
				System.out.println("No such webElement found");
			}
			System.out.println("Invalid UserName and Password");
			System.out.println(errorMsg);
		}
	}
	
	@Test(priority=2)
	public void logOut(){
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//a[@id='welcome']"))));
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(3000);
		driver.close();
	}
	
}

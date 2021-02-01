package Automation.OrangeHRM.Admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Automation.OrangeHRM.baseClass;


public class Login extends baseClass{
	@BeforeTest
	public void navigateToAdminLogin() throws IOException{
		driver = initializeDriver();
		driver.get(getProperties("url"));
		System.out.println("The title of the page is "+driver.getCurrentUrl());
	}
	
	@Test(priority=1)
	public void login(){
		Login login = new Login();
		String errorMsg = "";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
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
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterTest
	public void close(){
		driver.close();
	}
	
}

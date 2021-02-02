package Automation.OrangeHRM;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Automation.OrangeHRM.baseClass;
import Automation.OrangeHRM.PageObject.DashBoardPO;
import Automation.OrangeHRM.PageObject.LoginPO;
import Automation.OrangeHRM.PageObject.NavigationPO;


public class Login extends baseClass{
	public LoginPO loginPageObjects;
	public DashBoardPO dashboardPageObject;
	public NavigationPO navigationPageObject;
	@BeforeTest
	public void navigateToAdminLogin() throws IOException{
		
		driver = initializeDriver();
		driver.get(getProperties("url"));
		System.out.println("The title of the page is "+driver.getCurrentUrl());
		loginPageObjects = new LoginPO(driver);
		dashboardPageObject = new DashBoardPO(driver);
	}
	
	@Test(priority=1)
	public void login(){
		String errorMsg = "";
		loginPageObjects.adminUsername().sendKeys("Admin");;
		loginPageObjects.adminPassword().sendKeys("admin123");
		loginPageObjects.adminloginBtn().click();
		
		String usernameText = dashboardPageObject.profileName().getText();
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
	
}

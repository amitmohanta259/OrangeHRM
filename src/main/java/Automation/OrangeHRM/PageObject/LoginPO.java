package Automation.OrangeHRM.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPO {
	
	WebDriver driver;
    By username = By.xpath("//input[@id='txtUsername']");
	By password = By.xpath("//input[@id='txtPassword']");
	By loginBtn = By.xpath("//input[@id='btnLogin']");
	By forgetPassword = By.xpath("//input[text(),'Forgot your password?']");
	By errorMsg = By.xpath("//*[@id='spanMessage']");
	public LoginPO(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement adminUsername(){
		return driver.findElement(username);
	}
	
	public WebElement adminPassword(){
		return driver.findElement(password);
	}
	
	public WebElement adminloginBtn(){
		return driver.findElement(loginBtn);
	}
	
	public WebElement forgetPassword(){
		return driver.findElement(forgetPassword);
	}
	
	public WebElement errorMsg(){
		return driver.findElement(errorMsg);
	}

	
}

package Automation.OrangeHRM.Admin;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Automation.OrangeHRM.baseClass;


public class Login extends baseClass{
	@Test
	public void AdminLogin() throws IOException{
		driver = initializeDriver();
		System.out.println("The title of the page is "+driver.getCurrentUrl());
	}
	
}

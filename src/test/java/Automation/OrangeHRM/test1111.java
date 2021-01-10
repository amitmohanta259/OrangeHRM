package Automation.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class test1111 extends baseClass{

	WebDriver driver;
	@Test
	public void launchBrowser() throws IOException{
		driver = initializeDriver();		
	}
}

package Automation.OrangeHRM;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaunchBrowser extends baseClass{

	@BeforeTest
	public void launchBrowser() throws IOException{
		driver = initializeDriver();
		String url = getProperties("url");
		driver.get(url);	
	}
}

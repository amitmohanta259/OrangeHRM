package Automation.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {

	public WebDriver driver;
	Properties prop;
	
	public WebDriver initializeDriver() throws IOException{
		//Access Browser folder
		File browserFolder = new File("browser");
		String chromeDriver = (new File(browserFolder, "chromedriver.exe")).getAbsolutePath();
		String firefoxDriver = (new File(browserFolder, "geckodriver.exe")).getAbsolutePath();
		String edgeDriver = (new File(browserFolder, "msedgedriver.exe")).getAbsolutePath();
		//Access Properties file 
		prop = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\Amit\\workspace\\OrangeHRM\\src\\main\\java\\Automation\\OrangeHRM\\data.properties");
		prop.load(fin);
		String browserName = prop.getProperty("browserName");
	    
		if(browserName.equalsIgnoreCase("Chrome")){
			String chromePath= chromeDriver.replace("\\", "\\\\");
			System.setProperty("webdriver.chrome.driver",chromePath);
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("FireFox")) {
			String firefoxPath= firefoxDriver.replace("\\", "\\\\");
			System.setProperty("webdriver.chrome.driver",firefoxPath);
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")){
			String edgePath= edgeDriver.replace("\\", "\\\\");
			System.setProperty("webdriver.chrome.driver",edgePath);
			driver = new EdgeDriver();
		}
		else{
			System.out.println("Browser Configuration missing");
		}
		
		return driver;
	}
	
}

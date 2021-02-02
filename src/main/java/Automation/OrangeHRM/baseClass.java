package Automation.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException{
		//Access Browser folder
		File browserFolder = new File("browser");
		String chromeDriver = (new File(browserFolder, "chromedriver1.exe")).getAbsolutePath();
		String firefoxDriver = (new File(browserFolder, "geckodriver.exe")).getAbsolutePath();
		String edgeDriver = (new File(browserFolder, "msedgedriver.exe")).getAbsolutePath(); 
		String browserName = getProperties("browserName");
	    
		if(browserName.equalsIgnoreCase("Chrome")){
			String chromePath= chromeDriver.replace("\\", "\\\\");
			System.setProperty("webdriver.chrome.driver",chromePath);
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("FireFox")) {
			String firefoxPath= firefoxDriver.replace("\\", "\\\\");
			System.setProperty("webdriver.gecko.driver",firefoxPath);
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")){
			String edgePath= edgeDriver.replace("\\", "\\\\");
			System.setProperty("webdriver.edge.driver",edgePath);
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
//public WebDriver initializeDriver() throws IOException {
//		
//		//----------------------- Browser Properties ---------------------------------------------
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream("C:\\Users\\Amit\\workspace\\OrangeHRM\\src\\main\\java\\Automation\\OrangeHRM\\data.properties");
//		prop.load(fis);
//		String browserName= prop.getProperty("browserName");
//		//System.out.println(browserName);
//		
//		
//		
//		//----------------------- Initiate Browser ----------------------------------------------------
//		if(browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\Amit\\Downloads\\testing doc\\chromedriver_win32\\chromedriver.exe");
//			driver = new ChromeDriver();
//		}
//		else if(browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					"C:\\Users\\Amit\\Downloads\\testing doc\\geckodriver-v0.27.0-win64\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
//		else if(browserName.equalsIgnoreCase("IE")) {
//			//System.setProperty("webdriver.ie.driver", "C:\\Users\\AmitMohanta\\Downloads\\testing doc\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe")
//			//driver = new InternetExplorerDriver();
//		}
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		return driver;
//	
//	}
	
	public String getProperties(String propertyName) throws IOException{
		prop = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\Amit\\workspace\\OrangeHRM\\src\\main\\java\\Automation\\OrangeHRM\\data.properties");
		prop.load(fin);
		String property = prop.getProperty(propertyName);
		return property;
	}
	
}

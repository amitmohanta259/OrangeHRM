package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

class iosWebBrowser implements Runnable {
	public void run() {
		MutlipleDevice r1 = new MutlipleDevice();
		r1.executeTest("iPhone", "iPhone 11", "true", "14.0", "Thread 1", "iphone web testing");
	}
}

class AndroidWeBrowser implements Runnable {
	public void run() {
		MutlipleDevice r1 = new MutlipleDevice();
		r1.executeTest("Android", "Samsung Galaxy S9 Plus", "true", "9.0", "Thread 2", "Android Web Testing");
	}
}

public class MutlipleDevice {
	public static final String USERNAME = "thunderstorm3";
	public static final String AUTOMATE_KEY = "sBLy8p6KRpJABJF8H9X8";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {
		Thread object1 = new Thread(new iosWebBrowser());
		object1.start();
		Thread object2 = new Thread(new AndroidWeBrowser());
		object2.start();
	}
	public void executeTest(String browser, String device_name, String device_type, String os_version, String test_name, String build_name) {
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("browserName", browser);
		  caps.setCapability("device", device_name);
		  caps.setCapability("realMobile", device_type);
		  caps.setCapability("os_version", os_version);
		  caps.setCapability("name", test_name); // test name
		  caps.setCapability("build", build_name); // CI/CD job or build name
	      WebDriver driver;
			try {
				driver = new RemoteWebDriver(new URL(URL), caps);
			    JavascriptExecutor jse = (JavascriptExecutor)driver;
			    // Searching for 'BrowserStack' on google.com
			    driver.get("https://www.google.com");
			    WebElement element = driver.findElement(By.name("q"));
			    element.sendKeys("facebook");
			    element.submit();
			    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			    System.out.println(driver.getTitle());
		    // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page matches 'BrowserStack - Google Search'
		    if (driver.getTitle().contains("facebook")) {
		      jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
		    }
		    else {
		      jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
		    }
		    driver.quit();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

}

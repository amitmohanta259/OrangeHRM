package grid;

//Sample test in Java to run Automate session.
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.net.URL;
public class IosSample {
public static final String AUTOMATE_USERNAME = "thunderstorm3";
public static final String AUTOMATE_ACCESS_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
public static void main(String[] args) throws Exception {
 DesiredCapabilities caps = new DesiredCapabilities();
 caps.setCapability("browserName", "iPhone");
 caps.setCapability("device", "iPhone 11");
 caps.setCapability("realMobile", "true");
 caps.setCapability("os_version", "14.0");
 caps.setCapability("name", "iPhone"); // test name
 caps.setCapability("build", "browser test1"); // CI/CD job or build name
 WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
 driver.get("https://www.google.com");
 WebElement element = driver.findElement(By.name("q"));
 element.sendKeys("facebook");
 element.submit();
 System.out.println(driver.getTitle());
 // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page starts with 'BrowserStack'
 if (driver.getTitle().substring(0,12).equals("facebook")) {
 	markTestStatus("passed","Yaay title matched!",driver);
 }
 else {
 	markTestStatus("failed","Naay title did not match!",driver);
 }
 driver.quit();
}

// This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
public static void markTestStatus(String status, String reason, WebDriver driver) {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
}
} 

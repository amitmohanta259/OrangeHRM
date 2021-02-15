package RegressionTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation.OrangeHRM.baseClass;
import Automation.OrangeHRM.PageObject.DashBoardPO;
import Automation.OrangeHRM.PageObject.LoginPO;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class checkBoxes extends baseClass{

	@BeforeTest
	public void Initialize() throws IOException{
		driver = initializeDriver();
		driver.get("file:///C:/Users/Amit/Desktop/checkbox.html");
	}
	
	@Test
	public void checkBox() throws IOException {
		
		        String forValue =null;
				List<WebElement> element = driver.findElements(By.xpath("/html/body/form/label"));
				for (WebElement webElement : element) {
					if(webElement.getText().contains("car")){
						forValue = webElement.getAttribute("for");
					}
				}
				driver.findElement(By.name(forValue)).click();
	}
	
	@AfterTest
	public void close() {
		//driver.close();
	}

}

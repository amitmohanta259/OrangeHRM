package Automation.OrangeHRM;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Automation.OrangeHRM.PageObject.EmployeeListPO;
import Automation.OrangeHRM.PageObject.NavigationPO;

public class VerifyEmployeeList {
	
	NavigationPO navigationPageObjects;
	EmployeeListPO employeeListPageObjects;
	JsExecutorScript js;
	@Test(priority=1)
	public void enterSearchDetails() throws InterruptedException{
		navigationPageObjects = new NavigationPO(baseClass.driver);
		employeeListPageObjects = new EmployeeListPO(baseClass.driver);
		
		js = new JsExecutorScript<>();
		js.scrollView(navigationPageObjects.employeeList());
		
		navigationPageObjects.pim().click();
		navigationPageObjects.employeeList().click();
		
		Thread.sleep(4000);
		employeeListPageObjects.employeeName().clear();
		employeeListPageObjects.employeeName().sendKeys("a k singh");
		Thread.sleep(2000);
		employeeListPageObjects.search().click();
		
		js.scrollView(employeeListPageObjects.btnAdd());
		Thread.sleep(2000);
		
		List<WebElement> employeeDetails =employeeListPageObjects.employeeTableDetails();
		for (WebElement webElement : employeeDetails) {
			if(!webElement.getText().isEmpty())
				System.out.println(webElement.getText());
		}
	}
}

package Automation.OrangeHRM;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Automation.OrangeHRM.PageObject.EmployeeListPO;
import Automation.OrangeHRM.PageObject.NavigationPO;

public class VerifyEmployeeList {
	
	NavigationPO navigationPageObjects;
	EmployeeListPO employeeListPageObjects;
	JsExecutorScript js;
	List<WebElement> employeeList;
	List<WebElement> employeeDetails;
	
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
		
		
	}
	
	@Test(priority=2)
	public void searchList(){
		employeeList =employeeListPageObjects.employeeList();
		for (WebElement webElement : employeeList) {
			if(!webElement.getText().isEmpty())
				System.out.println(webElement.getText());
			else{
				throw new NoSuchElementException("No Element Found");
			}
		}
	}
	
	@Test(priority=3)
	public void clickToViewProfile(){
		if (!employeeList.isEmpty() && employeeList.get(0).getText().contains("a k Singh")) {
			employeeDetails =employeeListPageObjects.employeeTableDetails();
			employeeDetails.get(1).click();
		}else{
			throw new NoSuchElementException("Element not found");
		}
		
	}
}

package Automation.OrangeHRM;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Automation.OrangeHRM.PageObject.NavigationPO;
public class PimModule{
	public NavigationPO navigationPageObject;
	
	@Test(priority=1)
	public void navigateToPim(){
		navigationPageObject = new NavigationPO(baseClass.driver);
		try {
			Actions action = new Actions(baseClass.driver);
			action.moveToElement(navigationPageObject.pim()).build().perform();
		} catch (Exception e) {
			System.out.println("Error in line no 15-17");
		}
	}
	
	
	@Test(priority=2)
	public void navigateAddEmployee(){
		navigationPageObject.addEmployee().click();
	}
	
	@Test(priority=3)
	public void checkSelectedText(){
		List<WebElement> pimSubElements = baseClass.driver.findElements(By.xpath("//li[@class='current main-menu-first-level-list-item']/ul/li"));
		for (WebElement webElement : pimSubElements) {
			if(webElement.getAttribute("class").equals("selected")){
				String actual = webElement.getText();
				String expected =  "Add Employee";
				try {
					Assert.assertEquals(actual, expected);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Selected Element mismatched");
				}
			}
		}
	}
}

package Automation.OrangeHRM;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Automation.OrangeHRM.PageObject.NavigationPO;
public class PimModule{
	public NavigationPO navigationPageObject;
	
	@Test(priority=2)
	public void addEmployee(){
		System.out.println("Inside add Employee");
		System.out.println(baseClass.driver.getTitle());
		navigationPageObject = new NavigationPO(baseClass.driver);
		try {
			Actions action = new Actions(baseClass.driver);
			action.moveToElement(navigationPageObject.pim()).build().perform();
		} catch (Exception e) {
			System.out.println("Error in line no 12-17");
		}
	}
}

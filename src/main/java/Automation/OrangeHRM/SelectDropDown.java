package Automation.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class SelectDropDown<T>{
	public void SelectDropDownOperations(WebElement element,String selectBy,T value) throws InterruptedException{
		
		Select sc = new Select(element);
		switch (selectBy) {
		case "index":
			sc.selectByIndex((Integer)value);
			break;
			
		case "value":
			sc.selectByValue((String) value);
			break;

		case "visibleText":
			sc.selectByVisibleText((String) value);
			break;
			
		default:
		    Assert.assertTrue(false,"Invalid Selection or invalid value");
			break;
		}
	}
}

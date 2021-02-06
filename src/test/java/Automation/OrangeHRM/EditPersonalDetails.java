package Automation.OrangeHRM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Automation.OrangeHRM.PageObject.PersonalDetailsPO;

public class EditPersonalDetails {
	PersonalDetailsPO personalDetailPageObject;
	@Test(priority=1)
	public void Heading(){
		personalDetailPageObject = new PersonalDetailsPO(baseClass.driver);
		try {
			personalDetailPageObject.editAndSave().click();		
			personalDetailPageObject.licExpDate().click();
			
			//reusable method with 3 arg 1.webElement 2.selectBy 3.value 
			SelectDropDown dropDown = new SelectDropDown<>();
			dropDown.SelectDropDownOperations(personalDetailPageObject.licMonth(),"index",5);
			dropDown.SelectDropDownOperations(personalDetailPageObject.licYear(),"visibleText","1994");
			List<WebElement> dates = personalDetailPageObject.licDate();
			for (WebElement webElement : dates) {
				if(webElement.getText().equals("3")){
					//System.out.println("Webelement value "+webElement.getText());
					webElement.click();
					Thread.sleep(2000);
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		System.out.println(personalDetailPageObject.licExpDate().getText());
	}
}

package Automation.OrangeHRM;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.OrangeHRM.PageObject.PersonalDetailsPO;

public class EditPersonalDetails {
	PersonalDetailsPO personalDetailPageObject;
	SelectDropDown dropDown;
	@Test(priority=1)
	public void Heading(){
		personalDetailPageObject = new PersonalDetailsPO(baseClass.driver);
		Assert.assertTrue(personalDetailPageObject.head().getText().equals("Personal Details"));
	}
	@Test(priority=2)
	public void fillDetails(){
		try {
			personalDetailPageObject.editAndSave().click();		
			personalDetailPageObject.licExpDate().click();
			
			//reusable method with 3 arg 1.webElement 2.selectBy 3.value 
			dropDown = new SelectDropDown<>();
			dropDown.SelectDropDownOperations(personalDetailPageObject.licMonth(),"index",5);
			dropDown.SelectDropDownOperations(personalDetailPageObject.licYear(),"visibleText","2025");
			List<WebElement> dates = personalDetailPageObject.licDate();
			for (WebElement webElement : dates) {
				if(webElement.getText().equals("3")){
					//System.out.println("Webelement value "+webElement.getText());
					webElement.click();
					Thread.sleep(2000);
					break;
				}
			}
			
			dropDown.SelectDropDownOperations(personalDetailPageObject.maritailStatus(), "index", 1);
			dropDown.SelectDropDownOperations(personalDetailPageObject.Nationality(), "visibleText", "Indian");
			personalDetailPageObject.male().click();
			personalDetailPageObject.dateOfBirth().click();
			dropDown.SelectDropDownOperations(personalDetailPageObject.dobMonth(),"index", 2);
			dropDown.SelectDropDownOperations(personalDetailPageObject.dobYear(),"visibleText", "1994");
			List<WebElement> dobDates = (List<WebElement>) personalDetailPageObject.dobDate();
			for (WebElement webElement : dobDates) {
				if(webElement.getText().equals("3")){
					//System.out.println("Webelement value "+webElement.getText());
					webElement.click();
					Thread.sleep(2000);
					break;
				}
			}
			if(personalDetailPageObject.editAndSave().getAttribute("value").equals("Save")){
				personalDetailPageObject.editAndSave().click();
			}else{
				System.out.println("Perform edit first and the save");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		System.out.println(personalDetailPageObject.licExpDate().getText());
	}
	
	@Test(priority=3)
	public void AddBloodGroup() throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)baseClass.driver;
		js.executeScript("arguments[0].scrollIntoView();",personalDetailPageObject.bloodGroup());
		Thread.sleep(2000);
		personalDetailPageObject.editSaveCustom().click();
		dropDown.SelectDropDownOperations(personalDetailPageObject.bloodGroup(), "index", 1);
	}
	
}

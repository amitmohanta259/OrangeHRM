package Automation.OrangeHRM;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Automation.OrangeHRM.PageObject.AddEmployeePO;

public class AddEmployee {

	AddEmployeePO addemployeePageObject;
	String firstName,lastName,middleName;
	
	@Test(priority=5)
	public void fillForm(){
		addemployeePageObject = new AddEmployeePO(baseClass.driver);
		System.out.println("Inside fillForm");
		firstName="a";
		middleName="k";
		lastName="Singh";
		
		addemployeePageObject.firstName().sendKeys(firstName);
		try {
			addemployeePageObject.middleName().sendKeys(middleName);
			addemployeePageObject.lastName().sendKeys(lastName);
			addemployeePageObject.saveBtn().click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found");
		}
	}
	
	@Test(priority=6)
	public void verifyAddEmployee(){
		String profileName = baseClass.driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		String expectedProfileName = firstName+" "+middleName+" "+lastName;
		if(profileName.contains(expectedProfileName)){
			System.out.println("Successfully Added");
		}else{
			System.out.println("Error while adding the Profile name");
		}
	}
	
	
}

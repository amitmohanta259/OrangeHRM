package Automation.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.OrangeHRM.PageObject.AddEmployeePO;

public class AddEmployee {

	AddEmployeePO addemployeePageObject;
	String firstName,lastName,middleName;
	
	@Test(priority=1)
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
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found");
		}
	}
	
	@Test(priority=2, dependsOnMethods={"fillForm"})
	public void createLoginDetails(){
		if(addemployeePageObject.createLoginDetails().isSelected()){
			addemployeePageObject.username().sendKeys("aksingh");
			addemployeePageObject.password().sendKeys("password");
			addemployeePageObject.confirmPassword().sendKeys("password");
			Select sc = new Select(addemployeePageObject.status());
			sc.selectByValue("Enabled");
		}else{
			addemployeePageObject.createLoginDetails().click();
			createLoginDetails();
			Assert.assertTrue(addemployeePageObject.createLoginDetails().isSelected(),"Create Login Deatail is not selected");
		}
	}
	
	@Test(priority=3)
	public void save(){
		addemployeePageObject.saveBtn().click();
	}
	
	@Test(priority=4)
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

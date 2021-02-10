package Automation.OrangeHRM;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.OrangeHRM.PageObject.DashBoardPO;
import Automation.OrangeHRM.PageObject.LoginPO;

public class VerifyUserCredentials {
	LoginPO loginPageObject;
	DashBoardPO dashBoardPageObjects;
	@Test(priority=1)
	public void enterUserCredentials(){
		loginPageObject = new LoginPO(baseClass.driver);
		loginPageObject.adminUsername().sendKeys("aksingh");
		loginPageObject.adminPassword().sendKeys("password");
		loginPageObject.adminloginBtn().click();
	}
	
	@Test(priority=2)
	public void verifyUserCredentials(){
		dashBoardPageObjects = new DashBoardPO(baseClass.driver);
		Assert.assertTrue(dashBoardPageObjects.profileName().getText().contains("a"));
	}
}

package Automation.OrangeHRM;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Automation.OrangeHRM.PageObject.ContactDetailsPO;

public class AddContactDetails {
	ContactDetailsPO contactDetailsPageObjects;
	WebDriverWait wait;
	JsExecutorScript js;
	@Test(priority=1)
	public void clickOnContactDetails(){
		contactDetailsPageObjects = new ContactDetailsPO(baseClass.driver);
		wait = new WebDriverWait(baseClass.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPageObjects.contactDetailsBtn()));
		contactDetailsPageObjects.contactDetailsBtn().click();
	}
	
	@Test(priority=2)
	public void fillUpContactForm() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(contactDetailsPageObjects.street1()));
		js = new JsExecutorScript<>();
		
		js.scrollView(contactDetailsPageObjects.btnSave());
		contactDetailsPageObjects.btnSave().click();
		
		js.scrollView(contactDetailsPageObjects.street1());
		contactDetailsPageObjects.street1().sendKeys("adasdsadasd");
		
		js.scrollView(contactDetailsPageObjects.street2());
		contactDetailsPageObjects.street2().sendKeys("dsadsadasdsa");
		
		js.scrollView(contactDetailsPageObjects.contact_city());
		contactDetailsPageObjects.contact_city().sendKeys("dsadsadasd");
		
		js.scrollView(contactDetailsPageObjects.state());
		contactDetailsPageObjects.state().sendKeys("asdasdas");
		
		js.scrollView(contactDetailsPageObjects.zipcode());
		contactDetailsPageObjects.zipcode().sendKeys("3213123131");
		
		js.scrollView(contactDetailsPageObjects.homeTelephone());
		contactDetailsPageObjects.homeTelephone().sendKeys("453121111222");
		
		js.scrollView(contactDetailsPageObjects.contact_emp_mobile());
		contactDetailsPageObjects.contact_emp_mobile().sendKeys("3331131313131");
		
		js.scrollView(contactDetailsPageObjects.contact_emp_oth_email());
		contactDetailsPageObjects.contact_emp_oth_email().sendKeys("asdasda@adasd.cmmm");
		
		js.scrollView(contactDetailsPageObjects.contact_emp_oth_email());
		contactDetailsPageObjects.contact_emp_oth_email().sendKeys("dasdasda@bdasm.codasdas");
		
		js.scrollView(contactDetailsPageObjects.btnSave());
		contactDetailsPageObjects.btnSave().click();
	}
}

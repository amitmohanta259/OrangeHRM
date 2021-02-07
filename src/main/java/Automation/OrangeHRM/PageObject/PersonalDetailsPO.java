package Automation.OrangeHRM.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPO {
	
	public PersonalDetailsPO(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='head']/h1")
	WebElement head;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement editAndSave;
	
	@FindBy(xpath="//input[@id='personal_txtLicExpDate']")
	WebElement licExpDate;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement licMonth;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement licYear;
	
	@FindBy(xpath="//a[@class='ui-state-default']")
	List<WebElement> licDate;
	
	@FindBy(xpath="//input[@id='personal_DOB']")
	WebElement dateOfBirth;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement dobMonth;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement dobYear;
	
	@FindBy(xpath="//a[@class='ui-state-default']")
	List<WebElement> dobDate;
	
	@FindBy(xpath="//input[@id='personal_optGender_1']")
	WebElement male;
	
	@FindBy(xpath="//input[@id='personal_optGender_2']")
	WebElement female;
	
	@FindBy(xpath="//select[@id='personal_cmbMarital']")
	WebElement maritailStatus;
	
	@FindBy(xpath="//select[@id='personal_cmbNation']")
	WebElement Nationality;
	
	@FindBy(xpath="//select[@class='editable'][@name='custom1']")
	WebElement bloodGroup;
	
	@FindBy(xpath="//input[@id='btnEditCustom']")
	WebElement editSaveCustom;
	
	@FindBy(xpath="//input[@id='btnAddAttachment']")
	WebElement addSaveAttachment;
	
	public WebElement head(){
		return head;
	}
	
	public WebElement editAndSave(){
		return editAndSave;
	}
	
	public WebElement licExpDate(){
		return licExpDate;
	}
	
	public WebElement licMonth(){
		return licMonth;
	}
	
	public WebElement licYear(){
		return licYear;
	}
	
	public List<WebElement> licDate(){
		return  licDate;
	}
	
	public WebElement dateOfBirth(){
		return dateOfBirth;
	}
	
	public WebElement dobMonth(){
		return dobMonth;
	}
	
	public WebElement dobYear(){
		return dobYear;
	}
	
	public List<WebElement> dobDate(){
		return dobDate;
	}
	
	public WebElement male(){
		return male;
	}
	
	public WebElement female(){
		return female;
	}
	
	public WebElement maritailStatus(){
		return maritailStatus;
	}
	
	public WebElement Nationality(){
		return Nationality;
	}
	
	public WebElement bloodGroup(){
		return bloodGroup;
	}
	
	public WebElement editSaveCustom(){
		return editSaveCustom;
	}
	
	
}

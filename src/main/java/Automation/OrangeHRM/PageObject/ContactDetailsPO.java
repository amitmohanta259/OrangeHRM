package Automation.OrangeHRM.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPO {
	
	public ContactDetailsPO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Contact Details")
	WebElement contactDetailsBtn;
	
	@FindBy(xpath="//input[@id='contact_street1']")
	WebElement street1;
	
	@FindBy(xpath="//input[@id='contact_street2']")
	WebElement street2;
	
	@FindBy(xpath="//input[@id='contact_city']")
	WebElement contact_city;
	
	@FindBy(xpath="//input[@id='contact_province']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='contact_emp_zipcode']")
	WebElement zipcode;
	
	@FindBy(xpath="//select[@id='contact_country']")
	List<WebElement> country;
	
	@FindBy(xpath="//input[@id='contact_emp_hm_telephone']")
	WebElement homeTelephone;
	
	@FindBy(xpath="//input[@id='contact_emp_mobile']")
	WebElement contact_emp_mobile;
	
	@FindBy(xpath="//input[@id='contact_emp_work_telephone']")
	WebElement contact_emp_work_telephone;
	
	@FindBy(xpath="//input[@id='contact_emp_work_email']")
	WebElement contact_emp_work_email;
	
	@FindBy(xpath="//input[@id='contact_emp_oth_email']")
	WebElement contact_emp_oth_email;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement btnSave;
	
	@FindBy(xpath="//input[@id='btnAddAttachment']")
	WebElement btnAddAttachment;
	
	@FindBy(xpath="//input[@id='ufile']")
	WebElement ufile;
	
	@FindBy(xpath="//input[@id='txtAttDesc']")
	WebElement txtAttDesc;
	
	@FindBy(xpath="//input[@id='btnSaveAttachment']")
	WebElement btnSaveAttachment;
	
	@FindBy(xpath="//input[@id='cancelButton']")
	WebElement cancelButton;
	
	
	public WebElement contactDetailsBtn(){
		return contactDetailsBtn;
	}
	
	public WebElement street1(){
		return street1;
	}
	
	public WebElement street2(){
		return street2;
	}
	
	public WebElement contact_city(){
		return contact_city;
	}
	
	public WebElement state(){
		return state;
	}
	
	public WebElement zipcode(){
		return zipcode;
	}
	
	public List<WebElement> country(){
		return country;
	}
	
	public WebElement homeTelephone(){
		return homeTelephone;
	}
	
	public WebElement contact_emp_mobile(){
		return contact_emp_mobile;
	}
	
	public WebElement contact_emp_work_telephone(){
		return contact_emp_work_telephone;
	}
	
	public WebElement contact_emp_work_email(){
		return contact_emp_work_email;
	}
	
	public WebElement contact_emp_oth_email(){
		return contact_emp_oth_email;
	}
	
	public WebElement btnSave(){
		return btnSave;
	}
	
	public WebElement btnAddAttachment(){
		return btnAddAttachment;
	}
	
	public WebElement ufile(){
		return ufile;
	}
	
	public WebElement txtAttDesc(){
		return txtAttDesc;
	}
	
	public WebElement btnSaveAttachment(){
		return btnSaveAttachment;
	}
	
	public WebElement cancelButton(){
		return cancelButton;
	}
	
}

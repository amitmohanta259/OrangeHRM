package Automation.OrangeHRM.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePO {
	
	public AddEmployeePO(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='head']")
	WebElement head;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='middleName']")
	WebElement middleName;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='employeeId']")
	WebElement empID;
	
	@FindBy(xpath="//input[@id='photofile']")
	WebElement photograph;
	
	@FindBy(xpath="//input[@id='chkLogin']")
	WebElement createLoginDetails;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='validation-error']")
	WebElement errorMsg;
	
	@FindBy(xpath="//input[@id='user_name']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='re_password']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//*[@id='status']")
	WebElement status;
	
	
	public WebElement head(){
		return head;
	}
	
	public WebElement firstName(){
		return firstName;
	}
	
	public WebElement middleName(){
		return middleName;
	}
	
	public WebElement lastName(){
		return lastName;
	}
	
	public WebElement empID(){
		return empID;
	}
	
	public WebElement photograph(){
		return photograph;
	}
	
	public WebElement createLoginDetails(){
		return createLoginDetails;
	}
	
	public WebElement saveBtn(){
		return saveBtn;
	}
	
	public WebElement username(){
		return username;
	}
	
	public WebElement password(){
		return password;
	}
	
	public WebElement confirmPassword(){
		return confirmPassword;
	}
	
	public WebElement status(){
		return status;
	}
	
	public WebElement errorMsg(){
		return errorMsg;
	}
}

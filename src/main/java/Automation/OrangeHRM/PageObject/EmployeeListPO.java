package Automation.OrangeHRM.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.OrangeHRM.baseClass;

public class EmployeeListPO {
	public EmployeeListPO(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='empsearch_employee_name_empName']")
	WebElement employeeName;
	
	@FindBy(xpath="//input[@id='empsearch_id']")
	WebElement employeeSearchID;
	
	@FindBy(xpath="//*[@id='empsearch_employee_status']")
	WebElement employeeStatus;
	
	@FindBy(xpath="//select[@id='empsearch_termination']")
	WebElement employeeSearchTermination;
	
	@FindBy(xpath="//input[@id='empsearch_supervisor_name']")
	WebElement empsearchSupervisorName;
	
	@FindBy(xpath="//select[@id='empsearch_job_title']")
	WebElement empsearchJobTitle;
	
	@FindBy(xpath="//select[@id='empsearch_sub_unit']")
	WebElement empsearchSubUnit;
	
	@FindBy(xpath="//*[@id='resultTable']/tbody/tr")
	List<WebElement> employeeList;
	
	@FindBy(xpath="//*[@id='resultTable']/tbody/tr/td")
	List<WebElement> employeeTableDetails;
	
	@FindBy(xpath="//*[@id='searchBtn']")
	WebElement search;
	
	@FindBy(xpath="//*[@id='resetBtn']")
	WebElement resetBtn;
	
	@FindBy(xpath="//*[@id='btnAdd']")
	WebElement btnAdd;
	
	@FindBy(xpath="//*[@id='btnDelete']")
	WebElement btnDelete;
	
	public WebElement employeeName(){
		return employeeName;
	}
	
	public WebElement employeeSearchID(){
		return employeeSearchID;
	}
	
	public WebElement employeeStatus(){
		return employeeStatus;
	}
	
	public WebElement employeeSearchTermination(){
		return employeeSearchTermination;
	}
	
	public WebElement empsearchSupervisorName(){
		return empsearchSupervisorName;
	}
	
	public WebElement empsearchJobTitle(){
		return empsearchJobTitle;
	}
	
	public WebElement empsearchSubUnit(){
		return empsearchSubUnit;
	}
	
	public List<WebElement> employeeList(){
		return employeeList;
	}
	
	public List<WebElement> employeeTableDetails(){
		return employeeTableDetails;
	}
	
	public WebElement search(){
		return search;
	}
	
	public WebElement resetBtn(){
		return resetBtn;
	}
	
	public WebElement btnAdd(){
		return btnAdd;
	}
	
	public WebElement btnDelete(){
		return btnDelete;
	}
	
	
	
}

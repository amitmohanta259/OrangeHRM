package Automation.OrangeHRM.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPO {

	public NavigationPO(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']")
	WebElement admin;
	
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	WebElement pim;
	
//	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
//	WebElement leave;
//	
//	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
//	WebElement time;
//	
//	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
//	WebElement recruitment;
//	
//	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
//	WebElement myInfo;
//	
//	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
//	WebElement performance;
//	
//	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
//	WebElement dashboard;
//	
//	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
//	WebElement directory;
//	
//	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
//	WebElement maintenance;
//	
//	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
//	WebElement buzz;
//	
	@FindBy(xpath="//a[@id='menu_pim_Configuration']")
	WebElement configuration;
	
	@FindBy(xpath="//a[@id='menu_pim_viewEmployeeList']")
	WebElement employeeList;
	
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	WebElement addEmployee;
	
	@FindBy(xpath="//a[@id='menu_core_viewDefinedPredefinedReports']")
	WebElement reports;
	
	public WebElement pim(){
		return pim;
	}
	
	public WebElement employeeList(){
		return employeeList;
	}
	
	public WebElement addEmployee(){
		return addEmployee;
	}
	
	public WebElement reports(){
		return reports;
	}
	
}

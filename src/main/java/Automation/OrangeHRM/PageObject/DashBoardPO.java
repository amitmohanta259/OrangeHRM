package Automation.OrangeHRM.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPO {
	
	public DashBoardPO(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='MP_link']")
	WebElement marketPlace;
	
	@FindBy(xpath="//input[@id='Subscriber_link']")
	WebElement subscribe;
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement profileName;
	
	@FindBy(xpath="//a[@id='aboutDisplayLink']")
	WebElement about;
	
	@FindBy(linkText="Logout")
	WebElement logoutBtn;
	
	
	
	public WebElement marketPlace(){
		return marketPlace;
	}
	
	public WebElement subscribe(){
		return subscribe;
	}
	
	public WebElement profileName(){
		return profileName;
	}
	
	public WebElement about(){
		return about;
	}
	
	public WebElement logoutBtn(){
		return logoutBtn;
	}
}

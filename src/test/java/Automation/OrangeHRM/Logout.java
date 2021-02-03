package Automation.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Logout{
	
	@Test(priority=3)
	public void logOut(){
		WebDriverWait wait = new WebDriverWait(baseClass.driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(baseClass.driver.findElement(By.xpath("//a[@id='welcome']"))));
		baseClass.driver.findElement(By.xpath("//a[@id='welcome']")).click();
		baseClass.driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterTest()
	public void close() throws InterruptedException{
		Thread.sleep(3000);
		baseClass.driver.close();
	}
}

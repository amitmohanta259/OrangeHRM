package Automation.OrangeHRM;

import org.openqa.selenium.JavascriptExecutor;

public class JsExecutorScript<T>{
	
	public void scrollView(T element) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)baseClass.driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
		Thread.sleep(2000);
	}
}

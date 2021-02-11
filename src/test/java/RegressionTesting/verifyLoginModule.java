package RegressionTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation.OrangeHRM.baseClass;
import Automation.OrangeHRM.PageObject.DashBoardPO;
import Automation.OrangeHRM.PageObject.LoginPO;

public class verifyLoginModule extends baseClass{
	
	LoginPO loginPageObjects;
	DashBoardPO dashboardPageObjects;
	WebDriverWait wait;
	
	@BeforeTest
	public void navigateToAdminLogin() throws IOException{
		
		driver = initializeDriver();
		driver.get(getProperties("url"));
		System.out.println("The title of the page is "+driver.getCurrentUrl());
		loginPageObjects = new LoginPO(driver);
		dashboardPageObjects = new DashBoardPO(driver);
	}
	
	@Test(priority=1, dataProvider="getLoginCredentails")
	public void validUserCredentials(String username,String password,String actualResult){
		System.out.println(username+"============"+password+"============="+actualResult);
		String expectedResult="";
		loginPageObjects.adminUsername().sendKeys(username);
		loginPageObjects.adminPassword().sendKeys(password);
		loginPageObjects.adminloginBtn().click();
		try {
			System.out.println(dashboardPageObjects.profileName().getText());
			expectedResult = "valid";
			wait = new WebDriverWait(baseClass.driver, 10);
			wait.until(ExpectedConditions.visibilityOf(dashboardPageObjects.profileName()));
			dashboardPageObjects.profileName().click();
			dashboardPageObjects.logoutBtn().click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(loginPageObjects.errorMsg()));
			expectedResult = loginPageObjects.errorMsg().toString();
		}
	
	}
	
	@DataProvider
	public Object[][] getLoginCredentails() throws IOException{		
		
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Automation\\OrangeHRM\\DataSets.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fin);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		Object[][] data = new Object[rowCount][3];
		if (rowCount!=0) {
			for(int i=1;i<rowCount;i++){
				Row row=sheet.getRow(i);

				try {
					data[i][0] = row.getCell(0).getStringCellValue();
				} catch (Exception e) {
					row.createCell(0).setCellValue("");
					data[i][0] = row.getCell(0).getStringCellValue();
				}
				
				try {
					data[i][1] = row.getCell(1).getStringCellValue();
				} catch (Exception e) {
					row.createCell(1).setCellValue("");
					data[i][1] = row.getCell(1).getStringCellValue();
				}
				
				data[i][2] = row.getCell(2).getStringCellValue();
			}
		}
		FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Automation\\OrangeHRM\\DataSets.xlsx");
		book.write(fo);
		return data;
		
	}
	
	@AfterTest
	public void close(){
		driver.close();
	}
	
}

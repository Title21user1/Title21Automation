package org.title21.AdminModule_Test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.Reports_POM;

import org.title21.utility.BaseClass;
/*
 * not to execute now.

public class ReportPage_Test extends BaseClass
{
	
public LoginPage_POM login =new LoginPage_POM();
Reports report=new Reports();
@BeforeClass
public void openURL() 
{
	browser("Chrome", "https://quantumdev.title21.com");
}
@Test
public void Login() throws Exception
{
	login.login_username(driver).sendKeys("admin");
	login.login_BTN(driver).click();
	login.login_password(driver).sendKeys("administrator");
	login.login_BTN(driver).click();
	//Alert a = driver.switchTo().alert();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn t21-btn-default']")).click();
	
}
@Test
public void verifyReports()
{
	
	report.reportLinks(driver).click();
}
}
*/
package org.title21.test;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.POM.AdministrationCreateNewGroup_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

import net.sourceforge.htmlunit.corejs.javascript.serialize.ScriptableOutputStream;

public class CreateGroup_Test extends BaseClass {

	LoginPage_POM login = new LoginPage_POM();
	public LogoutPage_POM logout = new LogoutPage_POM();
	boolean group=false;
	String className="";
	AdministrationCreateNewGroup_POM adminCreateGroup = new AdministrationCreateNewGroup_POM();
	
	
	@BeforeClass
	public void openURL() 
	{
		//browser("Chrome", "https://quantumdev.title21.com");
		
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		//Call Login keyword
		test = extent.startTest("LoginFunction");
		login.login_username(driver).sendKeys(data[0][0]);
		test.log(LogStatus.PASS, "Username Entered");
		login.login_BTN(driver).click();
		test.log(LogStatus.PASS, "Clicked on Login button after entering Username.");
		
		login.login_password(driver).sendKeys(data[1][1]);
		test.log(LogStatus.PASS, "Correct password Entered.");
		login.login_BTN(driver).click();
		test.log(LogStatus.PASS, "Clicked on Login button."+
		test.addScreenCapture(captureScreenShot(driver, "View after Loggedin.")));	
		extent.endTest(test);
	}
	
	@Test(testName = "CreateGroup_admin", groups = "CreateGroup", priority = 0)
	public void CreateGroupInAdmin() 
	{
		BaseClass.getAdministrationPage();
		
		test = extent.startTest("CreateGroup_admin");
		test.addScreenCapture(captureScreenShot(driver, "AfterEnteringProperUsername"));
		
		
		String GroupsTab = adminCreateGroup.groupsTab(driver).getText();
		
		if(GroupsTab.contains("Groups"))
		{
			adminCreateGroup.groupsTab(driver).click();
			test.log(LogStatus.PASS, "Successfully click on 'Groups tab");
			adminCreateGroup.groupAddNewLink(driver).click();
			test.log(LogStatus.PASS, "Successfully click on 'Add New' link.");
			adminCreateGroup.verifyAddGroupPopUp(driver);
			test.log(LogStatus.PASS, "Verify 'Add Group' pop-up.");
			test.addScreenCapture(captureScreenShot(driver, "AfterEnteringProperUsername"));
			
			sleep(2);
			
			adminCreateGroup.addGroupCancelButton(driver).click();
			test.log(LogStatus.PASS, "Successfully click on 'Cancel' button");
			
			sleep(2);
			
			String AddNewTest = adminCreateGroup.groupAddNewLink(driver).getText();
			
			if(AddNewTest.contains("Add New")) {
				
				test.log(LogStatus.PASS, "Successfully navigate on 'Administration' page");
				
			}else {
				
				test.log(LogStatus.FAIL, "Unable to navigate on 'Administration' page after cancel pop-up.");
			}
		//	test.addScreenCapture(captureScreenShot(driver, "AfterEnteringProperUsername"));
			
			adminCreateGroup.groupAddNewLink(driver).click();
			test.log(LogStatus.PASS, "Successfully click on 'Add New' link.");
			
			adminCreateGroup.verifyAddGroupPopUp(driver);
			test.log(LogStatus.PASS, "Verify 'Add Group' pop-up.");
		//	test.addScreenCapture(captureScreenShot(driver, "AfterEnteringProperUsername"));
			
			adminCreateGroup.groupLocationDropDownClick(driver).click();
			
			//Select location
			Select SelectObj = new Select(adminCreateGroup.groupLocationDropDownClick(driver));
			SelectObj.selectByVisibleText("Dallas");
			
			String location = adminCreateGroup.groupLocationDropDownClick(driver).getText();
			
			if(location.contains("Dallas"))
			{
				test.log(LogStatus.PASS, "Successfully set 'Dallas' Location.");
			}else{
				test.log(LogStatus.FAIL, "Unable to set 'Dallas' Location.");
			}
			
			//provide group name 
			adminCreateGroup.addGroupTextBox(driver).sendKeys("Test1234");
			
			//String GroupName = adminCreateGroup.addGroupTextBox(driver).getText();
		//	test.addScreenCapture(captureScreenShot(driver, "AfterEnteringProperUsername"));
			/*if(GroupName.contains("Test1234"))
			{
				test.log(LogStatus.PASS, "Successfully set 'Test1234' group.");
			}else{
				test.log(LogStatus.FAIL, "Unable to set 'Test1234' group.");
			}*/
			
			//adminCreateGroup.acceptToAddGroup(driver);
			
			adminCreateGroup.addGroupAddButton(driver).click();
			
			
			if(adminCreateGroup.verifyAlerPopUp(driver)) 
			{
				adminCreateGroup.alerCloseButton(driver).click();
				test.log(LogStatus.PASS, "Successfully close alert PopUp.");
				
			}else {
				test.log(LogStatus.FAIL, "Unable to close alert PopUp.");
			}
			
			/*Alert alert= driver.switchTo().alert();
			String alertMessg=driver.switchTo().alert().getText();
			System.out.println(alertMessg);
			sleep(2);
			alert.accept();*/
			
			
			if(adminCreateGroup.groupFilterResult(driver) != null)
			{
				adminCreateGroup.groupFilterResult(driver).click();
				adminCreateGroup.groupFilterResult(driver).sendKeys("Test");
				adminCreateGroup.groupFilterResutGoButton(driver).click();
			//	adminCreateGroup.groupFilterResutGoButton(driver).click();
				
				//List<WebElement> allGroups = (List<WebElement>) adminCreateGroup.listOfGroups(driver);

				//String allGroupList = adminCreateGroup.listOfGroups(driver).getTagName();
				String allGroupList = adminCreateGroup.listOfGroups(driver).getText();
				
				List<WebElement> allGrouplist2 = driver.findElements(By.xpath("//tbody[@class='t21-js-clickable-rows']/tr/td"));
				System.out.println(allGrouplist2);
				
				if(allGroupList.contains("Test1234")) {
					
					test.log(LogStatus.PASS, "Successfully group is created.");
					
				}else {
					test.log(LogStatus.FAIL, "Successfully group is created.");
				}
				
				
				
				/*for ( WebElement Group: allGroups) 
				{ 
			        if ( Group.getText().contains("Text1234") ) {
			        	group= true;
			        }
			    }
				
				if(group==true)
				{
					test.log(LogStatus.PASS, "Successfully group is created.");
		        }else{
		        	test.log(LogStatus.FAIL, "Successfully group is created.");
		        }*/
			}
			else
			{
				test.log(LogStatus.PASS, "Unable to find 'Filter Result' text field.");
			}
			
		}else{
			
			test.log(LogStatus.FAIL, "Unable to find 'Groups' tab");
			
		}
		extent.endTest(test);
	}
	
	@AfterClass
	public void closeBrowserInstance() 
	{
		//call Logout keyword
		test = extent.startTest("logoutFunction");
		logout.administratorDropDown(driver).click();
		test.log(LogStatus.PASS, "Clicked on Administrator dropdown after sucessfully login.");
		logout.logoutLink(driver).click();
		test.log(LogStatus.PASS, "Clicked on logout link"+
		test.addScreenCapture(captureScreenShot(driver, "clickonLogoutlink")));	
		
		sleep(2);
		
		if (logout.verifyMessageonModalDialog(driver)){
			test.log(LogStatus.PASS, "Message on Logout alert verified."+
			test.addScreenCapture(captureScreenShot(driver, "Logout Alert")));
		};
		
		logout.logoutButton(driver).click();
		test.log(LogStatus.PASS, "Clicked on logout button"+
		test.addScreenCapture(captureScreenShot(driver, "ClickOnLogoutButton")));
		extent.endTest(test);
		
		
		driver.close();
	}

	
	
}

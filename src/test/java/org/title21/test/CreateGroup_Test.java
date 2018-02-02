package org.title21.test;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.POM.AdministrationCreateNewGroup_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;
public class CreateGroup_Test extends BaseClass {

	LoginPage_POM login; 
	LogoutPage_POM logout;
	String className="";
	AdministrationCreateNewGroup_POM adminCreateGroup;
	
	
	@BeforeClass
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login=new LoginPage_POM(driver);
		login.loginFunction();
	}
	
	@Test(testName = "CreateGroup_admin", groups = "CreateGroup", priority = 0)
	public void CreateGroupInAdmin() 
	{
		BaseClass.getAdministrationPage();
		
		test = extent.startTest("CreateGroup_admin");
		test.addScreenCapture(captureScreenShot(driver, "getAdministrationPage"));
		
		String GroupsTab = adminCreateGroup.groupsTab(driver).getText();
		
		if(GroupsTab.contains("Groups"))
		{
			adminCreateGroup.groupsTab(driver).click();
			test.log(LogStatus.PASS, "Successfully click on 'Groups tab");
			adminCreateGroup.groupAddNewLink(driver).click();
			test.log(LogStatus.PASS, "Successfully click on 'Add New' link.");
			adminCreateGroup.verifyAddGroupPopUp(driver);
			test.log(LogStatus.PASS, "Verify 'Add Group' pop-up.");
			test.addScreenCapture(captureScreenShot(driver, "Add Group"));
			
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
			test.addScreenCapture(captureScreenShot(driver, "AdministrationPage"));
			
			adminCreateGroup.groupAddNewLink(driver).click();
			test.log(LogStatus.PASS, "Successfully click on 'Add New' link.");
			sleep(2);
			adminCreateGroup.verifyAddGroupPopUp(driver);
			test.log(LogStatus.PASS, "Verify 'Add Group' pop-up.");
			test.addScreenCapture(captureScreenShot(driver, "AddGroup"));
			
			adminCreateGroup.groupLocationDropDownClick(driver).click();
			sleep(2);
			Select SelectObj = new Select(adminCreateGroup.groupLocationDropDownClick(driver));
			SelectObj.selectByVisibleText("Dallas");
			
			String location = adminCreateGroup.groupLocationDropDownClick(driver).getText();
			
			if(location.contains("Dallas"))
			{
				test.log(LogStatus.PASS, "Successfully set 'Dallas' Location.");
			}else{
				test.log(LogStatus.FAIL, "Unable to set 'Dallas' Location.");
			}
			
			adminCreateGroup.addGroupTextBox(driver).sendKeys("Test123");
			adminCreateGroup.addGroupTextBox(driver).click();
			
			
			if(adminCreateGroup.verifyalreadyGroupCreatedErrorMsg(driver)) {
				
				adminCreateGroup.addGroupCancelButton(driver).click();
				
			}
			else 
			{
				adminCreateGroup.addGroupAddButton(driver).click();
				
				if(adminCreateGroup.verifyAlerPopUp(driver)) 
				{
					adminCreateGroup.alerCloseButton(driver).click();
					test.log(LogStatus.PASS, "Successfully close alert PopUp.");
					test.addScreenCapture(captureScreenShot(driver, "AftercloseAlert"));
				}else {
					test.log(LogStatus.FAIL, "Unable to close alert PopUp.");
				}
				
				if(adminCreateGroup.groupFilterResult(driver) != null)
				{
					adminCreateGroup.groupFilterResult(driver).click();
					adminCreateGroup.groupFilterResult(driver).sendKeys("Test123");
					adminCreateGroup.groupFilterResutGoButton(driver).click();
					String allGroupList = adminCreateGroup.listOfGroups(driver).getText();
					test.addScreenCapture(captureScreenShot(driver, "listOfGroups"));
					
					if(allGroupList.contains("Test123")) {
						
						test.log(LogStatus.PASS, "Successfully group is created.");
						test.addScreenCapture(captureScreenShot(driver, "groupCreated"));
					}else {
						test.log(LogStatus.FAIL, "Successfully group is created.");
					}
				}
				else
				{
					test.log(LogStatus.PASS, "Unable to find 'Filter Result' text field.");
				}
				
			
				
			}
			
		}else{
			
			test.log(LogStatus.FAIL, "Unable to find 'Groups' tab");
		}
		extent.endTest(test);
	}
	
	@Test(testName = "logout_admin", groups = "Logout", priority = 1)
	public void LoginWithInvalidCredentials() throws Exception 
	{		
		logout=new LogoutPage_POM(driver);
		logout.logoutFunction();		
	}
	
	@AfterClass
	public void closeBrowserInstance() 
	{
		driver.close();
	}

}

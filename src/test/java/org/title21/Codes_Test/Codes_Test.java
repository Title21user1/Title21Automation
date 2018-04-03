package org.title21.Codes_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.Codes_POM.Codes_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.POM.Table;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;
public class Codes_Test extends BaseClass {

	LoginPage_POM login; 
	LogoutPage_POM logout;
	Table searchTable;
	Table groupTable;
	String className="";
	String number="";
	Codes_POM codes;
	boolean isRecordFound=false;
	String testcaseName="TestCase-WIA-Codes.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;
	
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
		codes = new Codes_POM(driver);
		test = extent.startTest("Create & Delete Groups");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		
		test.log(LogStatus.PASS, "1.Log in as the admin user.");
		codes.administratorDropDown().click();
		
		test.log(LogStatus.PASS, "2.Go to the administration page.");
		codes.administrationLink().click();
		
		sleep(4);
		verticalScrollingDown();
		test.log(LogStatus.PASS, "3.Click on codes."+
		test.addScreenCapture(captureScreenShot(driver, "Codes tab")));
		codes.codes_Tab().click();
		sleep(2);
		
		verticalScrollingUp();
		test.log(LogStatus.PASS, "4.Click on add class button.");
		codes.addCodeClass_Link().click();
		
		sleep(2);
		if(codes.addCodeClass_Header().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER1- Add code class dialog is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "addCodeClass_Header")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the Add code class dialog box.");
		}
		
		test.log(LogStatus.PASS, "5.Enter class name. ");
		codes.className_TextBox().sendKeys("Test case sp code2");
		
		test.log(LogStatus.PASS, "6.Click on add button.");
		codes.add_Button().click();
		
		sleep(2);
		if(codes.codeAddedSuccessfully_VerificationMsg().isDisplayed())
		{
			codes.close_Button().click();
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the successfully message for the Code added.");
		}
		
		if(codes.addCodeCategory_Link().isEnabled())
		{
			test.log(LogStatus.PASS, "<b>ER2- Code class added successfully and 'Add category' section is enabled.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Code class added successfully")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the 'Add category' section is enabled.");
		}
		
		test.log(LogStatus.PASS, "7.Enter code class name same as used in step(5)");
		codes.editClass_Icon().click();
		sleep(2);
		codes.className_TextBox().sendKeys("Test case sp code2");
		codes.add_Button().click();
		sleep(2);
		
		if(codes.nameAlreadyExists_ErrorMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER3- 'CodeName already exists' validation message is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "CodeName already exists")));
			codes.cancel_Button().click();
			sleep(2);
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the validation message for the 'CodeName already exists'.");
		}
		
		test.log(LogStatus.PASS, "9.Click on add category button.");
		codes.addCodeCategory_Link().click();
		sleep(2);

		if(codes.addCodeCategory_Header().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER4- Add code category popup screen is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Add code category popup")));
		}
		else
		{
			test.log(LogStatus.PASS, "Unable to find the Add code category popup screen.");
		}
		
		test.log(LogStatus.PASS, "10.Enter code category name.");
		codes.codeCategory_TextBox().sendKeys("sp code category");
		codes.add_Button().click();
		sleep(2);

		if(codes.codeAddedSuccessfully_VerificationMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER5- Code category added successfully and 'Add code' section is enabled.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Add code category popup")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the Code category added successfully and 'Add code' section is enabled.");
		}
		
		test.log(LogStatus.PASS, "12.Click on the close button.");
		codes.close_Button().click();
		
		test.log(LogStatus.PASS, "13.Click on add code button.");
		codes.addCodeName_Link().click();
		
		waitTillElementVisible(codes.addCodePopUp_Header());
		if(codes.addCodePopUp_Header().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER6- Add code popup screen is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Add code popup screen")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the Add code popup screen.");
		}
		
		test.log(LogStatus.PASS, "14.Click on add button.");
		codes.add_Button().click();
		
		waitTillElementVisible(codes.codeIdIsRequired_ErrorMsg());
		if(codes.codeIdIsRequired_ErrorMsg().isDisplayed()&& codes.nameIsRequired_ErrorMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER7- 'Code Id is required' and 'Code name is required' validation messages are displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Add code popup screen")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the 'Code Id is required' and 'Code name is required' validation messages.");
		}
		
		test.log(LogStatus.PASS, "15.Enter code Id");
		codes.addCodeId_TextBox().sendKeys("002");
		
		test.log(LogStatus.PASS, "16.Enter code name.");
		codes.addCodeName_TextBox().sendKeys("Test2");
		
		test.log(LogStatus.PASS, "17.Enter definition.");
		codes.addCodeDefinition_TextBox().sendKeys("Summary test2");
		
		test.log(LogStatus.PASS, "18.Select criticality from criticality dropdown.");
		codes.addCodeCritIdDropDown().selectByVisibleText("Critical");
		
		test.log(LogStatus.PASS, "19.Click on add button.");
		codes.add_Button().click();
		
		waitTillElementVisible(codes.codeAddedSuccessfully_VerificationMsg());
		if(codes.codeAddedSuccessfully_VerificationMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER8- A successful message for newly added code is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "A successful message for newly added code")));
			codes.close_Button().click();
		}
		else
		{
			test.log(LogStatus.PASS, "Unable to find the successful message for newly added code");
		}
		
		test.log(LogStatus.PASS, "20.Enter the code id same as used in step(15).");
		codes.addCodeName_Link().click();
		waitTillElementVisible(codes.addCodePopUp_Header());
		if(codes.addCodePopUp_Header().isDisplayed())
		{
			codes.addCodeId_TextBox().sendKeys("002");
			codes.add_Button().click();
			if(codes.codeId_ErrorMsg().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER9- 'CodeID already exists' validation message is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "CodeID already exists")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to d=find the 'CodeID already exists' validation message");
			}
			
			test.log(LogStatus.PASS, "21.Enter the code name same as used in step(16)");
			codes.addCodeName_TextBox().sendKeys("Test2");
			codes.add_Button().click();
			
			if(codes.nameAlreadyExists_ErrorMsg().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER10- 'Code Name already exists' validation message is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Code Name already exists")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the 'Code Name already exists' validation message.");
			}
			
			test.log(LogStatus.PASS, "22.Click on the cancel button.");
			codes.cancel_Button().click();
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the Add code popup screen.");
		}
		
		test.log(LogStatus.PASS, "23.Select other code class from code class dropdown.");
		codes.codeClass_DropDown().selectByVisibleText("Test doc class");
		
		test.log(LogStatus.PASS, "24.Click on add code.");
		codes.addCodeName_Link().click();
		
		waitTillElementVisible(codes.addCodeName_TextBox());
		test.log(LogStatus.PASS, "25.Enter code name same as used in step (16)");
		codes.addCodeName_TextBox().sendKeys("Test2");
		codes.addCodeId_TextBox().click();
		if(!codes.nameAlreadyExists_ErrorMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER11- Code name is accepted as Code Name is only unique within the Code Class.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Code name is accepted")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the Code name is accepted as Code Name");
		}
		codes.cancel_Button().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "26.Navigate to 'Code Availability' interface.");
		verticalScrollingDown();
		codes.getCodeAvailabilityList_Link().click();
		
		test.log(LogStatus.PASS, "27.Search for 'IndxCard' in the search field and click on go button.");
		codes.filterResult_TextBox().sendKeys("IndxCard");
		sleep(2);
		codes.filterResultGo_Button().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "28.Edit the 'IndxCard'.");
		clickOnEditButton("IndxCard");
		
		test.log(LogStatus.PASS, "29.Search for newly created code class (in previous steps) in the select a code class section.");
		waitTillElementVisible(codes.updateCodeAvailabilityIndexCard_Header());
		if(codes.updateCodeAvailabilityIndexCard_Header().isDisplayed())
		{
			getTrainingCompletedItem("Test case sp code2");
			if(isRecordFound)
			{
				//ER 12 – Code class gets added in selected code class section.
			}
			else
			{
				
			}
			
			test.log(LogStatus.PASS, "31.Click on the update button");
			codes.update_Button().click();
			
			waitTillElementVisible(codes.codeupdatedSuccessfully_VerificationMsg());
			if(codes.codeupdatedSuccessfully_VerificationMsg().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER13- A successful update message of Code classes for event type 'IndxCard' is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Code name is accepted")));
				test.log(LogStatus.PASS, "32.Click on the close button.");
				codes.close_Button().click();
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the successful update message of Code classes for event type 'IndxCard'");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the Update Code Availability Index Card Header");
		}
		
		test.log(LogStatus.PASS, "33.Logout from admin user and log in as a test user.");
		logout.logoutFunction();
		login.loginUser("", "");
		
		test.log(LogStatus.PASS, "34.Open an existing document that contains the codes control.");
		
		
		
		
		
		
		
		
		
	}
	
	@Test(testName = "logout_admin", groups = "Logout", priority = 1)
	public void LogoutFromAdmin() throws Exception 
	{		
		logout=new LogoutPage_POM(driver);
		logout.logoutFunction();		
	}
	
	@AfterClass
	public void closeBrowserInstance() 
	{
		extent.endTest(test);
		driver.close();
	}
	
	private void clickOnEditButton(String eventType)
	{
		
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.gettableCells(1);				
		
		for (int i=1;i<=tableCells.size();i++){
			if (eventType.equalsIgnoreCase(tableCells.get(i-1).getText()))
			{				
				WebElement delete = driver.findElement(By.xpath("//span[@class='fa fa-pencil action-items'][@title='Edit Code Availability']"));
				delete.click();
				break;
			}
		}
	}
	
	private boolean getTrainingCompletedItem(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getCodeavabilityItemCell(2);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{													
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
}

package org.title21.Module3_Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.Table;
import org.title21.Module3_POM.Codes_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.FunctionUtils;

import com.relevantcodes.extentreports.LogStatus;
public class Codes_Test extends BaseClass {

	LoginPage_POM login; 
	LogoutPage_POM logout;
	Table searchTable;
	String className="";
	String number="";
	String documetNo="";
	String categoryName="";
	String codeName ="";
	String codeNameInTable ="";
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
		logout=new LogoutPage_POM(driver);
		login.loginFunction();
		
	}
	@Test(testName = "Codes", groups = "Codes", priority = 0)
	public void CreateGroupInAdmin() 
	{
		codes = new Codes_POM(driver);
		test = extent.startTest("Codes");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		number = FunctionUtils.generateRandomNumber();
		test.log(LogStatus.PASS, "1.Log in as the admin user.");
		codes.administratorDropDown().click();
		
		test.log(LogStatus.PASS, "2.Go to the administration page.");
		codes.administrationLink().click();
		sleep(4);
		verticalScrollingDown();
		codes.codes_Link().click();
		test.log(LogStatus.PASS, "3.Click on codes."+
		test.addScreenCapture(captureScreenShot(driver, "Codes tab")));
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
		
		test.log(LogStatus.PASS, "5.Enter class name.");
		codes.className_TextBox().sendKeys(codesData[1][0]+number);
		
		test.log(LogStatus.PASS, "6.Click on add button.");
		codes.add_Button().click();
		
		sleep(2);
		if(codes.codeAddedSuccessfully_VerificationMsg().isDisplayed())
		{
			codes.close_Button().click();
			sleep(2);
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
		codes.className_TextBox().clear();
		codes.className_TextBox().sendKeys(codesData[1][1]); 
		test.log(LogStatus.PASS, "8.Click on add button.");
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
		codes.codeCategory_TextBox().sendKeys(codesData[1][0]+number+" category"); 
		test.log(LogStatus.PASS, "11.Click on add button.");
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
		sleep(2);
		
		test.log(LogStatus.PASS, "13.Click on add code button.");
		codes.addCodeName_Link().click();
		sleep(2);
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
		
		sleep(3);
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
		codes.addCodeId_TextBox().sendKeys(codesData[1][2]+number); 
		
		test.log(LogStatus.PASS, "16.Enter code name.");
		codes.addCodeName_TextBox().sendKeys(codesData[1][3]+number); 
		
		test.log(LogStatus.PASS, "17.Enter definition.");
		codes.addCodeDefinition_TextBox().sendKeys(codesData[1][4]); 
		
		test.log(LogStatus.PASS, "18.Select criticality from criticality dropdown.");
		codes.addCodeCritIdDropDown().selectByVisibleText(codesData[1][5]); 
		sleep(2);
		test.log(LogStatus.PASS, "19.Click on add button.");
		codes.add_Button().click();
		
		sleep(3);
		if(codes.codeAddedSuccessfully_VerificationMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER8- A successful message for newly added code is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "A successful message for newly added code")));
			codes.close_Button().click();
			sleep(2);
		}
		else
		{
			test.log(LogStatus.PASS, "Unable to find the successful message for newly added code");
		}
		
		test.log(LogStatus.PASS, "20.Enter the code id same as used in step(15).");
		codes.addCodeName_Link().click();
		sleep(2);
		if(codes.addCodePopUp_Header().isDisplayed())
		{
			codes.addCodeId_TextBox().sendKeys(codesData[1][2]+number); 
			sleep(2);
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
			codes.addCodeName_TextBox().sendKeys(codesData[1][3]+number);
			sleep(2);
			
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
			sleep(2);
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the Add code popup screen.");
		}
		
		test.log(LogStatus.PASS, "23.Select other code class from code class dropdown.");
		codes.codeClass_DropDown().selectByVisibleText(codesData[1][6]); 
		
		sleep(2);
		test.log(LogStatus.PASS, "24.Click on add code.");
		codes.addCodeName_Link().click();
		
		sleep(3);
		test.log(LogStatus.PASS, "25.Enter code name same as used in step (16)");
		codes.addCodeName_TextBox().sendKeys(codesData[1][3]+number); 
		codes.addCodeId_TextBox().click();
		sleep(2);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try
		{
			codes.nameAlreadyExists_ErrorMsg().isDisplayed();
			test.log(LogStatus.FAIL, "Unable to find the Code name is accepted as Code Name is only unique within the Code Class.");
		}
		catch(NoSuchElementException e)
		{
			test.log(LogStatus.PASS, "<b>ER11- Code name is accepted as Code Name is only unique within the Code Class.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Code name is accepted")));
		}
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		codes.cancel_Button().click();
		sleep(2);
		
		verticalScrollingDown();
		sleep(2);
		codes.getCodeAvailabilityList_Link().click();
		test.log(LogStatus.PASS, "26.Navigate to 'Code Availability' interface."+
				test.addScreenCapture(captureScreenShot(driver, "Code Availability")));
		sleep(2);
		verticalScrollingUp();
		sleep(2);
		test.log(LogStatus.PASS, "27.Search for 'IndxCard' in the search field and click on go button.");
		codes.filterResult_TextBox().sendKeys(codesData[1][7]);
		sleep(2);
		codes.filterResultGo_Button().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "28.Edit the 'IndxCard'.");
		clickOnEditButton(codesData[1][7]); 
		sleep(2);
		test.log(LogStatus.PASS, "29.Search for newly created code class (in previous steps) in the select a code class section.");
		sleep(4);
		if(codes.updateCodeAvailabilityIndexCard_Header().isDisplayed())
		{
			WebElement eleCodeClass = driver.findElement(By.xpath("//table[@class='t21-table-hover-custom t21-margin-bottom-10']//td/a[contains(text(),'"+number+"')]"));
			scrollIntoView(eleCodeClass);
			test.log(LogStatus.PASS, "30.Click on code class link.");
			eleCodeClass.click();
			
			WebElement eleSelectedCodeClasses = driver.findElement(By.xpath("//table[@class='t21-table-custom t21-margin-bottom-30']//td[contains(text(),'"+number+"')]"));
			scrollIntoView(eleSelectedCodeClasses);
			if(eleSelectedCodeClasses.isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER12- Code class gets added in selected code class section.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Code class gets added in selected code class")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the  Code class gets added in selected code class section");
			}
			
			test.log(LogStatus.PASS, "31.Click on the update button");
			codes.update_Button().click();
			
			sleep(3);
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
		sleep(2);
		test.log(LogStatus.PASS, "33.Logout from admin user and log in as a test user.");
		logout.logoutFunction();
		sleep(2);
		login.loginUser(loginData[8][0], loginData[8][1]);
		
		test.log(LogStatus.PASS, "34.Open an existing document that contains the codes control.");
		test.log(LogStatus.PASS, "Note: Edit mode needs to be turned on.");
		
		codes.getnewdoc().click();
		sleep(3);
		codes.getdocument().click();
		sleep(3);
		codes.getlocationDrodown().selectByVisibleText(routeData[1][0]);
		sleep(2);
		documetNo = codes.document_No().getAttribute("value");

		codes.getDocumentTitle().sendKeys(routeData[1][1]+documetNo); 
		codes.getDocChangeSummary().sendKeys(routeData[1][2]+documetNo);
		verticalScrollingDown();
		codes.getConfirmButton().click();
		sleep(5);
		codes.getdocumentcreationverify().isDisplayed(); 
		
		test.log(LogStatus.PASS, "35.Navigate to the 'Codes' tab.");
		codes.codes_Tab().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "36.Select the code class, which was added to documents (Index Cards) in step 27, from the 'Code Class' dropdown.");
		codes.codeClass_DropDown().selectByVisibleText(codesData[1][0]+number); 
		sleep(2);
		
		String categoryName=codes.codeCategoryOn_CodeTab().getText(); 
		if(categoryName.equalsIgnoreCase(codesData[1][0]+number+" category")) 
		{
			test.log(LogStatus.PASS, "<b>ER14- Newly created Code Class made available to an index card and the category is available.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Newly created Code Class made available")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the Newly created Code Class made available to an index card and the category."+
					test.addScreenCapture(captureScreenShot(driver, "Newly created Code Class made available")));
		}
		
		test.log(LogStatus.PASS, "37.Expand a category by clicking on the '+' to the left of the category name.");
		codes.codeCategory_PlusSign().click();
		
		test.log(LogStatus.PASS, "38.Verify with the code name added in step (20).");
		String codeName = codes.codeName_OnCodesTab().getText();
		if(codeName.equalsIgnoreCase(codesData[1][3]+number)) 
		{
			test.log(LogStatus.PASS, "<b>ER15- Code name is available and matched.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Newly created Code Class made available")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the Code name is available and matched.");
		}
		
		test.log(LogStatus.PASS, "39.Highlight a code, then click on it. ");
		codes.codeName_OnCodesTab().click();
		sleep(2);
		
		String codeNameInTable = codes.codeNameWithDetails_OnCodesTab().getText();
		if(codeNameInTable.equalsIgnoreCase(codesData[1][3]+number)) 
		{
			test.log(LogStatus.PASS, "<b>ER16- A code is added to the 'Applicable codes' list is matched.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Applicable codes")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the code is added to the 'Applicable codes' list matched.");
		}
		
		test.log(LogStatus.PASS, "40.Close the document.");
		driver.navigate().refresh();
		
		sleep(2);
		test.log(LogStatus.PASS, "41.Re-open the document and navigate to the codes tab.");
		codes.codes_Tab().click();
		sleep(2);
		codes.codeClass_DropDown().selectByVisibleText(codesData[1][0]+number); 
		sleep(2);
		
		codes.codeCategory_PlusSign().click();
		
		codes.codeName_OnCodesTab().click();
		sleep(2);
		
		codeNameInTable = codes.codeNameWithDetails_OnCodesTab().getText();
		if(codeNameInTable.equalsIgnoreCase(codesData[1][3]+number)) 
		{
			test.log(LogStatus.PASS, "<b>ER17- Document was saved with the selected code applied.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Applicable codes")));
			test.log(LogStatus.PASS, "42.Click on the delete button.");
			codes.deleteIconToDeleteCode_InCodeTab().click();
			sleep(2);
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the saved document with the selected code applied.");
		}
		
		if(codes.NoCodesSelected_OnCodesTab().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER18- Code is removed from the Document.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Code is removed")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find the 'Code is removed' on the Codes Tab.");
		}
	}
	
	@Test(testName = "logout_admin", groups = "Logout", priority = 1)
	public void LogoutFromAdmin() throws Exception 
	{		
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
	
}

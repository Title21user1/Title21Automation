package org.title21.Packages_Test;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.Table;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.Packages_POM.CreatingNewPackage_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

import com.relevantcodes.extentreports.LogStatus;

public class CreatingNewPackage_Test extends BaseClass{
	LoginPage_POM login;
	LogoutPage_POM logout;
	CreatingNewPackage_POM creatingNewPackage;
	static Logger log = Logger.getLogger(CreatingNewPackage_Test.class);
	String className="";
	String packageNo="";
	String fileUploadPath="";
	String docToSearch="";
	String obsoleteDate="";
	String obsoleteDateinserachDoc="";
	String docStatus="";
	String uploadFileName="FileToUpload.txt";
	Table searchTable;
	DBQueries dbqueries;
	AdminData adminData=new AdminData();
	String testcaseName="TestCase-WIA-Creating_new_package.docx";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass(alwaysRun=true)
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		dbqueries = new DBQueries();
		logout=new LogoutPage_POM(driver);
		login=new LoginPage_POM(driver);
		login.loginUser(loginData[7][0], loginData[7][1]);
	}

	@Test(testName = "CreatingNewPackage", groups = "Packages", priority = 0)
	public void DocumentRoutes() throws Exception
	{		
		test = extent.startTest("Creating New Package");
		test.log(LogStatus.PASS, "1.Login to the web interface.");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		creatingNewPackage=new CreatingNewPackage_POM(driver);	
		
		test.log(LogStatus.PASS, "2.Disable permission for 'Prohibit user attaching Archived Document'.");
		DBConnection.executeStoredProcedure(dbqueries.disablePermissionProhibitUserAttachingArchivedDoc);
		
		test.log(LogStatus.PASS, "3.Disable permission for 'Prohibit user attaching Released Document'.");
		DBConnection.executeStoredProcedure(dbqueries.disablePermissionProhibitUserAttachingReleasedDoc);
		
		test.log(LogStatus.PASS, "4.Click on the new and select package.");
		creatingNewPackage.getnewdoc().click();
		sleep(2);
		creatingNewPackage.package_Link().click();
		sleep(3);
		
		if(creatingNewPackage.verifyCreateNewPackagePopUpText())
		{
			test.log(LogStatus.PASS, "<b>ER1- Create new Package screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Create new Package screen")));
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Uable to find the create new Package screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Create new Package screen")));
		}
		
		test.log(LogStatus.PASS, "5.Select Cabinet and Section from the dropdown list.");
		creatingNewPackage.cabinet_DropDown().selectByVisibleText("Change Control Initiation");
		creatingNewPackage.cabinetSection_DropDown().selectByVisibleText("Initiation");
		
		test.log(LogStatus.PASS, "6.Add Package Name.");
		creatingNewPackage.packageName_TextBox().sendKeys("NeoTest");
		
		test.log(LogStatus.PASS, "7.Click on 'Create'.");
		creatingNewPackage.create_Button().click();
		sleep(3);
		
		if(creatingNewPackage.verifyPackageScreen())
		{
			test.log(LogStatus.PASS, "<b>ER2- Package screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Package screen")));
			
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Unable to find the Package screen.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Package screen")));
		}
		
		packageNo = creatingNewPackage.package_No().getText();
		
		test.log(LogStatus.PASS, "8.Ensure the Package is open in edit mode.");
		test.log(LogStatus.PASS, "9.Add an Author and Reason for change (if not already added).");
		creatingNewPackage.ChangeReason_TextBox().sendKeys("Testing");
		sleep(2);
		
		test.log(LogStatus.PASS, "10.Navigate to My Docs > Packages.");
		creatingNewPackage.myDocs_Tab().click();
		sleep(3);
		creatingNewPackage.packages_Link().click();
		sleep(3);
		
		creatingNewPackage.packageFilter_TextBox().sendKeys(packageNo);
		creatingNewPackage.packageFilterGo_Button().click();
		sleep(2);
		
		if(creatingNewPackage.filteredPackage_Result().getText().contains(packageNo))
		{
			test.log(LogStatus.PASS, "<b>ER3- Newly created package is present.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Newly created package")));
			
			test.log(LogStatus.PASS, "11.Open Package.");
			creatingNewPackage.filteredPackage_Result().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "12.Ensure the Package is open in edit mode.");
			verticalScrollingDown();
			
			test.log(LogStatus.PASS, "13.Click on 'Add/Remove' link available in documents frame.");
			creatingNewPackage.addRemove_LinkText().click();			
			sleep(3);
			if(creatingNewPackage.verifyAttachDocScreen())
			{
				test.log(LogStatus.PASS, "<b>ER4- Attach documents screen will appear.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Attach documents screen")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the attach documents screen.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Attach documents screen")));
			}
			
			test.log(LogStatus.PASS, "14.Select Status: Open, Created between (e.g. a month before current date and current date), Type: Document and Location: ALL");
			creatingNewPackage.selectStatus_DoropDown().selectByVisibleText("Open");
			sleep(2);
			creatingNewPackage.andDate_Box().click();
			sleep(2);
			creatingNewPackage.current_Date().click();
			sleep(2);
			creatingNewPackage.type_DropDown().selectByVisibleText("Document");
			sleep(2);
			creatingNewPackage.location_DropDown().click();
			sleep(2);
			creatingNewPackage.selectAll_Locacation().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "15.Select one or more Draft documents.");
			
			creatingNewPackage.onlyshowavailableDoc_CheckBox().click();
			sleep(4);
			int count=0;
			for(int i=1;i<=10;i++)
			{
				if(driver.findElement(By.xpath("//tr["+i+"]/td[2]/input")).isEnabled())
				{
					driver.findElement(By.xpath("//tr["+i+"]/td[2]/input")).click();
					count++;
				}
				if(count==2)
				{
					break;
				}
			}
			
			test.log(LogStatus.PASS, "16.Click on 'OK'.");
			javaScriptClick(creatingNewPackage.create_Button());
			sleep(2);
			verticalScrollingDown();
			sleep(2);
			
			if(creatingNewPackage.docAddedIn_DocSection().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER5- Selected documents appear in the document frame.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Selected documents")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the selected documents appear in the document frame.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Selected documents")));
			}
			
			test.log(LogStatus.PASS, "17.On Package screen add a 'Target Release Date'.");
			verticalScrollingUp();
			sleep(2);
			String targetReleaseDate=DateTimeUtils.getCurrentPSTDate();
			String[] preDate = targetReleaseDate.split("/");
			String dd1 = preDate[1];
			String dd=dd1;
			if(dd1.contains("0"))
			{
				dd=dd1.substring(1, 2);
				if(dd.equals("0")) 
				{
					dd = dd1;
				}
			}
			creatingNewPackage.targetReleaseDate_TextBox().click();
			driver.findElement(By.xpath("//*[text()='"+dd+"']")).click();
			sleep(4);
			
			if(creatingNewPackage.verifyUpdateAttachedDocPopUp())
			{
				test.log(LogStatus.PASS, "<b>ER6- Update attached document(s) (non-obsoleted only) to this Release Date? Pop up message is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Update attached document")));
				
				test.log(LogStatus.PASS, "18.Click on 'Yes'.");
				creatingNewPackage.yes_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the update attached document(s) (non-obsoleted only) to this Release Date? Pop up message.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Update attached document")));
			}
			
			sleep(2);
			if(creatingNewPackage.verifyMsgPopUpHeader())
			{
				test.log(LogStatus.PASS, "<b>ER7- 'No obsolete documents to update' Pop up message appears.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "No obsolete documents")));
				
				test.log(LogStatus.PASS, "19.Click on 'Close'.");
				creatingNewPackage.close_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the 'No obsolete documents to update' Pop up message.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "No obsolete documents")));
			}
			
			//add refresh code---------
			driver.navigate().refresh();
			sleep(2);
			creatingNewPackage.packages_Link().click();
			sleep(3);
			verticalScrollingUp();
			sleep(2);
			creatingNewPackage.packageFilter_TextBox().sendKeys(packageNo);
			creatingNewPackage.packageFilterGo_Button().click();
			sleep(2);
			creatingNewPackage.filteredPackage_Result().click();
			sleep(2);
			//-----------------------------
			
			test.log(LogStatus.PASS, "20.In the web interface, click on 'Add/Remove' link available in the document's frame.");
			verticalScrollingDown();
			sleep(2);
			creatingNewPackage.addRemove_LinkText().click();
			
			test.log(LogStatus.PASS, "21.Select Status: Open, Created between (e.g. a month before current date and current date), Type: Document and Location: ALL");
			creatingNewPackage.selectStatus_DoropDown().selectByVisibleText("Open");
			sleep(2);
			creatingNewPackage.andDate_Box().click();
			creatingNewPackage.current_Date().click();
			sleep(2);
			creatingNewPackage.type_DropDown().selectByVisibleText("Document");
			sleep(2);
			creatingNewPackage.location_DropDown().click();
			creatingNewPackage.selectAll_Locacation().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "22.Enter effective in the search field and click on go button");
			creatingNewPackage.attachedDocFilterResult_TextBox().sendKeys("Effective");
			creatingNewPackage.attachedDocFilterResultGo_Button().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "23.Select Effective documents.");
			
			creatingNewPackage.onlyshowavailableDoc_CheckBox().click();
			sleep(4);
			int count2=0;
			for(int i=1;i<=10;i++)
			{
				if(driver.findElement(By.xpath("//tr["+i+"]/td[2]/input")).isEnabled())
				{
					driver.findElement(By.xpath("//tr["+i+"]/td[2]/input")).click();
					count2++;
				}
				if(count2==2)
				{
					break;
				}
			}
			
			test.log(LogStatus.PASS, "24.Click on 'OK'.");
			javaScriptClick(creatingNewPackage.create_Button());
			sleep(2);
			
			if(creatingNewPackage.docAddedIn_DocSection().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER8- Added documents appear in the document frame.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "No obsolete documents")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the added documents in the document frame.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "No obsolete documents")));
			}
			
			sleep(2);
			test.log(LogStatus.PASS, "25.Mark the document to be obsolete from the context menu.");
			creatingNewPackage.thirdDocContext_Menu().click();
			sleep(4);
			verticalScrollingDown();
			sleep(2);
			creatingNewPackage.obsolete_Option().click();
			sleep(2);

			docToSearch = creatingNewPackage.thirdDoc_Name().getText();
			
			if(creatingNewPackage.verifyMsgPopUpHeader())
			{
				test.log(LogStatus.PASS, "<b>ER9- Document is marked Obsolete Message is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Document is marked Obsolete Message")));
				
				test.log(LogStatus.PASS, "26.Click on 'Close'.");
				creatingNewPackage.close_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the Document marked Obsolete.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Document is marked Obsolete Message")));
			}
			
			test.log(LogStatus.PASS, "27.Repeat Step 25 for all attached Effective documents.");
			creatingNewPackage.fourthDocContext_Menu().click();
			sleep(4);
			verticalScrollingDown();
			sleep(2);
			creatingNewPackage.obsolete_Option().click();
			sleep(2);
			creatingNewPackage.close_Button().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "28.On Package screen add an 'Obsolete Date'.");
			verticalScrollingUp();
			creatingNewPackage.obsoleteDateToSet_TextBox().click();
			creatingNewPackage.current_Date().click();
			sleep(2);
			
			if(creatingNewPackage.verifyupdateAttachedDocobsoleteDocPopUp())
			{
				test.log(LogStatus.PASS, "<b>ER10- Update attached document(s) (obsoleted only) to this Obsolete Date? Pop up message is appeared.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Update attached document")));
				
				test.log(LogStatus.PASS, "29.Click on 'Yes'.");
				creatingNewPackage.yes_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the Update attached document(s) (obsoleted only) to this Obsolete Date? Pop up message is appeared.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Update attached document")));
			}
			
			if(creatingNewPackage.verifyMsgPopUpHeader())
			{
				test.log(LogStatus.PASS, "<b>ER11- Successful message for updation of the document is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "updation of the document")));
				
				test.log(LogStatus.PASS, "30.Click on 'Close'.");
				creatingNewPackage.close_Button().click();
				sleep(4);
				
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the Successful message for updation of the document is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "updation of the document")));
			}
			
			//add refresh code---------
			driver.navigate().refresh();
			sleep(2);
			creatingNewPackage.packages_Link().click();
			sleep(3);
			verticalScrollingUp();
			sleep(2);
			creatingNewPackage.packageFilter_TextBox().sendKeys(packageNo);
			creatingNewPackage.packageFilterGo_Button().click();
			sleep(2);
			creatingNewPackage.filteredPackage_Result().click();
			sleep(2);
			//-----------------------------
			
			if(creatingNewPackage.obsoleteDateToSet_TextBox() != null)
			{
				test.log(LogStatus.PASS, "<b>ER12- Target Obsolete Date of the package is updated.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Target Obsolete Date")));
				obsoleteDate = creatingNewPackage.obsoleteDateToSet_TextBox().getAttribute("value");
			}
			else
			{
				test.log(LogStatus.PASS, "<b>Unable to find the Target Obsolete Date of the package is updated.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Target Obsolete Date")));
			}
			
			test.log(LogStatus.PASS, "31.Take any one of the attached Effective documents names and go to the searches.");
			verticalScrollingUp();
			sleep(2);
			creatingNewPackage.searches_Tab().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "32.Search for that document.");
			creatingNewPackage.searchesFilterResult_TextBox().sendKeys("Search on Document Number");
			sleep(2);
			creatingNewPackage.searchesFilterResultGo_Button().click();
			sleep(2);
			creatingNewPackage.searchOnDocumentNumber_LinkText().click();
			sleep(2);
			creatingNewPackage.docNo_TextBox().sendKeys(docToSearch);
			creatingNewPackage.searchGo_Button().click();
			sleep(2);
			verticalScrollingUp();
			sleep(2);
			
			test.log(LogStatus.PASS, "33.Open the document.");
			creatingNewPackage.filteredPackage_Result().click();
			sleep(4);
			
			obsoleteDateinserachDoc = creatingNewPackage.obsoleteDate_TextBox().getAttribute("value");
			
			if(obsoleteDateinserachDoc.equals(obsoleteDate))
			{
				test.log(LogStatus.PASS, "<b>ER13- Obsolete Date of Package and the added document is same.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Obsolete Date of Package")));
			}
			else
			{
				test.log(LogStatus.PASS, "<b>Unable to find the Obsolete Date of Package and the added document is same.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Obsolete Date of Package")));
			}
			
			sleep(2);
			test.log(LogStatus.PASS, "34.Navigate to package which was created in step 7.");
			creatingNewPackage.myDocs_Tab().click();
			sleep(2);
			creatingNewPackage.packages_Link().click();
			sleep(3);
			verticalScrollingUp();
			sleep(2);
			creatingNewPackage.packageFilter_TextBox().sendKeys(packageNo);
			creatingNewPackage.packageFilterGo_Button().click();
			sleep(2);
			creatingNewPackage.filteredPackage_Result().click();
			
			test.log(LogStatus.PASS, "34.Click on 'Add/Remove' link available in documents frame.");
			verticalScrollingDown();
			sleep(2);
			creatingNewPackage.addRemove_LinkText().click();
			sleep(2);
			
			if(creatingNewPackage.verifyAttachDocScreen())
			{
				test.log(LogStatus.PASS, "<b>ER14- Dialog to add documents will appear.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Dialog to add documents")));
			}
			else
			{
				test.log(LogStatus.PASS, "<b>Unable to find the Dialog to add documents will appear.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Dialog to add documents")));
			}
			
			test.log(LogStatus.PASS, "35.Select Status: Archived, Created between (e.g. a month before current date and current date) and Type: Document and Location: ALL");
			creatingNewPackage.selectStatus_DoropDown().selectByVisibleText("Archived");
			sleep(2);
			creatingNewPackage.andDate_Box().click();
			creatingNewPackage.current_Date().click();
			sleep(2);
			creatingNewPackage.type_DropDown().selectByVisibleText("Document");
			sleep(2);
			creatingNewPackage.location_DropDown().click();
			sleep(1);
			creatingNewPackage.selectAll_Locacation().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "36.Select any two archived documents.");
			creatingNewPackage.onlyshowavailableDoc_CheckBox().click();
			sleep(4);
			int count1=0;
			for(int i=1;i<=10;i++)
			{
				if(driver.findElement(By.xpath("//tr["+i+"]/td[2]/input")).isEnabled())
				{
					driver.findElement(By.xpath("//tr["+i+"]/td[2]/input")).click();
					count1++;
				}
				if(count1==2)
				{
					break;
				}
			}
			
			test.log(LogStatus.PASS, "37.Click on 'OK'.");
			javaScriptClick(creatingNewPackage.create_Button());
			sleep(2);
			
			
			test.log(LogStatus.PASS, "38.Enable permission for 'Prohibit user attaching Archived Document'.");
			DBConnection.executeStoredProcedure(dbqueries.enablePermissionProhibitUserAttachingArchivedDoc);
			
			test.log(LogStatus.PASS, "39.Enable permission for 'Prohibit user attaching Released Document'.");
			DBConnection.executeStoredProcedure(dbqueries.enablePermissionProhibitUserAttachingReleasedDoc);
			
			test.log(LogStatus.PASS, "40.In the web interface, open the Package created in Step 7 and click on 'Add/Remove' link available in documents frame. ");
			sleep(2);
			creatingNewPackage.addRemove_LinkText().click();
			sleep(2);
			
			if(creatingNewPackage.verifyAttachDocScreen())
			{
				test.log(LogStatus.PASS, "<b>ER16- Attach Documents screen will appear.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Attach Documents screen")));
			}
			else
			{
				test.log(LogStatus.PASS, "<b>Unable to find the Dialog to add documents will appear.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Attach Documents screen")));
			}
			
			test.log(LogStatus.PASS, "41.Select Status: Open, Created between (e.g. a month before current date and current date), Type: Document and Location: ALL");
			creatingNewPackage.selectStatus_DoropDown().selectByVisibleText("Open");
			sleep(2);
			creatingNewPackage.andDate_Box().click();
			creatingNewPackage.current_Date().click();
			sleep(2);
			creatingNewPackage.type_DropDown().selectByVisibleText("Document");
			sleep(2);
			creatingNewPackage.location_DropDown().click();
			sleep(2);
			creatingNewPackage.selectAll_Locacation().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "42.Enter effective in the search field and click on go button.");
			creatingNewPackage.attachedDocFilterResult_TextBox().sendKeys("Effective");
			creatingNewPackage.attachedDocFilterResultGo_Button().click();
			sleep(2);
			
			docStatus = creatingNewPackage.docStatus().getText();
			if(docStatus.equals(""))
			{
				test.log(LogStatus.PASS, "<b>ER17- All the Effective documents are greyed out.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "All the Effective documents are greyed")));
			}
			else
			{
				test.log(LogStatus.PASS, "<b>Unable to find the All the Effective documents are greyed out.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "All the Effective documents are greyed")));
			}
			
			test.log(LogStatus.PASS, "43.Select Status: Archived, Created between (e.g. a month before current date and current date) and Type: Document.");
			creatingNewPackage.selectStatus_DoropDown().selectByVisibleText("Archived");
			sleep(2);
			creatingNewPackage.andDate_Box().click();
			creatingNewPackage.current_Date().click();
			sleep(2);
			creatingNewPackage.type_DropDown().selectByVisibleText("Document");
			sleep(2);
			creatingNewPackage.location_DropDown().click();
			sleep(2);
			creatingNewPackage.selectAll_Locacation().click();
			sleep(4);
			creatingNewPackage.attachedDocFilterResult_TextBox().click();
			sleep(2);
			
			docStatus = creatingNewPackage.docStatus().getText();
			if(docStatus.equals(""))
			{
				test.log(LogStatus.PASS, "<b>ER17- All the Archived documents are greyed out.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "All the Archived documents")));
			}
			else
			{
				test.log(LogStatus.PASS, "<b>Unable to find the All the Archived documents are greyed out.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "All the Archived documents")));
			}
			
			test.log(LogStatus.PASS, "44.Select Status: Both, Created between (e.g. a month before current date and current date) and Type: Document");
			creatingNewPackage.selectStatus_DoropDown().selectByVisibleText("Both");
			sleep(2);
			creatingNewPackage.andDate_Box().click();
			creatingNewPackage.current_Date().click();
			sleep(2);
			creatingNewPackage.type_DropDown().selectByVisibleText("Document");
			sleep(2);
			creatingNewPackage.location_DropDown().click();
			sleep(2);
			creatingNewPackage.selectAll_Locacation().click();
			sleep(4);
			
			docStatus = creatingNewPackage.docStatus().getText();
			if(docStatus.equals(""))
			{
				test.log(LogStatus.PASS, "<b>ER19- All Effective and Archived documents are greyed out.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "All Effective and Archived documents")));
			}
			else
			{
				test.log(LogStatus.PASS, "<b>Unable to find the All Effective and Archived documents are greyed out.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "All Effective and Archived documents")));
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Unable to find the newly created package.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Newly created package")));
		}
	}

	@AfterClass(alwaysRun=true)
	public void closeBrowserInstance()
	{	
		logout.logoutFunction();
		extent.endTest(test);
		driver.close();
	}

}

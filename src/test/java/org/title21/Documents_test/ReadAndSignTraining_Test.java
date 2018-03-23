package org.title21.Documents_test;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.Documents_POM.ReadAndSignTraining_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.POM.Table;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

import com.relevantcodes.extentreports.LogStatus;

public class ReadAndSignTraining_Test extends BaseClass{
	LoginPage_POM login;
	LogoutPage_POM logout;
	ReadAndSignTraining_POM readSign;
	DateTimeUtils dateTimeUtils;
	static Logger log = Logger.getLogger(DocumentRoutes_Test.class);
	String className="";
	String documetNo="";
	String documetsName="";
	String fileUploadPath="";
	String uploadFileName="DocumentRouteTest.doc";
	Table searchTable;
	boolean isRecordFound=false;
	AdminData adminData=new AdminData();
		
	@BeforeClass
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		logout=new LogoutPage_POM(driver);
		login=new LoginPage_POM(driver);
		login.loginUser(loginData[7][0], loginData[7][1]);
		
	}
	
	@Test(testName = "ReadAndSignTraining", groups = "Read And Sign Trainings", priority = 0)
	public void DocumentRoutes() throws Exception
	{		
		test = extent.startTest("Read And Sign Training");
		test.log(LogStatus.PASS, "1.Login to the web interface as 'Test User'.");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file:///E:/sameer/Sameer Joshi/Title health solutions/Test case by neosoft/TestCase-WIA-document_routes.doc'>TestCaseDocument</a>");
		readSign=new ReadAndSignTraining_POM(driver);	
		dateTimeUtils=new DateTimeUtils();
		//=========================================================================Part=>01================================================================================
		readSign.getnewdoc().click();
		sleep(2);
		waitTillElementVisible(readSign.getdocument());
		readSign.getdocument().click();
		sleep(3);
		readSign.getlocationDrodown().selectByVisibleText(routeData[1][0]);
		sleep(2);
		documetNo = readSign.document_No().getAttribute("value");
		
		readSign.getDocumentTitle().sendKeys(routeData[1][1]+documetNo); 
		readSign.getDocChangeSummary().sendKeys(routeData[1][2]+documetNo);
		verticalScrollingDown();
		readSign.getConfirmButton().click();
		sleep(5);
		if(readSign.getdocumentcreationverify().isDisplayed()) 
		{
			test.log(LogStatus.PASS,"2.	Create a new document");
			
			readSign.addMainFile_Button().click();
			
			waitTillElementVisible(readSign.addMainFileHeader_Text());
			
			test.log(LogStatus.PASS,"3.Add a main file, approvers and other required fields.");
			
			//main file- 
			if(readSign.addMainFileHeader_Text().isDisplayed())
			{
				fileUploadPath=System.getProperty("user.dir") + "\\testdata";
				fileUploadPath=fileUploadPath+"\\"+uploadFileName;
				readSign.browse_Button().sendKeys(fileUploadPath);
				
				sleep(2);
				readSign.add_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL,"Unable to find Add Main File header.");
			}
			//approver-
			readSign.getDocumentApprovaltab().click();
			test.log(LogStatus.PASS,"4.	Click on the add approver link.");
			sleep(2);
			readSign.getAddApproverLink().click();
			sleep(2);
			if(readSign.addNewApprover_Header().isDisplayed())
			{
				readSign.getApproverRole().selectByVisibleText(routeData[1][3]);
				sleep(2);
				readSign.getLocationDropdown().selectByVisibleText(routeData[1][4]); 
				sleep(2);
				readSign.getnameinAddApprover().selectByVisibleText(routeData[1][5]);
				readSign.getSequenceinAddApprover().selectByVisibleText("1");
				readSign.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);
				readSign.approverAdd_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Add new approver popup screen."+
						test.addScreenCapture(captureScreenShot(driver, "new approver popup")));
			}
			//
			
			test.log(LogStatus.PASS,"4.Click on the 'Training' tab.");
			readSign.training_Tab().click();
			sleep(2);
			test.log(LogStatus.PASS,"5.Change the training type to 'Read and Sign'.");
			readSign.ChangeTrainingType_Link().click();
			waitTillElementVisible(readSign.changeTrainingType_Header());
			if(readSign.changeTrainingType_Header().isDisplayed())
			{
				readSign.readAndSignRadio_Button().click();
				test.log(LogStatus.PASS, "6.Click on save button.");
				readSign.changeTrainingTypePopUpSave_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Change Training Type Pop Up.");
			}
			
			test.log(LogStatus.PASS, "7.Set 'Schedule training: On promotion to the following cabinet' to 'Approved'.");
			readSign.scheduleTraining_DropDown().selectByVisibleText("Approved");
			
			test.log(LogStatus.PASS, "8.For 'Training due,' select the radio button 'before promotion to next cabinet'.");
			readSign.BeforePromotionRadio_Button().click();
			
			verticalScrollingDown();
			test.log(LogStatus.PASS, "9.For 'Select entities subject to training,' select the radio button 'Read/Write from cabinet'.");
			readSign.readWriteFromCabinetRadio_Button().click();
			
			verticalScrollingUp();
			test.log(LogStatus.PASS, "<b>ER1- The Read and Sign Training is scheduled.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Read and Sign Training is scheduled")));
			
			test.log(LogStatus.PASS, "10.Check in the document and route the document for approval.");
			readSign.docContext_Menu().click();
			sleep(1);
			readSign.checkIn_Route().click();
			sleep(2);
			
			if(readSign.checkInRoutePopUp_Header().isDisplayed())
			{
				readSign.checkInRouteSubmit_Button().click();
				sleep(2);
				readSign.verifyDocumentCheckedIn(driver);
				test.log(LogStatus.PASS, "<b>ER2- The document is checked in and route for approval.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document is checked in and route for approval")));
				readSign.close_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.PASS, "Unable to find Check In Route PopUp_Header.");
			}
			
			logout.logoutFunction();
			login.loginUser(loginData[1][0], loginData[1][1]);  //sameer
			
			test.log(LogStatus.PASS, "11.Login with approver's login and approve the document.");
			approveDocFromWizard(documetNo);
			test.log(LogStatus.PASS, "<b>ER3- The document is approved successfully and displays the successful message.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "document is approved successfully")));
			
			test.log(LogStatus.PASS, "12.Go to: Wizard > Training.");
			readSign.wizard_Option().click();
			sleep(2);
			readSign.wizardTraining_Tab().click();
			
			for(int i=1; i<=5; i++)
			 {
				selectDocForTraining(documetNo);
				 if(!isRecordFound)
				 {
					// verticalScrollingDown();
					 readSign.documentTableNext_Button().click();
			 			sleep(2); 
				 }
				 else
				 {
					 break;
				 }
			 }
			
			if(isRecordFound)
			{
				test.log(LogStatus.PASS, "<b>ER4- The Read and Sign training created is available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "The Read and Sign training created is available.")));
				test.log(LogStatus.PASS, "13.Select training");
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the validation message- The Read and Sign training created is available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "The Read and Sign training created is available.")));
			}
			
			verticalScrollingUp();
			test.log(LogStatus.PASS, "14.click on begin training.");
			readSign.beginTraining_Button().click();
			sleep(2);
			test.log(LogStatus.PASS, "<b>ER5- Details about the training document are visible.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "The Read and Sign training created is available.")));
			test.log(LogStatus.PASS, "15.Click on Document");
			readSign.document_Button().click();
			sleep(4);
			
			if(readSign.sign_Button().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER6- The document should be available in a new tab with options to Sign.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document should be available")));
				test.log(LogStatus.PASS, "16.Click on 'Sign'.");
				readSign.sign_Button().click();
			}
			else
			{
				test.log(LogStatus.FAIL, "unable to find the validation message- The document should be available in a new tab with options to Sign."+
						test.addScreenCapture(captureScreenShot(driver, "document should be available")));
			}
			waitTillElementVisible(readSign.pin_TextBox());
			if(readSign.pin_TextBox().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER7- The electronic signature dialog is presented.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "electronic signature dialog")));
				test.log(LogStatus.PASS, "17.Enter the pin and click on confirm button.");
				readSign.pin_TextBox().sendKeys("262829");
				readSign.changeTrainingTypePopUpSave_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the validation message- The electronic signature dialog is presented."+
						test.addScreenCapture(captureScreenShot(driver, "electronic signature dialog")));
			}
			
			getTrainingCompletedItem(documetNo);
			if(isRecordFound)
			{
				test.log(LogStatus.PASS, "<b>ER8- User is informed that the training item is completed, and the training item details are visible with the “Signed On” date updated.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "training item is completed")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the validation message- User is informed that the training item is completed, and the training item details are visible with the “Signed On” date updated.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "training item is completed")));
			}
			
			logout.logoutFunction();
			
			test.log(LogStatus.PASS, "18.Login as admin and navigate to audit log section.");
			login.loginUser(loginData[7][0], loginData[7][1]);
			
			readSign.administratorDropDown().click();
			readSign.auditLog_Option().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "19.Search the audit log for the signature entry by the test user.");
			
			if(readSign.audtitLogSearch_Field().isDisplayed())
			{
				readSign.audtitLogSearch_Field().clear();
				readSign.audtitLogSearch_Field().sendKeys(documetNo);
				readSign.audtitLogSearchFieldGo_button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.PASS, "unable to find the Audtit Log Search_Field.");
			}
			
			for(int i=1; i<=10; i++)
			{
				WebElement text = driver.findElement(By.xpath("//div[@class='t21-md-break t21-sm-break']//tr["+i+"]/td[5]"));
				String itemName= text.getText();
				
				if(itemName.equalsIgnoreCase("Completed Training Item"))
				{
					WebElement documentName = driver.findElement(By.xpath("//div[@class='t21-md-break t21-sm-break']//tr["+i+"]/td[8]"));
					String documentText= documentName.getText();
					if(documentText.contains(documetNo))
					{
						test.log(LogStatus.PASS, "<b>ER9- The audit log entry for the read and sign training performed through the web interface is recorded.<b>"+
								test.addScreenCapture(captureScreenShot(driver, "audit log entry for the read and sign training performed")));
					}
					break;
				}
			}
		}
		else
		{
			test.log(LogStatus.FAIL,"Unable to Create a new document form.");
		}
		
		logout.logoutFunction();
	//=====================================================================Part=>02=======================================================================
		login.loginUser(loginData[7][0], loginData[7][1]);
		
		readSign.getnewdoc().click();
		sleep(2);
		waitTillElementVisible(readSign.getdocument());
		readSign.getdocument().click();
		sleep(3);
		test.log(LogStatus.PASS,"20.Create a new document");
		readSign.getlocationDrodown().selectByVisibleText(routeData[1][0]);
		sleep(2);
		documetNo = readSign.document_No().getAttribute("value");
		
		readSign.getDocumentTitle().sendKeys(routeData[1][1]+documetNo); 
		readSign.getDocChangeSummary().sendKeys(routeData[1][2]+documetNo);
		verticalScrollingDown();
		readSign.getConfirmButton().click();
		sleep(5);
		test.log(LogStatus.PASS,"21.Ensure the document is open in edit mode.");
		if(readSign.getdocumentcreationverify().isDisplayed()) 
		{
			readSign.addMainFile_Button().click();
			
			waitTillElementVisible(readSign.addMainFileHeader_Text());
			
			test.log(LogStatus.PASS, "22.Add the main file, approvers, and all the required fields.");
			//main file- 
			if(readSign.addMainFileHeader_Text().isDisplayed())
			{
				fileUploadPath=System.getProperty("user.dir") + "\\testdata";
				fileUploadPath=fileUploadPath+"\\"+uploadFileName;
				readSign.browse_Button().sendKeys(fileUploadPath);
				
				sleep(2);
				readSign.add_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL,"Unable to find Add Main File header.");
			}
			//approver-
			readSign.getDocumentApprovaltab().click();
			test.log(LogStatus.PASS,"4.	Click on the add approver link.");
			sleep(2);
			readSign.getAddApproverLink().click();
			sleep(2);
			if(readSign.addNewApprover_Header().isDisplayed())
			{
				readSign.getApproverRole().selectByVisibleText(routeData[1][3]);
				sleep(2);
				readSign.getLocationDropdown().selectByVisibleText(routeData[1][4]); 
				sleep(2);
				readSign.getnameinAddApprover().selectByVisibleText(routeData[1][5]);
				readSign.getSequenceinAddApprover().selectByVisibleText("1");
				readSign.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);
				readSign.approverAdd_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Add new approver popup screen."+
						test.addScreenCapture(captureScreenShot(driver, "new approver popup")));
			}
			
			test.log(LogStatus.PASS, "23.Set the Target Release Date to one day after the current date.");
			readSign.general_Tab().click();
			sleep(2);
			readSign.targetReleaseDate_TextBox().sendKeys(DateTimeUtils.getYesterdayDate());
			test.log(LogStatus.PASS, "<b>ER10- Target release date is set.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Target release date is set.")));
			
			test.log(LogStatus.PASS, "24.Click on the 'Training' tab.");
			readSign.training_Tab().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "25.Select or change the training type to 'Read and Sign'.");
			readSign.ChangeTrainingType_Link().click();
			waitTillElementVisible(readSign.changeTrainingType_Header());
			if(readSign.changeTrainingType_Header().isDisplayed())
			{
				readSign.readAndSignRadio_Button().click();
				test.log(LogStatus.PASS, "6.Click on save button.");
				readSign.changeTrainingTypePopUpSave_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Change Training Type Pop Up.");
			}
			
			test.log(LogStatus.PASS, "26.Set 'Schedule training: On promotion to the following cabinet' to 'Approved'.");
			readSign.scheduleTraining_DropDown().selectByVisibleText("Approved");
				
			test.log(LogStatus.PASS, "27.For 'Training due', select the radio button 'before promotion to next cabinet'");
			readSign.BeforePromotionRadio_Button().click();
			
			verticalScrollingDown();
			
			test.log(LogStatus.PASS, "28.For 'Promotion Settings', select the checkbox 'Item may be promoted to next cabinet with open training items'.");
			readSign.promotionSettingsItemsCheck(true);
			
			test.log(LogStatus.PASS, "29.For 'Require the following percentage of training to be completed,' select the checkbox and add '50' % in the text box.");
			readSign.trainingsPercentagCheck(true);
			sleep(2);
			readSign.trainingsPercentage_TextBox().clear();
			readSign.trainingsPercentage_TextBox().sendKeys("50");
			
			test.log(LogStatus.PASS, "30.For 'Select entities subject to training', select the 'From Selection' radio button. Click on 'Entities' link. Select two entities and click on 'Update'.");
			readSign.entitiesSubject_FromSection().click();
			readSign.addNewTrainingEntities_Link().click();
			waitTillElementVisible(readSign.selectedEntities_Header());
			if(readSign.selectedEntities_Header().isDisplayed())
			{
				readSign.firstEmp_FromList().click();
				readSign.firstEmp_FromList().click();
				javaScriptClick(readSign.changeTrainingTypePopUpSave_Button());
			//	readSign.changeTrainingTypePopUpSave_Button().click();
				sleep(2);
				test.log(LogStatus.PASS, "<b>ER11- The Read and Sign Training is scheduled.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Target release date is set.")));
				
			}
			else
			{
				test.log(LogStatus.PASS, "Unable to find Selected Entities Header");
			}
		
		}
		else
		{
			test.log(LogStatus.FAIL,"Unable to Create a new document form.");
		}
		
		
		extent.endTest(test);
	}

	@AfterClass
	public void closeBrowserInstance()
	{		
		driver.close();
	}
	
	private boolean selectDocForApprovel(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getcollapseDocumentstableCells(5);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().equalsIgnoreCase(routeData[1][1]+docName))
			{													
				tableCells.get(i).click();
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
	
	private boolean selectDocForTraining(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getTrainingItemCells(2);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{													
				tableCells.get(i).click();
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
	
	private boolean getTrainingCompletedItem(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getTrainingCompletedItemCell(2);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{													
				tableCells.get(i).click();
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
	
	private void approveDocFromWizard(String docName)
	{
		readSign.wizard_Option().click();
		readSign.approval_Tab().click();
		sleep(2);
		isRecordFound = false;
		for(int i=1; i<=5; i++)
		 {
			 selectDocForApprovel(docName);
			 if(!isRecordFound)
			 {
				// verticalScrollingDown();
				 readSign.documentTableNext_Button().click();
		 			sleep(2); 
			 }
			 else
			 {
				 break;
			 }
		 }
		sleep(2);
		readSign.documentTab_ForApprover().click();
		sleep(2);
		readSign.documentApprove_Button().click();
		sleep(2);
		readSign.pinTo_Approve().clear();
		readSign.pinTo_Approve().sendKeys("262829");
		readSign.checkInRouteSubmit_Button().click();
		sleep(2);
	}
}

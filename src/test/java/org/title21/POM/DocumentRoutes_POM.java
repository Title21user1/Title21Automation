package org.title21.POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.validation.entities.ErrorMessages;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DocumentRoutes_POM extends CreateDocument_POM {

	public WebDriver driver;
	public WebElement element;
	static Logger log = Logger.getLogger(DocumentRoutes_POM.class);
	
	public DocumentRoutes_POM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//a[contains(@href,'DocumentApproval')]")
	WebElement documentApprovalTab;
	
	@FindBy(xpath="//a[contains(text(),'On')]")
	WebElement editModeOn;
	
	@FindBy(xpath="//a[contains(text(),'Off')]")
	WebElement editModeOff;
	
	@FindBy(xpath="//a[contains(@href,'AddApproverModal')]")
	WebElement addApproverLink;
		
	@FindBy(xpath="//a[contains(@href,'AddRouteModal')]")
	WebElement signatureRouteLink;
	
	@FindBy(xpath="//select[contains(@data-t21-form-action,'/GetApproverInfo')]")
	WebElement roleDropdown;
	
	@FindBy(xpath="//select[contains(@data-t21-form-action,'/SelectLocation')]")
	WebElement locationDropdowninAddApprover;
	
	@FindBy(xpath="//select[contains(@data-t21-form-action,'/SelectDocRouteApprovers')]")
	WebElement roleNameinAddSignature;
		
	@FindBy(xpath="//select[contains(@name,'SelectedMember')]")
	WebElement  nameinAddApprover;
	
	@FindBy(xpath="//select[contains(@name,'SelectedSequence')]")
	WebElement sequenceinAddApprover;
	
	@FindBy(xpath="//select[contains(@name,'SelectedAllottedDays')]")
	WebElement allottedDaysinAddApprover;
	
	@FindBy(xpath="//table[contains(@class,'t21-table-custom')]")
	WebElement tableRowsinCustomTable;
	
	public WebElement gettableCells(int i,int j){
		
		return tableRowsinCustomTable.findElement(By.xpath("/tbody/tr["+i+"]/td["+j+"]"));
	}
	
	@FindBy(css=".btn.btn-default.fa")
	WebElement addMainFileButton;
	
	@FindBy(xpath="//h4[text()='Add Main File']")
	WebElement addMainFileHeader;
	
	@FindBy(xpath="//*[@id='AttachmentFile']")
	WebElement browseButton;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement addButton;
	
	@FindBy(css=".btn.t21-btn-default.pull-left")
	WebElement cancelButton;
	
	@FindBy(xpath="//h4[text()='Add New Approver']")
	WebElement addNewApproverHeader;
	
	@FindBy(xpath="//select[@name='SelectedRole']")
	WebElement roledropDown;
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement approverAddButton;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement approverCancelButton;
	
	@FindBy(xpath="//span[text()='Name is required.']")
	WebElement approverNameIsReuired;
	
	@FindBy(xpath="//span[text()='Sequence is required.']")
	WebElement approverSequenceIsRequired;
	
	@FindBy(xpath="//span[text()='Allotted days are required.']")
	WebElement approverAllottedDaysRequired;
	
	@FindBy(xpath="//h4[text()='Add New Signature Route']")
	WebElement addNewSignatureRouteHeader;
	
	@FindBy(xpath="//select[@name='SelectedRoute']")
	WebElement routeNameDropDown;
	
	@FindBy(xpath="//div[@id='displaySel']//a[@title='Context Menu']")
	WebElement docContextMenu;
	
	@FindBy(xpath="//span[text()='Check In and Route']")
	WebElement checkInRoute;
	
	@FindBy(xpath="//h4[contains(text(),'Check In and Route')]")
	WebElement checkInRoutePopUpHeader;
	
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement checkInRouteSubmitButton;
	
	@FindBy(xpath="//h4[text()='Message']")
	WebElement messagePopUpHeader;
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement closeButton;
	
	@FindBy(xpath="//div[@class='t21-js-user-message-text']")
	WebElement messagePopUpBody;
	
	@FindBy(xpath="//*[@id='Wizard']/a/span[1]")
	WebElement wizardOption;
	
	@FindBy(css="#Approval>a")
	WebElement approvalTab;
	
	@FindBy(css="#documentId")
	WebElement documentNo;
	
	@FindBy(css=".flash")
	WebElement documentTabForApprover;
	
	@FindBy(xpath="//a[text()='Approve']")
	WebElement documentApproveButton;
	
	@FindBy(xpath="//*[@id='Pin']")
	WebElement pinToApprove;
	
	@FindBy(xpath="//h4[text()='No items for approval']")
	WebElement noItemForApproval;
	
	@FindBy(xpath="//span[text()='Next ']")
	WebElement documentTableNextButton;
	
	public WebElement documentTableNext_Button()
	{
		return documentTableNextButton;
	}
	
	public WebElement noItemForApproval_text()
	{
		return noItemForApproval;
	}
	
	public WebElement pinTo_Approve()
	{
		return pinToApprove;
	}
	
	public WebElement documentApprove_Button()
	{
		return documentApproveButton;
	}
	
	public WebElement documentTab_ForApprover()
	{
		return documentTabForApprover;
	}
	
	/*public Select document_No()
	{
		Select selectObj = new Select(documentNo);
		return selectObj;
	}*/
	
	public WebElement document_No()
	{
		return documentNo;
	}
	
	public WebElement approval_Tab()
	{
		return approvalTab;
	}
	
	public WebElement wizard_Option()
	{
		return wizardOption;
	}
	
	public WebElement messagePopUp_Body()
	{
		return messagePopUpBody;
	}
	
	public WebElement close_Button()
	{
		return closeButton;
	}
	
	public WebElement messagePopUp_Header()
	{
		return messagePopUpHeader;
	}
	
	public WebElement checkInRouteSubmit_Button()
	{
		return checkInRouteSubmitButton;
	}
	
	public WebElement checkInRoutePopUp_Header()
	{
		return checkInRoutePopUpHeader;
	}
	
	public WebElement checkIn_Route()
	{
		return checkInRoute;
	}
	
	public WebElement docContext_Menu()
	{
		return docContextMenu;
	}
	
	public Select routeName_DropDown()
	{
		Select selectObj= new Select(routeNameDropDown);
		return selectObj;
	}
	
	public WebElement addNewSignatureRoute_Header()
	{
		return addNewSignatureRouteHeader;
	}
	
	public WebElement signatureRoute_Link()
	{
		return signatureRouteLink;
	}
	
	public WebElement approverAllottedDaysRequired()
	{
		return approverAllottedDaysRequired;
	}
	
	public WebElement approverSequenceIsRequired()
	{
		return approverSequenceIsRequired;
	}
	
	public WebElement approverNameIsReuired()
	{
		return approverNameIsReuired;
	}
	
	public WebElement approverCancel_Button()
	{
		return approverCancelButton;
	}
	
	public WebElement approverAdd_Button()
	{
		return approverAddButton;
	}
	
	public Select getApproverRole()
	{		
		Select selectObj=new Select(roledropDown);
		return selectObj;		
	}
	
	public WebElement addNewApprover_Header()
	{
		return addNewApproverHeader;
	}
	
	public WebElement cancel_Button()
	{
		return cancelButton;
	}
	
	public WebElement add_Button()
	{
		return addButton;
	}
	
	public WebElement browse_Button()
	{
		return browseButton;
	}
	
	public WebElement addMainFileHeader_Text()
	{
		return addMainFileHeader;
	}
	
	public WebElement addMainFile_Button()
	{
		return addMainFileButton;
	}
	
	public Select getallottedDaysinAddApprover(){
		
		Select selectObj = new Select(allottedDaysinAddApprover);
		return selectObj;
	}
	
	public Select getSequenceinAddApprover(){
		
		Select selectObj = new Select(sequenceinAddApprover);
		return selectObj;
	}
	
	public Select getnameinAddApprover(){
		
		Select selectObj = new Select(nameinAddApprover);
		return selectObj;
	}
	
	public WebElement getDocumentApprovaltab(){
		
		return documentApprovalTab;
	}
	
	public WebElement getEditModeOn(){
		
		return editModeOn;
	}
	
	public WebElement getEditModeOff(){
		
		return editModeOff;
	}
	
	public WebElement getAddApproverLink(){
		
		return addApproverLink;
	}
	
	public WebElement getRoleDropdown(){
		
		return roleDropdown;
	}
	
	public Select getLocationDropdown(){
		Select selectObj=new Select(locationDropdowninAddApprover);
		return selectObj;	
	}
	
	public boolean verifyDocumentCheckedIn(WebDriver driver)
	{
		String popupText = messagePopUp_Body().getText();
		if(popupText.contains("successfully"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyNoItemForApproval(WebDriver driver)
	{
		String Text = noItemForApproval_text().getText();
		if(Text.contains("No items for approval"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}

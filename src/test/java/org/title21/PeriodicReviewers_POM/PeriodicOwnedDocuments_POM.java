package org.title21.PeriodicReviewers_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.Documents_POM.DocumentRoutes_POM;
import org.title21.validation.entities.ErrorMessages;

public class PeriodicOwnedDocuments_POM extends DocumentRoutes_POM {

	public WebDriver driver;
	public WebElement element;
	static Logger log = Logger.getLogger(DocumentRoutes_POM.class);
	
	public PeriodicOwnedDocuments_POM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//*[@id='DocPeriodicReviewDays']")
	WebElement periodicReviewsDaysTextBox;
	
	@FindBy(xpath="//*[@id='DocPeriodicReviewDateString']")
	WebElement pickDateTextBox;
	
	@FindBy(xpath="//a[contains(@href,'AddReviewerModal')]")
	WebElement editPeriodicReviewersLink; 
	
	@FindBy(css="#Location")
	WebElement editPeriodicReviewersLocation;
	
	@FindBy(xpath="//h4[text()='Edit Periodic Reviewers']")
	WebElement editPeriodicReviewersHeaderText;
	
	@FindBy(xpath="//*[@id='default-modal']/div/form/div/div[2]/div[2]/div[1]/input")
	WebElement availablePeriodicReviewersFilter;
	
	@FindBy(css=".btn.moveall.btn-default")
	WebElement availablePeriodicMoveButton;
	
	@FindBy(xpath=".//*[@id='bootstrap-duallistbox-nonselected-list_DocRequiredReviewerList[]']/option[1]")
	WebElement AvailablePeriodicReviewersSearchResultArea;
	
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement saveButton;
	
	@FindBy(xpath=".//*[@id='GeneralTab']/div[1]/div[2]/div[4]/div[2]/label")
	WebElement documentStatus;
	
	@FindBy(css="#Review>a")
	WebElement wizardReviewTab;
	
	@FindBy(xpath="//a[contains(@href,'#GeneralTab')]")
	WebElement genaralTab;
	
	@FindBy(xpath="//*[@id='DocTargetReleaseDateString']")
	WebElement docTargetReleaseDateTextBox;
	
	@FindBy(css=".btn-danger.t21-ajax-link")
	WebElement changeButton;
	
	@FindBy(css=".btn-success.t21-ajax-link")
	WebElement dontChangeButton;
	
	@FindBy(xpath="//table[@class='t21-table-custom']//tr[2]//span[@class='fa fa-caret-down']")
	WebElement firstPeriodicReviewerContextTab;
	
	@FindBy(xpath="//table[@class='t21-table-custom']//tr[3]//span[@class='fa fa-caret-down']")
	WebElement secondPeriodicReviewerContextTab;
	
	@FindBy(xpath="//*[@id='ReviewDocs']//tr[2]/td[2]//span[contains(text(),'Bypass')]/parent::a")
	WebElement firstPeriodicReviewerBypass;
	
	@FindBy(xpath="//p[contains(text(),'Bypass this reviewer')]")
	WebElement bypassReviewerConfirmationMsg;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement yesButton;
	
	@FindBy(xpath="//tr[2]//a[contains(text(),'Bypassed by')]")
	WebElement bypassedByFirstReviewerTextMsg;
	
	@FindBy(xpath="//*[@id='ReviewDocs']//tr[2]/td[2]//span[contains(text(),'Clear bypass')]/parent::a")
	WebElement firstPeriodicReviewerClearBypass;
	
	@FindBy(xpath="//a[text()='View Document']")
	WebElement viewDocButtonForPeriodicReview;
	
	@FindBy(xpath="//span[contains(text(),'Review decision')]")
	WebElement reviewDecisionPopUpHeader;
	
	@FindBy(xpath="//*[@id='Pin']")
	WebElement reviewPINTextBox;
	
	@FindBy(xpath="//tr[2]//*[contains(text(),'No Changes Required')]")
	WebElement noChangesRequiredFirstReviewer;
	
	@FindBy(xpath="//*[@id='ReviewDocs']//tr[3]/td[2]/div//span[contains(text(),'Bypass')]/parent::a")
	WebElement secondPeriodicReviewerBypass;
	
	@FindBy(css=".grid-button-text")
	WebElement auditLogOption;
	
	@FindBy(css=".dropdown-toggle.t21-nav-bar-dropdown")
	WebElement administratordropdown;
	
	@FindBy(css=".btn-group")
	WebElement changeDontChangeDisableButton;
	
	@FindBy(xpath="//*[@id='ReviewDocs']//tr[2]/td[6]")
	WebElement firstReviewerComments;
	
	@FindBy(xpath="//*[@id='Type']")
	WebElement auditLogTypeDropDown;
	
	@FindBy(xpath="//*[text()='Confirm']")   
	WebElement auditLogConfirmButton;
	
	@FindBy(xpath="//li[@id='Settings']")
	WebElement dropDownSettingLink;
	
	@FindBy(xpath="//*[@id='BatchReview']")
	WebElement multiSignReviewCheckBox;
	
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement approveConfirmButton;

	@FindBy(xpath="//*[@id='ReviewDocs']/div/div[3]/p")
	WebElement NoResultsReturned;
	
	@FindBy(xpath="//*[@id='t21-workarea']/div/div/div[1]/h5")
	WebElement NoItemsFound;
	
	public WebElement NoItemsFound_Text()
	{
		return NoItemsFound;
	}
	
	public WebElement NoResultsReturned_Text()
	{
		return NoResultsReturned;
	}
	
	public WebElement approveConfirm_Button()
	{
		return approveConfirmButton;
	}
	
	public WebElement multiSignReview_CheckBox()
	{
		return multiSignReviewCheckBox;
	}
	
	public WebElement dropDownSetting_Link()
	{
		return dropDownSettingLink;
	}
	
	public WebElement auditLogConfirm_Button()
	{
		return auditLogConfirmButton;
	}
	
	public Select auditLogType_DropDown()
	{
		Select selectObj = new Select(auditLogTypeDropDown);
		return selectObj;
	}
	
	public WebElement firstReviewer_Comments()
	{
		return firstReviewerComments;
	}
	
	public WebElement changeDontChangeDisable_Button()
	{
		return changeDontChangeDisableButton;
	}
	
	public WebElement auditLog_Option()
	{
		return auditLogOption;
	}
	
	public WebElement administratorDropDown()
	{
		return administratordropdown;
	}
	
	public WebElement secondPeriodicReviewer_Bypass()
	{
		return secondPeriodicReviewerBypass;
	}
	
	public WebElement noChangesRequired_FirstReviewer()
	{
		return noChangesRequiredFirstReviewer;
	}
	
	public WebElement reviewPIN_TextBox()
	{
		return reviewPINTextBox;
	}
	
	public WebElement reviewDecisionPopUp_Header()
	{
		return reviewDecisionPopUpHeader;
	}

	public WebElement viewDocButtonForPeriodicReview()
	{
		return viewDocButtonForPeriodicReview;
	}
	
	public WebElement firstPeriodicReviewer_ClearBypass()
	{
		return firstPeriodicReviewerClearBypass;
	}
	
	public WebElement bypassedByFirstReviewer_TextMsg()
	{
		return bypassedByFirstReviewerTextMsg;
	}
	
	public WebElement yes_Button()
	{
		return yesButton;
	}
	
	public WebElement bypassReviewer_ConfirmationMsg()
	{
		return bypassReviewerConfirmationMsg;
	}
	
	public WebElement firstPeriodicReviewerBypass_Menu()
	{
		return firstPeriodicReviewerBypass;
	}
	
	public WebElement secondPeriodicReviewer_ContextTab()
	{
		return secondPeriodicReviewerContextTab;
	}
	
	public WebElement firstPeriodicReviewer_ContextTab()
	{
		return firstPeriodicReviewerContextTab;
	}
	
	public WebElement dontChange_Button()
	{
		return dontChangeButton;
	}
	
	public WebElement change_Button()
	{
		return changeButton;
	}
	
	public WebElement docTargetReleaseDate_TextBox()
	{
		return docTargetReleaseDateTextBox;
	}
	
	public WebElement general_Tab()
	{
		return genaralTab;
	}
	
	public WebElement wizardReview_Tab()
	{
		return wizardReviewTab;
	}
	
	public WebElement document_Status()
	{
		return documentStatus;
	}
	
	public WebElement save_Button()
	{
		return saveButton;
	}
	
	public WebElement AvailablePeriodicReviewers_SearchResultArea()
	{
		return AvailablePeriodicReviewersSearchResultArea;
	}
	
	public WebElement availablePeriodic_MoveButton()
	{
		return availablePeriodicMoveButton;
	}
	
	public WebElement availablePeriodicReviewers_Filter()
	{
		return availablePeriodicReviewersFilter;
	}
	
	public WebElement editPeriodicReviewers_HeaderText()
	{
		return editPeriodicReviewersHeaderText;
	}

	public Select editPeriodicReviewersLocationDropDown()
	{
		Select selectObje = new Select(editPeriodicReviewersLocation);
		return selectObje;
	}
	
	public WebElement editPeriodicReviewers_Link()
	{
		return editPeriodicReviewersLink;
	}
	
	public WebElement pickDate_TextBox()
	{
		return pickDateTextBox;
	}
	
	public WebElement periodicReviewsDays_TextBox()
	{
		return periodicReviewsDaysTextBox;
	}
	
	public void multiSignReviewCheck(Boolean check)
	{
	  if (!check && multiSignReview_CheckBox().isSelected()) 
	  {
		  multiSignReview_CheckBox().click();
	  }
	  else if (check && !multiSignReview_CheckBox().isSelected())
	  {
		  multiSignReview_CheckBox().click();
	  }
	}
	
	public boolean verifyNoResults(){
		
		String errorMessage="";
		try 
		{
			errorMessage = NoResultsReturned_Text().getText();
			
		}catch(NoSuchElementException e) {
			
		}
		if(errorMessage.contains("No results"))
		{
			return true;
		}
		else
		{	
			return false;
		}		
	}
	
	public boolean verifyNoItemsFoundText(){
		
		String errorMessage="";
		try 
		{
			errorMessage = NoItemsFound_Text().getText();
			
		}catch(NoSuchElementException e) {
			
		}
		if(errorMessage.contains("No items found"))
		{
			return true;
		}
		else
		{	
			return false;
		}		
	}
}
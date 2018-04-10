package org.title21.Documents_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath="//*[@id='Location']")
	WebElement editPeriodicReviewersLocation;
	
	@FindBy(xpath="//h4[text()='Edit Periodic Reviewers']")
	WebElement editPeriodicReviewersHeaderText;
	
	@FindBy(css=".t21-placeholder.form-control.valid")
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
	
}


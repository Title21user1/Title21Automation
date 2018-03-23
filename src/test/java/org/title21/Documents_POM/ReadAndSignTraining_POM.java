package org.title21.Documents_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReadAndSignTraining_POM extends DocumentRoutes_POM {

	public WebDriver driver;
	public WebElement element;
	static Logger log = Logger.getLogger(DocumentRoutes_POM.class);
	
	public ReadAndSignTraining_POM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//a[contains(@href,'#TrainingTab')]")
	WebElement trainingTab;
	
	@FindBy(xpath="//a[contains(@href,'ChangeTrainingTypeModal')]")
	WebElement changeTrainingTypeLink;
	
	@FindBy(xpath="//h4[text()='Change Training Type']")
	WebElement changeTrainingTypeHeader;
	
	@FindBy(xpath="//input[@value='ReadAndSign']")
	WebElement readAndSignRadioButton;
	
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement changeTrainingTypePopUpSaveButton;
	
	@FindBy(xpath="//*[@id='SelectedCabinet']")
	WebElement scheduleTrainingDropDown;
	
	@FindBy(xpath="//input[@value='BeforePromotion']")
	WebElement BeforePromotionRadioButton;
	
	@FindBy(xpath="//*[@id='TrainingTab']/div/div/div[8]/form/div[1]")
	WebElement readWriteFromCabinetRadioButton;
	
	@FindBy(css="#Training>a")
	WebElement wizardTrainingTab;
	
	@FindBy(xpath="//a[text()='Begin Training']")
	WebElement beginTrainingButton;
	
	@FindBy(xpath="//a[text()='Document']")
	WebElement documentButton;
	
	@FindBy(xpath="//a[text()='Sign']")
	WebElement signButton;
	
	@FindBy(xpath="//*[@id='Pin']")
	WebElement pinTextBox;
	
	@FindBy(css=".dropdown-toggle.t21-nav-bar-dropdown")
	WebElement administratordropdown;
	
	@FindBy(css=".grid-button-text")
	WebElement auditLogOption;
	
	@FindBy(css=".t21-placeholder")
	WebElement audtitLogSearchField;
	
	@FindBy(xpath="//button[@type='submit'][@tabindex='1']")
	WebElement audtitLogSearchFieldGobutton;
	
	public WebElement audtitLogSearchFieldGo_button()
	 {
		 return audtitLogSearchFieldGobutton;
	 }
	
	public WebElement audtitLogSearch_Field()
	{
		return audtitLogSearchField;
	}
	
	public WebElement auditLog_Option()
	{
		return auditLogOption;
	}
	
	public WebElement administratorDropDown()
	{
		return administratordropdown;
	}
	
	public WebElement pin_TextBox()
	{
		return pinTextBox;
	}
	
	public WebElement sign_Button()
	{
		return signButton;
	}
	
	public WebElement document_Button()
	{
		return documentButton;
	}
	
	public WebElement beginTraining_Button()
	{
		return beginTrainingButton;
	}
	
	public WebElement wizardTraining_Tab()
	{
		return wizardTrainingTab;
	}
	
	public WebElement readWriteFromCabinetRadio_Button()
	{
		return readWriteFromCabinetRadioButton;
	}
	
	public WebElement BeforePromotionRadio_Button()
	{
		return BeforePromotionRadioButton;
	}
	
	public Select scheduleTraining_DropDown()
	{
		Select selectObj = new Select(scheduleTrainingDropDown);
		return selectObj;
	}
	
	public WebElement changeTrainingTypePopUpSave_Button()
	{
		return changeTrainingTypePopUpSaveButton;
	}
	
	public WebElement readAndSignRadio_Button()
	{
		return readAndSignRadioButton;
	}
	
	public WebElement changeTrainingType_Header()
	{
		return changeTrainingTypeHeader;
	}
	
	public WebElement ChangeTrainingType_Link()
	{
		return changeTrainingTypeLink;
	}
	
	public WebElement training_Tab()
	{
		return trainingTab;
	}

}


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
	
	@FindBy(xpath="//a[contains(@href,'#GeneralTab')]")
	WebElement genaralTab;
	
	@FindBy(xpath="//*[@id='DocTargetReleaseDateString']")
	WebElement targetReleaseDateTextBox;
	
	@FindBy(css="#CanPromoteWithOpenTraining")
	WebElement promotionSettingsItemCheckBox;
	
	@FindBy(css="#MinPercentRequired")
	WebElement trainingsPercentageCheckBox;
	
	@FindBy(css="#Percent")
	WebElement trainingsPercentageTextBox;
	
	@FindBy(xpath="//*[@id='EntitiesFromSelection'][@value='True']")
	WebElement entitiesSubjectFromSection;
	
	@FindBy(xpath="//*[@id='add-new-training-entities']")
	WebElement addNewTrainingEntitiesLink;
	
	@FindBy(xpath="//h4[text()='Selected Entities']")
	WebElement selectedEntitiesHeader;
	
	@FindBy(xpath="//*[@id='bootstrap-duallistbox-nonselected-list_selectedEmployee']/option[1]")
	WebElement firstEmpFromList;
	
	@FindBy(xpath=".//*[@id='GeneralTab']/div[1]/div[2]/div[4]/div[2]/label")
	WebElement documentStatus;
	
	@FindBy(xpath="//*[@id='EmployeeFilterBox']")
	WebElement entitiesEmpFilterBox;
	
	@FindBy(xpath="//*[@id='tab1']/div[1]/div/span[1]/button")
	WebElement entitiesEmpFilterGoButton;
	
	@FindBy(xpath="//*[@id='tab1']/div[3]/div[1]/div/button[1]")
	WebElement moveSelectedEntitiesButton;
	
	@FindBy(xpath="//*[@id='bootstrap-duallistbox-selected-list_selectedEmployee']/option")
	WebElement addedFirstEntities;
	
	@FindBy(xpath="//*[@id='TrainingDueBy'][@value='ByDate']")
	WebElement trainingDueByDate;
	
	@FindBy(xpath="//*[@id='TrainingDueDate']")
	WebElement trainingDueDateTextBox;
	
	public WebElement trainingDueDate_TextBox()
	{
		return trainingDueDateTextBox;
	}

	public WebElement trainingDue_ByDate()
	{
		return trainingDueByDate;
	}
	
	public WebElement addedFirst_Entities()
	{
		return addedFirstEntities;
	}
	
	public WebElement moveSelectedEntities_Button()
	{
		return moveSelectedEntitiesButton;
	}
	
	public WebElement entitiesEmpFilterGo_Button()
	{
		return entitiesEmpFilterGoButton;
	}
	
	public WebElement entitiesEmp_FilterBox()
	{
		return entitiesEmpFilterBox;
	}
	
	public WebElement document_Status()
	{
		return documentStatus;
	}
	
	public WebElement firstEmp_FromList()
	{
		return firstEmpFromList;
	}
	
	public WebElement selectedEntities_Header()
	{
		return selectedEntitiesHeader;
	}
	
	public WebElement addNewTrainingEntities_Link()
	{
		return addNewTrainingEntitiesLink;
	}
	
	public WebElement entitiesSubject_FromSection()
	{
		return entitiesSubjectFromSection;
	}
	
	public WebElement trainingsPercentage_TextBox()
	{
		return trainingsPercentageTextBox;
	}
	
	public WebElement trainingsPercentage_CheckBox()
	{
		return trainingsPercentageCheckBox;
	}
	
	public WebElement promotionSettingsItem_CheckBox()
	{
		return promotionSettingsItemCheckBox;
	}
	
	public WebElement targetReleaseDate_TextBox()
	{
		return targetReleaseDateTextBox;
	}
	
	public WebElement general_Tab()
	{
		return genaralTab;
	}
	
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
	
	public void promotionSettingsItemsCheck(Boolean check)
	 {
	  if (!check && promotionSettingsItem_CheckBox().isSelected()) {
		  promotionSettingsItem_CheckBox().click();
	  }
	  else if (check && !promotionSettingsItem_CheckBox().isSelected()) {
		  promotionSettingsItem_CheckBox().click();
	  }
	 }
	
	public void trainingsPercentagCheck(Boolean check)
	 {
	  if (!check && trainingsPercentage_CheckBox().isSelected()) {
		  trainingsPercentage_CheckBox().click();
	  }
	  else if (check && !trainingsPercentage_CheckBox().isSelected()) {
		  trainingsPercentage_CheckBox().click();
	  }
	 }
}


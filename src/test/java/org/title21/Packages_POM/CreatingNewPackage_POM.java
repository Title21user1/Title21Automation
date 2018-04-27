package org.title21.Packages_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.Documents_POM.DocumentRoutes_POM;

public class CreatingNewPackage_POM extends DocumentRoutes_POM {

	public WebDriver driver;
	public WebElement element;
	static Logger log = Logger.getLogger(CreatingNewPackage_POM.class);
	
	public CreatingNewPackage_POM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//div[text()='Package']")
	WebElement packageLink;
	
	@FindBy(xpath="//span[text()='Create New Package']")
	WebElement createNewPackage_HeaderText;
	
	@FindBy(xpath="//*[@id='Cabinet']")
	WebElement cabinetDropDown;
	
	@FindBy(xpath="//*[@id='CabinetSection']")
	WebElement cabinetSectionDropDown;
	
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement createButton;
	
	@FindBy(xpath="//*[@id='TravelerName']")
	WebElement packageNameTextBox;
	
	@FindBy(xpath="//label[text()='PKG']")
	WebElement packageTypeLable;
	
	@FindBy(xpath="//*[@id='ChangeReason']")
	WebElement ChangeReasonTextBox;
	
	@FindBy(xpath="//span[text()='My Docs']")
	WebElement myDocsTab;
	
	@FindBy(xpath="//a[contains(@href,'Travelers')]")
	WebElement packagesLink;
	
	@FindBy(xpath=".//*[@id='GeneralTab']/div[1]/div[2]/div[1]/div[2]/label")
	WebElement packageNo;
	
	@FindBy(css=".t21-placeholder")
	WebElement packageFilterTextBox;
	
	@FindBy(xpath="//button[@type='submit'][contains(text(),'Go')]")
	WebElement packageFilterGoButton;
	
	@FindBy(xpath="//tr[1]/td[2]")
	WebElement filteredPackageResult;
	
	@FindBy(xpath="//a[contains(@href,'AttachDocsToTravModal')]")
	WebElement addRemoveLinkText;
	
	@FindBy(xpath="//h4[text()='Attach Documents']")
	WebElement attachDocHeaderText;
	
	@FindBy(xpath="//*[@id='SelectedStatus']")
	WebElement selectStatusDoropDown;
	
	@FindBy(xpath="//*[@id='default-modal']/div/form/div/div[2]/div[1]/div[2]/input[1]")
	WebElement createdBetweenDateBox;
	
	@FindBy(xpath="//input[@name='SelectedEndDate']")
	WebElement andDateBox;
	
	@FindBy(xpath="//*[@id='SelectedEventType']")
	WebElement typeDropDown;
	
	@FindBy(xpath="//span[@class='multiselect-selected-text']")
	WebElement locationDropDown;
	
	@FindBy(xpath="//*[@class='multiselect-item multiselect-all']")
	WebElement selectAllLocacation;
	
	@FindBy(css=".day.today")
	WebElement currentDate;

	@FindBy(xpath="//*[@id='collapse-0']//tr[1]/td[2]")
	WebElement docAddedInDocSection;
	
	@FindBy(xpath="//input[@id='TravTargetReleaseDateString']")
	WebElement targetReleaseDateTextBox;
	
	@FindBy(css=".modal-title>span")
	WebElement updateAttachedDocHeaderText;
	
	@FindBy(xpath="//*[text()='Update attached documents obsolete date']")
	WebElement updateAttachedDocobsoleteHeaderText;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement yesButton;
	
	@FindBy(xpath="//h4[text()='Message']")
	WebElement msgPopUpHeader;
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement closeButton;
	
	@FindBy(xpath="//input[@name='searchString']")
	WebElement attachedDocFilterResultTextBox;
	
	@FindBy(xpath="//*[@id='default-modal']/div/form/div/div[2]/div[1]/div[5]/div/span[1]/button")
	WebElement attachedDocFilterResultGoButton;
	
	@FindBy(xpath="//*[@id='collapse-0']//tr[3]/td[3]/div/a/span[1]")
	WebElement thirdDocContextMenu;
	
	@FindBy(xpath="//*[@id='collapse-0']//tr[3]/td[2]")
	WebElement thirdDocName;
	
	@FindBy(xpath="//*[@id='collapse-0']//tr[4]/td[3]/div/a/span[1]")
	WebElement fourthDocContextMenu;
	
	@FindBy(xpath="//span[text()='Obsolete']")
	WebElement obsoleteOption;

	@FindBy(css="#DocObsoleteDateString")
	WebElement obsoleteDate_TextBox;
	
	@FindBy(xpath="//*[@id='TravObsoleteDateString']")
	WebElement obsoleteDateToSet_TextBox;
	
	@FindBy(xpath="//*[@id='NavSearches']")
	WebElement searchesTab;
	
	@FindBy(xpath="//*[@id='RegularSearches']/div/div[1]/div/form/div/input")
	WebElement searchesFilterResultTextBox;
	
	@FindBy(xpath="//*[@id='RegularSearches']/div/div[1]/div/form/div/span[1]/button")
	WebElement searchesFilterResultGoButton;
	
	@FindBy(xpath="//*[@id='OnlyShowAvailable']")
	WebElement onlyshowavailableDocCheckBox;
	
	@FindBy(xpath="//a[@id='editCell'][text()='Search on Document Number']")
	WebElement searchOnDocumentNumberLinkText;
	
	@FindBy(xpath="//*[@id='param-0']")
	WebElement docNoTextBox;
	
	@FindBy(xpath="//input[@type='submit'][@value='Go']")
	WebElement searchGoButton;
	
	@FindBy(xpath="//tr[1]/td[6]")
	WebElement docStatus;
	
	public WebElement docStatus()
	{
		return docStatus;
	}
	
	public WebElement obsoleteDateToSet_TextBox()
	{
		return obsoleteDateToSet_TextBox;
	}
	
	public WebElement searchGo_Button()
	{
		return searchGoButton;
	}
	
	public WebElement docNo_TextBox()
	{
		return docNoTextBox;
	}
	
	public WebElement searchOnDocumentNumber_LinkText()
	{
		return searchOnDocumentNumberLinkText;
	}
	
	public WebElement onlyshowavailableDoc_CheckBox()
	{
		return onlyshowavailableDocCheckBox;
	}
	
	public WebElement selectAll_Locacation()
	{
		return selectAllLocacation;
	}
	
	public WebElement searchesFilterResultGo_Button()
	{
		return searchesFilterResultGoButton;
	}
	
	public WebElement searchesFilterResult_TextBox()
	{
		return searchesFilterResultTextBox;
	}
	
	public WebElement searches_Tab()
	{
		return searchesTab;
	}
	
	public WebElement thirdDoc_Name()
	{
		return thirdDocName;
	}
	
	public WebElement updateAttachedDocobsolete_HeaderText()
	{
		return updateAttachedDocobsoleteHeaderText;
	}
	
	public WebElement obsoleteDate_TextBox()
	{
		return obsoleteDate_TextBox;
	}
	
	public WebElement obsolete_Option()
	{
		return obsoleteOption;
	}
	
	public WebElement fourthDocContext_Menu()
	{
		return fourthDocContextMenu;
	}
	
	public WebElement thirdDocContext_Menu()
	{
		return thirdDocContextMenu;
	}
	
	public WebElement attachedDocFilterResultGo_Button()
	{
		return attachedDocFilterResultGoButton;
	}
	
	public WebElement attachedDocFilterResult_TextBox()
	{
		return attachedDocFilterResultTextBox;
	}
	
	
	public WebElement close_Button()
	{
		return closeButton;
	}
	
	public WebElement msgPopUp_Header()
	{
		return msgPopUpHeader;
	}
	
	public WebElement yes_Button()
	{
		return yesButton;
	}
	
	public WebElement updateAttachedDocHeaderText()
	{
		return updateAttachedDocHeaderText;
	}
	
	public WebElement targetReleaseDate_TextBox()
	{
		return targetReleaseDateTextBox;
	}
	
	public WebElement docAddedIn_DocSection()
	{
		return docAddedInDocSection;
	}
	
	public WebElement current_Date()
	{
		return currentDate;
	}
	
	public WebElement location_DropDown()
	{
		return locationDropDown;
	}
	
	public Select type_DropDown()
	{
		Select selectObj = new Select(typeDropDown);
		return selectObj;
	}
	
	public WebElement andDate_Box()
	{
		return andDateBox;
	}
	
	public WebElement createdBetween_DateBox()
	{
		return createdBetweenDateBox;
	}
	
	public Select selectStatus_DoropDown()
	{
		Select selectObj = new Select(selectStatusDoropDown);
		return selectObj;
	}
	
	public WebElement attachDoc_HeaderText()
	{
		return attachDocHeaderText;
	}
	
	public WebElement addRemove_LinkText()
	{
		return addRemoveLinkText;
	}
	
	public WebElement filteredPackage_Result()
	{
		return filteredPackageResult;
	}
	
	public WebElement packageFilterGo_Button()
	{
		return packageFilterGoButton;
	}
	
	public WebElement packageFilter_TextBox()
	{
		return packageFilterTextBox;
	}

	public WebElement package_No()
	{
		return packageNo;
	}
	
	public WebElement packages_Link()
	{
		return packagesLink;
	}
	
	public WebElement myDocs_Tab()
	{
		return myDocsTab;
	}
	
	public WebElement ChangeReason_TextBox()
	{
		return ChangeReasonTextBox;
	}
	
	public WebElement packageType_Lable()
	{
		return packageTypeLable;
	}
	
	public WebElement packageName_TextBox()
	{
		return packageNameTextBox;
	}

	public WebElement create_Button()
	{
		return createButton;
	}
	
	public Select cabinetSection_DropDown()
	{
		Select selectObj = new Select(cabinetSectionDropDown);
		return selectObj;
	}
	
	public Select cabinet_DropDown()
	{
		Select selectObj = new Select(cabinetDropDown);
		return selectObj;
	}
	
	public WebElement createNewPackage_HeaderText()
	{
		return createNewPackage_HeaderText;
	}
	
	public WebElement package_Link()
	{
		return packageLink;
	}
	
	
	public boolean verifyCreateNewPackagePopUpText()
	{
		String CreateNewPackageHeaderText = createNewPackage_HeaderText.getText();
		
		if(CreateNewPackageHeaderText.equalsIgnoreCase("Create New Package"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyPackageScreen()
	{
		String packageText = packageType_Lable().getText();
		
		if(packageText.equalsIgnoreCase("PKG"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyAttachDocScreen()
	{
		String headerText = attachDoc_HeaderText().getText();
		
		if(headerText.equalsIgnoreCase("Attach Documents"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyUpdateAttachedDocPopUp()
	{
		String headerText = updateAttachedDocHeaderText().getText();
		
		if(headerText.equalsIgnoreCase("Update attached documents release date"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean verifyupdateAttachedDocobsoleteDocPopUp()
	{
		String headerText = updateAttachedDocobsolete_HeaderText().getText();
		
		if(headerText.equalsIgnoreCase("Update attached documents obsolete date"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyMsgPopUpHeader()
	{
		String headerText = msgPopUp_Header().getText();
		
		if(headerText.equalsIgnoreCase("Message"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}


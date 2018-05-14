package org.title21.Module3_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.Documents_POM.DocumentRoutes_POM;
import org.title21.utility.BaseClass;

public class Codes_POM extends DocumentRoutes_POM
{
public WebDriver driver;
public WebElement element;
BaseClass baseClassObj = new BaseClass();

public Codes_POM(WebDriver driver) {
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[contains(@href,'GetCodeList')]")
WebElement codeslink;

@FindBy(xpath="//*[contains(@href,'AddCodeClass')]")
WebElement addCodeClass;

@FindBy(xpath="//h4[text()='Add Code Class']")
WebElement addCodeClassHeader;

@FindBy(xpath="//button[text()='Add']")
WebElement addButton;

/*@FindBy(xpath="//select[@id='CodeClass']")
WebElement classNameTextBox;*/

@FindBy(xpath="//input[@id='CodeClass'][@data-val='true']")
WebElement classNameTextBox;

@FindBy(xpath="//span[text()='Name already exists']")
WebElement nameAlreadyExistsErrorMsg;

@FindBy(xpath="//div[contains(text(),'added successfully')]")
WebElement codeAddedSuccessfullyVerificationMsg;

@FindBy(xpath="//button[text()='Close']")
WebElement closeButton;

@FindBy(xpath="//a[contains(@href,'AddCodeCategory')]")
WebElement addCodeCategoryLink;

@FindBy(css=".fa-pencil")
WebElement editClassIcon;

@FindBy(xpath="//button[text()='Cancel']")
WebElement cancelButton;

@FindBy(xpath="//h4[text()='Add Code Category']")
WebElement addCodeCategoryHeader;

@FindBy(xpath="//input[@id='CodeCategoryName'][@type='text']")
WebElement codeCategoryTextBox;

@FindBy(xpath="//a[contains(@href,'AddCodeName')]")
WebElement addCodeNameLink;

@FindBy(xpath="//h4[text()='Add Code']")
WebElement addCodePopUpHeader;

@FindBy(xpath="//span[text()='Code Id is required']")
WebElement codeIdIsRequiredErrorMsg;

@FindBy(xpath="//span[text()='Name is required']")
WebElement nameIsRequiredErrorMsg;

@FindBy(xpath="//input[@id='CodeId'][@type='text']")
WebElement addCodeIdTextBox;

@FindBy(xpath="//*[@id='CodeName'][@type='text']")
WebElement addCodeNameTextBox;

@FindBy(xpath="//*[@id='Definition'][@type='text']")
WebElement addCodeDefinitionTextBox;

@FindBy(xpath="//*[@id='CritId']")
WebElement addCodeCritIdDropDown;

@FindBy(xpath="//*[@id='CodeId-error']")
WebElement codeIdErrorMsg;

@FindBy(xpath="//*[@id='CodeClass']")
WebElement codeClassDropDown;

@FindBy(xpath="//a[contains(@href,'GetCodeAvailabilityList')]")
WebElement getCodeAvailabilityListLink;

/*@FindBy(css=".form-control.t21-placeholder")
WebElement filterResultTextBox;*/

@FindBy(xpath="//*[@id='t21-workarea']/div/div/div[2]/div[2]/div/div/div/div/form/div/input")
WebElement filterResultTextBox;

/*@FindBy(xpath="//button[@type='submit'][@tabindex='1']")
WebElement filterResultGoButton;*/

@FindBy(xpath="//*[@id='t21-workarea']/div/div/div[2]/div[2]/div/div/div/div/form/div/span[1]/button")
WebElement filterResultGoButton;

@FindBy(xpath="//h4[text()='Update Code Availability for IndxCard']")
WebElement updateCodeAvailabilityIndexCardHeader;

@FindBy(xpath="//button[text()='Update']")
WebElement updateButton;

@FindBy(xpath="//div[contains(text(),'updated successfully')]")
WebElement codeupdatedSuccessfullyVerificationMsg;

@FindBy(css=".dropdown-toggle.t21-nav-bar-dropdown")
WebElement administratordropdown;

@FindBy(xpath="//a[contains(@href, 'Administration')]")
WebElement administrationlink;

@FindBy(xpath="//a[contains(@href,'#CodesTab')]")
WebElement codesTab;

@FindBy(css=".t21-js-parentnode.head")
WebElement codeCategoryOnCodeTab;

@FindBy(css=".treeview.hover.t21-no-padding>ul>li>label")
WebElement codeCategoryPlusSign;

@FindBy(css=".t21-code-with-description")
WebElement codeNameOnCodesTab;

@FindBy(xpath="//*[@id='CodesTab']//td[1]")
WebElement codeNameWithDetailsOnCodesTab;

@FindBy(css=".action-items")
WebElement deleteIconToDeleteCodeInCodeTab;

@FindBy(css=".col-md-7>div>div")
WebElement NoCodesSelectedOnCodesTab;

public WebElement NoCodesSelected_OnCodesTab()
{
	return NoCodesSelectedOnCodesTab;
}

public WebElement deleteIconToDeleteCode_InCodeTab()
{
	return deleteIconToDeleteCodeInCodeTab;
}

public WebElement codeNameWithDetails_OnCodesTab()
{
	return codeNameWithDetailsOnCodesTab;
}

public WebElement codeName_OnCodesTab()
{
	return codeNameOnCodesTab;
}

public WebElement codeCategory_PlusSign()
{
	return codeCategoryPlusSign;
}

public WebElement codeCategoryOn_CodeTab()
{
	return codeCategoryOnCodeTab;
}

public WebElement codes_Tab()
{
	return codesTab;
}

public WebElement administrationLink()
{
	 return administrationlink;
}

public WebElement administratorDropDown()
{
	 return administratordropdown;
}

public WebElement codeupdatedSuccessfully_VerificationMsg()
{
	return codeupdatedSuccessfullyVerificationMsg;
}

public WebElement update_Button()
{
	return updateButton;
}

public WebElement updateCodeAvailabilityIndexCard_Header()
{
	return updateCodeAvailabilityIndexCardHeader;
}

public WebElement filterResultGo_Button()
{
	return filterResultGoButton;
}

public WebElement filterResult_TextBox()
{
	return filterResultTextBox;
}

public WebElement getCodeAvailabilityList_Link()
{
	return getCodeAvailabilityListLink;
}

public Select codeClass_DropDown()
{
	Select selectObj = new Select(codeClassDropDown);
	return selectObj;
}

public WebElement codeId_ErrorMsg()
{
	return codeIdErrorMsg;
}

public Select addCodeCritIdDropDown()
{
	Select selectObj = new Select(addCodeCritIdDropDown);
	return selectObj;
}

public WebElement addCodeDefinition_TextBox()
{
	return addCodeDefinitionTextBox;
}

public WebElement addCodeName_TextBox()
{
	return addCodeNameTextBox;
}

public WebElement addCodeId_TextBox()
{
	return addCodeIdTextBox;
}

public WebElement nameIsRequired_ErrorMsg()
{
	return nameIsRequiredErrorMsg;
}

public WebElement codeIdIsRequired_ErrorMsg()
{
	return codeIdIsRequiredErrorMsg;
}

public WebElement addCodePopUp_Header()
{
	return addCodePopUpHeader;
}

public WebElement addCodeName_Link()
{
	return addCodeNameLink;
}

public WebElement codeCategory_TextBox()
{
	return codeCategoryTextBox;
}

public WebElement addCodeCategory_Header()
{
	return addCodeCategoryHeader;
}

public WebElement cancel_Button()
{
	return cancelButton;
}

public WebElement editClass_Icon()
{
	return editClassIcon;
}

public WebElement addCodeCategory_Link()
{
	return addCodeCategoryLink;
}

public WebElement close_Button()
{
	return closeButton;
}

public WebElement codeAddedSuccessfully_VerificationMsg()
{
	return codeAddedSuccessfullyVerificationMsg;
}

public WebElement nameAlreadyExists_ErrorMsg()
{
	return nameAlreadyExistsErrorMsg;
}

public WebElement className_TextBox()
{
	return classNameTextBox;
}

public WebElement add_Button()
{
	return addButton;
}

public WebElement addCodeClass_Header()
{
	return addCodeClassHeader;
}

public WebElement addCodeClass_Link()
{
	return addCodeClass;
}

public WebElement codes_Link()
{
	return codeslink;
}
 
}

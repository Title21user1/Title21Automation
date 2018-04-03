package org.title21.Codes_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.POM.AdministrationPage_POM;
import org.title21.utility.BaseClass;

public class Codes_POM extends AdministrationPage_POM
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

@FindBy(xpath="//select[@id='CodeClass']")
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

@FindBy(xpath=".form-control.t21-placeholder")
WebElement filterResultTextBox;

@FindBy(xpath="//button[@type='submit'][@tabindex='1']")
WebElement filterResultGoButton;

@FindBy(xpath="//h4[text()='Update Code Availability for IndxCard']")
WebElement updateCodeAvailabilityIndexCardHeader;

@FindBy(xpath="//button[text()='Update']")
WebElement updateButton;

@FindBy(xpath="//div[contains(text(),'updated successfully')]")
WebElement codeupdatedSuccessfullyVerificationMsg;

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

public WebElement codes_Tab()
{
	return codeslink;
}
 
}

package org.title21.PeriodicReviewers_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.Documents_POM.DocumentRoutes_POM;

import freemarker.core.ReturnInstruction.Return;

public class PeriodicNotOwnedDocuments_POM extends PeriodicOwnedDocuments_POM {

	public WebDriver driver;
	public WebElement element;
	static Logger log = Logger.getLogger(DocumentRoutes_POM.class);
	
	public PeriodicNotOwnedDocuments_POM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//*[@id='DocPeriodicReviewDays']")
	WebElement periodicReviewsDaysTextBox;
	
	@FindBy(xpath="//a[contains(@href, 'Administration')]")
	 WebElement administrationlink;
	
	@FindBy(xpath="//a[contains(@href,'GetUserList')]")
	WebElement usersLink;
	
	@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div[2]/div[2]/div/div[3]/div/div/form/div/input")
	WebElement filterTextBox;
	
	@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div[2]/div[2]/div/div[3]/div/div/form/div/span[1]/button")
	WebElement goFilterButton;
	
	@FindBy(xpath="//*[@id='bootstrap-duallistbox-selected-list_dualListItemList[]']")
	WebElement selectedGroupsTextArea;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath="//a[contains(@href,'GetGroupList')]")
	WebElement groupLink;
	
	@FindBy(xpath="//a[text()='Documents']")
	WebElement updateGroupDocTab;
	
	@FindBy(xpath="//*[@id='tab3']/div[2]/div[1]/h5")
	WebElement docPermissionsPartTwo;
	
	@FindBy(xpath="//label[text()='Allow periodic review without viewing document']")
	WebElement allowPeriodicReviewWithoutViewingDocumentText;
	
	public WebElement allowPeriodicReviewWithoutViewingDocument_Text()
	{
		return allowPeriodicReviewWithoutViewingDocumentText;
	}

	public WebElement docPermissions_PartTwo()
	{
		return docPermissionsPartTwo;
	}
	public WebElement updateGroupDoc_Tab()
	{
		return updateGroupDocTab;
	}
	
	public WebElement group_Link()
	{
		return groupLink;
	}
	
	public WebElement cancel_Button()
	{
		return cancelButton;
	}
	
	public WebElement selectedGroups_TextArea()
	{
		return administrationlink;
	}
	
	public WebElement filterText()
	{
		return filterTextBox;
	}

	public WebElement goButton()
	{
		return goFilterButton;
	}
	
	public WebElement users_Link()
	{
		return usersLink;
	}
	
	public WebElement administrationLink()
	{
		 return administrationlink;
	}
	
	public WebElement periodicReviewsDays_TextBox()
	{
		return periodicReviewsDaysTextBox;
	}
	
	
	public void docPermissionItemsCheck(Boolean check)
	 {
	  if (!check && allowPeriodicReviewWithoutViewingDocument_Text().isSelected()) {
		  allowPeriodicReviewWithoutViewingDocument_Text().click();
	  }
	  else if (check && !allowPeriodicReviewWithoutViewingDocument_Text().isSelected()) {
		  allowPeriodicReviewWithoutViewingDocument_Text().click();
	  }
	 }
	
}


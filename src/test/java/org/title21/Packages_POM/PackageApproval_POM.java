package org.title21.Packages_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.Documents_POM.DocumentRoutes_POM;

public class PackageApproval_POM extends CreatingNewPackage_POM {

	public WebDriver driver;
	public WebElement element;
	static Logger log = Logger.getLogger(PackageApproval_POM.class);
	
	public PackageApproval_POM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//*[@id='collapse-0']//tr[1]/td[3]/div/a/span[1]")
	WebElement firstDocContextMenu;
	
	@FindBy(xpath="//a[text()='Attachments/Tasks']")
	WebElement attachmentsTasksTab;
	
	@FindBy(xpath="//*[@id='collapse-2']/div/div/div[1]/a")
	WebElement attachmentsAddNewLink;
	
	@FindBy(xpath="//a[contains(@href,'Approvals')]")
	WebElement approvalsTab;
	
	@FindBy(xpath="//a[contains(@href,'AddApproverModal')]")
	WebElement approverLink;
	
	@FindBy(xpath="//span[text()='Route For Approval']")
	WebElement packageRouteApproval;
	
	@FindBy(css=".t21-placeholder")
	WebElement approvalFilterResultTextBox;
	
	@FindBy(xpath="//button[@type='submit'][@tabindex='1']")
	WebElement approvalFilterResultGoButton;
	
	@FindBy(xpath="//tr[1]/td[3]/a")
	WebElement filteredPackage;
	
	@FindBy(xpath="//div[@id='set-4']//a[contains(@href,'Approval')]")
	WebElement docApprovalLink;
	
	@FindBy(xpath=".//*[@id='collapse1']/div/div[1]/div[1]/a/span")
	WebElement approveLink;
	
	@FindBy(xpath="//tr[1]/td[2]/a")
	WebElement searchedDoc;
	
	@FindBy(xpath="//a[contains(@href,'ApprovalsTab')]")
	WebElement packageApprovalsTab;
	
	public WebElement packageApprovalsTab()
	{
		return packageApprovalsTab;
	}
	
	public WebElement searched_Doc()
	{
		return searchedDoc;
	}
	
	public WebElement approveLink()
	{
		return approveLink;
	}
	
	public WebElement docApproval_Link()
	{
		return docApprovalLink;
	}
	
	public WebElement filtered_Package()
	{
		return filteredPackage;
	}
	
	public WebElement approvalFilterResultGo_Button()
	{
		return approvalFilterResultGoButton;
	}
	
	public WebElement approvalFilterResult_TextBox()
	{
		return approvalFilterResultTextBox;
	}
	
	public WebElement packageRouteApproval()
	{
		return packageRouteApproval;
	}
	
	public WebElement approver_Link()
	{
		return approverLink;
	}
	
	public WebElement approvals_Tab()
	{
		return approvalsTab;
	}
	
	public WebElement attachmentsAddNewLink()
	{
		return attachmentsAddNewLink;
	}
	
	public WebElement attachmentsTasks_Tab()
	{
		return attachmentsTasksTab;
	}
	
	public WebElement firstDoc_ContextMenu()
	{
		return firstDocContextMenu;
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
	
}


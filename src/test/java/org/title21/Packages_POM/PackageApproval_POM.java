package org.title21.Packages_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.Documents_POM.DocumentRoutes_POM;

public class PackageApproval_POM extends CreatingNewPackage_POM {

	public WebDriver driver;
	public WebElement element;
	DBConnection dbconnection = new DBConnection();
	DBQueries dbqueries = new DBQueries();
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
	
	@FindBy(xpath="//*[@id='t21-workarea']/div/div/div/div[2]/div/div[2]/div/div/form/div/input")
	WebElement approvalFilterResultTextBox;
	
	@FindBy(xpath="//*[@id='t21-workarea']/div/div/div/div[2]/div/div[2]/div/div/form/div/span[1]/button")
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
	
	@FindBy(xpath="//a[contains(@href,'Reject&DisplayId')]")
	WebElement docRejectLink;
	
	@FindBy(xpath="//*[@id='ApprovalsTab']/div/div/div[2]/div/div[2]/p")
	WebElement packageRejectedMsg;
	
	@FindBy(xpath="//*[@id='Comments']")
	WebElement commentsTextBox;
	
	@FindBy(xpath="//*[@id='t21-workarea']/div/div/div/div[2]/div[2]/div[2]/div/div/form/div/input")
	WebElement searchesFilterTextBox;
	
	@FindBy(xpath="//*[@id='t21-workarea']/div/div/div/div[2]/div[2]/div[2]/div/div/form/div/span[1]/button")
	WebElement searchesFilterGoButton;
	
	@FindBy(xpath="//*[@id='displaySel']/div[1]/div[3]/div/a/span[2]")
	WebElement searchesPackageContextMenu;
	
	@FindBy(xpath="//*[@id='ApprovalDocs']/div[1]/div/form/div/input")
	WebElement wizardApprovalFilterTextBox;
	
	@FindBy(xpath="//*[@id='ApprovalDocs']/div[1]/div/form/div/span[1]/button")
	WebElement wizardApprovalFilterGoButton;
	
	@FindBy(xpath="//a[contains(@href,'GeneralTab')]")
	WebElement generalTab;
	
	@FindBy(xpath="//*[@id='GeneralTab']/div[1]/div[2]/div[3]/div[2]/label")
	WebElement currentStapesStatus;
	
	@FindBy(css="#Dashboard>a>span")
	WebElement dashboard;
	
	public WebElement dashboard_Tab()
	{
		return dashboard;
	}
	
	public WebElement currentStapesStatus()
	{
		return currentStapesStatus;
	}
	
	public WebElement general_Tab()
	{
		return generalTab;
	}
	
	public WebElement wizardApprovalFilterGoButton()
	{
		return wizardApprovalFilterGoButton;
	}
	
	public WebElement wizardApprovalFilterTextBox()
	{
		return wizardApprovalFilterTextBox;
	}
	
	public WebElement searchesPackageContextMenu()
	{
		return searchesPackageContextMenu;
	}
	
	public WebElement searchesFilterGoButton()
	{
		return searchesFilterGoButton;
	}
	
	public WebElement searchesFilterTextBox()
	{
		return searchesFilterTextBox;
	}
	
	public WebElement comments_TextBox()
	{
		return commentsTextBox;
	}
	
	public WebElement packageRejectedMsg()
	{
		return packageRejectedMsg;
	}
	
	public WebElement docRejectLink()
	{
		return docRejectLink;
	}
	
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
	
	public boolean verifyPackageRejectedMsg()
	{
		String CreateNewPackageHeaderText = packageRejectedMsg.getText();
		
		if(CreateNewPackageHeaderText.equalsIgnoreCase("You have successfully rejected"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@SuppressWarnings("static-access")
	public void enableCIBMTR_LMS()
	{
		int LMSValue = dbconnection.getIntDBValue(dbqueries.DCOsValue, "LmsEnabled");
		
		if (LMSValue==0)
		{
			try {
				DBConnection.executeStoredProcedure(dbqueries.doNotForwardAttachedIndexCards);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("LMS enabled");
		}
	}
}


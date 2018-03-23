package org.title21.Documents_POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.title21.Documents_test.CheckInCheckOut_Test;
import org.title21.utility.BaseClass;

public class MyDocs_POM
{
	public WebDriver driver;
	public WebElement element;
	public String docID;
	static Logger log = Logger.getLogger(CheckInCheckOut_Test.class);

	public MyDocs_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//*[@id='NavMyDocs']/a/span")
	WebElement	mydocs;

	@FindBy(xpath="//a[contains(@href,'CheckedOutDocuments')]")
	WebElement	checkoutbyme;

	@FindBy(xpath="//input[@name='FilterValue'][@type='text']")
	WebElement	search;

	@FindBy(css=".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	WebElement	goButton;

	@FindBy(css=".t21-js-row-link.event-id>a")
	WebElement	firstDocument;

	@FindBy(xpath="//*[@id='displaySel']//a[@title='Context Menu']")
	WebElement	contextMenu;

	@FindBy(xpath=" //span[@class='grid-button-text'][text()='Check In']")
	WebElement	checkinContextMenu;

	@FindBy(xpath="//span[@class='grid-button-text'][text()='Check Out']")
	WebElement	checkoutContextMenu;

	@FindBy(xpath="//span[@class='grid-button-text'][text()='Undo Check Out']")
	WebElement	undocheckoutContextMenu;

	@FindBy(xpath="//span[@class='grid-button-text'][text()='Route For Approval']")
	WebElement	routeApporvalContextMenu;

	@FindBy(xpath="//input[@name='submitButton']")
	WebElement	checkinButton;

	@FindBy(xpath="//button[text()='Close']")
	WebElement	checkinCloseButton;

	@FindBy(id="CheckedOutTo")
	WebElement	checkoutPerson;
	
	@FindBy(id="NewCabinetSection")
	WebElement	sectiondrawer;

	@FindBy(xpath="//input[@name='submitButton']")
	WebElement	checkoutConfirmButton;

	@FindBy(xpath="//a[contains(@href,'AddRouteModal')]")
	WebElement	signatureRoute;

	@FindBy (xpath="//a[contains(@href,'AddApproverModal')]")
	WebElement approver;

	@FindBy(xpath="//a[contains(@href,'DocumentApprovalsTab')]")
	WebElement	documentApproval;

	@FindBy(xpath=".//*[@id='lock']/a[2]")
	WebElement	editModeON;

	@FindBy(xpath="//*[@id='default-modal']//select[@class='form-control t21-ajax-submit-select']")
	WebElement	routeName;

	@FindBy(xpath="//input[@class='btn t21-btn-primary t21-ajax-submit-button process-btn-click']")
	WebElement signatureroteAddButton;

	@FindBy(xpath="//a[contains(@href,'RejectedDocuments')]")
	WebElement rejectedByOthers;

	@FindBy(xpath="//select[@name='SelectedRole']")
	WebElement role;

	@FindBy(xpath="//select[@id='SelectedLocation']")
	WebElement addapproverlocation;

	@FindBy(xpath="//select[@name='SelectedMember']")
	WebElement addapprovername;

	@FindBy(xpath="//select[@name='SelectedSequence']")
	WebElement addapproversequence;

	@FindBy(xpath="//select[@name='SelectedAllottedDays']")
	WebElement addapproveralloteddays;

	@FindBy(xpath="//a[contains(@href,'TrainingTab')]")
	WebElement trainingtab;

	@FindBy(xpath="//a[contains(@href,'ChangeTrainingTypeModal')]")
	WebElement changetrainingtype;

	@FindBy(xpath="//a[@id='add-new-training-entities']")
	WebElement entities;

	@FindBy(xpath="//a[contains(@href,'CodesTab')]")
	WebElement codestab;

	@FindBy(xpath="//select[@id='CodeClass']")
	WebElement codeclass;

	@FindBy(xpath="//input[@name='submit']")
	WebElement undoyesbutton;

	@FindBy(css="#IncludeDocumentReviewers")
	WebElement documentapprovercheckbox;

	@FindBy(css="#IncludeAttachments")
	WebElement attachmentscheckbox;

	@FindBy(css="#IncludeTrainingItems")
	WebElement trainingitemscheckbox;

	@FindBy(css=".t21-js-dashboard-row-link.t21-desc-ellipsis-info>a")
	List<WebElement> recentViewedDocs;

	@FindBy(xpath = "//*[@id='collapse-2']//td[2][@class='wrapword-breakword']")
	List<WebElement> beforeCheckAttachment;
	
	@FindBy(xpath = "//*[@id='collapse-2']//td[2][@class='wrapword-breakword']")
	List<WebElement> afterCheckAttachment;
	
	@FindBy(xpath = "//*[@id='collapse-1']//li")
	List<WebElement> beforeCheckReviewer;
	
	@FindBy(xpath = "//*[@id='collapse-1']//li")
	List<WebElement> afterCheckReviewer;
	
	@FindBy(xpath = "//*[@id='collapse-3']//td[1][@class='min-column no-wrap']")
	List<WebElement> beforeCheckLinks;
	
	@FindBy(xpath = "//*[@id='collapse-3']//td[1][@class='min-column no-wrap']")
	List<WebElement> afterCheckLinks;
	
	@FindBy(xpath = "//*[@id='TrainingTab']//span[2][@class='entity-table-cell']")
	List<WebElement> beforeCheckEntities;
	
	@FindBy(xpath = "//*[@id='TrainingTab']//span[2][@class='entity-table-cell']")
	List<WebElement> afterCheckEntities;
	
	@FindBy(xpath = "//*[@id='DocumentApprovalsTab']//td[2]")
	List<WebElement> beforeCheckApprover;
	
	@FindBy(xpath = "//*[@id='DocumentApprovalsTab']//td[2]")
	List<WebElement> afterCheckApprover;
	
	@FindBy(xpath = "//*[@id='CodesTab']//td[1]")
	List<WebElement> beforeCheckCodes;
	
	@FindBy(xpath = "//*[@id='CodesTab']//td[1]")
	List<WebElement> afterCheckCodes;
	
	public WebElement getMyDocs()
	{
		return mydocs;
	}

	public WebElement getCheckOutByMe()
	{
		return checkoutbyme;
	}

	public WebElement getSearch()
	{
		return search;
	}

	public WebElement getGoButton()
	{
		return goButton;
	}

	public WebElement getFirstDocumentName()
	{
		return firstDocument;
	}

	public WebElement getContextMenu()
	{
		return contextMenu;
	}

	public WebElement getCheckinContextMenu()
	{
		return checkinContextMenu;
	}

	public WebElement getCheckoutContextMenu()
	{
		return checkoutContextMenu;
	}

	public WebElement getUndoCheckoutContextMenu()
	{
		return undocheckoutContextMenu;
	}

	public WebElement getCheckinButton()
	{
		return checkinButton;
	}

	public WebElement getCheckinCloseButton()
	{
		return checkinCloseButton;
	}

	public WebElement getCheckoutPerson()
	{
		return checkoutPerson;
	}

	public WebElement getCheckoutConfirmButton()
	{
		return checkoutConfirmButton;
	}

	public WebElement getSignatureRoute()
	{
		return signatureRoute;
	}

	public WebElement getApprover()
	{
		return approver;
	}

	public WebElement getDocumentApproval()
	{
		return documentApproval;
	}

	public WebElement getEditModeON()
	{
		return editModeON;
	}

	public WebElement getSignatureRouteAddButton()
	{		
		return signatureroteAddButton;			
	}

	public WebElement getRouteApporvalContext()
	{		
		return routeApporvalContextMenu;			
	}

	public WebElement rejectedByOthers()
	{		
		return rejectedByOthers;			
	}

	public Select getRouteName()
	{		
		Select selectObj=new Select(routeName);
		return selectObj;		
	}

	public Select selectRole()
	{		
		Select selectObj=new Select(role);
		return selectObj;		
	}

	public Select addApproverLocation()
	{		
		Select selectObj=new Select(addapproverlocation);
		return selectObj;		
	}

	public Select addApproverName()
	{		
		Select selectObj=new Select(addapprovername);
		return selectObj;		
	}

	public Select addApproverSequence()
	{		
		Select selectObj=new Select(addapproversequence);
		return selectObj;		
	}

	public Select addApproverAllotedDays()
	{		
		Select selectObj=new Select(addapproveralloteddays);
		return selectObj;		
	}
	
	public Select selectSectionDrawer()
	{		
		Select selectObj=new Select(sectiondrawer);
		return selectObj;		
	}

	public WebElement trainingTab()
	{
		return trainingtab;
	}

	public WebElement changeTrainingTab()
	{
		return changetrainingtype;
	}

	public WebElement editEntities()
	{
		return entities;
	}

	public WebElement codesTab()
	{
		return codestab;
	}

	public WebElement undoCheckoutYesButton()
	{
		return undoyesbutton;
	}

	public WebElement documentApproverCheckbox()
	{
		return documentapprovercheckbox;
	}

	public WebElement attachmentCheckbox()
	{
		return attachmentscheckbox;
	}

	public WebElement trainingItemsCheckbox()
	{
		return trainingitemscheckbox;
	}

	public List<WebElement> getAllRecentViewedDocs()
	{
		return recentViewedDocs;
	}

	public void codeCategory(String Catergory)
	{
		WebElement element = driver.findElement(By.xpath("//span[text()[contains(.,'"+Catergory+"')]]"));
		element.click();
	}

	public void codeName(String CodeName)
	{
		WebElement element = driver.findElement(By.xpath("//a[text()[contains(.,'"+CodeName+"')]]"));
		element.click();
	}

	public Select selectCodeClass()
	{		
		Select selectObj=new Select(codeclass);
		return selectObj;		
	}

	public boolean verifyNoAttachmentPresent()
	{
		element=driver.findElement(By.xpath("//div[@class='alert t21-alert-info t21-no-margin']/p"));
		String errorMessage = element.getText();
		boolean isAttachmentPresent=false;

		if(errorMessage.contains("No attachments"))
		{
			isAttachmentPresent=false;
		}else{
			isAttachmentPresent=true;
			log.error("Attachment is Present");
		}	
		return isAttachmentPresent;
	}

	public boolean verifyNoApproverPresent()
	{
		element=driver.findElement(By.xpath("//*[text()[contains(.,'approvers')]]"));
		String errorMessage = element.getText();
		boolean isApproverPresent=false;

		if(errorMessage.contains("No required approvers"))
		{
			isApproverPresent=false;
		}else{
			isApproverPresent=true;
			log.error("Approver is Present");
		}	
		return isApproverPresent;
	}

	public boolean verifyNoTrainingEntitiesPresent()
	{
		element=driver.findElement(By.xpath("//*[@id='TrainingTab']//div[@class='alert t21-alert-info']"));
		String errorMessage = element.getText();
		boolean isTrainingEntitesPresent=false;

		if(errorMessage.contains("Entities will be selected based on read/write access from cabinet."))
		{
			isTrainingEntitesPresent=false;
		}else{
			isTrainingEntitesPresent=true;
			log.error("Approver is Present");
		}	
		return isTrainingEntitesPresent;
	}

	public boolean firstDocumentID(){

		element=getFirstDocumentName();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;

		if(errorMessage.contains(docID))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Document is not present.");
		}	
		return isValidationMessagePresent;
	}

	public void selectTrainingType(int index)
	{
		List<WebElement> list = driver.findElements(By.xpath("//input[@id='TrainingType']"));
		list.get(index).click();
	}

	public void documentApproverCheck(Boolean check)
	{
		if (!check && documentApproverCheckbox().isSelected()) {
			documentApproverCheckbox().click();
		}
		else if (check && !documentApproverCheckbox().isSelected()) {
			documentApproverCheckbox().click();
		}
	}
	
	public void attachmentCheck(Boolean check)
	{
		if (!check && attachmentCheckbox().isSelected()) {
			attachmentCheckbox().click();
		}
		else if (check && !attachmentCheckbox().isSelected()) {
			attachmentCheckbox().click();
		}
	}
	
	public void trainingItemsCheck(Boolean check)
	{
		if (!check && trainingItemsCheckbox().isSelected()) {
			trainingItemsCheckbox().click();
		}
		else if (check && !trainingItemsCheckbox().isSelected()) {
			trainingItemsCheckbox().click();
		}
	}

	public void selectEntitiesSubject(int index)
	{
		List<WebElement> list = driver.findElements(By.xpath("//input[@id='EntitiesFromSelection']"));
		list.get(index).click();
	}
	
	public WebElement searchDocument(String documentName)
	{
		driver.findElement(By.xpath("//span[text()[contains(.,'Searches')]]")).click();
		BaseClass.sleep(2);
		driver.findElement(By.xpath("//*[@id='editCell'][text()='Search on Document Number']")).click();
		BaseClass.sleep(2);
		driver.findElement(By.xpath("//input[@id='param-0']")).sendKeys(documentName);
		BaseClass.sleep(2);
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		BaseClass.sleep(2);
		JavascriptExecutor js=(JavascriptExecutor)driver;	
		for (int i=0;i<2;i++){
			js.executeScript("window.scrollBy(0,-250)");
		}
		BaseClass.sleep(2);
		WebElement document = driver.findElement(By.xpath("//*[text()[contains(.,'"+documentName+"')]]"));
		return document;
	}
	
	public boolean compareAttachment()
	{
		boolean isAttachmentMatched;

		try
		{
			Assert.assertEquals(beforeCheckAttachment(), afterCheckAttachment());
			isAttachmentMatched=true;
			
		} catch (Throwable e)
		{
			Assert.assertNotEquals(beforeCheckAttachment(), afterCheckAttachment());
			isAttachmentMatched=false;
		}
		return isAttachmentMatched;
	}
	
	public boolean compareReviewer()
	{
		boolean isAttachmentMatched;
		
		try
		{
			Assert.assertEquals(beforeCheckReviewer(), afterCheckReviewer());
			isAttachmentMatched=true;
			
		} catch (Throwable e)
		{
			Assert.assertNotEquals(beforeCheckReviewer(), afterCheckReviewer());
			isAttachmentMatched=false;
		}
		return isAttachmentMatched;
	}
	
	
	public List<WebElement> beforeCheckAttachment()
	{
		return beforeCheckAttachment;
	}
	public List<WebElement> afterCheckAttachment()
	{
		return afterCheckAttachment;
	}
	public List<WebElement> beforeCheckReviewer()
	{
		return beforeCheckReviewer;
	}
	public List<WebElement> afterCheckReviewer()
	{
		return afterCheckReviewer;
	}
	public List<WebElement> beforeCheckLinks()
	{
		return beforeCheckLinks;
	}
	public List<WebElement> afterCheckLinks()
	{
		return afterCheckLinks;
	}
	public List<WebElement> beforeCheckEntities()
	{
		return beforeCheckEntities;
	}
	public List<WebElement> afterCheckEntities()
	{
		return afterCheckEntities;
	}
	public List<WebElement> beforeCheckApprover()
	{
		return beforeCheckApprover;
	}
	public List<WebElement> afterCheckApprover()
	{
		return afterCheckApprover;
	}
	public List<WebElement> beforeCheckCodes()
	{
		return beforeCheckCodes;
	}
	public List<WebElement> afterCheckCodes()
	{
		return afterCheckCodes;
	}
	
	
	public void clickCreatedDocFromRecentViewed(String docID)
	{
		List<WebElement> list = getAllRecentViewedDocs();
		int numberOfEle = list.size();
		int i;
		for(i=0; i<numberOfEle; i++)
		{
			String str = list.get(i).getText();
			if(str.contains(docID))
			{
				int j = i+1;
				WebElement element = driver.findElement(By.xpath(".//*[@id='t21-workarea']/div/div/div[1]/div[1]/div[2]/div[3]/table/tbody/tr["+j+"]/td[1]/a"));

				element.click();
			}
		}
	}	
}
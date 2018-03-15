package org.title21.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.title21.utility.BaseClass;

public class WizardPage_POM extends BaseClass{
	public BaseClass baseClassObj=new BaseClass();
	public WebDriver driver;
	WebElement element;
	
	public WizardPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".dropdown-toggle.t21-nav-bar-dropdown")
	WebElement administratordropdown;
	
	@FindBy(xpath =".//*[@id='Settings']/a")
	WebElement settinglink;
	
	@FindBy(xpath =".//*[@id='OpenWizardOnStartUp']")
	WebElement wizardcheckbox;
	
	@FindBy(css =".modal-title")
	WebElement modeltext;
	
	@FindBy(xpath =".//*[@id='t21-workarea']/div/div/div[2]/div/div/div[2]/div/h3[1]")
	WebElement trainingtextonmodel;
	
	@FindBy(css =".t21-btn-primary.btn-lg.btn.t21-top-split")
	WebElement starttrainingnowbutton;
	
	@FindBy(xpath =".//*[@id='t21-workarea']/div/div/div[2]/div/div/div[2]/div/h3[2]")
	WebElement approveltextmodel;
	
	@FindBy(xpath =".//*[@id='t21-workarea']/div/div/div[2]/div/div/div[2]/div/h3[3]")
	WebElement reviewingtextmodel;
	
	@FindBy(xpath =".//*[@id='t21-workarea']/div/div/div[2]/div/div/div[2]/div/a[3]")
	WebElement reviewingbutton;
	
	@FindBy(xpath =".//*[@id='Wizard']/a/span[1]")
	WebElement wizardbutton;
	
	@FindBy(xpath =".//*[@id='Approval']/a")
	WebElement approvalbutton;
	
	@FindBy(xpath =".//*[@id='ApprovalDocs']/div[1]/div/form/div/input")
	WebElement approvalFilterText;
	
	@FindBy(xpath =".//*[@id='ApprovalDocs']/div[1]/div/form/div/span[1]/button")
	WebElement approvalGoButton;
	
	@FindBy(xpath =".//*[@id='collapseDocuments']/div/table/tbody/tr[1]/td[3]/a")
	WebElement approvalFirstDoc;
	
	@FindBy(xpath =".//*[@id='tab-strip']/ul/li[2]/a[1]")
	WebElement firstDocTab;
	
	@FindBy(xpath =".//*[@id='Tutorial_step2']/a[1]")
	WebElement rejectButton;
	
	@FindBy(id ="Pin")
	WebElement pinText;
	
	@FindBy(id ="Comments")
	WebElement commentsText;
	
	@FindBy(xpath =".//*[@id='default-modal']/div/form/div/div[3]/div/input")
	WebElement rejectConfirmButton;
	
	@FindBy(xpath =".//*[@id='t21-workarea']/div/div/div[1]/div/div[3]/div/p")
	WebElement rejectMessage;
	
	
	public WebElement getWizardButton()
	{
		return wizardbutton;
	}
	
	public WebElement getApporvalButton()
	{
		return approvalbutton;
	}
	
	public WebElement getApprovalFilterText()
	{
		return approvalFilterText;
	}
	
	public WebElement getApprovalGoButton()
	{
		return approvalGoButton;
	}
	
	public WebElement getApprovalFirstDoc()
	{
		return approvalFirstDoc;
	}
	
	public WebElement getFirstDocTab()
	{
		return firstDocTab;
	}
	
	public WebElement getRejectButton()
	{
		return rejectButton;
	}
	
	public WebElement getPinText()
	{
		return pinText;
	}
	
	public WebElement getCommentText()
	{
		return commentsText;
	}
	
	public WebElement rejectConfirmButton()
	{
		return rejectConfirmButton;
	}
	
	public WebElement rejectMessage()
	{
		return rejectMessage;
	}
	
	public WebElement verifWizard(WebDriver driver, String vrifytrxt) {
		List<WebElement> list = driver
				.findElements(By.xpath(".//*[@id='t21-workarea']/div/div/div[2]/div/div/div[2]/div/h3"));
		int size = list.size();
		//element = driver.findElement(modeltext);
		String text = modeltext.getText();
		System.out.println(text);
		if (text.equals("Title21 Wizard")) {
			

			List<WebElement> button = driver
					.findElements(By.xpath(".//*[@id='t21-workarea']/div/div/div[2]/div/div/div[2]/div/a"));
			int bsize = button.size();
			for (int i = 0; i < size; i++) {
				String veifytext = list.get(i).getText();
				System.out.println(veifytext);

				if (veifytext.equals(vrifytrxt)) {

					for (int j = i; j < bsize; j++) {

						button.get(j).click();
						System.out.println(j);

						break;
					}
				}

			}

		} else {
			administratordropdown.click();
		}

		return element;
	}
	
	public String getFirstDocText()
	{
		String doctext = getApprovalFirstDoc().getText();
		return doctext;
	}
	
	public String getRejectMessageText()
	{
		String doctext = rejectMessage().getText();
		return doctext;
	}

}

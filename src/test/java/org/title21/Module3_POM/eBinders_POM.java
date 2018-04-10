package org.title21.Module3_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.utility.BaseClass;

public class eBinders_POM
{
	public WebDriver driver;

	public eBinders_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='NavOrganizers']")
	WebElement ebinders;

	@FindBy(xpath="//a[contains(@href,'GetEbinderList')]")
	WebElement adminEbinders;

	@FindBy(xpath="//a[contains(@href,'AddeBinder')]")
	WebElement addEbinders;

	@FindBy(xpath="//a[contains(@href,'AddRootFolder')]")
	WebElement addRootFolder;

	@FindBy(css="#EbinderName")
	WebElement ebinderName;

	@FindBy(xpath="//select[@name='Group']")
	WebElement ebinderGroup;

	@FindBy(xpath="//button[text()='Add']")
	WebElement addButton;

	@FindBy(xpath="//button[text()='Close']")
	WebElement closeButton;

	@FindBy(id="OrganizerName")
	WebElement rootFolderName;

	@FindBy(id="GridLocation")
	WebElement location;
	
	@FindBy(id="CriteriaName")
	WebElement queryext;
	
	@FindBy(xpath="//button[text()='Verify']")
	WebElement verifyButton;
	
	@FindBy(css=".fa.fa-trash-o.action-items")
	WebElement deleteButton;
	
	@FindBy(xpath="//input[@value='Yes']")
	WebElement yesButton;
	
	@FindBy(xpath="//div[@class='t21-md-break t21-sm-break']")
	WebElement tablebody;
	
	public WebElement getEbinders()
	{
		return ebinders;			
	}

	public WebElement adminEbinders()
	{
		return adminEbinders;			
	}

	public WebElement addEbinders()
	{
		return addEbinders;		
	}

	public WebElement addRootFolder()
	{
		return addRootFolder;		
	}

	public WebElement ebinderNameText()
	{
		return ebinderName;		
	}

	public Select ebinderGroup()
	{
		Select selectobj = new Select(ebinderGroup);
		return selectobj;
	}

	public WebElement addButton()
	{
		return addButton;		
	}

	public WebElement closeButton()
	{
		return closeButton;		
	}

	public WebElement rootFolderName()
	{
		return rootFolderName;		
	}

	public Select location()
	{
		Select selectobj = new Select(location);
		return selectobj;		
	}
	
	public WebElement selectQueryText()
	{
		return queryext;
	}
	
	public WebElement verifyButton()
	{
		return verifyButton;
	}
	
	public WebElement deleteButton()
	{
		return deleteButton;
	}
	
	public WebElement yesButton()
	{
		return yesButton;
	}
	
	public WebElement tableBodyLayout()
	{
		return tablebody;
	}
	
	public void expandAllEbinders()
	{
		driver.findElement(By.xpath("//span[text()[contains(.,'Blood Center')]]")).click();
		BaseClass.sleep(1);
		driver.findElement(By.xpath("//span[text()[contains(.,'Standard Operating Procedures')]]")).click();
		BaseClass.sleep(1);
		driver.findElement(By.xpath("//span[text()='test']")).click();
		BaseClass.sleep(1);
		driver.findElement(By.xpath("//span[text()='Draft']")).click();
		BaseClass.sleep(1);
		driver.findElement(By.xpath("//span[text()='New test']")).click();
		BaseClass.sleep(1);
	}

	public void expandEbinder(String ebinderName)
	{
		driver.findElement(By.xpath("//span[text()='"+ebinderName+"']")).click();
		BaseClass.sleep(1);
	}

	public void selectEbinder(String ebinderName)
	{
		driver.findElement(By.xpath("//a[text()='"+ebinderName+"']")).click();
		BaseClass.sleep(1);
	}

	public void checkUseForGroup(String groupName)
	{
		List<WebElement> group = driver.findElements(By.xpath("//*[@class='t21-table-hover-row']/td[1]"));
		int sizeoflist = group.size();
		for (int i = 0; i < sizeoflist; i++)
		{
			String element = group.get(i).getText();
			if(element.equalsIgnoreCase(groupName))
			{
				int j=i+1;
				driver.findElement(By.xpath("//*[@id='t21-workarea']/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr["+j+"]/td[3]/input")).click();
			}
		}
	}
	
	public void setFavourites(String docID)
	{
		driver.findElement(By.xpath("//input[@name='FilterValue']")).sendKeys(docID);
		BaseClass.sleep(1);
		driver.findElement(By.xpath("//button[text()[contains(.,'Go')]]")).click();
		BaseClass.sleep(1);
		driver.findElement(By.xpath("//span[@class='fa fa-star-o fav-star-open']")).click();
		BaseClass.sleep(1);
	}
	
	public void unsetFavorites()
	{

		driver.findElement(By.xpath("//span[@class='fa fa-star fav-star']")).click();
		BaseClass.sleep(1);
	}
	
	public boolean verifyDocumentPresentInFavorites(String docID)
	{
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='t21-js-dashboard-row-link t21-desc-ellipsis-info']/a"));
		
		boolean isDocumentPresent=false;

		int sizeoflist = list.size();
		for (int i = 0; i < sizeoflist; i++)
		{
			String element = list.get(i).getText();
			if(element.startsWith(docID))
			{
				isDocumentPresent=true;
				
			}
		}
		return isDocumentPresent;
	}
}

package org.title21.Module3_POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.utility.BaseClass;
import org.title21.validation.entities.ErrorMessages;

public class Reports_POM
{
	public WebDriver driver;
	static Logger log = Logger.getLogger(Reports_POM.class);

	public Reports_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='NavReports']")
	WebElement reports;

	@FindBy(xpath="//a[contains(@href,'GetReport')]")
	WebElement adminReports;

	@FindBy(xpath="//a[contains(@href,'AddReport')]")
	WebElement addReports;

	@FindBy(xpath="//button[text()='Add']")
	WebElement addButton;

	@FindBy(xpath="//button[text()='Close']")
	WebElement closeButton;

	@FindBy(xpath="//span[text()[contains(.,'Report name')]]")
	WebElement reportnamevalidation;

	@FindBy(xpath="//span[text()[contains(.,'select report')]]")
	WebElement selectreportvalidation;

	@FindBy(xpath="//span[text()[contains(.,'Category is required')]]")
	WebElement categoryrequiredvalidation;
	
	@FindBy(xpath="//span[text()[contains(.,'design permission')]]")
	WebElement designpermissionvalidation;
	
	@FindBy(id="ReportItem_ReportName")
	WebElement reportName;
	
	@FindBy(id="ReportFile")
	WebElement browse;
	
	@FindBy(id="ReportItem_Category")
	WebElement category;
	
	@FindBy(xpath="//a[text()[contains(.,'Permissions')]]")
	WebElement permissiontab;
	
	@FindBy(xpath="//*[@class='t21-table-hover-row']/td[1]")
	List<WebElement> groups;

	public WebElement reports()
	{
		return reports;
	}

	public WebElement adminReports()
	{
		return adminReports;
	}
	
	public WebElement addReports()
	{
		return addReports;
	}

	public WebElement addButton()
	{
		return addButton;		
	}

	public WebElement closeButton()
	{
		return closeButton;		
	}

	public WebElement reportNameValidation()
	{
		return reportnamevalidation;		
	}

	public WebElement selectReportValidation()
	{
		return selectreportvalidation;		
	}

	public WebElement categoryRequiredValidation()
	{
		return categoryrequiredvalidation;		
	}
	
	public WebElement designPermissionValidation()
	{
		return designpermissionvalidation;		
	}
	
	public WebElement reportName()
	{
		return reportName;		
	}
	
	public WebElement browse()
	{
		return browse;		
	}
	
	public WebElement permissionTab()
	{
		return permissiontab;		
	}
	
	public List<WebElement> allGroupsName()
	{
		return groups;		
	}
	
	public Select category()
	{
		Select selectobj = new Select(category);
		return selectobj;		
	}

	public boolean verifyReportNameValidationMessage(){

		WebElement element=reportNameValidation();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.equalsIgnoreCase(ErrorMessages.ReportNameValidation))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for Report Name field is not displayed.");
		}	
		return isValidationMessagePresent;
	}
	
	public boolean verifySelectFileValidationMessage(){

		WebElement element=selectReportValidation();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.equalsIgnoreCase(ErrorMessages.SelectReportValidation))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for Select File field is not displayed.");
		}	
		return isValidationMessagePresent;
	}
	
	public boolean verifyCategoryReportValidationMessage(){

		WebElement element=categoryRequiredValidation();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.equalsIgnoreCase(ErrorMessages.CategoryRequiredValidation))
		{
			System.out.println(errorMessage);
			isValidationMessagePresent=true;
		}else{
			System.out.println(errorMessage);
			log.error("Validation message for Category field is not displayed.");
		}	
		return isValidationMessagePresent;
	}
	
	public boolean verifyDesignPermissionValidationMessage(){

		WebElement element=designPermissionValidation();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.equalsIgnoreCase(ErrorMessages.DesignPermissionValidation))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for Design Permission is not displayed.");
		}	
		return isValidationMessagePresent;
	}
	
	public void checkUseDesignForGroup(String name)
	{
		List<WebElement> list = allGroupsName();
		int numberOfEle = list.size();
		int i;
		for(i=0; i<numberOfEle; i++)
		{
			String str = list.get(i).getText();
			if(str.contains(name))
			{
				int j = i+1;
				WebElement element1 = driver.findElement(By.xpath("//*[@id='tab2']/div/div[2]/table/tbody/tr["+j+"]/td[3]/input"));
				element1.click();
				BaseClass.sleep(2);
				WebElement element2 = driver.findElement(By.xpath("//*[@id='tab2']/div/div[2]/table/tbody/tr["+j+"]/td[4]/input"));
				element2.click();
			}
		}
	}
	
	public void checkUseForGroup(String name)
	{
		List<WebElement> list = allGroupsName();
		int numberOfEle = list.size();
		int i;
		for(i=0; i<numberOfEle; i++)
		{
			String str = list.get(i).getText();
			if(str.contains(name))
			{
				int j = i+1;
				WebElement element = driver.findElement(By.xpath("//*[@id='tab2']/div/div[2]/table/tbody/tr["+j+"]/td[4]/input"));
				element.click();
				BaseClass.sleep(2);
			}
		}
	}
}

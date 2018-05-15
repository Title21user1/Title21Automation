
package org.title21.AdminModule_POM;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reports_POM 
{	protected WebDriver driver;
	protected WebElement element;
	
	public Reports_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="#NavReports>a>span")
	WebElement reportslink;//=By.cssSelector("#NavReports>a>span");
	
	@FindBy(css=".t21-js-tutorial-info")
	WebElement reporttitle;//=By.cssSelector(".t21-js-tutorial-info");
	
	@FindAll({@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div/div[2]/div[3]/table/tbody/tr/td/a")})
	public List<WebElement> reportlinks;//=By.xpath(".//*[@id='t21-workarea']/div/div/div/div[2]/div[3]/table/tbody/tr/td/a");
	
	
	public WebElement reportsLink(WebDriver driver)
	{
		//element=driver.findElement(reportslink);
		return reportslink;
	}
	public WebElement reportTitle()
	{
		element= reporttitle;
		String title = element.getText();
		if(title.equals("Reports "))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		return element;
	}
	public WebElement reportLinks(WebDriver driver)
	{
		List<WebElement> links = (reportlinks);
		int linksize = links.size();
		for(int i=0;i<linksize;i++)
		{
			String linkslist = links.get(i).getText();
			System.out.println(linkslist);
			
		}
		return element;
		
	}
}

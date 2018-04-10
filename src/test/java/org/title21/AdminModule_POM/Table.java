package org.title21.AdminModule_POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.title21.utility.BaseClass;
import org.title21.validation.entities.ErrorMessages;

public class Table extends BaseClass
{
	public BaseClass baseClassObj=new BaseClass();
	public WebDriver driver;
	public WebElement element;
		
	@FindBy(xpath="//ancestor::table")
	WebElement table;
	
	//@FindAll({@FindBy(xpath="//tr")})
	//List<WebElement> tableRows;
		
	@FindBy(xpath="//*[contains(@class,'t21-js-clickable-rows')]/tr")
	List<WebElement> tableRows; 
		
	@FindBy(tagName = "thead")
	WebElement tableHeader;	
	
	@FindBy(xpath="//span[contains(@class,'pagination-label') and contains(text(),'Previous')]")
	WebElement previous;
	
	@FindBy(xpath="//span[contains(@class,'pagination-label') and contains(text(),'Next')]")
	WebElement next;
	
	public Table(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public WebElement getTable()
	{
		return table;
	}
	
	public List<WebElement> gettableRows(){		
		return table.findElements( By.xpath("//tr"));
	}

	public List<WebElement> gettableCells(){	
		List<WebElement> cells = null;
		for(WebElement row : tableRows) {
		    cells = row.findElements(By.xpath("//td"));
		  }
		return cells;
	}
	
	/*
	 *  
	 */
	
	public List<WebElement> getColumnData(int columnNumber){	
		List<WebElement> cells = null;
		for(WebElement row : tableRows) {
		    cells = row.findElements(By.xpath("//td"+"["+columnNumber+"]"));
		  }
		return cells;
	}
		
	
	/*
	 * Following function will find tablecells only in given column.
	 * @param columnNumber
	 */
	
	public List<WebElement> gettableCells(int columnNumber){	
		List<WebElement> cells = null;
		for(WebElement row : tableRows) {
		    cells = row.findElements(By.xpath("//td["+columnNumber+"]")); 
		  }
		return cells;
	}
	//for doc
	public List<WebElement> getDocumentApprovalstableCells(int columnNumber){	
		List<WebElement> cells = null;
		for(WebElement row : tableRows) {
		    cells = row.findElements(By.xpath("//div[@id='DocumentApprovalsTab']//td["+columnNumber+"]")); 
		  }
		return cells;
	}
	
	public List<WebElement> getcollapseDocumentstableCells(int columnNumber){	
		List<WebElement> cells = null;
		for(WebElement row : tableRows) {
		    cells = row.findElements(By.xpath("//div[@id='collapseDocuments']//td["+columnNumber+"]")); 
		  }
		return cells;
	}
	
	public List<WebElement> getTrainingItemDoc(int columnNumber){	
		List<WebElement> cells = null;
		for(WebElement row : tableRows) {
		    cells = row.findElements(By.xpath("//*[@id='TrainingWizard']//td["+columnNumber+"]")); 
		  }
		return cells;
	}
	
	public List<WebElement> getTrainingItemCells(int columnNumber){	
		List<WebElement> cells = null;
		for(WebElement row : tableRows) {
		    cells = row.findElements(By.xpath("//div[@data-t21-ajax-id='training-item-list']//td["+columnNumber+"]")); 
		  }
		return cells;
	}
	
	public List<WebElement> getTrainingCompletedItemCell(int columnNumber){	
		List<WebElement> cells = null;
		for(WebElement row : tableRows) {
		    cells = row.findElements(By.xpath("//td[2]")); 
		  }
		return cells;
	}
	public List<WebElement> getCodeavabilityItemCell(int columnNumber){	
		List<WebElement> cells = null;
		for(WebElement row : tableRows) {
		    cells = row.findElements(By.xpath("//div[@class='t21-max-height-200']//td["+columnNumber+"]")); 
		  }
		return cells;
	}
	public WebElement getDeleteIcon(WebElement tableRow){
		
		WebElement rowToDeleteElement=tableRow.findElement(By.xpath("//span[@title='Remove Group']"));
		return rowToDeleteElement;
	}
	
	public WebElement getTableHeader()
	{
		return tableHeader;
	}
	
	public List<WebElement> getColumnHeadings()
	{		
		List<WebElement> columnHeadings = 
				tableHeader.findElements(By.xpath("//tr/th/a"));
		
		return columnHeadings;
	}
	
	public int getNumberOfRows() {
		return tableRows.size();
	}
		
	
	public int getNumberOfVisibleRows() {
		int i = 0;
		for (WebElement row : tableRows) {
			if (row.isDisplayed()) {
				i++;
			}
		}
		return i-1;
	}
		
}



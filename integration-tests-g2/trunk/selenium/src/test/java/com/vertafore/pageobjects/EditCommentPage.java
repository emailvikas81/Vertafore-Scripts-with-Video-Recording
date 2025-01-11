package com.vertafore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;

public class EditCommentPage {
	private final WebDriver driver;

	// Comment Date
	@FindBy(how = How.NAME, using = "commentUpdateDate")
	private WebElement updateCommentDateTextBox;

	// Comment Category
	@FindBy(how = How.NAME, using = "category")
	private WebElement updateCommentCategoryDropDown;

	// Start Date
	@FindBy(how = How.NAME, using = "searchStartDate")
	private WebElement searchStartDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "searchEndDate")
	private WebElement searchEndDateTextBox;

	// Context Type
	@FindBy(how = How.NAME, using = "cntxtTypeCd")
	private WebElement contextTypeDropDown;

	// Comment
	@FindBy(how = How.NAME, using = "comment")
	private WebElement updateCommentTextbox;

	// save option
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel option
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Return Button
	@FindBy(how = How.LINK_TEXT, using = "Return")
	private WebElement returnButton;

	// Search Button
	@FindBy(how = How.LINK_TEXT, using = "Search")
	private WebElement searchButton;

	// Clear Button
	@FindBy(how = How.LINK_TEXT, using = "Clear Fields")
	private WebElement clearButton;

	public EditCommentPage(WebDriver driver) {
		this.driver = driver;
	}

	public int locateCommentToEdit(String commentToBeEdited) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		int rowNo = global.searchInTable(driver,
				"//*[@id='ConfigureCommentForm']/table[2]/tbody/tr", 6,
				commentToBeEdited);
		rowNo = rowNo - 1;
		final WebElement moveOverObject = driver.findElement(By
				.xpath("//div[@id='KF_ITEM_" + rowNo + "']/img"));
		G2_Common.navigateToMenu(driver, moveOverObject, "Edit");
		return rowNo;
	}

	public void editComment(String editCommentDate, String editCommentCategory,
			String editCommentDescription) {

		G2_Common.updateField(driver, this.updateCommentDateTextBox,
				editCommentDate);

		this.updateCommentCategoryDropDown.sendKeys(editCommentCategory);
		G2_Common.updateField(driver, this.updateCommentTextbox,
				editCommentDescription);
		this.saveButton.click();

	}

	public void returnvalidate(){
		this.returnButton.click();
	}
	
	public void searchComment(String searchStartDate, String searchEndDate,
			String commentsCategory, String contextType) {

		G2_Common.updateField(driver, this.searchStartDateTextBox,
				searchStartDate);
		G2_Common.updateField(driver, this.searchEndDateTextBox, searchEndDate);
		this.updateCommentCategoryDropDown.sendKeys(commentsCategory);
		this.contextTypeDropDown.sendKeys(contextType);
		this.searchButton.click();
	}
	/*
	 * public int searchInTable(WebDriver driver, String tableXpath, int colNo,
	 * String searchString) { int iRowNum, iColNum, Match = 0; WebElement
	 * element = driver.findElement(By.xpath(tableXpath)); List<WebElement>
	 * rowCollection = element.findElements(By .xpath(tableXpath)); //
	 * "# of rows in table: " + rowCollection.size() // Here iRowNum and
	 * iColNum, to indicate Row and Column // numbers. It may or may not be
	 * required in real-time Test Cases. iRowNum = 1; for (WebElement rowElement
	 * : rowCollection) {
	 * 
	 * List<WebElement> colCollection = rowElement.findElements(By
	 * .xpath("td")); iColNum = 1; for (WebElement colElement : colCollection) {
	 * if (iColNum == colNo) { if (searchString != "" && searchString != null &&
	 * iColNum > 1) { // 1st 2 column doesn't contain data if
	 * (colElement.getText().trim() .equals(searchString.trim())) {
	 * G2_Common.APPLICATION_LOGS .info("Table Validation: value found." +
	 * searchString); Match = 1; return iRowNum; } } } iColNum = iColNum + 1; }
	 * iRowNum = iRowNum + 1; }
	 * 
	 * if (Match != 1) { G2_Common.APPLICATION_LOGS
	 * .error("Table Validation: value not found : " + searchString); } return
	 * -1; }
	 */
}

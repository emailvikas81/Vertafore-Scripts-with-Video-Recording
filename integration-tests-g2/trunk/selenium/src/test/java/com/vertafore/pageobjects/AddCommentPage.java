package com.vertafore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.Global_Common;

public class AddCommentPage {
	private final WebDriver driver;

	// Comment Date
	@FindBy(how = How.NAME, using = "commentUpdateDate")
	private WebElement commentDateTextbox;

	// Heightened Supervision Comment Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement commentDateTextboxHS;

	// Comment Category
	@FindBy(how = How.NAME, using = "category")
	private WebElement commentCategoryDropDown;

	// Context Type
	@FindBy(how = How.XPATH, using = "//form[@id='ConfigureCommentForm']/div[3]/div[2]/table/tbody/tr[2]/td[2]")
	private WebElement contextTypeText;

	// Context Description
	@FindBy(how = How.XPATH, using = "//form[@id='ConfigureCommentForm']/div[3]/div[2]/table/tbody/tr[2]/td[4]")
	private WebElement contextTypeDescriptionText;

	// Comment
	@FindBy(how = How.NAME, using = "comment")
	private WebElement commentTextBox;

	// Heightened Supervision Comment
	@FindBy(how = How.NAME, using = "cmntTxt")
	private WebElement commentTextBoxHS;

	// save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Data missing Error
	@FindBy(how = How.ID, using = "valerrors")
	private WebElement dataMissingError;

	// Data Missing Error Exists
	@FindBy(how = How.ID, using = "valerrors")
	private List<WebElement> dataMissingErrorExists;

	public AddCommentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addComment(String addCommentDate, String addCommentCategory,
			String addCommentDescription) {

		this.commentDateTextbox.sendKeys(addCommentDate);
		this.commentCategoryDropDown.sendKeys(addCommentCategory);
		this.commentTextBox.sendKeys(addCommentDescription);
		this.saveButton.click();

	}

	public void addCommentHS(String testDataPrefix, String contextType) {

		String addCommentDate = Global_Common
				.getEnvironmentProperty(testDataPrefix + "addCommentDate");
		String addCommentDescription = Global_Common
				.getEnvironmentProperty(testDataPrefix + "addComment");

		this.commentDateTextboxHS.sendKeys(addCommentDate);
		this.commentTextBoxHS.sendKeys(addCommentDescription);
		this.saveButton.click();
	}

}

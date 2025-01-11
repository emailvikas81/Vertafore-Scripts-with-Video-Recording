package com.vertafore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.Global_Common;

public class CommentPage {
	private WebDriver driver;

	// Start date
	@FindBy(how = How.NAME, using = "searchStartDate")
	private WebElement commentsEnteredFromTextbox;

	// End date
	@FindBy(how = How.NAME, using = "searchEndDate")
	private WebElement commentsEnteredToTextbox;

	// Comment Category Exists
	@FindBy(how = How.NAME, using = "category")
	private List<WebElement> commentCategoryExistsDropDown;

	// context type
	@FindBy(how = How.NAME, using = "cntxtTypeCd")
	private List<WebElement> commentContextTypeDropDown;

	// search option
	@FindBy(how = How.LINK_TEXT, using = "Search")
	private WebElement searchCommentLink;

	// Clear option
	@FindBy(how = How.LINK_TEXT, using = "Clear Fields")
	private WebElement clearCommentFieldsLink;

	// Add comment
	@FindBy(how = How.LINK_TEXT, using = "Add Comment")
	private WebElement addCommentLink;

	@FindBy(how = How.XPATH, using = "//form[@id='ConfigureCommentForm']/table[2]/tbody/tr/td/div")
	private WebElement actionsButton;

	// Edit comment action
	@FindBy(how = How.XPATH, using = "xpath=(//a[contains(text(),'Edit')])[7]")
	private WebElement editactionButton;

	public CommentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchComment() {

		String searchByStartDate = Global_Common
				.getEnvironmentProperty("commentEnteredFrom");
		String searchByEndDate = Global_Common
				.getEnvironmentProperty("commentEnteredTo");
		String searchByCommentCategory = Global_Common
				.getEnvironmentProperty("commentCategory");
		String searchByContextType = Global_Common
				.getEnvironmentProperty("contexttype");

		this.commentsEnteredFromTextbox.sendKeys(searchByStartDate);
		this.commentsEnteredToTextbox.sendKeys(searchByEndDate);
		this.commentCategoryExistsDropDown.equals(searchByCommentCategory);
		this.commentContextTypeDropDown.equals(searchByContextType);
		this.searchCommentLink.click();

	}

	public void clickAddComment() {

		this.addCommentLink.click();
	}

	public void clickEditComment() {
		this.editactionButton.click();
	}
	
	public void headerInfoCheck(String data22[]){
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(
				driver,
				"//form[@id='ConfigureCommentForm']/div/div/table/tbody/tr",
				1, data22);
	}

}

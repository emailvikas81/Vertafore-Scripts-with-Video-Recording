package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class AddCommentAddressPage {
	private final WebDriver driver;

	// Comment Date
	@FindBy(how = How.NAME, using = "commentUpdateDate")
	private WebElement commentUpdateDateTextField;

	// Context Type
	@FindBy(how = How.XPATH, using = ".//*[@id='ConfigureCommentForm']/div[3]/div[2]/table/tbody/tr[2]/td[3]")
	private WebElement contextTypePreSelected;

	// Comment Field
	@FindBy(how = How.NAME, using = "comment")
	private WebElement commentFieldTextField;

	// Context Description
	@FindBy(how = How.XPATH, using = ".//*[@id='ConfigureCommentForm']/div[3]/div[2]/table/tbody/tr[2]/td[5]")
	private WebElement contextDescriptionPreSelected;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Cave")
	private WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Name Header
	@FindBy(how = How.XPATH, using = ".//*[@id='ConfigureCommentForm']/div[2]/div/table/tbody/tr/td[2]")
	private WebElement nameHeader;

	public AddCommentAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addAddressPage() {
		String commentDate = Global_Common
				.getEnvironmentProperty("commentDate");
		String commentField = Global_Common
				.getEnvironmentProperty("commentField");

		this.commentUpdateDateTextField.sendKeys(commentDate);
		this.commentFieldTextField.sendKeys(commentField);
		this.saveButton.click();
	}

}

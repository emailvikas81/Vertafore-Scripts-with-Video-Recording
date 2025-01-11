package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TerminateAffiliationPage {

	private final WebDriver driver;

	// Termination Date
	@FindBy(how = How.NAME, using = "toDate")
	private WebElement terminationDateTextBox;

	// Termination Request date
	@FindBy(how = How.NAME, using = "termRqstDate")
	private WebElement terminationRequestDateTextBox;

	// Processing Instruction dropdown
	@FindBy(how = How.XPATH, using = ".//*[@id='AffiliationForm']/div[2]/div[2]/table/tbody/tr[3]/td[3]/select")
	private WebElement processingInstructionDropDown;

	// Continue
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	private WebElement continueButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement canceButton;

	// Back
	@FindBy(how = How.LINK_TEXT, using = "Back")
	private WebElement backButton;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	public TerminateAffiliationPage(WebDriver driver) {
		this.driver = driver;

	}

	public void terminateAffiliation(String processingInstruction) {

		this.processingInstructionDropDown.click();
		this.processingInstructionDropDown.sendKeys(processingInstruction);
		this.processingInstructionDropDown.click();
		this.continueButton.click();
		this.saveButton.click();

	}

	public String checkDataValidationErrors(String processingInstruction) {
		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		this.processingInstructionDropDown.sendKeys(processingInstruction);
		this.continueButton.click();
		this.saveButton.click();
		return null;
	}

}

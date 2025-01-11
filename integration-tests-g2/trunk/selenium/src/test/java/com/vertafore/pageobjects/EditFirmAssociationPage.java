package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditFirmAssociationPage {
	private final WebDriver driver;

	// Start Date
	@FindBy(how = How.NAME, using = "assgnmntStartDate")
	private WebElement updateStartDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "assgnmntEndDate")
	private WebElement updateEndDateTextBox;

	// Status
	@FindBy(how = How.NAME, using = "statusCode")
	private WebElement updateStatusDropDown;

	// Finra Sequence #
	@FindBy(how = How.NAME, using = "nasdSeqNo")
	private WebElement updateFinraSequenceNumberTextBox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.NAME, using = "Cancel")
	private WebElement cancelButton;

	public EditFirmAssociationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editFirmAssociation(String updateFirmAssociationStartDate,
			String updateFirmAssociationStatus) {

		G2_Common.updateField(driver, this.updateStartDateTextBox,
				updateFirmAssociationStartDate);
		this.updateStatusDropDown.sendKeys(updateFirmAssociationStatus);
		this.saveButton.click();
	}
}

package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddFirmAssociationSecondPage {
	private final WebDriver driver;

	// Start Date
	@FindBy(how = How.NAME, using = "assgnmntStartDate")
	private WebElement startDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "assgnmntEndDate")
	private WebElement endDateTextBox;

	// Status
	@FindBy(how = How.NAME, using = "statusCode")
	private WebElement statusDropDown;

	// Finra Sequence #
	@FindBy(how = How.NAME, using = "nasdSeqNo")
	private WebElement finraSequenceNumberTextBox;

	// Personnel Role
	@FindBy(how = How.NAME, using = "prsnlRole")
	private WebElement personnelRoleTextBox;

	// Relationship#
	@FindBy(how = How.NAME, using = "relationshipNo")
	private WebElement relationShipTextBox;

	// Firm Role
	@FindBy(how = How.NAME, using = "firmRole")
	private WebElement firmRoleDropDown;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.NAME, using = "Cancel")
	private WebElement cancelButton;

	public AddFirmAssociationSecondPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addFirmAssociation(String assignmentStartDate,
			String assignmentStatus, String assignmentPersonnelRole) {

		this.startDateTextBox.sendKeys(assignmentStartDate);
		this.statusDropDown.sendKeys(assignmentStatus);
		this.personnelRoleTextBox.sendKeys(assignmentPersonnelRole);
		this.saveButton.click();
	}


}

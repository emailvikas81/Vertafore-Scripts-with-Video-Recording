package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddRoleFirmAssociationPage {
	private final WebDriver driver;

	// Personnel Role
	@FindBy(how = How.NAME, using = "prsnlRole")
	private WebElement personnelRoleTextBox;

	// Relationship#
	@FindBy(how = How.NAME, using = "relationshipNo")
	private WebElement relationShipTextBox;

	// Firm Role
	@FindBy(how = How.NAME, using = "firmRole")
	private WebElement firmRoleDropDown;

	// Start Date
	@FindBy(how = How.NAME, using = "roleStartDate")
	private WebElement startDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "roleEndDate")
	private WebElement endDateTextBox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.NAME, using = "Cancel")
	private WebElement cancelButton;

	public AddRoleFirmAssociationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addRoleToFirmAssociation(String addRoleStartDate,
			String addPersonnelRole) {
		this.startDateTextBox.sendKeys(addRoleStartDate);
		this.personnelRoleTextBox.sendKeys(addPersonnelRole);
		this.saveButton.click();
	}


}

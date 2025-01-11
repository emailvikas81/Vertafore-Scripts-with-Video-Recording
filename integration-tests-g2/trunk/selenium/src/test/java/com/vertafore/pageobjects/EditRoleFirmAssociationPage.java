package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditRoleFirmAssociationPage {
	private final WebDriver driver;

	// Personnel Role
	@FindBy(how = How.NAME, using = "prsnlRole")
	private WebElement updatePersonnelRoleTextBox;

	// Relationship#
	@FindBy(how = How.NAME, using = "relationshipNo")
	private WebElement updateRelationShipTextBox;

	// Firm Role
	@FindBy(how = How.NAME, using = "firmRole")
	private WebElement updateFirmRoleDropDown;

	// Start Date
	@FindBy(how = How.NAME, using = "roleStartDate")
	private WebElement updateStartDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "roleEndDate")
	private WebElement updateEndDateTextBox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.NAME, using = "Cancel")
	private WebElement cancelButton;

	public EditRoleFirmAssociationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editRoleToFirmAssociation(String updateRoleStartDate) {

		G2_Common.updateField(driver, this.updateStartDateTextBox,
				updateRoleStartDate);
		this.saveButton.click();
	}

}

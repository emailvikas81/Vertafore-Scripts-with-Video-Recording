package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditExternalSystemIdentifierPage {
	private final WebDriver driver;

	// Type
	@FindBy(how = How.NAME, using = "system")
	private WebElement updateTypeDropDown;

	// Identification in External System
	@FindBy(how = How.NAME, using = "identificationInExternalSystem")
	private WebElement updateIdentificationInExternalSystemTextbox;

	// Start date
	@FindBy(how = How.NAME, using = "validFrom")
	private WebElement updateStartDateTextbox;

	// End Date
	@FindBy(how = How.NAME, using = "validTo")
	private WebElement updateEndDateTextbox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public EditExternalSystemIdentifierPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editExternalSystemIdentifier(String updateType,
			String updateIdentificationInExternalSystem,
			String updateStartDate, String updateEndDate) {

		G2_Common.updateField(driver,
				this.updateIdentificationInExternalSystemTextbox,
				updateIdentificationInExternalSystem);
		G2_Common.updateField(driver, this.updateStartDateTextbox,
				updateStartDate);
		G2_Common.updateField(driver, this.updateEndDateTextbox, updateEndDate);
		this.saveButton.click();
	}
}

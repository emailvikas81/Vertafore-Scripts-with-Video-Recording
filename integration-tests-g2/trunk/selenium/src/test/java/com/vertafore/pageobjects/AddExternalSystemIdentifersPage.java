package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddExternalSystemIdentifersPage {

	private final WebDriver driver;

	// Type
	@FindBy(how = How.NAME, using = "system")
	private WebElement typeDropDown;

	// Identification in External System
	@FindBy(how = How.NAME, using = "identificationInExternalSystem")
	private WebElement identificationInExternalSystemTextbox;

	// Start date
	@FindBy(how = How.NAME, using = "validFrom")
	private WebElement startDateTextbox;

	// End Date
	@FindBy(how = How.NAME, using = "validTo")
	private WebElement endDateTextbox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public AddExternalSystemIdentifersPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addExternalSystemIdentifier(String addType,
			String addIdentificationInExternalSystem, String addStartDate,
			String addEndDate) {

		this.typeDropDown.sendKeys(addType);
		this.identificationInExternalSystemTextbox
				.sendKeys(addIdentificationInExternalSystem);
		this.startDateTextbox.sendKeys(addStartDate);
		this.endDateTextbox.sendKeys(addEndDate);
		this.saveButton.click();
	}

}

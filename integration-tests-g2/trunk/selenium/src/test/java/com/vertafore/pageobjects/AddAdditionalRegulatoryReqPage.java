package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddAdditionalRegulatoryReqPage {
	private final WebDriver driver;

	// Regulatory Requirement
	@FindBy(how = How.ID, using = "regulatoryRqmt")
	private WebElement regulatoryRqmtDropdown;

	// State
	@FindBy(how = How.ID, using = "state")
	private WebElement stateDropdown;

	// Status
	@FindBy(how = How.ID, using = "status")
	private WebElement statusDropdown;

	// Requested Date
	@FindBy(how = How.NAME, using = "requestedDate")
	private WebElement requestedDateTextBox;

	// Expiration Date
	@FindBy(how = How.NAME, using = "expirationDate")
	private WebElement expirationDateTextBox;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Additional Regulatory Requirement added successfully.
	@FindBy(how = How.XPATH, using = "//div[@id='msgValidtnDiv']/font/ul/li")
	private WebElement successMessage;

	public AddAdditionalRegulatoryReqPage(WebDriver driver) {
		this.driver = driver;
	}

	// Add Additional Regulatory Requirement Addition
	public void addRegulatoryReq(String addRegulatoryRequirement,
			String addState, String addARStatus, String addRequestedDate) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		this.regulatoryRqmtDropdown.sendKeys(addRegulatoryRequirement);
		this.stateDropdown.sendKeys(addState);
		this.stateDropdown.click();
		this.statusDropdown.sendKeys(addARStatus);
		this.requestedDateTextBox.sendKeys(addRequestedDate);
		this.saveButton.click();

	}

}

package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditAdditionalRegulatoryReqPage {
	private final WebDriver driver;

	// Regulatory Requirement
	@FindBy(how = How.ID, using = "regulatoryRqmt")
	private WebElement regulatoryRqmtDropdown;

	// State
	@FindBy(how = How.NAME, using = "state")
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

	public EditAdditionalRegulatoryReqPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editRegulatoryReq(String editARRState, String editARRStatus,
			String editARRRequestedDate) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		this.stateDropdown.sendKeys(editARRState);
		this.statusDropdown.sendKeys(editARRStatus);
		G2_Common.updateField(driver, this.requestedDateTextBox,
				editARRRequestedDate);
		this.saveButton.click();
	}

}

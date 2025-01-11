package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditLicensePage {
	private WebDriver driver;

	// Edit when Resident state is CA and Status is Active
	// Original Issue Date
	@FindBy(how = How.NAME, using = "originalIssueDate")
	private WebElement el_OriginalIssueDateTextBox;

	// License #
	@FindBy(how = How.NAME, using = "licenseNbr")
	private WebElement el_LicenseNumberTextBox;

	// Effective Date
	@FindBy(how = How.NAME, using = "effectiveDate")
	private WebElement el_EffectiveDateTextBox;

	// Expiration Date
	@FindBy(how = How.NAME, using = "renewalDate")
	private WebElement el_ExpirationDateTextBox;

	// Physical Copy Received
	@FindBy(how = How.NAME, using = "physicalCopyReceived")
	private WebElement el_PhysicalCopyDropdown;

	// Renewal Status
	@FindBy(how = How.NAME, using = "renewalStatusCode")
	private WebElement el_RenewalStatusDropdown;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// SaveButton
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	public void editLicense(String el_OriginalIssueDate,
			String el_LicenseNumber, String el_Effective,
			String el_ExpirationDate, String el_PhysicalCopy,
			String el_RenewalStatus) {

		G2_Common.updateField(driver, this.el_OriginalIssueDateTextBox,
				el_OriginalIssueDate);
		G2_Common.updateField(driver, this.el_LicenseNumberTextBox,
				el_LicenseNumber);
		G2_Common.updateField(driver, this.el_EffectiveDateTextBox,
				el_Effective);
		G2_Common.updateField(driver, this.el_ExpirationDateTextBox,
				el_ExpirationDate);
		this.el_PhysicalCopyDropdown.sendKeys(el_PhysicalCopy);
		this.el_RenewalStatusDropdown.sendKeys(el_RenewalStatus);

		this.saveButton.click();

	}

	public EditLicensePage(WebDriver driver) {
		this.driver = driver;
	}
}

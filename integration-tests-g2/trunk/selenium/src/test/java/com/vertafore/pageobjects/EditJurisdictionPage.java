package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class EditJurisdictionPage {
	private final WebDriver driver;

	// Registration Type
	@FindBy(how = How.NAME, using = "registrationTypeCode")
	private WebElement updateRegistrationTypeDropDown;

	// Jurisdiction
	@FindBy(how = How.NAME, using = "jurisdictionCode")
	private WebElement updateJurisdictionDropDown;

	// Firm
	@FindBy(how = How.NAME, using = "firmId")
	private WebElement updateFirmDropDown;

	// FINRA Status
	@FindBy(how = How.NAME, using = "nasdStatus")
	private WebElement updateFinraStatusDropDown;

	// Status
	@FindBy(how = How.NAME, using = "statusCode")
	private WebElement updateStatusDropDown;

	// Status Date
	@FindBy(how = How.NAME, using = "statusDate")
	private WebElement updateStatusDateTextBox;

	// Filing Date
	@FindBy(how = How.NAME, using = "filingDate")
	private WebElement updateFilingDateTextBox;

	// Approved Date
	@FindBy(how = How.NAME, using = "approvedDate")
	private WebElement updateApprovedDateTextBox;

	// save option
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel option
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public EditJurisdictionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editJurisdiction(String updateFinraStatus, String updateStatus,
			String updateStatusDate, String updateFilingDate,
			String updateApprovalDate) {

		this.updateFinraStatusDropDown.sendKeys(updateFinraStatus);
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		this.updateStatusDropDown.click();
		this.updateStatusDropDown.sendKeys(updateStatus);
		G2_Common.updateField(driver, this.updateStatusDateTextBox,
				updateStatusDate);
		G2_Common.updateField(driver, this.updateFilingDateTextBox,
				updateFilingDate);
		G2_Common.updateField(driver, this.updateApprovedDateTextBox,
				updateApprovalDate);
		this.saveButton.click();
	}
}

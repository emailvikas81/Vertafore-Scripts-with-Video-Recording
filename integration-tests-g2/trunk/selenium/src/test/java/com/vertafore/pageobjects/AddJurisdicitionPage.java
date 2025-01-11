package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class AddJurisdicitionPage {
	private final WebDriver driver;

	// Registration Type
	@FindBy(how = How.NAME, using = "registrationTypeCode")
	private WebElement registrationTypeDropDown;

	// Jurisdiction
	@FindBy(how = How.NAME, using = "jurisdictionCode")
	private WebElement jurisdictionDropDown;

	// Firm
	@FindBy(how = How.ID, using = "firmId")
	private WebElement firmDropDown;

	// FINRA Status
	@FindBy(how = How.NAME, using = "nasdStatus")
	private WebElement finraStatusDropDown;

	// Status
	@FindBy(how = How.ID, using = "statusCode")
	private WebElement statusDropDown;

	// Status Date
	@FindBy(how = How.NAME, using = "statusDate")
	private WebElement statusDateTextBox;

	// Filing Date
	@FindBy(how = How.NAME, using = "filingDate")
	private WebElement filingDateTextBox;

	// Approved Date
	@FindBy(how = How.NAME, using = "approvedDate")
	private WebElement approvedDateTextBox;

	// save option
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel option
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public AddJurisdicitionPage(WebDriver driver) {
		this.driver = driver;

	}

	public void addJurisdiction(String addRegistrationType,
			String addJurisdiction, String addFirm, String addFinraStatus,
			String addStatus, String addStatusDate, String addFilingDate) {
		Global_Common.setDriverTimeout(driver, 5, TimeUnit.SECONDS);
		this.registrationTypeDropDown.sendKeys(addRegistrationType);
		this.jurisdictionDropDown.sendKeys(addJurisdiction);
		Global_Common.setDriverTimeout(driver, 5, TimeUnit.SECONDS);
		this.firmDropDown.click();
		this.firmDropDown.sendKeys(addFirm); // dependent of firm association
		this.finraStatusDropDown.sendKeys(addFinraStatus);
		this.statusDropDown.sendKeys(addStatus);
		G2_Common.dropdownSelectionByIndex(this.statusDropDown, 1);
		G2_Common.updateField(driver, this.statusDateTextBox,
				addStatusDate);
		G2_Common.updateField(driver, this.filingDateTextBox,
				addFilingDate);
//		this.statusDateTextBox.sendKeys(addStatusDate);
//		this.filingDateTextBox.sendKeys(addFilingDate);
		this.saveButton.click();
	}


}

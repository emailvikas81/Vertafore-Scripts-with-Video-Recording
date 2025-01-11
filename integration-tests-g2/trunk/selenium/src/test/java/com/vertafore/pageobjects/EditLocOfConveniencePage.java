package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditLocOfConveniencePage {
	private final WebDriver driver;

	// From Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement fromDateTextBox;

	// Description
	@FindBy(how = How.NAME, using = "description")
	private WebElement descriptionTextField;

	// Address Line 1
	@FindBy(how = How.NAME, using = "addressLineOne")
	private WebElement addressLineOneTextField;

	// City
	@FindBy(how = How.NAME, using = "city")
	private WebElement addressCityTextField;

	// Country
	@FindBy(how = How.NAME, using = "country")
	private WebElement addresscountryDropDown;

	// State
	@FindBy(how = How.NAME, using = "state")
	private WebElement addressState;

	// PostalCode
	@FindBy(how = How.NAME, using = "postalCode")
	private WebElement postalCodeTextBox;

	// Audit Base Date
	@FindBy(how = How.NAME, using = "auditBaseDte")
	private WebElement auditBaseDateTextBox;

	// Audit Frequency
	@FindBy(how = How.NAME, using = "auditFrequency")
	private WebElement auditFrequencyDropDown;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public EditLocOfConveniencePage(WebDriver driver) {
		this.driver = driver;
	}

	public void editLocOfConvenience(String elcFromDate, String elcDescription,
			String elcLineOne, String elcCity, String elcCountry,
			String elcState, String elcPostalCode, String elcAuditBaseDate,
			String elcAuditFrequency) {

		G2_Common.updateField(driver, this.fromDateTextBox, elcFromDate);
		G2_Common
				.updateField(driver, this.descriptionTextField, elcDescription);
		G2_Common.updateField(driver, this.addressLineOneTextField, elcLineOne);
		G2_Common.updateField(driver, this.addressCityTextField, elcCity);
		this.addresscountryDropDown.sendKeys(elcCountry);
		this.addressState.sendKeys(elcState);
		G2_Common.updateField(driver, this.postalCodeTextBox, elcPostalCode);
		G2_Common.updateField(driver, this.auditBaseDateTextBox,
				elcAuditBaseDate);
		this.auditFrequencyDropDown.sendKeys(elcAuditFrequency);
		this.saveButton.click();
	}

}

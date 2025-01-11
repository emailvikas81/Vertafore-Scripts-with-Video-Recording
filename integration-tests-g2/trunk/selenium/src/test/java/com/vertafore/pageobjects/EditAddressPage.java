package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditAddressPage {
	private final WebDriver driver;

	// From Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement fromDateTextField;

	// Address Line 1
	@FindBy(how = How.NAME, using = "addressOneLine")
	private WebElement addressLineOneTextField;

	// Address City
	@FindBy(how = How.NAME, using = "city")
	private WebElement addressCityTextField;

	// Address Country
	@FindBy(how = How.NAME, using = "country")
	private WebElement addresscountryDropDown;

	// Private Residence
	@FindBy(how = How.NAME, using = "privateResidence")
	private WebElement privateResidenceDropDown;

	// Address State
	@FindBy(how = How.NAME, using = "state")
	private WebElement addressStateDropDown;

	// Address PostalCode
	@FindBy(how = How.NAME, using = "postalCode")
	private WebElement postalCodeTextField;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public EditAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editAddress(String eaFromDate, String eaPrivateResidence,
			String eaLineOne, String eaCity, String eaCountry, String eaState,
			String eaPostalCode) {

		G2_Common.updateField(driver, this.fromDateTextField, eaFromDate);
		// this.privateResidenceDropDown.sendKeys(eaPrivateResidence);
		G2_Common.updateField(driver, this.addressLineOneTextField, eaLineOne);
		G2_Common.updateField(driver, this.addressCityTextField, eaCity);
		this.addresscountryDropDown.sendKeys(eaCountry);
		this.addressStateDropDown.sendKeys(eaState);
		G2_Common.updateField(driver, this.postalCodeTextField, eaPostalCode);
		this.saveButton.click();
	}

	public void FromDateValidate(String addFromFutureDate,
			String editAddressLine1, String editAddressPostalCode) {
		G2_Common
				.updateField(driver, this.fromDateTextField, addFromFutureDate);
		G2_Common.updateField(driver, this.addressLineOneTextField,
				editAddressLine1);
		G2_Common.updateField(driver, this.postalCodeTextField,
				editAddressPostalCode);
	}

}

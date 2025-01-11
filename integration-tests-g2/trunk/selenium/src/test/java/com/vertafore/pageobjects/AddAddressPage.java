package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class AddAddressPage {
	private static WebDriver driver;

	// Address Purpose
	@FindBy(how = How.XPATH, using = ".//*[@id='addressPurpose']")
	private static WebElement addressPurposeDropdown;

	// From Date
	@FindBy(how = How.NAME, using = "fromDate")
	private static WebElement fromDateTextField;

	// Address Line 1
	@FindBy(how = How.NAME, using = "addressOneLine")
	private static WebElement addressLineOneTextField;

	// Address City
	@FindBy(how = How.NAME, using = "city")
	private static WebElement addressCityTextField;

	// Address Country
	@FindBy(how = How.NAME, using = "country")
	private static WebElement addresscountryDropDown;

	// Address Type
	@FindBy(how = How.NAME, using = "addressType")
	private static WebElement addressTypeDropDown;

	// Private Residence
	@FindBy(how = How.NAME, using = "privateResidence")
	private static WebElement privateResidenceDropDown;

	// Address State
	@FindBy(how = How.NAME, using = "state")
	private static WebElement addressStateDropDown;

	// Address PostalCode
	@FindBy(how = How.NAME, using = "postalCode")
	private static WebElement postalCodeTextField;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private static WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Footer
	@FindBy(how = How.XPATH, using = "//body/table/tbody/tr[3]/td/table/tbody/tr/td")
	private static WebElement footerTestClick;

	// Name Header
	@FindBy(how = How.XPATH, using = ".//*[@id='indvAddressForm']/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/div/div/table/tbody/tr/td[2]")
	private WebElement nameHeader;

	public AddAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	// Entering Data to the Address according to the Search Result
	public void addAddress(String aaAddressPurpose, String aaFromDate,
			String aaAddressType, String aaPrivateResidence, String aaLineOne,
			String aaCity, String aaCountry, String aaState, String aaPostalCode) {

		Global_Common.setDriverTimeout(driver, 60, TimeUnit.SECONDS);
		addressPurposeDropdown.sendKeys(aaAddressPurpose);
		fromDateTextField.sendKeys(aaFromDate);
		addressLineOneTextField.sendKeys(aaLineOne);
		addressCityTextField.sendKeys(aaCity);
		addresscountryDropDown.sendKeys(aaCountry);
		addressStateDropDown.sendKeys(aaState);
		postalCodeTextField.sendKeys(aaPostalCode);
		addressTypeDropDown.sendKeys(aaAddressType);
		footerTestClick.click();
		// privateResidenceDropDown.sendKeys(aaPrivateResidence);
		Global_Common.setDriverTimeout(driver, 60, TimeUnit.SECONDS);
		saveButton.click();
	}

}

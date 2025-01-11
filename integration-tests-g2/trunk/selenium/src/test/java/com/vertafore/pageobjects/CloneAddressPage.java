package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class CloneAddressPage {
	private final WebDriver driver;

	// Address Purpose
	@FindBy(how = How.NAME, using = "addressPurpose")
	private WebElement addressPurposeDropdown;

	// From Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement fromDateTextField;

	// To Date
	@FindBy(how = How.NAME, using = "toDate")
	private WebElement toDateTextField;

	// Address Line 1
	@FindBy(how = How.NAME, using = "addressOneLine")
	private WebElement addressLineOneTextField;

	// Address City
	@FindBy(how = How.NAME, using = "city")
	private WebElement addressCityTextField;

	// Address Country
	@FindBy(how = How.NAME, using = "country")
	private WebElement addresscountryDropDown;

	// Address Type
	@FindBy(how = How.NAME, using = "addressType")
	private WebElement addressTypeDropDown;

	// Address State
	@FindBy(how = How.NAME, using = "state")
	private WebElement addressStateDropDown;

	// Address PostalCode
	@FindBy(how = How.NAME, using = "postalCode")
	private WebElement postalCodeTextField;

	// FINRA Seq #
	@FindBy(how = How.NAME, using = "nasdSeqNo")
	private WebElement finraSeqNo;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public CloneAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public void cloneAddress(String caAddressPurpose, String caFromDate,
			String caAddressType, String caFinraSeqNo, String caToDate,
			String caLineOne, String caCity, String caCountry, String caState,
			String caPostalCode) {
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		G2_Common.dropdownSelectionByVisibleText(driver, this.addressPurposeDropdown, caAddressPurpose);
		//this.addressPurposeDropdown.sendKeys(caAddressPurpose);
		G2_Common.updateField(driver, this.fromDateTextField, caFromDate);
		//G2_Common.dropdownSelectionByVisibleText(driver, this.addressTypeDropDown, caAddressType);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.addressTypeDropDown.sendKeys(caAddressType);
		G2_Common.updateField(driver, this.finraSeqNo, caFinraSeqNo);
		G2_Common.updateField(driver, this.toDateTextField, caToDate);
		G2_Common.updateField(driver, this.addressLineOneTextField, caLineOne);
		G2_Common.updateField(driver, this.addressCityTextField, caCity);
		this.addressTypeDropDown.sendKeys(caAddressType);
		this.addresscountryDropDown.sendKeys(caCountry);
		this.addressStateDropDown.sendKeys(caState);
		G2_Common.updateField(driver, this.postalCodeTextField, caPostalCode);
		this.saveButton.click();
	}

}

package com.vertafore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddLocOfConveniencePage {

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

	public AddLocOfConveniencePage(WebDriver driver) {
		this.driver = driver;

	}

	public String addLocOfConvenience(String alcFromDate,
			String alcDescription, String alcLineOne, String alcCity,
			String alcCountry, String alcState, String alcPostalCode,
			String alcAuditBaseDate, String alcAuditFrequency) {

		this.fromDateTextBox.sendKeys(alcFromDate);
		this.descriptionTextField.sendKeys(alcDescription);
		this.addressLineOneTextField.sendKeys(alcLineOne);
		this.addressCityTextField.sendKeys(alcCity);
		this.addresscountryDropDown.sendKeys(alcCountry);
		this.addressState.sendKeys(alcState);
		this.postalCodeTextBox.sendKeys(alcPostalCode);
		this.auditBaseDateTextBox.sendKeys(alcAuditBaseDate);
		this.auditFrequencyDropDown.sendKeys(alcAuditFrequency);
		this.saveButton.click();

		String cRDNo = driver
				.findElement(
						By.xpath(".//*[@id='indvAddressForm']/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/div/div/table/tbody/tr/td[6]"))
				.getText();
		return cRDNo;

	}
	
	


}

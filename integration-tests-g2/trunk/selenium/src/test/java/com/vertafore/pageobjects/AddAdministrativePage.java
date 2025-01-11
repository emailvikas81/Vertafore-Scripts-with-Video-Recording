package com.vertafore.pageobjects;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class AddAdministrativePage {
	private final WebDriver driver;

	// Page 1
	// Last Name
	@FindBy(how = How.NAME, using = "lastName")
	private WebElement adminLastNameTextBox;

	// First Name
	@FindBy(how = How.NAME, using = "firstName")
	private WebElement adminFirstNameTextBox;

	// Search Button
	@FindBy(how = How.LINK_TEXT, using = "Search")
	private WebElement searchButton;

	// Clear Field Button
	@FindBy(how = How.LINK_TEXT, using = "Clear Fields")
	private WebElement clearFieldsButton;

	// Select potential Supervisors
	@FindBy(how = How.NAME, using = "indvPrmId")
	private WebElement potentialSupervisorsRadio;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Continue Button
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	private WebElement continueButton;

	// Page 2
	// From Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement adminFromDateTextBox;

	// Super Status
	@FindBy(how = How.NAME, using = "superStatus")
	private WebElement adminSuperStatusDropDown;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	public AddAdministrativePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addAdministrativeSupervisor(String adminLastName,
			String admiFirstName, String adminFromDate, String adminSuperStatus) {

		this.adminLastNameTextBox.sendKeys(adminLastName);
		this.adminFirstNameTextBox.sendKeys(admiFirstName);
		this.searchButton.click();
		this.potentialSupervisorsRadio.click();
		this.continueButton.click();
		checkDataValidationErrors();
		this.adminFromDateTextBox.sendKeys(adminFromDate);
		this.adminSuperStatusDropDown.sendKeys(adminSuperStatus);
		this.saveButton.click();
	}

	public String checkDataValidationErrors() {
		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		String dataValidationErrors = Global_Common
				.getEnvironmentProperty("ASDataValidationErrors");
		this.saveButton.click();
		String actualValidationError = global.retrieveFailureReason();
		if (actualValidationError.equals(dataValidationErrors)) {
			G2_Common.APPLICATION_LOGS
					.info("Data Validation Error is as expected.");
		} else {
			fail("Test failed, as the expected Data Validation Error is: "
					+ dataValidationErrors
					+ " , actual Data Validation Error is: "
					+ actualValidationError);
		}
		return null;
	}

}

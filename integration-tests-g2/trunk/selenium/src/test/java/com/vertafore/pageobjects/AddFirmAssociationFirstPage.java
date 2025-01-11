package com.vertafore.pageobjects;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class AddFirmAssociationFirstPage {
	private final WebDriver driver;

	// Firm Name
	@FindBy(how = How.NAME, using = "firmName")
	private WebElement firmNameTextBox;

	// External System ID
	@FindBy(how = How.NAME, using = "externalSystemCode")
	private WebElement externalSystemIDDropDown;

	// External System ID
	@FindBy(how = How.NAME, using = "externalSystemId")
	private WebElement externalSystemIDTextBox;

	// Identifiers
	@FindBy(how = How.NAME, using = "identifiers")
	private WebElement identifiersDropDown;

	// Identifiers Value
	@FindBy(how = How.NAME, using = "identifiersValue")
	private WebElement identifiersTextBox;

	// License
	@FindBy(how = How.NAME, using = "license")
	private WebElement licenseDropDown;

	// License Value
	@FindBy(how = How.NAME, using = "licenseValue")
	private WebElement licenseTextBox;

	// Search
	@FindBy(how = How.LINK_TEXT, using = "Search")
	private WebElement searchLink;

	// Clear Fields
	@FindBy(how = How.LINK_TEXT, using = "Clear Fields")
	private WebElement clearFIeldsLink;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelLink;

	// Continue
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	private WebElement continuelLink;

	// Radio Button
	@FindBy(how = How.NAME, using = "firmId")
	private WebElement radioButtons;

	public AddFirmAssociationFirstPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchByIdentifiers(String identifiersCode,
			String identifiersValue) {
		G2_Common.dropdownSelection(this.identifiersDropDown, identifiersCode);

		this.identifiersTextBox.sendKeys(identifiersValue);
		this.searchLink.click();
	}

	public String checkDataValidationErrors() {
		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		String dataValidationErrors = Global_Common
				.getEnvironmentProperty("AFADataValidationErrors");
		this.searchLink.click();
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

	public void clickOnRadioButton() {
		this.radioButtons.click();
	}

	public void clickOnContinueLink() {
		this.continuelLink.click();
	}

}

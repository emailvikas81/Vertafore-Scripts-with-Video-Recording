package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddComplianceSupervisorFirstPage {
	@SuppressWarnings("unused")
	private final WebDriver driver;

	// Last Name
	@FindBy(how = How.NAME, using = "lastName")
	private WebElement lastNameTextBox;

	// First Name
	@FindBy(how = How.NAME, using = "firstName")
	private WebElement firstNameTextBox;

	// External System ID(DropDown)
	@FindBy(how = How.NAME, using = "extSysCd")
	private WebElement externalSystemIdDropdown;

	// External System ID(TextBox)
	@FindBy(how = How.NAME, using = "extSysId")
	private WebElement externalSystemIdTextBox;

	// Identifiers(DropDown)
	@FindBy(how = How.NAME, using = "identifiers")
	private WebElement identifierDropDown;

	// Identifiers(TextBox)
	@FindBy(how = How.NAME, using = "identifiersValue")
	private WebElement identifierTextBox;

	// License(DropDown)
	@FindBy(how = How.NAME, using = "license")
	private WebElement licenseDropDown;

	// License(TextBox)
	@FindBy(how = How.NAME, using = "licenseValue")
	private WebElement licenseTextBox;

	// Search
	@FindBy(how = How.LINK_TEXT, using = "Search")
	private WebElement searchLink;

	// Clear Fields
	@FindBy(how = How.LINK_TEXT, using = "Clear Fields")
	private WebElement clearFieldsLink;

	// Potential compliance supervisor table
	@FindBy(how = How.XPATH, using = "//form[@id='ConfigureRegSupervisorForm']/table[2]/thead/tr/td")
	private WebElement potentialComplianceSupervisorTable;

	// Radio Button
	@FindBy(how = How.NAME, using = "idSeq")
	private WebElement radioButton;

	// Continue
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	private WebElement continueLink;

	// Return
	@FindBy(how = How.LINK_TEXT, using = "Return")
	private WebElement returnLink;

	// Method Goes Here
	public AddComplianceSupervisorFirstPage(WebDriver driver) {
		this.driver = driver;

	}

	public void searchAndSelectPotentialComplianceSupervisorByLastName(
			String lastName) {

		this.lastNameTextBox.sendKeys(lastName);
		this.searchLink.click();
		this.radioButton.click();
		this.continueLink.click();
	}

	public void clickOnReturn() {
		this.returnLink.click();
	}

}

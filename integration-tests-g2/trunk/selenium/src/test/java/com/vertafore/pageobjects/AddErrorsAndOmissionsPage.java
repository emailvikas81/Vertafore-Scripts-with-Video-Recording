package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddErrorsAndOmissionsPage {
	private final WebDriver driver;

	// Status
	@FindBy(how = How.NAME, using = "status")
	private WebElement statusDropDown;

	// Effective date
	@FindBy(how = How.NAME, using = "effectiveDt")
	private WebElement effectiveDateTextBox;

	// Expiration date
	@FindBy(how = How.NAME, using = "expDt")
	private WebElement expirationDateTextBox;

	// Provider Name
	@FindBy(how = How.NAME, using = "providerName")
	private WebElement providerNameTextBox;

	// Policy
	@FindBy(how = How.NAME, using = "policyNumber")
	private WebElement policyNumberTextBox;

	// Maximum coverage amount
	@FindBy(how = How.NAME, using = "maxCoverageAmt")
	private WebElement maxCoverageAmountTextBox;

	// Provider financial rating
	@FindBy(how = How.NAME, using = "finacialRating")
	private WebElement financialRatingDropDown;

	// Financial rating company
	@FindBy(how = How.NAME, using = "finacialRatingCompany")
	private WebElement financialRatingCompanyTextBox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public AddErrorsAndOmissionsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addErrorsAndOmissions(String addStatus,
			String addEffectiveDate, String addExpirationDate,
			String addProviderName, String addPolicy,
			String addMaximumCoverageAmount, String addProviderFinancialRating,
			String addFinancialRatingCompany) {

		this.statusDropDown.sendKeys(addStatus);
		this.effectiveDateTextBox.sendKeys(addEffectiveDate);
		this.expirationDateTextBox.sendKeys(addExpirationDate);
		this.providerNameTextBox.sendKeys(addProviderName);
		this.policyNumberTextBox.sendKeys(addPolicy);
		this.maxCoverageAmountTextBox.sendKeys(addMaximumCoverageAmount);
		this.financialRatingDropDown.sendKeys(addProviderFinancialRating);
		this.financialRatingCompanyTextBox.sendKeys(addFinancialRatingCompany);
		this.saveButton.click();
	}

}

package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditErrorsAndOmissionsPage {
	private final WebDriver driver;

	// status
	@FindBy(how = How.NAME, using = "status")
	private WebElement updateStatusDropDown;

	// Effective date
	@FindBy(how = How.NAME, using = "effectiveDt")
	private WebElement updateEffectiveDateTextBox;

	// Expiration date
	@FindBy(how = How.NAME, using = "expDt")
	private WebElement updateExpirationDateTextBox;

	// provider Name
	@FindBy(how = How.NAME, using = "providerName")
	private WebElement updateProviderNameTextBox;

	// policy
	@FindBy(how = How.NAME, using = "policyNumber")
	private WebElement updatePolicyNumberTextBox;

	// maximum coverage amount
	@FindBy(how = How.NAME, using = "maxCoverageAmt")
	private WebElement updateMaxCoverageAmountTextBox;

	// provider financial rating
	@FindBy(how = How.NAME, using = "finacialRating")
	private WebElement updateFinancialRatingDropDown;

	// financial rating company
	@FindBy(how = How.NAME, using = "finacialRatingCompany")
	private WebElement updateFinancialRatingCompanyTextBox;

	// save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public EditErrorsAndOmissionsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editErrorsAndOmissions(String updateStatus,
			String updateEffectiveDate, String updateExpirationDate,
			String updateProviderName, String updatePolicy,
			String updateMaximumCoverageAmount,
			String updateproviderFinancialRating,
			String updateFinancialRatingCompany) {

		G2_Common.updateField(driver, this.updateEffectiveDateTextBox,
				updateEffectiveDate);
		this.updateStatusDropDown.sendKeys(updateStatus);
		G2_Common.updateField(driver, this.updateExpirationDateTextBox,
				updateExpirationDate);
		G2_Common.updateField(driver, this.updateProviderNameTextBox,
				updateProviderName);
		G2_Common.updateField(driver, this.updatePolicyNumberTextBox,
				updatePolicy);
		G2_Common.updateField(driver, this.updateMaxCoverageAmountTextBox,
				updateMaximumCoverageAmount);
		G2_Common.updateField(driver, this.updateFinancialRatingCompanyTextBox,
				updateFinancialRatingCompany);
		this.updateFinancialRatingDropDown
				.sendKeys(updateproviderFinancialRating);
		this.saveButton.click();
	}
}

package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class AddLicensePage {
	private final WebDriver driver;

	// License page
	// State
	@FindBy(how = How.NAME, using = "state")
	private WebElement al_StateDropdown;

	// License Type
	@FindBy(how = How.NAME, using = "licenseType")
	private WebElement al_LicenseTypeDropdown;

	// Status
	@FindBy(how = How.NAME, using = "status")
	private WebElement al_StatusDropdown;

	// Original Issue Date
	@FindBy(how = How.NAME, using = "originalIssueDate")
	private WebElement al_OriginalIssueDateTextBox;

	// Physical Copy Received
	@FindBy(how = How.NAME, using = "physicalCopyReceived")
	private WebElement al_PhysicalCopyReceivedDropDown;

	// Effective Date
	@FindBy(how = How.NAME, using = "effectiveDate")
	private WebElement al_EffectiveDateTextBox;

	// Renewal Status
	@FindBy(how = How.NAME, using = "renewalStatusCode")
	private WebElement al_RenewalStatusDropDown;

	// License No.
	@FindBy(how = How.NAME, using = "licenseNbr")
	private WebElement al_LicenseNumberTextBox;

	// Expiration Date
	@FindBy(how = How.NAME, using = "renewalDate")
	private WebElement al_ExpirationDateTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id='ConfigureLicQualForm']/div[4]/div[2]/table")
	private WebElement licGroupBox;

	// Qualifications Selection Check Boxes
	@FindBy(how = How.XPATH, using = ".//*[@id='ConfigureLicQualForm']/div[4]/div[2]/table/tbody/tr[1]/td[2]/input")
	private WebElement al_QualificationsCheckBox;

	// Add individual
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	private WebElement continueButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// SaveButton
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Additional Regulatory Requirement page
	// CE Review Period Start Date
	@FindBy(how = How.NAME, using = "ceReviewStartDate")
	private WebElement ceReviewPeriodStartDateTextBox;

	// CE Review Period End Date
	@FindBy(how = How.NAME, using = "ceReviewEndDate")
	private WebElement ceReviewPeriodEndDateTextBox;

	// CE Review Period Status
	@FindBy(how = How.NAME, using = "ceReviewStatus")
	private WebElement ceReviewPeriodStatusDropdown;

	// CE Requirements Ethics Start Date
	@FindBy(how = How.ID, using = "startDate[0]")
	private WebElement cerEthicsStartDateTextBox;

	// CE Requirements Ethics Required Hours
	@FindBy(how = How.ID, using = "requiredHours[0]")
	private WebElement cerEthicsRequiredHoursTextBox;

	// CE Requirements Ethics Status
	@FindBy(how = How.ID, using = "status[0]")
	private WebElement cerEthicsStatusDropDown;

	// CE Requirements Total Hours For License Start Date
	@FindBy(how = How.ID, using = "startDate[1]")
	private WebElement certhLicenseStartDateTextBox;

	// CE Requirements Total Hours For License Required Hours
	@FindBy(how = How.ID, using = "requiredHours[1]")
	private WebElement certhLicenseRequiredHoursTextBox;

	// CE Requirements Total Hours For License Status
	@FindBy(how = How.ID, using = "status[1]")
	private WebElement certhLicenseStatusDropDown;

	// Add More Button
	@FindBy(how = How.ID, using = "addMore")
	private WebElement addMoreButton;

	// Back Button
	@FindBy(how = How.LINK_TEXT, using = "Back")
	private WebElement backButton;

	// Add License Button
	@FindBy(how = How.ID, using = "save")
	private WebElement addLicenseButton;

	public AddLicensePage(WebDriver driver) {
		this.driver = driver;
	}

	// License Can be added when the Status of the Individual is Active
	// No License can be added if any License for the same State and License
	// Type is exist
	public void addLicense(String al_State, String al_LicenseType,
			String al_Status, String al_OriginalIssueDate,
			String al_PhysicalCopyReceived, String al_EffectiveDate,
			String al_RenewalStatus, String al_LicenseNumber,
			String al_ExpirationDate, String al_Qualification,
			String ceReviewPeriodStartDate, String ceReviewPeriodEndDate,
			String ceReviewPeriodStatus, String cerEthicsStartDate,
			String cerEthicsRequiredHours, String cerEthicsStatus,
			String certhLicenseStart, String certhLicenseRequiredHours,
			String certhLicenseStatus) {
		// License page
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		this.al_StateDropdown.sendKeys(al_State);
		this.al_StateDropdown.click();
		this.al_LicenseTypeDropdown.click();
		this.al_LicenseTypeDropdown.sendKeys(al_LicenseType);
		this.al_LicenseTypeDropdown.click();
		this.al_StatusDropdown.sendKeys(al_Status);
		this.al_OriginalIssueDateTextBox.sendKeys(al_OriginalIssueDate);
		this.al_PhysicalCopyReceivedDropDown.sendKeys(al_PhysicalCopyReceived);
		this.al_EffectiveDateTextBox.sendKeys(al_EffectiveDate);
		this.al_RenewalStatusDropDown.sendKeys(al_RenewalStatus);
		this.al_LicenseNumberTextBox.sendKeys(al_LicenseNumber);
		this.al_ExpirationDateTextBox.sendKeys(al_ExpirationDate);
		for (String qualVal : al_Qualification.split(",")) {
			G2_Common.groupCheckBoxSelection(licGroupBox, "inputField",
					"selectedQuals", qualVal);
		}
		this.continueButton.click();

		// Additional Regulatory Requirement page if the resident State is CA -
		// California during Add individual

		G2_Common.updateField(driver, this.ceReviewPeriodStartDateTextBox,
				ceReviewPeriodStartDate);
		G2_Common.updateField(driver, this.ceReviewPeriodEndDateTextBox,
				ceReviewPeriodEndDate);
		this.ceReviewPeriodStatusDropdown.sendKeys(ceReviewPeriodStatus);
		G2_Common.updateField(driver, this.cerEthicsStartDateTextBox,
				cerEthicsStartDate);
		G2_Common.updateField(driver, this.cerEthicsRequiredHoursTextBox,
				cerEthicsRequiredHours);
		this.cerEthicsStatusDropDown.sendKeys(cerEthicsStatus);
		G2_Common.updateField(driver, this.certhLicenseStartDateTextBox,
				certhLicenseStart);
		this.certhLicenseStatusDropDown.sendKeys(certhLicenseStatus);
		G2_Common.updateField(driver, this.certhLicenseRequiredHoursTextBox,
				certhLicenseRequiredHours);

		this.saveButton.click();

	}

	public void addLicense2(String state, String licenseType, String status,
			String originalIssueDate, String physicalCopyReceived,
			String effectiveDate, String renewalStatus, String licenseNumber,
			String expirationDate, String qualification) {

		this.addLicenseButton.click();

		this.al_StateDropdown.sendKeys(state);
		this.al_StateDropdown.click();
		this.al_LicenseTypeDropdown.click();
		this.al_LicenseTypeDropdown.sendKeys(licenseType);
		this.al_LicenseTypeDropdown.click();
		this.al_StatusDropdown.sendKeys(status);
		this.al_OriginalIssueDateTextBox.sendKeys(originalIssueDate);
		this.al_PhysicalCopyReceivedDropDown.sendKeys(physicalCopyReceived);
		this.al_EffectiveDateTextBox.sendKeys(effectiveDate);
		this.al_RenewalStatusDropDown.sendKeys(renewalStatus);
		this.al_LicenseNumberTextBox.sendKeys(licenseNumber);
		this.al_ExpirationDateTextBox.sendKeys(expirationDate);
		for (String qualVal : qualification.split(",")) {
			G2_Common.groupCheckBoxSelection(licGroupBox, "inputField",
					"selectedQuals", qualVal);
		}
		this.saveButton.click();
	}

}

package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditAppointmentPage {

	private final WebDriver driver;

	// Effective Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement effectiveDateTextBox;

	// Billing Code
	@FindBy(how = How.NAME, using = "billingCode")
	private WebElement billingCodeTextBox;

	// Agent Number
	@FindBy(how = How.NAME, using = "agtNbr")
	private WebElement agentNumberTextBox;

	// Agency Code
	@FindBy(how = How.NAME, using = "agyCd")
	private WebElement agencyCodeTextBox;

	// Termination Date
	@FindBy(how = How.NAME, using = "toDate")
	private WebElement terminationDateTextBox;

	// Termination Reason
	@FindBy(how = How.NAME, using = "statusReasonCd")
	private WebElement terminationReasonDropDown;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public EditAppointmentPage(WebDriver driver) {
		this.driver = driver;

	}

	public void editAppointment(String editEffectiveDate,
			String editBillingCode, String editAgentCode, String editAgencyCode) {
		// TODO Auto-generated method stub
		G2_Common.updateField(driver, this.effectiveDateTextBox,
				editEffectiveDate);
		G2_Common.updateField(driver, this.billingCodeTextBox, editBillingCode);
		G2_Common.updateField(driver, this.agentNumberTextBox, editAgentCode);
		G2_Common.updateField(driver, this.agencyCodeTextBox, editAgencyCode);
		this.saveButton.click();

	}

}

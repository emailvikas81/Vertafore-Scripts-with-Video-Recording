package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditComplianceSupervisorPage {
	private final WebDriver driver;

	// Start Date
	@FindBy(how = How.NAME, using = "supervisionStartDate")
	private WebElement startDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "supervisionEndDate")
	private WebElement endDateTextBox;

	// Status
	@FindBy(how = How.NAME, using = "supervisorStatus")
	private WebElement statusDropDown;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveLink;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelLink;

	// OK
	@FindBy(how = How.LINK_TEXT, using = "OK")
	private WebElement okLink;

	public EditComplianceSupervisorPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editComplianceSupervisor(
			String editComplianceSupervisonStartDate,
			String editComplianceSupervisionStatus,
			String editComplianceSupervisonEndDate) {

		G2_Common.updateField(driver, this.startDateTextBox,
				editComplianceSupervisonStartDate);
		this.statusDropDown.click();
		this.statusDropDown.sendKeys(editComplianceSupervisionStatus);
		G2_Common.updateField(driver, this.endDateTextBox,
				editComplianceSupervisonEndDate);
		this.saveLink.click();
		this.okLink.click();
	}

}

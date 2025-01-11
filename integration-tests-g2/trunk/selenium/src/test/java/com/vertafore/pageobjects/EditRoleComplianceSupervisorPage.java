package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditRoleComplianceSupervisorPage {
	private final WebDriver driver;

	// Start Date
	@FindBy(how = How.NAME, using = "strDate")
	private WebElement startDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "endDate")
	private WebElement endDateTextBox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveLink;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelLink;

	public EditRoleComplianceSupervisorPage(WebDriver driver) {
		this.driver = driver;

	}

	public void editRoleToComplianceSupervisor(
			String editRoleToComplianceSupervisorStartDate) {

		G2_Common.updateField(driver, this.startDateTextBox,
				editRoleToComplianceSupervisorStartDate);
		this.saveLink.click();

	}

}

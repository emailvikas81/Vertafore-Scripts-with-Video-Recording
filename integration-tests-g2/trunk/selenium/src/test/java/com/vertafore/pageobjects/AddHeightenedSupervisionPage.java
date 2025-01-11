package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class AddHeightenedSupervisionPage {
	private final WebDriver driver;

	// From Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement fromDateTextBox;

	// To Date
	@FindBy(how = How.NAME, using = "toDate")
	private WebElement toDateTextBox;

	// Supervision Reason
	@FindBy(how = How.NAME, using = "supervisionRsnCd")
	private WebElement supervisionReasonDropDown;

	// Heightened Supervision Supervisor
	@FindBy(how = How.NAME, using = "supervisorId")
	private WebElement heightenedSupervisionSupervisorDropDown;

	// Comment
	@FindBy(how = How.NAME, using = "cmntTxt")
	private WebElement commentTextBox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.NAME, using = "Cancel")
	private WebElement cancelButton;

	public AddHeightenedSupervisionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addHeightenedSupervison(String fromDate, String toDate,
			String supervisionReason, String heightenedSupervisionSupervisor) {
		G2_Common.updateField(driver, this.fromDateTextBox, fromDate);

		this.toDateTextBox.sendKeys(toDate);
		this.supervisionReasonDropDown.click();
		this.supervisionReasonDropDown.sendKeys(supervisionReason);
		this.heightenedSupervisionSupervisorDropDown.click();
		this.heightenedSupervisionSupervisorDropDown
				.sendKeys(heightenedSupervisionSupervisor);
		this.saveButton.click();
	}


}

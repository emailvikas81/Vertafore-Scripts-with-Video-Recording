package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditHeightenedSupervisionPage {

	private final WebDriver driver;

	// From Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement updateFromDateTextBox;

	// To Date
	@FindBy(how = How.NAME, using = "toDate")
	private WebElement updateToDateTextBox;

	// Supervision Reason
	@FindBy(how = How.NAME, using = "supervisionRsnCd")
	private WebElement updateSupervisionReasonDropDown;

	// Heightened Supervision Supervisor
	@FindBy(how = How.NAME, using = "supervisorId")
	private WebElement updateHeightenedSupervisionSupervisorDropDown;

	// Comment
	@FindBy(how = How.NAME, using = "cmntTxt")
	private WebElement updateCommentTextBox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.NAME, using = "Cancel")
	private WebElement cancelButton;

	public EditHeightenedSupervisionPage(WebDriver driver) {
		this.driver = driver;

	}

	public void editHeightenedSupervison(String updateFromDate,
			String updateToDate, String updateSupervisionReason) {

		G2_Common.updateField(driver, this.updateFromDateTextBox,
				updateFromDate);
		G2_Common.updateField(driver, this.updateToDateTextBox, updateToDate);
		this.updateSupervisionReasonDropDown
				.sendKeys("updateSupervisionReason");
		this.saveButton.click();

	}

}

package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class EditBusinessProcessPage {
	private final WebDriver driver;

	// State
	@FindBy(how = How.ID, using = "state")
	private WebElement bpeStateDropDown;

	// Status
	@FindBy(how = How.ID, using = "status")
	private WebElement bpeStatusDropDown;

	// Start Date
	@FindBy(how = How.NAME, using = "startDate")
	private WebElement bpeStartDateTextBox;

	// License Type
	@FindBy(how = How.ID, using = "licenseType")
	private WebElement bpeLicenseTypeDropDown;

	// Status Reason
	@FindBy(how = How.ID, using = "statusReason")
	private WebElement bpeStatusReasonDropDown;

	// Comment
	@FindBy(how = How.ID, using = "normalText")
	private WebElement bpeCommentTextBox;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public EditBusinessProcessPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editBusinessProcess(String bpeState, String bpeStatus,
			String bpeStart, String bpeLicenseType, String bpeStatusReason,
			String bpeComment) {
		Global_Common.setDriverTimeout(driver, 50, TimeUnit.SECONDS);
		this.bpeStateDropDown.sendKeys(bpeState);
		this.bpeStatusDropDown.sendKeys(bpeStatus);
		G2_Common.updateField(driver, this.bpeStartDateTextBox, bpeStart);
		this.bpeLicenseTypeDropDown.sendKeys(bpeLicenseType);
		this.bpeStatusReasonDropDown.sendKeys(bpeStatusReason);
		G2_Common.updateField(driver, this.bpeCommentTextBox, bpeComment);
		this.saveButton.click();
	}

}

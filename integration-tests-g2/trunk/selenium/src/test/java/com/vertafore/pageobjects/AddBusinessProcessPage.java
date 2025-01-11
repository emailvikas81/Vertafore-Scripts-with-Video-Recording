package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class AddBusinessProcessPage {
	private final WebDriver driver;

	// Business Process
	@FindBy(how = How.NAME, using = "process")
	private WebElement businessProcessDropDown;

	// State
	@FindBy(how = How.ID, using = "state")
	private WebElement bpeStateDropDown;

	// Status
	@FindBy(how = How.ID, using = "status")
	private WebElement bpeStatusDropDown;

	// Start Date
	@FindBy(how = How.NAME, using = "startDate")
	private WebElement bpeStartDate;

	// License Type
	@FindBy(how = How.ID, using = "licenseType")
	private WebElement bpeLicenseTypeDropDown;

	// Status Reason
	@FindBy(how = How.ID, using = "statusReason")
	private WebElement bpeStatusReasonDropDown;

	// Comment
	@FindBy(how = How.ID, using = "normalText")
	private WebElement bpeCommentTextDropDown;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public AddBusinessProcessPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addBusinessProcess(String addBusinessProcess,
			String addBPEState, String addBPEStatus, String addBPEStart,
			String addBPELicenseType, String addBPEStatusReason,
			String addBPECommentText) {
		Global_Common.setDriverTimeout(driver, 50, TimeUnit.SECONDS);
		this.businessProcessDropDown.sendKeys(addBusinessProcess);
		this.bpeStateDropDown.sendKeys(addBPEState);
		this.bpeStatusDropDown.sendKeys(addBPEStatus);
		this.bpeStateDropDown.sendKeys(addBPEState);
		this.bpeStartDate.sendKeys(addBPEStart);
		this.bpeLicenseTypeDropDown.click();
		this.bpeLicenseTypeDropDown.sendKeys(addBPELicenseType);
		this.bpeStatusReasonDropDown.sendKeys(addBPEStatusReason);
		this.bpeCommentTextDropDown.sendKeys(addBPECommentText);
		this.saveButton.click();

	}

}

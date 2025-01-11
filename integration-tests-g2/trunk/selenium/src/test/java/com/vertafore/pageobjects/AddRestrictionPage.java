package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class AddRestrictionPage {
	private final WebDriver driver;

	// Restriction Reason
	@FindBy(how = How.NAME, using = "rstrctnTypeCd")
	private WebElement ar_RestrictionReasonDropDown;

	// Start Date
	@FindBy(how = How.NAME, using = "startDte")
	private WebElement ar_StartDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "endDte")
	private WebElement ar_EnddateTextBox;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Return Button
	@FindBy(how = How.LINK_TEXT, using = "Return")
	private WebElement returnButton;

	public AddRestrictionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addRestriction(String ar_RestrictionReason, String ar_StartDate) {
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		this.ar_RestrictionReasonDropDown.sendKeys(ar_RestrictionReason);
		G2_Common.updateField(driver, this.ar_StartDateTextBox, ar_StartDate);
		this.saveButton.click();

	}

}

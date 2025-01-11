package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class AffiliationAddRestrictionPage {

	private WebDriver driver;

	// Restriction Reason
	@FindBy(how = How.NAME, using = "rstrctnTypeCd")
	private WebElement restrictedReasonDropDown;

	// Start Date
	@FindBy(how = How.NAME, using = "startDte")
	private WebElement startDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "endDte")
	private WebElement endDateTextBox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Return
	@FindBy(how = How.LINK_TEXT, using = "Return")
	private WebElement returnButton;

	public AffiliationAddRestrictionPage(WebDriver driver) {
		this.driver = driver;

	}

	public void addRestrictionToAffiliation() {
		String restrictionReason = Global_Common
				.getEnvironmentProperty("RestrictionReason");
		this.restrictedReasonDropDown.sendKeys(restrictionReason);
		this.saveButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.returnButton.click();

	}
}

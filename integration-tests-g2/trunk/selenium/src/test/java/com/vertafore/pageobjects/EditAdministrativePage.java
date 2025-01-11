package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditAdministrativePage {
	private final WebDriver driver;

	// Start Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement adminEditFromDateTextBox;

	// Super Status
	@FindBy(how = How.NAME, using = "superStatus")
	private WebElement adminEditSuperStatusDropDown;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	public EditAdministrativePage(WebDriver driver) {
		this.driver = driver;
	}

	public void editAdministrativeSupervisor(String adminEditFromDate,
			String adminEditSuperStatus) {
		G2_Common.updateField(driver, this.adminEditFromDateTextBox,
				adminEditFromDate);
		this.adminEditSuperStatusDropDown.sendKeys(adminEditSuperStatus);
		this.saveButton.click();
	}
}
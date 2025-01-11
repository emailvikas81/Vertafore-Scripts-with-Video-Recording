package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddcomplianceSupervisorSecondPage {
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

	// Supervisor Role
	@FindBy(how = How.NAME, using = "supervisorRole")
	private WebElement supervisorRoleDropDown;

	// Individual Role
	@FindBy(how = How.NAME, using = "indvRole")
	private WebElement individualRoleDropDown;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelLink;

	// Method goes here
	public AddcomplianceSupervisorSecondPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addComplianceSupervisor(String addStartDate, String addStatus,
			String addSupervisorRole, String addIndividualRole) {

		this.startDateTextBox.sendKeys(addStartDate);
		this.statusDropDown.sendKeys(addStatus);
		this.supervisorRoleDropDown.sendKeys(addSupervisorRole);
		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('agent').disabled = false");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (this.individualRoleDropDown.isEnabled()) {

			this.individualRoleDropDown.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			this.individualRoleDropDown.sendKeys(addIndividualRole);
		}
		this.saveButton.click();
	}


}

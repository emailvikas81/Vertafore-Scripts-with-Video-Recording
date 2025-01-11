package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddRoleComplianceSupervisorPage {
	private final WebDriver driver;

	// Supervisor Role
	@FindBy(how = How.NAME, using = "supervisorRole")
	private WebElement supervisorRoleDropDown;

	// Individual Role
	@FindBy(how = How.NAME, using = "indvRole")
	private WebElement individualRoleDropDown;

	// Start Date
	@FindBy(how = How.NAME, using = "strDate")
	private WebElement startDateTextBox;

	// End Date
	@FindBy(how = How.NAME, using = "endDate")
	private WebElement endDateTextBox;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelLink;

	public AddRoleComplianceSupervisorPage(WebDriver driver) {
		this.driver = driver;

	}

	public void addRoleToComplianceSupervisor(
			String addSupervisorRoleToComplianceSupervisor,
			String addIndividualRoleToComplianceSupervisor,
			String addRoleStartDate) {

		this.supervisorRoleDropDown
				.sendKeys(addSupervisorRoleToComplianceSupervisor);
		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('agent').disabled = false");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (this.individualRoleDropDown.isEnabled()) {
			this.individualRoleDropDown.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			this.individualRoleDropDown
					.sendKeys(addIndividualRoleToComplianceSupervisor);
		}
		this.startDateTextBox.sendKeys(addRoleStartDate);
		this.saveButton.click();
	}


}

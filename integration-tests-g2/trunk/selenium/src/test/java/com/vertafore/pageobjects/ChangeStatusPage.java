package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class ChangeStatusPage {
	private final WebDriver driver;

	// Status
	@FindBy(how = How.NAME, using = "status")
	private WebElement cs_StatusDropdown;

	// Termination Date
	@FindBy(how = How.NAME, using = "terminationDate")
	private WebElement cs_TerminationDateTextBox;

	// Termination Reason
	@FindBy(how = How.NAME, using = "terminationReason")
	private WebElement cs_TerminationReasonDropdown;

	// Processing Instruction
	@FindBy(how = How.NAME, using = "apptProcInstruction")
	private WebElement cs_ProcessingInstructionDropdown;

	// Termination Initiated by State
	@FindBy(how = How.NAME, using = "initiatedByState")
	private WebElement cs_TerminationInitiatedDropdown;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// SaveButton
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Footer
	@FindBy(how = How.XPATH, using = "//body/table[2]/tbody/tr/td")
	private WebElement footerText;

	public ChangeStatusPage(WebDriver driver) {
		this.driver = driver;
	}

	public void changeStatus(String cs_Status, String cs_TerminationDate,
			String cs_TerminationReason, String cs_ProcessingInstruction,
			String cs_TerminationInitiated) {

		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		this.cs_StatusDropdown.click();
		this.cs_StatusDropdown.sendKeys(cs_Status);
		this.footerText.click();
		G2_Common.updateField(driver, this.cs_TerminationDateTextBox,
				cs_TerminationDate);
		this.cs_TerminationReasonDropdown.sendKeys(cs_TerminationReason);
		this.cs_ProcessingInstructionDropdown
				.sendKeys(cs_ProcessingInstruction);
		this.cs_TerminationInitiatedDropdown.sendKeys(cs_TerminationInitiated);
		this.saveButton.click();
	}

}

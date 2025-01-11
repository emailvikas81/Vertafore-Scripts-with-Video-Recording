package com.vertafore.pageobjects;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;

public class AddMultiStageAppointmentFirstPage {

	private static final String StateVerifiedDropDown = null;

	private final WebDriver driver;

	// Appointment States (make A list Of web element)
	@FindBy(how = How.NAME, using = "states")
	private List<WebElement> appointmentStatesCheckBoxesList;

	// Appointment companies Groupbox
	@FindBy(how = How.XPATH, using = "html/body/table/tbody/tr[2]/td/form/div[3]/div[2]/table/tbody/tr[4]/td/table")
	private List<WebElement> appointmentCompanyGroupBox;

	// Select all (Appointment States)
	@FindBy(how = How.NAME, using = "selectAllStates")
	private WebElement selectAllAppointmentStatesCheckBox;

	// Appintment Companies CheckBox
	@FindBy(how = How.NAME, using = "companies")
	private List<WebElement> appointmentCompaniesCheckBoxList;

	// Select all (Appointment Companies)
	@FindBy(how = How.NAME, using = "selectAllCompanies")
	private WebElement selectAllAppointmentCompaniesCheckBox;

	// Appointment Companies
	@FindBy(how = How.NAME, using = "html/body/table/tbody/tr[2]/td/form/div[4]/div[2]/table/tbody/tr[4]/td/table")
	private WebElement appointmentCompaniesGroupBox;

	// Appointment Status
	@FindBy(how = How.NAME, using = "status")
	private WebElement appointmentStatusDropDown;

	// State Verified
	@FindBy(how = How.NAME, using = "stateVerified")
	private WebElement stateVerifiedDropDown;

	// Renewal Date
	@FindBy(how = How.NAME, using = "renewalDate")
	private WebElement renewalDateTextBox;

	// Request Date
	@FindBy(how = How.NAME, using = "requestDate")
	private WebElement requestDateTextBox;

	// Agent Number
	@FindBy(how = How.NAME, using = "agentNumber")
	private WebElement agentNumberTextBox;

	// Agency Code
	@FindBy(how = How.NAME, using = "agencyCode")
	private WebElement agencyCodeTextBox;

	// Processing instruction(make a list of web element)
	@FindBy(how = How.NAME, using = "processingInstruction")
	private List<WebElement> processingInstructionRadioButtonsList;

	// Pause Session
	@FindBy(how = How.LINK_TEXT, using = "Pause Session")
	private WebElement pauseSessionButton;

	// Continue
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	private WebElement continueButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public AddMultiStageAppointmentFirstPage(WebDriver driver) {
		this.driver = driver;

	}

	public void addAppointmentStatesAndCompany(String appointmentStatus,
			String stateVerified, String agentNumber, String agencyCode,
			String appointmentCompanies) {

		this.selectAllAppointmentCompaniesCheckBox.click();
		this.selectCheckBox(appointmentCompanies);
		this.processingInstructionRadioButtonsList.get(1).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		this.appointmentStatusDropDown.sendKeys(appointmentStatus);
		this.stateVerifiedDropDown.sendKeys(stateVerified);
		this.agentNumberTextBox.sendKeys(agentNumber);
		this.agencyCodeTextBox.sendKeys(agencyCode);

		this.continueButton.click();

	}

	private boolean selectCheckBox(String checkBoxText) {

		List<WebElement> CHECKBOXlist = driver.findElements(By
				.xpath("//td[contains(text(), '" + checkBoxText
						+ "')]/input[@type='checkbox'] "));
		for (WebElement checkbox : CHECKBOXlist) {
			if (CHECKBOXlist.size() > 1) {
				G2_Common.APPLICATION_LOGS.info(checkBoxText
						+ " : More than one check box with specified text.");
			}
			checkbox.click(); // selects one
			System.out.println(checkbox.getAttribute("value"));
			G2_Common.APPLICATION_LOGS.info(checkBoxText + " selected");

			return true;
		}
		G2_Common.APPLICATION_LOGS.info(checkBoxText + " NOT selected");
		return false;
	}

	private boolean stateAndCompanySelection(String stateAndCompanyVal) {
		// TODO Auto-generated method stub

		List<WebElement> CHECKBOXlist = driver.findElements(By
				.xpath("//input[@type='checkbox']"));

		for (WebElement checkbox : CHECKBOXlist) {
			System.out.println(checkbox.getText());
			System.out.println(checkbox.getAttribute("innerHTML"));
			if (checkbox.getText().trim().contains(stateAndCompanyVal)) {
				checkbox.click();

			}
		}
		return false;
	}

	public String checkDataValidationErrorsMultiStateAppointmentFirstStep(
			String AddMultiStateFirstStepValidationErrors) {
		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		this.selectAllAppointmentStatesCheckBox.click();
		this.selectAllAppointmentCompaniesCheckBox.click();
		this.continueButton.click();
		String actualValidationError = global.retrieveFailureReason();
		if (actualValidationError
				.equals(AddMultiStateFirstStepValidationErrors)) {
			G2_Common.APPLICATION_LOGS
					.info("Data Validation Error is as expected.");
			System.out.println("Add Restriction");
			System.out.println(actualValidationError);
		} else {
			System.out.println(actualValidationError);
			fail("Test failed, as the expected Data Validation Error is: "
					+ AddMultiStateFirstStepValidationErrors
					+ " , actual Data Validation Error is: "
					+ actualValidationError);
		}
		return null;

	}

	public void clickOnPauseSessionButton() {
		this.pauseSessionButton.click();
	}

	public void clickOnContinueButton() {
		this.continueButton.click();
	}

}

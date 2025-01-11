package com.vertafore.pageobjects;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class CommunicationTrackingSummaryPage {
	private final WebDriver driver;

	// From Communication Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement fromCommunicationDateTextBox;

	// Communication Type
	@FindBy(how = How.NAME, using = "communicationType")
	private WebElement communicationTypeDropDown;

	// To Communication Date
	@FindBy(how = How.NAME, using = "toDate")
	private WebElement toCommunicationDateTextBox;

	// Add Communication Tracking
	@FindBy(how = How.LINK_TEXT, using = "Add Communication Tracking")
	private WebElement addCommunicationTrackingLink;

	// Filter Button
	@FindBy(how = How.LINK_TEXT, using = "Filter")
	private WebElement filterButton;

	// Clear Field Button
	@FindBy(how = How.LINK_TEXT, using = "Clear Fields")
	private WebElement clearFieldsButton;

	public CommunicationTrackingSummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void communicationTrackingSummary(String fromCommunicationDate,
			String toCommunicationDate) {

		G2_Common.updateField(driver, this.fromCommunicationDateTextBox,
				fromCommunicationDate);
		String fromDateToDateValidationErrors = Global_Common
				.getEnvironmentProperty("fromDateToDateValidationErrors");
		G2_Common.updateField(driver, this.toCommunicationDateTextBox,
				toCommunicationDate);
		this.filterButton.click();
		checkDataValidationErrors(fromDateToDateValidationErrors);
	}

	public void addCommunicationTracking() {
		this.addCommunicationTrackingLink.click();
	}

	public void checkDataValidationErrors(String expectedDataValidationErrors) {
		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		String actualValidationError = global.retrieveFailureReason();
		if (actualValidationError.equals(expectedDataValidationErrors)) {
			G2_Common.APPLICATION_LOGS
					.info("Data Validation Error is as expected.");

		} else {
			G2_Common.APPLICATION_LOGS
					.error("Test failed, as the expected Data Validation Error is: "
							+ expectedDataValidationErrors
							+ " , actual Data Validation Error is: "
							+ actualValidationError);
			fail("Test failed, as the expected Data Validation Error is: "
					+ expectedDataValidationErrors
					+ " , actual Data Validation Error is: "
					+ actualValidationError);
		}
	}

	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//div/div/table/tbody/tr", 1,
				data22);
	}

}

package com.vertafore.pageobjects;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class AddMultiStateAppointmentThirdPage {

	private final WebDriver driver;

	// Field To Populate
	@FindBy(how = How.ID, using = "prePop")
	private WebElement fieldToPopulateDropDown;

	// Value
	@FindBy(how = How.ID, using = "prePopBilling")
	private WebElement valueTextBox;

	// Populate
	@FindBy(how = How.LINK_TEXT, using = "Populate")
	private WebElement populateLink;

	// Background CheckBox
	@FindBy(how = How.NAME, using = "backgroundInvestigationIndicator")
	private WebElement backgroundCheckBox;

	// Back
	@FindBy(how = How.LINK_TEXT, using = "Back")
	private WebElement backButton;

	// Pause Session
	@FindBy(how = How.LINK_TEXT, using = "Pause Session")
	private WebElement pauseSessionButton;

	// Submit
	@FindBy(how = How.LINK_TEXT, using = "Submit")
	private WebElement submitButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Additional Required Information text box
	@FindBy(how = How.NAME, using = "questionAnswer(13111)")
	private WebElement AdditionalRequiredInformation;

	// Additional Required Information radio button 1
	@FindBy(how = How.XPATH, using = "(//input[@name='questionAnswer(13011)'])[2]")
	private WebElement appointeereceivedtrainingRadioButton1;

	// Additional Required Information radio button2
	@FindBy(how = How.XPATH, using = "xpath=(//input[@name='questionAnswer(13211)'])[2]")
	private WebElement appointeereceivedtrainingRadioButton2;
	@FindBy(how = How.XPATH, using = "html/body/table/tbody/tr[3]/td/table/tbody/tr/td[1]")
	private WebElement footerLocation;

	public AddMultiStateAppointmentThirdPage(WebDriver driver) {
		this.driver = driver;

	}

	public void populateField(String fieldToPopulate,
			String fieldToPopulateValue, String Experience) {

		this.fieldToPopulateDropDown.sendKeys(fieldToPopulate);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].checked = true;", this.valueTextBox);
		this.valueTextBox.sendKeys(fieldToPopulateValue);
		this.populateLink.click();
		this.AdditionalRequiredInformation.sendKeys(Experience);
		radioButtonselectionByValue("y");
		radioButtonselectionByValue1("N");
		// this.appointeereceivedtrainingRadioButton2.click();
		this.submitButton.click();
	}

	public String checkDataValidationErrorsMultiStateAppointmentFinalStep(
			String AddMultiStateFinalStepValidationErrors) {
		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		String dataValidationErrors = Global_Common
				.getEnvironmentProperty("AddMultiStateFinalStepValidationErrors");
		this.submitButton.click();
		String actualValidationError = global.retrieveFailureReason();
		if (actualValidationError.equals(dataValidationErrors)) {
			G2_Common.APPLICATION_LOGS
					.info("Data Validation Error is as expected.");
			System.out.println("Add Restriction");
			System.out.println(actualValidationError);
		} else {
			System.out.println(actualValidationError);
			fail("Test failed, as the expected Data Validation Error is: "
					+ dataValidationErrors
					+ " , actual Data Validation Error is: "
					+ actualValidationError);
		}
		return null;
	}

	public void radioButtonselectionByValue(String value) {
		List<WebElement> radioButtons = driver.findElements(By
				.xpath("//input[@name='questionAnswer(13011)']"));

		int iSize = radioButtons.size();

		for (int i = 0; i < iSize; i++) {

			String sValue = radioButtons.get(i).getAttribute("value");

			if (sValue.equalsIgnoreCase(value)) {

				radioButtons.get(i).click();

				// This will take the execution out of for loop

				break;

			}

		}
	}

	public void radioButtonselectionByValue1(String value) {
		List<WebElement> radioButtons = driver.findElements(By
				.xpath("//input[@name='questionAnswer(13211)']"));

		int iSize = radioButtons.size();

		for (int i = 0; i < iSize; i++) {

			String sValue = radioButtons.get(i).getAttribute("value");

			if (sValue.equalsIgnoreCase(value)) {

				radioButtons.get(i).click();

				// This will take the execution out of for loop

				break;

			}

		}
	}

	public void clickOnBackButton() {
		this.backButton.click();
	}

	public void clickOnPauseSessionButton() {
		this.pauseSessionButton.click();
	}
}

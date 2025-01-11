package com.vertafore.pageobjects;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;

public class AddMultiStateAppointmentSecondPage {

	private WebDriver driver;

	// Appointment Types
	@FindBy(how = How.NAME, using = "appointmentValue(CA~523404)")
	private List<WebElement> appointmentTypesCheckBoxesList;

	// Back
	@FindBy(how = How.LINK_TEXT, using = "Back")
	private WebElement backButton;

	// PauseSession
	@FindBy(how = How.LINK_TEXT, using = "Pause Session")
	private WebElement pauseSessionButton;

	// Continue
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	private WebElement continueButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public AddMultiStateAppointmentSecondPage(WebDriver driver) {
		this.driver = driver;

	}

	public void clickOnBackLink() {

		this.backButton.click();

	}

	public void addMultiStateAppSecondStep(String appointmentTypeSc) {

		this.continueButton.click();

	}

	public void clickOnPauseSessionLink() {
		this.pauseSessionButton.click();

	}

	private boolean appointmentTypeSC(String appTypeVal) {
		// TODO Auto-generated method stub
		List<WebElement> appTypesSCList = driver.findElements(By
				.xpath("(//input[@name='appointmentValue(SC~523404)'])"));

		System.out.println(appTypesSCList.size());
		int i = 1;
		for (WebElement appType : appTypesSCList) {
			if (appTypesSCList.get(i).getAttribute("checked") != null) {
				appTypesSCList.get(i).click();
			}
			System.out.println(appType.getAttribute("Value"));
			System.out.println(appTypeVal);
			if (appType.getAttribute("Value").trim()
					.contains(appTypeVal.trim())) {
				driver.findElement(
						By.xpath("(//input[@name='appointmentValue(SC~523404)'])["
								+ i + "]")).click();
				return true;
			}
			i++;
		}
		return false;
	}

	public void uncheckGruopBox() {

		List<WebElement> checkBoxList = driver.findElements(By
				.cssSelector("input:checked[type='checkbox']"));
		System.out.println(checkBoxList.size());
		int i = 1;
		int checkedflag = 1;
		for (WebElement appType : checkBoxList) {
			if (checkBoxList.get(i).getAttribute("checked") != null) {
				checkBoxList.get(i).click();
				if (i < (checkBoxList.size() - 1))
					i++;
			}

		}
	}

	public String checkDataValdaitonErrorsMultiStateAppSecondStep(
			String expectedDataValidationErrors) {
		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		this.uncheckGruopBox();
		this.continueButton.click();
		String actualValidationError = global.retrieveFailureReason();
		System.out.println(actualValidationError);
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
		return null;
	}

	public void clickOnContinueButton() {
		this.continueButton.click();
	}
}

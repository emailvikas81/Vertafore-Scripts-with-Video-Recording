package com.vertafore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditEmploymentHistoryPage {
	private final WebDriver driver;

	// Employer
	@FindBy(how = How.NAME, using = "employerName")
	private WebElement updateEmployerTextBox;

	// FINRA Sequence #
	@FindBy(how = How.NAME, using = "nasdSeqNbr")
	private WebElement updateFinraSequenceNumberTextBox;

	// Position Held
	@FindBy(how = How.ID, using = "positionDescription")
	private WebElement updatePositionHeldTextBox;

	// Investment Related
	@FindBy(how = How.NAME, using = "investmentRelatedInd")
	private WebElement updateInvestmentRelatedDropDown;

	// From Date
	@FindBy(how = How.NAME, using = "startDate")
	private WebElement updateStartDateTextBox;

	// To date
	@FindBy(how = How.NAME, using = "endDate")
	private WebElement updateEndDateTextBox;

	// city
	@FindBy(how = How.NAME, using = "cityName")
	private WebElement updateCityTextBox;

	// postal code
	@FindBy(how = How.NAME, using = "postalCd")
	private WebElement updatePostalCodeTextBox;

	// state
	@FindBy(how = How.NAME, using = "stateCode")
	private WebElement updateStatesDropDown;

	// country
	@FindBy(how = How.NAME, using = "country")
	private WebElement updateCountriesDropDown;

	// save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Alert Titles
	@FindBy(how = How.XPATH, using = "//div[@class='alertTitle']")
	private List<WebElement> alertTitles;

	public EditEmploymentHistoryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editEmploymentHistory(String updateemployer,
			String updatefinrasequencenumber, String updatepositionheld,
			String updateinvestmentrelated, String updatestartdate,
			String updateenddate, String updatecityname,
			String updatepostalcode, String updatestatename,
			String updatecountryname) {

		G2_Common.updateField(driver, this.updateEmployerTextBox,
				updateemployer);
		G2_Common.updateField(driver, this.updateFinraSequenceNumberTextBox,
				updatefinrasequencenumber);
		G2_Common.updateField(driver, this.updatePositionHeldTextBox,
				updatepositionheld);
		this.updateInvestmentRelatedDropDown.sendKeys(updateinvestmentrelated);
		G2_Common.updateField(driver, this.updateStartDateTextBox,
				updatestartdate);
		G2_Common.updateField(driver, this.updateEndDateTextBox, updateenddate);
		G2_Common.updateField(driver, this.updateCityTextBox, updatecityname);
		G2_Common.updateField(driver, this.updatePostalCodeTextBox,
				updatepostalcode);
		this.updateStatesDropDown.sendKeys(updatestatename);
		this.updateCountriesDropDown.sendKeys(updatecountryname);
		this.saveButton.click();
	}
}

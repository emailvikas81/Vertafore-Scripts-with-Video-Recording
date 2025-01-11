package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddEmploymentHistoryPage {
	private final WebDriver driver;

	// Employer
	@FindBy(how = How.NAME, using = "employerName")
	private WebElement employerTextBox;

	// FINRA Sequence #
	@FindBy(how = How.NAME, using = "nasdSeqNbr")
	private WebElement finraSequenceNumberTextBox;

	// Position Held
	@FindBy(how = How.ID, using = "positionDescription")
	private WebElement positionHeldTextBox;

	// Investment Related
	@FindBy(how = How.NAME, using = "investmentRelatedInd")
	private WebElement investmentRelatedDropDown;

	// From Date
	@FindBy(how = How.NAME, using = "startDate")
	private WebElement fromDateTextBox;

	// To date
	@FindBy(how = How.NAME, using = "endDate")
	private WebElement toDateTextBox;

	// city
	@FindBy(how = How.NAME, using = "cityName")
	private WebElement cityTextBox;

	// postal code
	@FindBy(how = How.NAME, using = "postalCd")
	private WebElement postalCodeTextBox;

	// state
	@FindBy(how = How.NAME, using = "stateCode")
	private WebElement statesDropDown;

	// country
	@FindBy(how = How.NAME, using = "country")
	private WebElement countriesDropDown;

	// save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public AddEmploymentHistoryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addEmploymentHistory(String addemployer,
			String addfinrasequencenumber, String addpositionheld,
			String addinvestmentrelated, String addstartdate,
			String addenddate, String addcityname, String addpostalcode,
			String addstatename, String addcountryname) {

		this.employerTextBox.sendKeys(addemployer);
		this.finraSequenceNumberTextBox.sendKeys(addfinrasequencenumber);
		this.positionHeldTextBox.sendKeys(addpositionheld);
		this.investmentRelatedDropDown.sendKeys(addinvestmentrelated);
		this.fromDateTextBox.sendKeys(addstartdate);
		this.toDateTextBox.sendKeys(addenddate);
		this.cityTextBox.sendKeys(addcityname);
		this.postalCodeTextBox.sendKeys(addpostalcode);
		this.statesDropDown.sendKeys(addstatename);
		this.countriesDropDown.sendKeys(addcountryname);
		this.saveButton.click();
	}


}

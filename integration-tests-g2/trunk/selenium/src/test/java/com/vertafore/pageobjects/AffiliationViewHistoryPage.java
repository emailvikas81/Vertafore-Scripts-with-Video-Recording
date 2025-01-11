package com.vertafore.pageobjects;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class AffiliationViewHistoryPage {

	private WebDriver driver;

	// State

	@FindBy(how = How.NAME, using = "state")
	private WebElement StateDropdown;

	// Choose Report output form

	@FindBy(how = How.NAME, using = "rptFormat")
	private WebElement ReportOutputFormDropDown;

	// Generate Report

	@FindBy(how = How.LINK_TEXT, using = "Generate Report")
	private WebElement GenerateReportLink;

	// Reset Form
	@FindBy(how = How.LINK_TEXT, using = "Reset Form")
	private WebElement ResetFormLink;

	public AffiliationViewHistoryPage(WebDriver driver) {
		this.driver = driver;

	}

	public void AssertPageTitle() {
		String ExpectedTitle = Global_Common
				.getEnvironmentProperty("Aff&AppTitle ");

		assertEquals(driver.getTitle(), ExpectedTitle);
	}

	public void ViewHistoryOfAffiliation() {
		String SelectState = Global_Common
				.getEnvironmentProperty("SelectState");
		this.StateDropdown.sendKeys(SelectState);
		this.GenerateReportLink.click();
	}

}

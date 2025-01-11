package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SummaryOfLicensesQualificationsPage {
	private final WebDriver driver;

	// Add License Link
	@FindBy(how = How.ID, using = "save")
	private WebElement addLicenseButton;

	// Add License Link
	@FindBy(how = How.XPATH, using = "save")
	private WebElement addCommentLAQ;

	public SummaryOfLicensesQualificationsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addLicense() {
		this.addLicenseButton.click();
	}
	
	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//div/div/table/tbody/tr", 1,
				data22);
	}

}

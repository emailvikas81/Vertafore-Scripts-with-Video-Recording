package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JurisdictionSummaryPage {
	private WebDriver driver;

	// Add Jurisdiction
	@FindBy(how = How.LINK_TEXT, using = "Add Jurisdiction")
	private WebElement addJurisdictionLink;

	// Method goes here
	public JurisdictionSummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddJurisdictionLink() {
		this.addJurisdictionLink.click();
	}

	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//div/div/table/tbody/tr", 1,
				data22);
	}
}

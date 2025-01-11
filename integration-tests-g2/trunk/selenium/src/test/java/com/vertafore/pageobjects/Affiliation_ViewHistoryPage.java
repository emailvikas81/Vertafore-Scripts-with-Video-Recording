package com.vertafore.pageobjects;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class Affiliation_ViewHistoryPage {

	private WebDriver driver;

	// State
	@FindBy(how = How.NAME, using = "state")
	private WebElement stateDropdown;

	// Choose Report output form
	@FindBy(how = How.NAME, using = "rptFormat")
	private WebElement reportOutputFormDropDown;

	// Generate Report
	@FindBy(how = How.LINK_TEXT, using = "Generate Report")
	private WebElement generateReportLink;

	// Reset Form
	@FindBy(how = How.LINK_TEXT, using = "Reset Form")
	private WebElement resetFormLink;

	public Affiliation_ViewHistoryPage(WebDriver driver) {
		this.driver = driver;

	}

	public void viewHistoryOfAffiliation(String selectState) {
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.stateDropdown.sendKeys(selectState);
		String oldTab = driver.getWindowHandle();
		this.generateReportLink.click();
		ArrayList<String> newTab = new ArrayList<String>(
				driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.close();
		driver.switchTo().window(oldTab);

	}

}

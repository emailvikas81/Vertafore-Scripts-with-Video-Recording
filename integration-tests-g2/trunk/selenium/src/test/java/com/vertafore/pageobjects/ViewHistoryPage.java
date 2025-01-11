package com.vertafore.pageobjects;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class ViewHistoryPage {
	private final WebDriver driver;

	// Choose report output format
	@FindBy(how = How.NAME, using = "rptFormat")
	private WebElement vhChooseReportOutputFormatDropDown;

	// Generate Report Button
	@FindBy(how = How.LINK_TEXT, using = "Generate Report")
	private WebElement vhGenerateReportButton;

	// Reset Button
	@FindBy(how = How.LINK_TEXT, using = "Reset Form")
	private WebElement vhResetButton;

	public void viewHistory(String vh_ChooseReportOutputFormat) {

		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		this.vhChooseReportOutputFormatDropDown
				.sendKeys(vh_ChooseReportOutputFormat);
		String oldTab = driver.getWindowHandle();
		this.vhGenerateReportButton.click();
		ArrayList<String> newTab = new ArrayList<String>(
				driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.close();
		driver.switchTo().window(oldTab);

	}

	public ViewHistoryPage(WebDriver driver) {
		this.driver = driver;
	}
}

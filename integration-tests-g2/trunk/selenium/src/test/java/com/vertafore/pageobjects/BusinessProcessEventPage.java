package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.Global_Common;

public class BusinessProcessEventPage {
	private final WebDriver driver;

	// Add Business Process Link
	@FindBy(how = How.ID, using = "save")
	private WebElement addBusinessProcessLink;

	// Exapnd Button
	@FindBy(how = How.XPATH, using = ".//*[@id='GB_001_image']")
	private WebElement expandButton;

	public BusinessProcessEventPage(WebDriver driver) {
		this.driver = driver;
	}

	// Calling Add Business Process Function by clicking the Link
	public void addBusinessProcess() {
		this.addBusinessProcessLink.click();
	}

	public void expandBPTree() {
		this.expandButton.click();
	}

	public void headerInfoCheck(String data22[]) {
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver,
				"//form[@id='BusProcessAndEvntsForm']/div/div/table/tbody/tr",
				1, data22);
	}
}

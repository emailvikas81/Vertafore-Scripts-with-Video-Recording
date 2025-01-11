package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class FirmAssociationPage {
	private WebDriver driver;

	// Add Firm Association Link
	@FindBy(how = How.LINK_TEXT, using = "Add Firm Association")
	private WebElement addFirmAssociationLink;

	// Method Goes here
	public FirmAssociationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddFirmAssociationLink() {
		this.addFirmAssociationLink.click();
	}
	
	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//div/div/table/tbody/tr", 1,
				data22);
	}
	
	public String validateHeader(String expectedPageHeader){
		Global_Common.setDriverTimeout(driver, 10, TimeUnit.SECONDS);
		String pageHeader = driver
				.findElement(By.cssSelector("td.bannerTitle")).getText();
		if (pageHeader.equals(expectedPageHeader)) {
			G2_Common.APPLICATION_LOGS.info("Page Header: " + pageHeader);
			return "";
		} else {
			G2_Common.APPLICATION_LOGS.info("Actual Page Header: " + pageHeader
					+ " , Expected Page Header: " + expectedPageHeader);
			return "error";
		}
		
	}
}

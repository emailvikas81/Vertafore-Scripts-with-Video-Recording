package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdditionalRegulatoryReqPage {

	private final WebDriver driver;

	// Add Additional Regulatory Requirement
	@FindBy(how = How.ID, using = "save")
	private WebElement addAdditionalRegulatoryReqLink;

	public AdditionalRegulatoryReqPage(WebDriver driver) {
		this.driver = driver;
	}

	// Clicking Add Additional Regulatory Links
	public void addRegulatoryReq() {
		this.addAdditionalRegulatoryReqLink.click();
	}
	
	public void headerInfoCheck(String data22[]){
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(
				driver,
				"//form[@id='PrdcrAddlRegltryRqmtForm']/div/div/table/tbody/tr",
				1, data22);
	}

}

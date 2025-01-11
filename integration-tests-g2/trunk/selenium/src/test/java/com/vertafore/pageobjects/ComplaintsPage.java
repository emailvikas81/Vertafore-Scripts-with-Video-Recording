package com.vertafore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ComplaintsPage {

	private WebDriver driver;

	@FindBy(how = How.CSS, using = ".InfoMessage>ul>li")
	private List<WebElement> informationMessages;

	public ComplaintsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyComplaintRecord() {

	}
	
	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//div/div/table/tbody/tr", 1,
				data22);
	}
}
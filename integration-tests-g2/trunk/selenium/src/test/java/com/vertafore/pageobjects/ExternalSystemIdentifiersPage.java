package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ExternalSystemIdentifiersPage {
	private WebDriver driver;

	// ADD External System Identifier
	@FindBy(how = How.LINK_TEXT, using = "Add External System ID")
	private WebElement addExternalSystemIdLink;

	// Edit action
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Edit')])[4]")
	private WebElement editExternalSystemIdentifierActionButton;

	public ExternalSystemIdentifiersPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddExternalsystemID() {
		this.addExternalSystemIdLink.click();
	}

	public void clickEditExternalIdentifier() {
		this.editExternalSystemIdentifierActionButton.click();
	}

	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//div/div/table/tbody/tr", 1,
				data22);
	}

}

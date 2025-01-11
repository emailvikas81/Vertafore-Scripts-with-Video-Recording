package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ErrorsAndOmissionsPage {
	private WebDriver driver;

	// Add Errors and omissions
	@FindBy(how = How.LINK_TEXT, using = "Add Errors and Omissions")
	private WebElement addErrorsAndOmissionsLink;

	// Add comment action
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Add Comment')])[2]")
	private WebElement addCommentToErrorsAndOmissionsButton;

	// Edit
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Edit')])[3]")
	private WebElement editErrorsAndOmissionsButton;

	public ErrorsAndOmissionsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddErrorsAndOmissions() {
		this.addErrorsAndOmissionsLink.click();

	}

	public void clickAddCommentToErrorsAndOmmissions() {
		this.addCommentToErrorsAndOmissionsButton.click();
	}

	public void clickEditErrorAndOmissions() {
	}

	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//div/div/table/tbody/tr", 1,
				data22);
	}

}

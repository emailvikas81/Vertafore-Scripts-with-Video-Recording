package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddBusinessProcessEventPage {
	private final WebDriver driver;

	// Select All Event
	@FindBy(how = How.NAME, using = "eventSelectAll")
	private WebElement selectAllEventCheckBox;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Expand Button
	@FindBy(how = How.XPATH, using = ".//*[@id='GB_001_image']")
	private WebElement expandButton;

	public AddBusinessProcessEventPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addBusinessProcessEvent() {
		this.selectAllEventCheckBox.click();
		this.saveButton.click();
		this.expandButton.click();

	}

	public void clickExpandButton() {
		this.expandButton.click();
	}

}

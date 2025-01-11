package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.Global_Common;

public class EditRestrictionPage {
	private final WebDriver driver;

	// End Date
	@FindBy(how = How.CLASS_NAME, using = "datepicker")
	private WebElement er_EndDateTextBox;

	// SaveButton
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Return Button
	@FindBy(how = How.LINK_TEXT, using = "Return")
	private WebElement returnButton;

	public void editRestriction(String er_EndDate) {
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		this.er_EndDateTextBox.sendKeys(er_EndDate);
		this.saveButton.click();
		this.returnButton.click();
	}

	public EditRestrictionPage(WebDriver driver) {
		this.driver = driver;
	}

}

package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditEventBusinessProcessEventPage {
	private final WebDriver driver;

	// Event Drop Down
	@FindBy(how = How.NAME, using = "businessProcessEvents[0].eventTypeCd")
	private WebElement eventDropDown;

	// Event Date Text Box
	@FindBy(how = How.NAME, using = "businessProcessEvents[0].eventDate")
	private WebElement eventDateTextBox;

	// Exapnd Button
	@FindBy(how = How.XPATH, using = ".//*[@id='GB_001_image']")
	private WebElement expandButton;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public EditEventBusinessProcessEventPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editEvent(String bpeEvent, String bpeEventDate) {

		this.eventDropDown.sendKeys(bpeEvent);
		G2_Common.updateField(driver, this.eventDateTextBox, bpeEventDate);
		this.saveButton.click();
	}
}

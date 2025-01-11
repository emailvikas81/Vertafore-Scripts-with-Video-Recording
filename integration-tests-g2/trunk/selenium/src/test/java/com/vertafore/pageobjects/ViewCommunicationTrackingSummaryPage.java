package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ViewCommunicationTrackingSummaryPage {
	private final WebDriver driver;

	// Continue Button
	@FindBy(how = How.LINK_TEXT, using = "Return")
	private WebElement returnButton;

	public ViewCommunicationTrackingSummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void viewCommunicationTracking() {
		this.returnButton.click();

	}
}

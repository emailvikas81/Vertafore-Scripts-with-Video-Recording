package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AffiliationAndappointmentSummaryPage {

	private WebDriver driver;

	// Add Single-State Appointment
	@FindBy(how = How.LINK_TEXT, using = "Add Single-State Appointment")
	private WebElement addSingleStateAppointmentLink;

	// Add Multi-State Appointment
	@FindBy(how = How.LINK_TEXT, using = "Add Multi-State Appointment")
	private WebElement addMultiStateAppointmentLink;

	// Expand Button
	@FindBy(how = How.ID, using = "GB_001_image")
	private WebElement expandButton;

	// Resume Button
	@FindBy(how = How.LINK_TEXT, using = "Resume Multi-State Appointment Session")
	private WebElement resumeMultiStateAppointmentSessionLink;

	public AffiliationAndappointmentSummaryPage(WebDriver driver) {
		this.driver = driver;

	}

	public void clickOnExpandButton() {
		this.expandButton.click();
	}

	public void clickOnAddSingleStateAppointmentLink() {
		this.addSingleStateAppointmentLink.click();

	}

	public void clickOnAddMultiStateAppointmentLink() {
		this.addMultiStateAppointmentLink.click();

	}

	public void clickOnresumeMultiStateAppointmentSessionLink() {
		this.resumeMultiStateAppointmentSessionLink.click();

	}

}

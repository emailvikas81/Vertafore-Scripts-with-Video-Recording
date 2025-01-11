package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;

public class EditCommunicationTrackingPage {
	private final WebDriver driver;

	// Subject of Communication
	@FindBy(how = How.NAME, using = "subject")
	private WebElement subjectOfCommunicationTextBox;

	// Date of Communication
	@FindBy(how = How.NAME, using = "communicationDate")
	private WebElement dateOfCommunicationTextbox;

	// Communication Type
	@FindBy(how = How.NAME, using = "communicationType")
	private WebElement communicationTypeDropDown;

	// Comments
	@FindBy(how = How.NAME, using = "comments")
	private WebElement commentsTextField;

	// Due Date
	@FindBy(how = How.NAME, using = "dueDate")
	private WebElement dueDateTextBox;

	// Follow-up User
	@FindBy(how = How.NAME, using = "followUpUser")
	private WebElement followUpUserDropDown;

	// Time of Communication
	@FindBy(how = How.NAME, using = "time")
	private WebElement timeOfCommunicationTextBox;

	// Time(AM/PM)
	@FindBy(how = How.NAME, using = "timePeriod")
	private WebElement timePeriodDropDown;

	// Completion Date
	@FindBy(how = How.NAME, using = "completionDate")
	private WebElement completionDateTextBox;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public EditCommunicationTrackingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void editCommunicationTracking(String ectSubjectOfCommunication,
			String ectDateOfCommunication, String ectCommunicationType,
			String ectComments, String ectDueDate, String ectFollowUpUser,
			String ectTimeOfCommunication, String ectTimePeriod,
			String ectCompletionDate) {

		G2_Common.updateField(driver, this.subjectOfCommunicationTextBox,
				ectSubjectOfCommunication);
		G2_Common.updateField(driver, this.dateOfCommunicationTextbox,
				ectDateOfCommunication);
		this.communicationTypeDropDown.sendKeys(ectCommunicationType);
		G2_Common.updateField(driver, this.commentsTextField, ectComments);
		G2_Common.updateField(driver, this.dueDateTextBox, ectDueDate);
		this.followUpUserDropDown.sendKeys(ectFollowUpUser);
		G2_Common.updateField(driver, this.timeOfCommunicationTextBox,
				ectTimeOfCommunication);
		this.timePeriodDropDown.sendKeys(ectTimePeriod);
		G2_Common.updateField(driver, this.completionDateTextBox,
				ectCompletionDate);
		this.saveButton.click();
	}

}

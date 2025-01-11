package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCommunicationTrackingPage {
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

	public AddCommunicationTrackingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addCommunicationTracking(String actSubjectOfCommunication,
			String actDateOfCommunication, String actCommunicationType,
			String actComments, String actDueDate, String actFollowUpUser,
			String actTimeOfCommunication, String actTimePeriod,
			String actCompletionDate) {

		this.subjectOfCommunicationTextBox.sendKeys(actSubjectOfCommunication);
		this.dateOfCommunicationTextbox.sendKeys(actDateOfCommunication);
		this.communicationTypeDropDown.sendKeys(actCommunicationType);
		this.commentsTextField.sendKeys(actComments);
		this.dueDateTextBox.sendKeys(actDueDate);
		this.followUpUserDropDown.sendKeys(actFollowUpUser);
		this.timeOfCommunicationTextBox.sendKeys(actTimeOfCommunication);
		this.timePeriodDropDown.sendKeys(actTimePeriod);
		this.completionDateTextBox.sendKeys(actCompletionDate);
		this.saveButton.click();
	}

}

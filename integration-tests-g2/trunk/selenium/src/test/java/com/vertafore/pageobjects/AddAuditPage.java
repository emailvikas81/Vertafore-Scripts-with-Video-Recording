package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class AddAuditPage {
	private final WebDriver driver;

	// Page 1 of 2
	// Auditee Type Branch
	@FindBy(how = How.XPATH, using = "//input[@name='auditeeTypeB']")
	private WebElement branchRadioButton;

	// Auditee Type LOC
	@FindBy(how = How.XPATH, using = "(//input[@name='auditeeTypeB'])[2]")
	private WebElement locRadioButton;

	// Audit Template Name
	@FindBy(how = How.ID, using = "template")
	private WebElement auditTemplateNameDropDown;

	// Individual Name
	@FindBy(how = How.ID, using = "individualName")
	private WebElement individualSugBox;

	// Loc Of Convenience
	@FindBy(how = How.ID, using = "locId")
	private WebElement locOfConvenienceDropDown;

	// NEXT Button
	@FindBy(how = How.LINK_TEXT, using = "Next")
	private WebElement nextButton;

	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Page 2 of 2
	// Audit Name
	@FindBy(how = How.NAME, using = "auditName")
	private WebElement page2AuditNameTextBox;

	// Scheduled Start Date
	@FindBy(how = How.NAME, using = "startDate")
	private WebElement page2StartDateTextBox;

	// Status
	@FindBy(how = How.NAME, using = "statusCd")
	private WebElement page2StatusDropDown;

	// Comment
	@FindBy(how = How.NAME, using = "comment")
	private WebElement page2CommentBox;

	// Scheduled Completion Date
	@FindBy(how = How.NAME, using = "completionDate")
	private WebElement page2CompletionDateTextBox;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Suggestion
	@FindBy(how = How.XPATH, using = "//div[@id='YUICONTAINER_indvId']/div/div[2]/ul/li/span")
	private WebElement suggestionResult;

	public AddAuditPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addAudit(String auditTemplateName, String cRDNo,
			String auditLocationOfConvenience, String page2AuditName,
			String page2ScheduledStartDate,
			String page2ScheduledCompletionDate, String page2Comment) {

		Global_Common.setDriverTimeout(driver, 50, TimeUnit.SECONDS);
		// Page 1
		this.locRadioButton.click();
		this.auditTemplateNameDropDown.sendKeys(auditTemplateName);
		this.individualSugBox.sendKeys(cRDNo);
		this.individualSugBox.sendKeys(cRDNo);
		this.suggestionResult.click();
		this.individualSugBox.sendKeys(Keys.TAB);
		Global_Common.setDriverTimeout(driver, 10, TimeUnit.SECONDS);
		Select se = new Select(locOfConvenienceDropDown);
		locOfConvenienceDropDown.click();
		se.selectByVisibleText(auditLocationOfConvenience);
		locOfConvenienceDropDown.sendKeys(Keys.ENTER);
		// Global_Common.setDriverTimeout(driver, 10, TimeUnit.SECONDS);
		// this.locOfConvenienceDropDown.sendKeys(Keys.ARROW_DOWN);
		// this.locOfConvenienceDropDown.sendKeys(auditLocationOfConvenience);
		// this.nextButton.click();

		// Page 2
		G2_Common.updateField(driver, page2AuditNameTextBox, page2AuditName);
		// this.page2AuditNameTextBox.sendKeys(page2AuditName);
		this.page2StartDateTextBox.sendKeys(page2ScheduledStartDate);
		this.page2CompletionDateTextBox.sendKeys(page2ScheduledCompletionDate);
		this.page2CommentBox.sendKeys(page2Comment);


		String inspectionArea=Global_Common.getEnvironmentProperty("inspectionAreaAudit");
		String orderNo=Global_Common.getEnvironmentProperty("orderNo");
		for(int i=3;i<14;i++)
		{
			String data= driver.findElement(By.xpath(".//*[@id='HG1']/tbody/tr["+i+"]/td[3]")).getText();
		//	System.out.println(data);
			if(data.equals(inspectionArea))
					{
				driver.findElement(By.xpath(".//*[@id='HG1']/tbody/tr["+i+"]/td[2]/input")).click();
				driver.findElement(By.xpath(".//*[@id='HG1']/tbody/tr["+i+"]/td[4]/input")).sendKeys(orderNo);
			}
			else{
				
			}
		}

		this.saveButton.click();
	}

}

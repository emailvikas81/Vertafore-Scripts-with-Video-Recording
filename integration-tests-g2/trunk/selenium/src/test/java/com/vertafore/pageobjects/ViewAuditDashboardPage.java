package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class ViewAuditDashboardPage {
	private final WebDriver driver;

	// Auditee Type Branch
	@FindBy(how = How.ID, using = "radiobrnch")
	private WebElement branchRadioButton;

	// Auditee Type LOC
	@FindBy(how = How.ID, using = "radioLoc")
	private WebElement locRadioButton;

	// Individual Name Suggestion Box
	@FindBy(how = How.ID, using = "indvidualNameText")
	private WebElement individualNameSuggessionBox;

	// Loc Of Convenience
	@FindBy(how = How.ID, using = "loc")
	private WebElement locOfConvenienceDropDown;

	// Primary Auditor Name
	@FindBy(how = How.ID, using = "prmAudtrNameText")
	private WebElement primaryAuditorNameNextBox;

	// Audit Status
	@FindBy(how = How.NAME, using = "auditStatus")
	private WebElement auditStatusDropDown;

	// Scheduled Start Date From
	@FindBy(how = How.NAME, using = "schdStrtdte")
	private WebElement startDateFromTextBox;

	// Search Button
	@FindBy(how = How.LINK_TEXT, using = "Search")
	private WebElement searchButton;

	// Clear Field Button
	@FindBy(how = How.LINK_TEXT, using = "Clear Fields")
	private WebElement clearFieldsButton;

	// Add Audit Link
	@FindBy(how = How.LINK_TEXT, using = "Add Audit")
	private WebElement addAuditLink;

	// Audit Profile Link
	@FindBy(how = How.LINK_TEXT, using = "Audit Profile")
	private WebElement auditProfileLink;

	// Suggestion
	@FindBy(how = How.XPATH, using = ".//*[@id='YUICONTAINER_indvidualName']/div[1]/div[2]/ul/li[1]/span[1]")
	private WebElement suggestionResult;

	public void viewAudit() {
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String vadIndividualSuggestion = Global_Common
				.getEnvironmentProperty("vad_IndividualSuggestion");

		this.locRadioButton.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		G2_Common.updateField(driver, this.individualNameSuggessionBox,
				vadIndividualSuggestion);
		this.suggestionResult.click();
		this.searchButton.click();
		this.addAuditLink.click();

	}

	public ViewAuditDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addAudit() {
		this.addAuditLink.click();

	}

}

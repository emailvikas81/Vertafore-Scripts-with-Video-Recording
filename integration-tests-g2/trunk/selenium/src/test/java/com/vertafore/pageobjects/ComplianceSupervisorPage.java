package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ComplianceSupervisorPage {
	private WebDriver driver;

	// Supervisor Status
	@FindBy(how = How.NAME, using = "supervisorStatus")
	private WebElement supervisorStatusTextBox;

	// Firm
	@FindBy(how = How.NAME, using = "firmName")
	private WebElement firmTextBox;

	// Filter
	@FindBy(how = How.LINK_TEXT, using = "Filter")
	private WebElement filterButton;

	// Clear Fields
	@FindBy(how = How.LINK_TEXT, using = "Clear Fields")
	private WebElement clearFieldsButton;

	// Add Compliance Supervisor
	@FindBy(how = How.LINK_TEXT, using = "Add Compliance Supervisor")
	private WebElement addComplianceSupervisorLink;

	// Add comment
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Add Comment')])[8]")
	private WebElement addCommentButton;

	// Add Role
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Add Role')])[8]")
	private WebElement addRoleButton;

	// Edit
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Edit')])[16]")
	private WebElement editButton;

	// Edit Role
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Edit Role')])[8]")
	private WebElement editRoleButton;

	// Supervisor's Name(Change the using Part as per the name)
	@FindBy(how = How.LINK_TEXT, using = "Mishra, Animesh")
	private WebElement supevisorNameLink;

	public ComplianceSupervisorPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddComplianceSupervisor() {

		this.addComplianceSupervisorLink.click();
	}

	public void clickAddCommentToComplianceSupervisor() {
		this.addCommentButton.click();
	}

	public void clickAddRoleToComplianceSupervisor() {
		this.addRoleButton.click();
	}

	public void editComplianceSupervisor() {

		this.editButton.click();
	}

	public void editRoleComplianceSupervisor() {

		this.editRoleButton.click();
	}

	public void clickSupervisorNameLink() {

		this.supevisorNameLink.click();
	}

	public void searchComplianceSupervisor(String supervisionStatus) {

		this.supervisorStatusTextBox.sendKeys(supervisionStatus);
		this.filterButton.click();
	}
	
	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//form[@id='ConfigureRegSupervisorForm']/div/div/table/tbody/tr", 1,
				data22);
	}

}

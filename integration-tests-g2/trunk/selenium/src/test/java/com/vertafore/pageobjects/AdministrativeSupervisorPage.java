package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdministrativeSupervisorPage {
	private final WebDriver driver;

	// Supervisor Status
	@FindBy(how = How.NAME, using = "superStatus")
	private WebElement supervisorStatusDropdown;

	// Add Administrative Supervisor Link
	@FindBy(how = How.ID, using = "save")
	private WebElement addAdminSupervisorLink;

	// Filter Button
	@FindBy(how = How.LINK_TEXT, using = "Filter")
	private WebElement filterButton;

	// Clear Field Button
	@FindBy(how = How.LINK_TEXT, using = "Clear Fields")
	private WebElement clearFieldsButton;

	public AdministrativeSupervisorPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addAdministrativeSupervisor() {
		this.addAdminSupervisorLink.click();
	}
	
	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//form[@id='SupervisorForm']/table/tbody/tr/td/div/div/table/tbody/tr", 1,
				data22);
	}
}

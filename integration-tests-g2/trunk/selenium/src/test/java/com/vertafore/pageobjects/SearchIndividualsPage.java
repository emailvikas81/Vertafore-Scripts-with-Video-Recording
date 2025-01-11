package com.vertafore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class SearchIndividualsPage {
	private final WebDriver driver;

	// Database Link
	@FindBy(how = How.XPATH, using = "//td[4]/span")
	private WebElement databaseLink;

	// Manage Individuals Link
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Manage Individuals')])[3]")
	private WebElement manageIndividualsLink;

	// Last Name
	@FindBy(how = How.NAME, using = "lastName")
	private WebElement lastName;

	// First Name
	@FindBy(how = How.NAME, using = "firstName")
	private WebElement firstName;

	// Identifier DropDown
	@FindBy(how = How.NAME, using = "identifiers")
	private WebElement identifierDropDown;

	// Identifier Textbox
	@FindBy(how = How.NAME, using = "identifiersValue")
	private WebElement identifierTextBox;

	// Search Button
	@FindBy(how = How.LINK_TEXT, using = "Search")
	private WebElement searchBtn;

	// Search Result :0 records found.
	@FindBy(how = How.XPATH, using = "//div[@id='msgValidtnDiv']/font/ul/li")
	private WebElement searchResult0Records;

	// Search Result table Lastname, Firstname
	@FindBy(how = How.XPATH, using = "//table[@id='HG1']/tbody/tr[3]/td[3]")
	private WebElement searchResultName;

	// Add Individual
	@FindBy(how = How.LINK_TEXT, using = "Add Individual")
	private WebElement addIndividual;

	public SearchIndividualsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToManageIndividuals() {
		Global_Common.setDriverTimeout(driver, 90, TimeUnit.SECONDS);
		G2_Common.mainMenuNavigation(driver, databaseLink,
				manageIndividualsLink);
	}

	public void searchIndividuals(String lastName, String firstName) {
		Global_Common.setDriverTimeout(driver, 90, TimeUnit.SECONDS);
		this.lastName.sendKeys(lastName);
		this.firstName.sendKeys(firstName);
		this.searchBtn.click();
	}

	public String searchIndividualsForHeightenedSupervision(String identifiers,
			String identifierValue) {
		Global_Common.setDriverTimeout(driver, 90, TimeUnit.SECONDS);

		G2_Common.dropdownSelection(identifierDropDown, identifiers);
		this.identifierTextBox.sendKeys(identifierValue);
		this.searchBtn.click();
		if (G2_Common.isElementPresent(this.searchResultName)) {
			if (this.searchResultName.getText().contains(identifierValue)) {
				G2_Common.APPLICATION_LOGS.info("Individual Found: "
						+ this.searchResultName.getText());
				return this.searchResultName.getText();
			}

		} else if (G2_Common.isElementPresent(this.searchResult0Records)) {
			G2_Common.APPLICATION_LOGS
					.info(this.searchResult0Records.getText());
			return this.searchResult0Records.getText();
		}
		return "";
	}

	public void addIndividual() {
		this.addIndividual.click();
	}

	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//form[@id='ConfigureIndvForm']/div[2]/div/table/tbody/tr", 1, data22);
	}
};

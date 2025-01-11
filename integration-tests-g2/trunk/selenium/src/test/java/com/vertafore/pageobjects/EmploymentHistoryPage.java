package com.vertafore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmploymentHistoryPage {
	private WebDriver driver;

	// information message
	@FindBy(how = How.CSS, using = ".InfoMessage>ul>li")
	private List<WebElement> informationMessages;

	// Employment history table
	@FindBy(how = How.XPATH, using = "//form[@id='indvEmplHistForm']/table[2]/thead/tr/td")
	private List<WebElement> employmentHistoryTable;

	@FindBy(how = How.LINK_TEXT, using = "Add Employment History")
	private WebElement addEmploymentHistoryLink;

	public EmploymentHistoryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddEmploymentHistory() {
		this.addEmploymentHistoryLink.click();
	}
	
	public void headerInfoCheck(String data22[]){
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(
				driver,
				"//div/div/table/tbody/tr",
				1, data22);
	}

}

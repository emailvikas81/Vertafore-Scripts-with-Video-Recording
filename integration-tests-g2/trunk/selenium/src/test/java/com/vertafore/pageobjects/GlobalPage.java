package com.vertafore.pageobjects;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class GlobalPage {
	private final WebDriver driver;

	// DataMissingError
	@FindBy(how = How.ID, using = "valerrors")
	private WebElement dataError;

	// Data Missing Error Exists
	@FindBy(how = How.ID, using = "valerrors")
	private List<WebElement> dataErrorExists;

	// Success Message
	@FindBy(how = How.XPATH, using = "//div[@id='msgValidtnDiv']/font/ul/li")
	private WebElement successMessage;

	// 0 records found.
	@FindBy(how = How.XPATH, using = "//div[@id='msgValidtnDiv']/font/ul/li")
	private WebElement zeroRecords;
	// Cancel Button
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	// Request Timeout Error
	@FindBy(how = How.ID, using = "errorTitle")
	private WebElement requestTimeoutError;

	// SaveButton
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	public GlobalPage(WebDriver driver) {
		this.driver = driver;
	}

	// Check Page Title
	public String validateTitle(String expectedPageTitle) {
		Global_Common.setDriverTimeout(driver, 10, TimeUnit.SECONDS);
		String pageTitle = driver.getTitle();
		if (pageTitle.equals(expectedPageTitle)) {
			G2_Common.APPLICATION_LOGS.info("Page Title: " + pageTitle);
			return "";
		} else {
			G2_Common.APPLICATION_LOGS.info("Actual Page Title: " + pageTitle
					+ " , Expected Page Title: " + expectedPageTitle);
			return "error";
		}

	}

	// Clicks cancel button & ensures navigation to previous page
	public String validateCancelOp(String expectedPageHeader) {
		cancelButton.click();
		Global_Common.setDriverTimeout(driver, 10, TimeUnit.SECONDS);
		String pageHeader = driver
				.findElement(By.cssSelector("td.bannerTitle")).getText();
		if (pageHeader.equals(expectedPageHeader)) {
			G2_Common.APPLICATION_LOGS
					.info("Cancel button operation: Status: Normal . Page Header: "
							+ pageHeader);
			return "";
		} else {
			G2_Common.APPLICATION_LOGS
					.warn("Cancel button operation: Status: Unsuccessful . Actual Page Header: "
							+ pageHeader
							+ " , Expected Page Header: "
							+ expectedPageHeader);
			return "error";
		}

	}

	// Validates Data Header content
	public String validateHeaderInformation(WebDriver driver,
			String tableXpath, int rowNo, String data[]) {
		int iRowNum, iColNum;
		WebElement element = driver.findElement(By.xpath(tableXpath));
		List<WebElement> rowCollection = element.findElements(By
				.xpath(tableXpath));
		// Here iRowNum and iColNum, to indicate Row and Column
		// numbers. It may or may not be required in real-time Test Cases.
		iRowNum = 1;
		for (WebElement rowElement : rowCollection) {
			if (iRowNum == rowNo) {
				List<WebElement> colCollection = rowElement.findElements(By
						.xpath("td"));

				iColNum = 0;
				for (WebElement colElement : colCollection) {

					if (data[iColNum] != "" && iColNum > 1) {
						// 1st 2 column doesn't contain data
						if (colElement.getText().trim().equals(data[iColNum])) {
							G2_Common.APPLICATION_LOGS.info(colElement
									.getText() + " Match!");
						} else {
							G2_Common.APPLICATION_LOGS.info(colElement
									.getText()
									+ ","
									+ data[iColNum]
									+ " didn't match!");
						}
					}
					iColNum = iColNum + 1;
				}
			}
			iRowNum = iRowNum + 1;
		}
		return "";
	}

	// Validates table content
	public String validateTable(WebDriver driver, String tableXpath, int rowNo,
			String data[]) {
		int iRowNum, iColNum, misMatch = 0;
		WebElement element = driver.findElement(By.xpath(tableXpath));
		List<WebElement> rowCollection = element.findElements(By
				.xpath(tableXpath));
		// "# of rows in table: " + rowCollection.size()
		// Here iRowNum and iColNum, to indicate Row and Column
		// numbers. It may or may not be required in real-time Test Cases.
		iRowNum = 1;
		for (WebElement rowElement : rowCollection) {
			if (iRowNum == rowNo) {
				List<WebElement> colCollection = rowElement.findElements(By
						.xpath("td"));
				iColNum = 0;
				for (WebElement colElement : colCollection) {
					if (data[iColNum] != "" && data[iColNum] != null
							&& iColNum > 1) {
						// 1st 2 column doesn't contain data
						if (!colElement.getText().trim()
								.equals(data[iColNum].trim())) {
							G2_Common.APPLICATION_LOGS
									.error("Table Validation: Actual value : "
											+ colElement.getText()
											+ ", Expected value: "
											+ data[iColNum] + " didn't match!");
							misMatch = 1;
						}
					}
					iColNum = iColNum + 1;
				}
			}
			iRowNum = iRowNum + 1;
		}
		if (misMatch != 1) {
			G2_Common.APPLICATION_LOGS
					.info("Table Validation: Successful; expected values match.");
		}
		return "";
	}

	public int searchInTable(WebDriver driver, String tableXpath, int colNo,
			String searchString) {
		int iRowNum, iColNum, Match = 0;
		WebElement element = driver.findElement(By.xpath(tableXpath));
		List<WebElement> rowCollection = element.findElements(By
				.xpath(tableXpath));
		// "# of rows in table: " + rowCollection.size()
		// Here iRowNum and iColNum, to indicate Row and Column
		// numbers. It may or may not be required in real-time Test Cases.
		iRowNum = 1;
		for (WebElement rowElement : rowCollection) {

			List<WebElement> colCollection = rowElement.findElements(By
					.xpath("td"));
			iColNum = 1;
			for (WebElement colElement : colCollection) {
				if (iColNum == colNo) {
					if (searchString != "" && searchString != null
							&& iColNum > 1) {
						// 1st 2 column doesn't contain data
						if (colElement.getText().trim()
								.equals(searchString.trim())) {
							G2_Common.APPLICATION_LOGS
									.info("Table Validation: value found."
											+ searchString);
							Match = 1;
							return iRowNum;
						}
					}
				}
				iColNum = iColNum + 1;
			}
			iRowNum = iRowNum + 1;
		}

		if (Match != 1) {
			G2_Common.APPLICATION_LOGS
					.error("Table Validation: value not found : "
							+ searchString);
		}
		return -1;
	}

	public String taskResponse() {
		Global_Common.setDriverTimeout(driver, 5, TimeUnit.SECONDS);
		if (G2_Common.isElementPresent(successMessage)) {
			G2_Common.APPLICATION_LOGS.info(this.successMessage.getText());
			return "success";
		} else if (dataErrorExists.size() > 0) {
			G2_Common.APPLICATION_LOGS.error(this.dataError.getText());
			return "error";
		}
		return "";
	}

	// Task success
	public String retrieveSuccessMessage() { // change return type
		Global_Common.setDriverTimeout(driver, 1, TimeUnit.SECONDS);
		if (G2_Common.isElementPresent(successMessage)) {
			return this.successMessage.getText();
		}
		return "";
	}

	// Error handling
	public String retrieveFailureReason() { // change return type
		Global_Common.setDriverTimeout(driver, 1, TimeUnit.SECONDS);
		if (dataErrorExists.size() > 0) {
			// System.out.println(this.DataError.getText());
			return this.dataError.getText();
		}
		return "";
	}

	// ensure 0 records found before inserting a new value?
	public String zeroRecordsMessage() { // change return type
		Global_Common.setDriverTimeout(driver, 1, TimeUnit.SECONDS);
		if (G2_Common.isElementPresent(zeroRecords)) {
			return this.zeroRecords.getText(); // "0 records found."
		}
		return "";
	}

	public String validateCommentTable(String comment, String contextType) {
		// Note: comment is pulled from Testdata properties file,
		// while the ContextType is passed by the calling method
		// Comment Table
		List<WebElement> tableContents = driver.findElements(By
				.xpath("//*[@id='ConfigureCommentForm']/table[2]/tbody/tr"));
		int found = 0;
		// Comment Table validation
		String tableText = driver.findElement(
				By.cssSelector("table.resultRendererTable")).getText();

		for (WebElement row : tableContents) {
			WebElement conType = row.findElement(By.xpath("./td[4]"));
			WebElement commText = row.findElement(By.xpath("./td[6]"));
			if (commText.getText().equals(comment)
					&& conType.getText().equals(contextType)) {
				found = 1;
				break;
			}
		}
		if (found == 1) {
			G2_Common.APPLICATION_LOGS.info("Comment successfully added : "
					+ ",Context Type : " + contextType + " , Comment : "
					+ comment);

		} else {
			G2_Common.APPLICATION_LOGS.error("Comment Not added : "
					+ ",Context Type : " + contextType + " , Comment : "
					+ comment + "\n Complete table contents: " + tableText);
		}
		return null;
	}

	public String checkDataValidationErrors(String expectedDataValidationErrors) {
		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		this.saveButton.click();
		String actualValidationError = global.retrieveFailureReason();
		if (actualValidationError.equals(expectedDataValidationErrors)) {
			G2_Common.APPLICATION_LOGS
					.info("Data Validation Error is as expected.");

		} else {
			G2_Common.APPLICATION_LOGS
					.error("Test failed, as the expected Data Validation Error is: "
							+ expectedDataValidationErrors
							+ " , actual Data Validation Error is: "
							+ actualValidationError);
			fail("Test failed, as the expected Data Validation Error is: "
					+ expectedDataValidationErrors
					+ " , actual Data Validation Error is: "
					+ actualValidationError);
		}
		return null;
	}

}

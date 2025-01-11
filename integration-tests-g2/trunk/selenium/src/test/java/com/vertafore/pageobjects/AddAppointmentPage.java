package com.vertafore.pageobjects;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;
import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class AddAppointmentPage<IWebElement> {

	private final WebDriver driver;

	// Company
	@FindBy(how = How.NAME, using = "insurerDesc")
	private WebElement companyTextBox;

	// Company value selection
	@FindBy(how = How.XPATH, using = ".//*[@id='YUICONTAINER_insurerId']/div[1]/div[2]/ul/li[1]")
	private WebElement companyValueToBeClicked;

	// State
	@FindBy(how = How.NAME, using = "stCd")
	public WebElement stateDropDown;

	// State List
	@FindBy(how = How.NAME, using = "stCd")
	private List<WebElement> stateDropDownList;

	// producer type
	@FindBy(how = How.NAME, using = "scApptCategoryCd")
	private WebElement producerTypeDropdown;

	// Appointment Type
	@FindBy(how = How.NAME, using = "selectedApptTypes")
	private WebElement appointmentTypeCheckBox;

	@FindBy(how = How.NAME, using = "//*[@id='AppointmentForm']/div[3]/div[2]/table/tbody/tr[4]/td[3]/table/tbody/tr/td")
	private WebElement appointmentTypeGroupBox;

	// Effective Date
	@FindBy(how = How.NAME, using = "fromDate")
	private WebElement effectiveDateTextBox;

	// Request Date
	@FindBy(how = How.NAME, using = "requestDate")
	private WebElement requestDateTextBox;

	// Billing Code
	@FindBy(how = How.NAME, using = "billingCode")
	private WebElement billingCodeTextBox;

	// Agent Number
	@FindBy(how = How.NAME, using = "agtNbr")
	private WebElement agentNumberTextBox;

	// Agency Code
	@FindBy(how = How.NAME, using = "agyCd")
	private WebElement agencyCodeTextBox;

	// Partners
	@FindBy(how = How.NAME, using = "distributorText")
	private WebElement partnersTextBox;

	// Processing Instructions Radio button(Record only)
	@FindBy(how = How.XPATH, using = "//input[@name='processImmediately'][3]")
	private WebElement recordOnlyRadioButton;

	// processing instruction list
	@FindBy(how = How.XPATH, using = "table[@id='formProcessingTable']/tbody/tr/td[2]")
	private List<WebElement> processingInstructionsList;

	// BackGround Investigation
	@FindBy(how = How.NAME, using = "requestBICheck")
	private WebElement backgroundCheckBox;

	// Add Single-State Appointment
	@FindBy(how = How.LINK_TEXT, using = "Add Single-State Appointment")
	private WebElement addSingleStateAppointmentLink;

	// Footer
	@FindBy(how = How.XPATH, using = "html/body/table/tbody/tr[3]/td/table/tbody/tr/td[1]")
	private WebElement footerClick;

	// Save
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Cancel
	@FindBy(how = How.LINK_TEXT, using = "Cancel")
	private WebElement cancelButton;

	public AddAppointmentPage(WebDriver driver) {
		this.driver = driver;

	}

	public void addSingleStateAppointment(String company, String state,
			String appointmentType, String billingCode, String agentCode,
			String agencyCode, String producerType,
			String ProcessingInstructions, String aaAPIDisabled) {
		String firstLetter = String.valueOf(company.charAt(0));
		this.companyTextBox.sendKeys(firstLetter); // Pass the 1st char
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		List<WebElement> findElements = driver
				.findElements(By
						.xpath("//*[@id='YUICONTAINER_insurerId']/div[1]/div[2]/ul/li"));
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//*[@id='YUICONTAINER_insurerId']/div[1]/div[2]/ul/li")));
		for (WebElement webElement : findElements) {
			if (webElement.getText().equals(company)) {
				webElement.click();
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("#stCd")));
		try {
			selectStateDropDown(state);
			// Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.cssSelector(".inputField")));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			G2_Common.APPLICATION_LOGS.error(e);
			e.printStackTrace();
		}
		if (state.equals("SC - South Carolina")) {
			this.producerTypeDropdown.sendKeys(producerType);
			this.footerClick.click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector(".inputField")));
		if (this.appointmentTypeCheckBox.isDisplayed()) {

			for (String appTypeVal : appointmentType.split(",")) {
				appointmentTypeSelection(appTypeVal);
				// Global_Common.selectCheckBox(driver, appTypeVal);
			}

		} else {
			G2_Common.APPLICATION_LOGS
					.error("Appointment Type CheckBox not displayed");

		}

		this.billingCodeTextBox.sendKeys(billingCode);
		this.agentNumberTextBox.sendKeys(agentCode);
		this.agencyCodeTextBox.sendKeys(agencyCode);

		if (!state.equals("AK - Alaska")) 
		{
			this.backgroundCheckBox.click();
		}
		G2_Common.checkRadioButtonEnabled(driver, aaAPIDisabled);
		// this.recordOnlyRadioButton.click();
		if (ProcessingInstructions != null
				&& !ProcessingInstructions.equals("")) {
			G2_Common.selectRadioButton(driver, ProcessingInstructions);
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		this.saveButton.click();

	}

	public String selectStateDropDown(String state) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		clickAnElementByName("stCd");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		this.stateDropDown.sendKeys(state);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		this.stateDropDown.click();
		this.footerClick.click();
		Select se = new Select(this.stateDropDown);
		if (se.getFirstSelectedOption().getText() == null) {
			G2_Common.APPLICATION_LOGS.error("State Dropdown has no values!!");
			return null;
		}
		if (!se.getFirstSelectedOption().getText().equals(state)) {
			WebElement stateDropDown2 = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(By
							.name("stCd")));
			this.stateDropDown.click();

			dropdownSelectionByVisibleText(driver, this.stateDropDown, state);
			if (!se.getFirstSelectedOption().getText().equals(state)) {
				this.stateDropDown.click();
				G2_Common.dropdownSelection(this.stateDropDown, state);
				System.out.println("3rd"
						+ se.getFirstSelectedOption().getText());
				if (!se.getFirstSelectedOption().getText().equals(state)) {
					G2_Common.APPLICATION_LOGS
							.error("State Dropdown Gave up!!");
				}
			}
		}
		return state;
	}

	public static boolean dropdownSelectionByVisibleText(WebDriver driver,
			WebElement dropDown, String valueToSelect) {
		Global_Common.setDriverTimeout(driver, 90, TimeUnit.SECONDS);
		Select se = new Select(dropDown);
		dropDown.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		se.selectByVisibleText(valueToSelect);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		dropDown.sendKeys(Keys.TAB);
		WebElement selectedOption = se.getFirstSelectedOption();
		if (selectedOption.getText().equals(valueToSelect)) {
			return true;
		}
		return false;
	}

	private boolean appointmentTypeSelection(String appTypeVal) {
		List<WebElement> appTypesList;
		Boolean iselementpresent = driver
				.findElements(
						By.xpath("//*[@id='AppointmentForm']/div[3]/div[2]/table/tbody/tr[4]/td[3]/table/tbody/tr/td"))
				.size() != 0;
		if (iselementpresent == true) {
			appTypesList = driver
					.findElements(By
							.xpath("//*[@id='AppointmentForm']/div[3]/div[2]/table/tbody/tr[4]/td[3]/table/tbody/tr/td"));

			int i = 1;
			for (WebElement appType : appTypesList) {
				if (appType.getText().trim().contains(appTypeVal.trim())) {
					driver.findElement(
							By.xpath("//*[@id='AppointmentForm']/div[3]/div[2]/table/tbody/tr[4]/td[3]/table/tbody/tr/td["
									+ i + "]/input")).click();
					return true;
				}
				i++;
			}
			return false;
		} else {
			appTypesList = driver
					.findElements(By
							.xpath(".//*[@id='AppointmentForm']/div[3]/div[2]/table/tbody/tr[5]/td[3]"));
		}
		int i = 1;
		for (WebElement appType : appTypesList) {
			if (appType.getText().trim().contains(appTypeVal.trim())) {
				driver.findElement(
						By.xpath("//*[@id='AppointmentForm']/div[3]/div[2]/table/tbody/tr[5]/td[3]/table/tbody/tr[1]/td["
								+ i + "]/input")).click();
				return true;
			}
			i++;
		}
		return false;
	}

	public WebElement getWhenVisible(By locator, int timeout) {

		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));

		return element;

	}

	public String checkDataValidationErrorsAddSingleStateAppointment(
			String companyVal, String stateVal, String dataValidationErrors) {
		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		String firstLetter = String.valueOf(companyVal.charAt(0));
		this.companyTextBox.sendKeys(firstLetter); // Pass the 1st char
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		List<WebElement> findElements = driver
				.findElements(By
						.xpath("//*[@id='YUICONTAINER_insurerId']/div[1]/div[2]/ul/li"));
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//*[@id='YUICONTAINER_insurerId']/div[1]/div[2]/ul/li")));
		for (WebElement webElement : findElements) {
			if (webElement.getText().equals(companyVal)) {
				webElement.click();
				break;
			}
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("#stCd")));
		try {
			selectStateDropDown(stateVal);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.linkText("Save")));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			G2_Common.APPLICATION_LOGS.error(e);
			e.printStackTrace();
		}
		this.footerClick.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("Save")));
		this.saveButton.click();
		String actualValidationError = global.retrieveFailureReason();
		if (actualValidationError.equals(dataValidationErrors)) {
			G2_Common.APPLICATION_LOGS
					.info("Data Validation Error is as expected.");
		} else {
			fail("Test failed, as the expected Data Validation Error is: "
					+ dataValidationErrors
					+ " , actual Data Validation Error is: "
					+ actualValidationError);
		}
		return null;
	}

	public static boolean groupCheckBoxSelectionAA(WebElement groupBoxElement,
			String checkBoxName, String value) {

		List<WebElement> checkBoxElements = groupBoxElement.findElements(By
				.name(checkBoxName));
		int blank = 0;
		for (int i = 0; i < checkBoxElements.size(); i++) {
			if (checkBoxElements.get(i).getText().equals("")) {
				blank++;
			}
			if (checkBoxElements.get(i).getText().equals(value)) {
				if (!checkBoxElements.get(i - blank).isSelected()) {
					checkBoxElements.get(i - blank).click();
					G2_Common.APPLICATION_LOGS.info(value + " selected");
					return true;
				} else {
					G2_Common.APPLICATION_LOGS
							.info(value + " already selected");
					return true;
				}
			}
		}
		G2_Common.APPLICATION_LOGS.info(value + " NOT selected !!");
		return false;
	}

	public void clickAnElementByName(String name) {
		WebDriverWait delay = new WebDriverWait(driver, 60);
		delay.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
		driver.findElement(By.name(name)).click();
	}

	public String validateAppointmentTable(WebDriver driver, String tableXpath,
			String company, String data[]) {
		int iRowNum, iColNum, Match = 0;
		String data2[] = data;
		WebElement element = driver.findElement(By.xpath(tableXpath));
		List<WebElement> rowCollection = element.findElements(By
				.xpath(tableXpath));
		iRowNum = 1;
		for (WebElement rowElement : rowCollection) {
			// if (iRowNum == rowNo) {
			List<WebElement> colCollection = rowElement.findElements(By
					.xpath("td"));
			iColNum = 0;
			for (WebElement colElement : colCollection) {
				if (data[iColNum] != "" || data[iColNum] != null && iColNum > 1) {
					// search company in Affiliations table
					if (colElement.getText().trim().equals(company.trim())) {
						G2_Common.APPLICATION_LOGS
								.info("Table Validation: value found : "
										+ company + " , Row number : "
										+ iRowNum);
						Match = 1;
						break;
					}
				}
				iColNum = iColNum + 1;
			}
		}

		if (Match == 1) {

			driver.findElement(
					By.xpath("//*[@id='GB_00" + iRowNum + "_image']")).click(); // expand
																				// the
																				// affiliation
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			for (String appTypeVal : data[2].split(",")) {
				data2[2] = appTypeVal;
				// search state in appointments table & get the row number
				int rowNo = global.searchInTable(driver, "//*[@id='Table"
						+ iRowNum + "']/tbody/tr", 3, appTypeVal);
				// validate table for selected row number
				global.validateTable(driver, "//*[@id='Table" + iRowNum
						+ "']/tbody/tr", rowNo, data2);
			}
		}
		return "";
	}

}

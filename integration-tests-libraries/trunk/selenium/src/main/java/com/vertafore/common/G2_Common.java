package com.vertafore.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Strings;

public class G2_Common {
	public static final Logger SELENIUM_LOGS = Logger.getRootLogger();
	public static final Logger APPLICATION_LOGS = Logger
			.getLogger("devpinoyLogger");

	public static void login(WebDriver driver, String accountID, String username) {
		String envUrl = Global_Common
				.getEnvironmentProperty("g2.environment.url") + accountID;
		driver.get(envUrl);
		driver.findElement(By.name("ssousername")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(
				Global_Common.getEnvironmentProperty("accountID." + accountID
						+ "." + username + ".password"));
		driver.findElement(
				By.xpath("//*[@id='Table2']/tbody/tr/td/form/div/table[1]/tbody/tr[5]/td[2]/a"))
				.click();
		waitForPageToLoad(driver);
	}

	public static void loginProducerPortal(WebDriver driver,
			String usernameProducerPortal, String environment) {
		String envUrl = Global_Common
				.getEnvironmentProperty("g2.producer.portal.url");
		driver.get(envUrl);
		driver.findElement(By.name("username"))
				.sendKeys(usernameProducerPortal);
		driver.findElement(By.name("password")).sendKeys(
				Global_Common.getEnvironmentProperty(usernameProducerPortal
						+ ".password"));

		if (environment.equalsIgnoreCase("PROD")) {
			driver.findElement(
					By.xpath("/html/body/table/tbody/tr[2]/td/form/table/tbody/tr[4]/td[2]/table/tbody/tr[5]/td/input"))
					.click();
		} else {
			driver.findElement(
					By.xpath("/html/body/table/tbody/tr[2]/td/form/table/tbody/tr[4]/td[2]/table/tbody/tr[6]/td/input"))
					.click();
		}
		waitForPageToLoad(driver);
	}

	public static WebDriver getPast408(WebDriver driver, String accountID,
			String userName) {
		int limit = 0;
		while (exists408(driver) && limit < 10) {
			Global_Common.endTestCase(driver);
			driver = Global_Common.loadWebDriver();
			G2_Common.login(driver, accountID, userName);
			limit++;
		}
		if (limit >= 10) {
			fail("408 error, please run test again.");
		}
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver getPast408ProducerPortal(WebDriver driver,
			String usernameProducerPortal, String environment) {
		int limit = 0;
		while (exists408(driver) && limit < 10) {
			Global_Common.endTestCase(driver);
			driver = Global_Common.loadWebDriver();
			G2_Common.loginProducerPortal(driver, usernameProducerPortal,
					environment);
			limit++;
		}
		if (limit >= 10) {
			fail("408 error, please run test again.");
		}
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		return driver;
	}

	private static boolean exists408(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath("//*[@id='sign']"));

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void waitForPageToLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 90);
		try {
			wait.until(pageLoad);
		} catch (Throwable pageLoadWaitError) {
			fail("Timeout during page load");
		}
	}

	public static void testEnvModulesTest(List<WebElement> moduleCells,
			WebDriver driver) {
		for (int i = 0; i < moduleCells.size(); i++) {
			driver.get(Global_Common.getEnvironmentProperty("g2.root.url")
					+ Global_Common.getEnvironmentProperty("module." + i));
			waitForPageToLoad(driver);

			switch (i) {
			case 0:
				assertEquals(
						"Employment Module",
						true,
						driver.findElement(
								By.xpath("//*[@id='tableHead']/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			case 1:
				assertEquals(
						"Database Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[2]/td/form/div[2]/div[2]/table[1]/tbody/tr[1]/td[2]"))
								.isDisplayed());
				break;
			case 2:
				break;
			case 3:
				assertEquals(
						"Toolkit Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[3]/td/form/div[4]/div[2]/table[1]/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			case 4:
				assertEquals(
						"Admin Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[3]/td/form/div[4]/div[2]/table/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			}
			driver.get(Global_Common.getEnvironmentProperty("g2.root.url")
					+ "/rpts/serviceRouter.do?action=process&targetModule=HOME&targetSubModule=HOMEPAGE&targetComponent=&targetService=");
			waitForPageToLoad(driver);
		}
	}

	public static void uatEnvModulesTest(List<WebElement> moduleCells,
			WebDriver driver) {
		for (int i = 0; i < moduleCells.size(); i++) {
			driver.get(Global_Common.getEnvironmentProperty("g2.root.url")
					+ Global_Common.getEnvironmentProperty("module." + i));
			waitForPageToLoad(driver);

			switch (i) {
			case 0:
				assertEquals(
						"Reports Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[2]/td/form/div[3]/div[2]/table[1]/tbody/tr[1]/td[2]"))
								.isDisplayed());
				break;
			case 1:
				assertEquals(
						"Admin Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[3]/td/form/div[4]/div[2]/table/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			case 2:
				assertEquals(
						"Configuration Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[2]/td/form/div[2]/div[2]/table[1]/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			}
			driver.get(Global_Common.getEnvironmentProperty("g2.root.url")
					+ "/rpts/serviceRouter.do?action=process&targetModule=HOME&targetSubModule=HOMEPAGE&targetComponent=&targetService=");
			waitForPageToLoad(driver);
		}
	}

	public static void preprodEnvModulesTest(List<WebElement> moduleCells,
			WebDriver driver) {
		for (int i = 0; i < moduleCells.size(); i++) {
			driver.get(Global_Common.getEnvironmentProperty("g2.root.url")
					+ Global_Common.getEnvironmentProperty("module." + i));
			waitForPageToLoad(driver);

			switch (i) {
			case 0:
				assertEquals(
						"Employment Module",
						true,
						driver.findElement(
								By.xpath("//*[@id='tableHead']/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			case 1:
				assertEquals(
						"Database Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[2]/td/form/div[2]/div[2]/table[1]/tbody/tr[1]/td[2]"))
								.isDisplayed());
				break;
			case 2:
				// Reports Module
				break;
			case 3:
				assertEquals(
						"Toolkit Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[3]/td/form/div[4]/div[2]/table[1]/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			case 4:
				assertEquals(
						"Admin Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[3]/td/form/div[4]/div[2]/table/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			}
			driver.get(Global_Common.getEnvironmentProperty("g2.root.url")
					+ "/rpts/serviceRouter.do?action=process&targetModule=HOME&targetSubModule=HOMEPAGE&targetComponent=&targetService=");
			waitForPageToLoad(driver);
		}
	}

	public static void prodEnvModulesTest(List<WebElement> moduleCells,
			WebDriver driver) {
		for (int i = 0; i < moduleCells.size(); i++) {
			driver.get(Global_Common.getEnvironmentProperty("g2.root.url")
					+ Global_Common.getEnvironmentProperty("module." + i));
			waitForPageToLoad(driver);

			switch (i) {
			case 0:
				assertEquals(
						"Reports Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[2]/td/form/div[3]/div[2]/table[1]/tbody/tr[1]/td[2]"))
								.isDisplayed());
				break;
			case 1:
				assertEquals(
						"Admin Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[3]/td/form/div[4]/div[2]/table/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			case 2:
				assertEquals(
						"Configuration Module",
						true,
						driver.findElement(
								By.xpath("/html/body/table/tbody/tr[2]/td/form/div[2]/div[2]/table[1]/tbody/tr[1]/td[1]"))
								.isDisplayed());
				break;
			}
			driver.get(Global_Common.getEnvironmentProperty("g2.root.url")
					+ "/rpts/serviceRouter.do?action=process&targetModule=HOME&targetSubModule=HOMEPAGE&targetComponent=&targetService=");
			waitForPageToLoad(driver);
		}
	}

	public static String infoVersionServerNumber(WebDriver driver, String url)
			throws Exception {
		driver.get(url);
		int locationFound = 0;
		for (int i = 1; i < 10; i++) {
			String labelFound = driver.findElement(
					By.xpath("//*[@id='buildInfo']/p[2]/span[" + i + "]"))
					.getText();
			if (labelFound.equals("Server:")) {
				locationFound = i + 1;
				break;
			}
		}
		String serverNumber = driver.findElement(
				By.xpath("//*[@id='buildInfo']/p[2]/span[" + locationFound
						+ "]")).getText();
		return serverNumber;
	}

	public static boolean isElementPresent(WebElement we) {
		try {
			we.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			// APPLICATION_LOGS.error("Element does not exist.");
			return false;
		}
	}

	public static void mainMenuNavigation(WebDriver driver,
			WebElement mainMenu, WebElement subMenu) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String prevPage = driver.getTitle();

		// String PrevPageHeader = GetPageHeader(driver);

		Actions action = new Actions(driver);
		action.moveToElement(mainMenu).perform();
		action.click(subMenu).perform();
		String currPage = driver.getTitle();

		// String CurrPageHeader = GetPageHeader(driver);
		APPLICATION_LOGS.info("Navigated from " + prevPage + " Page to "
				+ currPage + " Page.");
		// Global_Common.APPLICATION_LOGS.info("Navigated from " +
		// PrevPageHeader + " Page to " + CurrPageHeader + " Page.");
	}

	public static String getPageHeader(WebDriver driver) {
		String pageHeader = null;

		// if(isElementPresent(driver.findElement(By.cssSelector("table.bannerTable.0.0")))){
		// PageHeader =
		// driver.findElement(By.cssSelector("table.bannerTable.0.0")).getText();
		// }else
		if (isElementPresent(driver.findElement(By
				.cssSelector("span.bannerTitle")))) {
			pageHeader = driver.findElement(By.cssSelector("span.bannerTitle"))
					.getText();
		} else if (isElementPresent(driver.findElement(By
				.cssSelector("td.bannerTitle")))) {
			pageHeader = driver.findElement(By.cssSelector("td.bannerTitle"))
					.getText();
		} else {
			pageHeader = "";
		}

		return pageHeader;
	}

	public static void navigateTo(WebDriver driver, String selectLink) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// String prevPage = driver.getTitle();
		String prevPage = driver.findElement(By.cssSelector("td.bannerTitle"))
				.getText();
		WebElement menu = driver.findElement(By
				.xpath("//*[@id='KF_ITEM_0']/img")); // menu on search
														// individual page
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebElement submenu2 = driver.findElement(By.linkText(selectLink));
		action.click(submenu2).perform();
		// String currPage = driver.getTitle();
		String currPage = driver.findElement(By.cssSelector("td.bannerTitle"))
				.getText();
		APPLICATION_LOGS.info("Navigated from " + prevPage + " Page to "
				+ currPage + " Page.");
	}

	public static void navigateToLevel(WebDriver driver,
			WebElement moveOverObject, String secondRowValue, String selectLink) {
		// driver,SecondRowValue,"//div[@id='KF_ITEM_0_0']/img","Edit"
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// String prevPage = driver.getTitle();
		String prevPage = driver.findElement(By.cssSelector("td.bannerTitle"))
				.getText();
		// traverse through table, 1st search matching second row value & them
		// mouse-hover
		WebElement menu = driver.findElement(By
				.xpath("//div[@id='KF_ITEM_0_0']/img")); // menu on search
															// individual page
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebElement submenu2 = driver.findElement(By.linkText(selectLink));
		action.click(submenu2).perform();
		// String currPage = driver.getTitle();
		String currPage = driver.findElement(By.cssSelector("td.bannerTitle"))
				.getText();
		APPLICATION_LOGS.info("Navigated from " + prevPage + " Page to "
				+ currPage + " Page.");
	}

	public static void navigateToMenu(WebDriver driver,
			WebElement moveOverObject, String selectLink) {
		// driver,SecondRowValue,"//div[@id='KF_ITEM_0_0']/img","Edit"
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// String prevPage = driver.getTitle();
		String prevPage = driver.findElement(By.cssSelector("td.bannerTitle"))
				.getText();
		// traverse through table, 1st search matching second row value & them
		// mouse-hover
		// WebElement menu =
		// driver.findElement(By.xpath("//div[@id='KF_ITEM_0_0']/img")); // menu
		// on search individual page
		Actions action = new Actions(driver);
		action.moveToElement(moveOverObject).perform();
		WebElement submenu2 = driver.findElement(By.linkText(selectLink));
		action.click(submenu2).perform();
		// String currPage = driver.getTitle();
		String currPage = driver.findElement(By.cssSelector("td.bannerTitle"))
				.getText();
		APPLICATION_LOGS.info("Navigated from " + prevPage + " Page to "
				+ currPage + " Page.");
	}

	public static void actionsNavigateTo(WebDriver driver, String selectLink) {
		String prevPage, currPage;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		prevPage = driver.getTitle();

		WebElement menu = driver.findElement(By.xpath("//img[@alt='Menu']")); // Actions
																				// icon
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		WebElement submenu2 = driver.findElement(By.linkText(selectLink));
		action.click(submenu2).perform();
		// String currPage = driver.getTitle();
		// currPage = driver.findElement(By.cssSelector("td.bannerTitle"))
		// .getText();

		currPage = driver.getTitle();

		APPLICATION_LOGS.info("Navigated from " + prevPage + " Page to "
				+ currPage + " Page.");
		// try { // Any validation?
		// assertEquals(SelectLink, driver.getTitle());
		// } catch (Error e) {
		// System.out.println(e.toString());
		// }
	}

	public static boolean updateField(WebDriver driver, WebElement we,
			String value) {
		Global_Common.setDriverTimeout(driver, 15, TimeUnit.SECONDS);
		String previousVal = we.getText(); // getText not capturing value!
		if (value != "") {
			we.clear();
			we.sendKeys(value);
			/*
			 * if(we.getText().equals(Value)){
			 * Global_Common.APPLICATION_LOGS.info("Field value updated. to: " +
			 * Value + ", from : " + PreviousVal); return true;} else {
			 * Global_Common
			 * .APPLICATION_LOGS.info("Field value not updated. to: " + Value +
			 * ", Field value is : " + we.getText() );
			 * fail("Field value not updated. to: " + Value +
			 * ", Field value is : " + we.getText() ); return false; }
			 */
			return true;
		}
		return false;
	}

	public static boolean dropdownSelection(WebElement dropDown,
			String valueToSelect) {
		Select se = new Select(dropDown);
		// we.click();//this is for jurisdiction , where the displayed & listed
		// values are different - dynamic
		// System.out.println(dropDown.getText());

		se.selectByValue(valueToSelect);
		WebElement selectedOption = se.getFirstSelectedOption();
		if (selectedOption.getText().equals(valueToSelect)) {
			return true;
		}
		return false;
	}

	public static boolean dropdownSelectionByVisibleText(WebDriver driver,
			WebElement dropDown, String valueToSelect) {
		Global_Common.setDriverTimeout(driver, 90, TimeUnit.SECONDS);
		Select se = new Select(dropDown);
		dropDown.click();// this is for jurisdiction , where the displayed &
							// listed
		// values are different - dynamic
		// System.out.println(dropDown.getText());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		se.selectByVisibleText(valueToSelect);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dropDown.sendKeys(Keys.ENTER);
		// Note: Hitting enter key can have various implications
		WebElement selectedOption = se.getFirstSelectedOption();
		if (selectedOption.getText().equals(valueToSelect)) {
			return true;
		}
		return false;
	}

	public static String dropdownSelectionByIndex(WebElement we,
			int indexToSelect) {
		Select se = new Select(we);
		// we.click();
		// System.out.println(we.getText());
		se.selectByIndex(indexToSelect);
		WebElement selectedOption = se.getFirstSelectedOption();
		// if (SelectedOption.getText().equals(ValueToSelect)){
		return selectedOption.getText();
		// }
		// return false;
	}

	public static String bambooLatestBuildNumber(WebDriver driver,
			String urlBambooLatestBuildResults) {
		if (Strings.isNullOrEmpty(System.getenv("BUILD_NUMBER"))) {
			if (urlBambooLatestBuildResults != null) {
				driver.get(urlBambooLatestBuildResults);
				String pageSource = driver.getPageSource();
				pageSource = pageSource.replace(
						System.getProperty("line.separator"), "");
				Pattern pattern = Pattern
						.compile("<buildNumber>\\s*([0-9]+)\\s*</buildNumber>");
				Matcher matcher = pattern.matcher(pageSource);
				matcher.find();
				return matcher.group(1);
			}
		} else {
			return System.getenv("BUILD_NUMBER");
		}
		return null;
	}

	public static boolean groupCheckBoxSelection(WebElement groupBoxElement,
			String lableClassName, String checkBoxName, String value) {

		List<WebElement> labelElements = groupBoxElement.findElements(By
				.className(lableClassName));
		List<WebElement> checkBoxElements = groupBoxElement.findElements(By
				.name(checkBoxName));
		int blank = 0;
		for (int i = 0; i < labelElements.size(); i++) {
			if (labelElements.get(i).getText().equals("")) {
				blank++;
			}
			if (labelElements.get(i).getText().equals(value)) {
				if (!checkBoxElements.get(i - blank).isSelected()) {
					checkBoxElements.get(i - blank).click();
					APPLICATION_LOGS.info(value + " checkbox selected");
					return true;
				} else {
					APPLICATION_LOGS.info(value + " checkbox already selected");
					return true;
				}
			}
		}
		APPLICATION_LOGS.error(value + " checkbox NOT selected !!");
		return false;
	}

	public static boolean selectCheckBox(WebDriver driver, String checkBoxText) {
		// not suited if 2 checkboxes having same label/text
		List<WebElement> checkBoxList = driver.findElements(By
				.xpath("//td[contains(text(), '" + checkBoxText
						+ "')]/input[@type='checkbox'] "));
		for (WebElement checkbox : checkBoxList) {
			if (checkBoxList.size() > 1) {
				APPLICATION_LOGS.info(checkBoxText
						+ " : More than one check box with specified text.");
			}
			checkbox.click(); // selects one
			APPLICATION_LOGS.info(checkBoxText + " selected");

			return true;
		}
		APPLICATION_LOGS.error(checkBoxText + " NOT selected");
		G2_Common.captureScreenShot(driver, "Checkbox-");
		return false;
	}

	public static boolean selectRadioButton(WebDriver driver,
			String radioButtonText) {
		// not suited if 2 radio having same label/text
		if (radioButtonText == null || radioButtonText.equals("")) {
			G2_Common.APPLICATION_LOGS
					.info("No radio button text passed to select.");
			return false;
		}
		List<WebElement> radioButtonList = driver
				.findElements(By
						.xpath("//input[@type='radio' and contains(following-sibling::text(),'"
								+ radioButtonText + "')]"));

		for (WebElement radioButton : radioButtonList) {
			boolean actualValue = radioButton.isEnabled();

			if (!actualValue) {
				G2_Common.APPLICATION_LOGS.error(radioButtonText
						+ " radio button is disabled");
				break;
			}
			if (radioButtonList.size() > 1) {
				G2_Common.APPLICATION_LOGS.info(radioButtonText
						+ " : More than one radio button with specified text.");
			}
			radioButton.click(); // selects one
			G2_Common.APPLICATION_LOGS.info(radioButtonText + " selected");

			return true;
		}
		G2_Common.APPLICATION_LOGS.error(radioButtonText + " Not selected");
		return false;
	}

	public static void captureScreenShot(WebDriver driver, String obj) {
		File screenshotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File("Screenshots\\" + obj
					+ "" + GetTimeStampValue() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String GetTimeStampValue() {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString();
		String systime = timestamp.replace(":", "-");
		return systime;

	}

	public static boolean verifyAllCheckBoxSelected(WebDriver driver) {
		{
			int checkedflag = 1;
			List<WebElement> checkBoxList = driver.findElements(By
					.xpath("//input[@type='checkbox']"));
			for (WebElement appType : checkBoxList) {
				if (appType.isSelected() == true) {
					checkedflag = 0;
				} else {
					checkedflag = 1;
					break;
				}
			}
			if (checkedflag == 0) {
				G2_Common.APPLICATION_LOGS.info("All GroupBoxes are checked.");
				return true;
			} else {
				G2_Common.APPLICATION_LOGS
						.info("All GroupBoxes are not checked.");

				return false;
			}
		}
	}

	public static boolean checkRadioButtonEnabled(WebDriver driver,
			String radioButtonText) {
		// not suited if 2 radio having same label/text
		if (radioButtonText == null || radioButtonText.equals("")) {
			G2_Common.APPLICATION_LOGS
					.info("No radio button text passed to select.");
			return false;
		}
		List<WebElement> radioButtonList = driver
				.findElements(By
						.xpath("//input[@type='radio' and contains(following-sibling::text(),'"
								+ radioButtonText + "')]"));
		if (radioButtonList.size() > 1) {
			G2_Common.APPLICATION_LOGS.info(radioButtonText
					+ " : More than one radio button with specified text.");
		}
		for (WebElement radioButton : radioButtonList) {

			boolean actualValue = radioButton.isEnabled();

			if (!actualValue) {
				G2_Common.APPLICATION_LOGS.info(radioButtonText
						+ " radio button is disabled");
				return false;

			} else {
				G2_Common.APPLICATION_LOGS.info(radioButtonText
						+ " radio button is enabled");
				return true;
			}

		}
		return false;
	}
}

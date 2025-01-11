package com.vertafore.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;

//import com.vertafore.pageobjects.Global_Common;

public class Global_Common {

	public static void endTestCase(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {

		}
	}

	public static String generateRandomNumber(int charLength) {
		return String.valueOf(charLength < 1 ? 0 : new Random()
				.nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
				+ (int) Math.pow(10, charLength - 1));
	}

	public static WebDriver loadWebDriver() {
		WebDriver driver;

		DesiredCapabilities capabilities;
		String driverType = System.getenv("DRIVER_TYPE");
		if (driverType.equalsIgnoreCase("htmlunit")) {
			driver = new HtmlUnitDriver(false);
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		} else if (driverType.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if (driverType.equalsIgnoreCase("phantomjs")) {
			capabilities = new DesiredCapabilities();
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability("takesScreenshot", false);
			capabilities.setCapability(
					PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
					new String[] { "--ignore-ssl-errors=yes" });
			driver = new PhantomJSDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

		} else {
			throw new RuntimeException(
					"Driver type variable is undefined or invalid.");
		}
		return driver;
	}

	public static void setDriverTimeout(WebDriver driver, long time,
			TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time, unit);
	}

	public static String getURL(WebDriver driver, String hrefContains) {
		List<WebElement> links = driver.findElements(By
				.xpath("//a[contains(@href, '" + hrefContains + "')]"));
		String getURL = "";
		for (WebElement e : links) {
			getURL = e.getAttribute("href");
			break;
		}
		return getURL;
	}

	public static String pandaBambooLatestBuildNumber(WebDriver driver,
			String buildKey) {
		String restCall = "http://jira-agile.sircon.com:8082/panda-services/rest/hacks/"
				+ buildKey;
		driver.get(restCall);
		String pageSource = driver.getPageSource();
		String driverType = System.getenv("DRIVER_TYPE");
		if ((driverType.equalsIgnoreCase("firefox"))
				|| (driverType.equalsIgnoreCase("phantomjs"))) {
			pageSource = pageSource.replace(
					System.getProperty("line.separator"), "");
			Pattern pattern = Pattern.compile(">\\s*([0-9]+)\\s*</pre>");
			Matcher matcher = pattern.matcher(pageSource);
			matcher.find();
			return matcher.group(1);
		} else {
			return pageSource;
		}
	}

	/** Returns null or the pipeline build# you're querying */
	public static String pandaPipelineCheck(String appKey, String envName) {
		String restCall = "http://jira-agile.sircon.com:8082/panda-services/rest/environment/"
				+ appKey + "/" + envName + "/current";
		WebClient webClient = new WebClient();
		try {
			WebResponse res = webClient.getPage(restCall).getWebResponse();
			if (res.getStatusCode() == 200) {
				String json = res.getContentAsString();
				JSONObject obj = new JSONObject(json);
				String fullRCName = obj.getString("currentVersion");
				if (fullRCName != null) {
					return fullRCName.replace("RC-", "");
				}
			}
		} catch (Exception ignored) {
			ignored.printStackTrace();
		}
		return null;
	}

	public static Boolean availabilityCheck(String url) throws IOException,
			InterruptedException {
		WebClient client = new WebClient();
		int statusCode = 0;
		try {
			statusCode = client.getPage(url).getWebResponse().getStatusCode();
		} catch (Exception e) {
			return false;
		}
		if (statusCode == 200) {
			return true;
		}
		return false;
	}

	public static String regularExpressionMatcher(String source,
			String regularExpression, int indexValueFound) {
		Pattern pattern = Pattern.compile(regularExpression);
		Matcher matcher = pattern.matcher(source);
		matcher.find();
		return matcher.group(indexValueFound);
	}

	public static String getEnvironment() {
		String environment = System.getenv("ENVIRONMENT");
		if (environment == null) {
			environment = "test";
		}
		return environment;
	}

	public static String getEnvironmentProperty(String propertyFileType,
			String propertyName) {
		ResourceBundle props = ResourceBundle.getBundle(getEnvironment()
				+ propertyFileType);
		try {
			String propertyValue = props.getString(propertyName);
			return propertyValue;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getEnvironmentProperty(String propertyName) {
		return getEnvironmentProperty("", propertyName);
	}

	public static ArrayList<String> getServerList() {
		ArrayList<String> serverList = new ArrayList<String>();
		String appServerIP = "";
		int i = 1;
		do {
			appServerIP = getEnvironmentProperty("appserver" + i);
			if (appServerIP != null) {
				serverList.add(appServerIP);
				i++;
			}
		} while (appServerIP != null);
		return serverList;
	}

	public static void switchWindow(WebDriver driver, int windowOrder) {
		int order = 1;
		for (String winHandle : driver.getWindowHandles()) {
			if (order == windowOrder) {
				driver.switchTo().window(winHandle);
				break;
			}
			order++;
		}
	}

	public static String expectedResultsFileName() {
		String methodName = Thread.currentThread().getStackTrace()[2]
				.getMethodName();
		String className = Thread.currentThread().getStackTrace()[2]
				.getFileName().replace(".java", "");
		String resultsFileName = className + "_" + methodName;
		return resultsFileName;
	}

	public static int expectedResultsRowCount(String fileName)
			throws IOException {
		int lineCount = 0;
		String lineRead = "";
		LineNumberReader reader = new LineNumberReader(new FileReader(fileName));
		while ((lineRead = reader.readLine()) != null) {
			lineCount = reader.getLineNumber();
		}
		reader.close();
		return lineCount;
	}

	public static int expectedResultsColumnCount(String fileName)
			throws IOException {
		int columnCount = 0;
		String currentLine = "";
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(fileName));
		currentLine = br.readLine();
		if (br != null)
			br.close();
		String[] firstRow = currentLine.split(",");
		columnCount = firstRow.length + 1;
		return columnCount;
	}

	/*
	 * public static String validateTable(WebDriver driver, String tableID,
	 * String expectedResultsFile) throws Exception{ String
	 * expectedResultsFilePath = ".\\src\\test\\results\\" +
	 * expectedResultsFile; String results = ""; List<List<String>>
	 * expectedResultsList = new ArrayList(); List<List<String>>
	 * actualResultsList = new ArrayList(); CSVReader resultsFile = null; try {
	 * resultsFile = new CSVReader(new FileReader(expectedResultsFilePath)); }
	 * catch (FileNotFoundException e) {
	 * System.out.println("Expected results file (" + expectedResultsFile +
	 * " not found"); } String [] entireRow; int rowCount =
	 * Global_Common.expectedResultsRowCount(expectedResultsFilePath); int
	 * columnCount =
	 * Global_Common.expectedResultsColumnCount(expectedResultsFilePath);
	 * for(int i=0; i<rowCount; i++){ ArrayList<String> columnList = new
	 * ArrayList<String>(); entireRow = resultsFile.readNext(); for(int c=0;
	 * c<columnCount; c++){ columnList.add(entireRow[c].trim()); }
	 * expectedResultsList.add(columnList); } String[] rowText; WebElement table
	 * = driver.findElement(By.xpath("//*[@id='" + tableID + "']")); for
	 * (WebElement rowElement : table.findElements(By.tagName("tr"))){
	 * ArrayList<String> columnList = new ArrayList<String>(); List<WebElement>
	 * cols = rowElement.findElements(By.tagName("td")); rowText = new
	 * String[cols.size()]; for (int i = 0; i < rowText.length; i++){
	 * columnList.add(cols.get(i).getText().trim()); } if(columnList.size() ==
	 * columnCount){ actualResultsList.add(columnList); } } for(int row=0;
	 * row<expectedResultsList.size(); row++){ List<String> expected =
	 * expectedResultsList.get(row); List<String> actual =
	 * actualResultsList.get(row); if (!expected.equals(actual)){ for(int col=0;
	 * col<expected.size(); col++){
	 * if(!expected.get(col).equals(actual.get(col)) &&
	 * !expected.get(col).equals("*")){ if(results.equals("")){ results =
	 * "\nFAIL!  Expected: " + expected.get(col) + " | Actual: " +
	 * actual.get(col) + "  (Row:" + (row+1) + ", Column:" + (col+1) + ")\n";
	 * }else{ results = results + "FAIL!  Expected: " + expected.get(col) +
	 * " | Actual: " + actual.get(col) + "  (Row:" + (row+1) + ", Column:" +
	 * (col+1) + ")\n"; } } } } } return results; }
	 */

}

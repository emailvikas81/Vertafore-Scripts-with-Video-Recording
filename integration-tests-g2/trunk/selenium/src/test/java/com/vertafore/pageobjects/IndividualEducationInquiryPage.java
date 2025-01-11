package com.vertafore.pageobjects;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;

public class IndividualEducationInquiryPage {
	private final WebDriver driver;

	// Inquiry Type
	// Historical Data Radio Button
	@FindBy(how = How.XPATH, using = "(//input[@name='historicalData'])[2]")
	private WebElement historicalDataRadioButton;

	// Include Current Data only Radio Button
	@FindBy(how = How.NAME, using = "historicalData")
	private WebElement IncludeCurrentDataRadioButton;

	// Choose report output format
	@FindBy(how = How.NAME, using = "rptFormat")
	private WebElement chooseReportOutputFormatDropDown;

	// Generate Report Button
	@FindBy(how = How.LINK_TEXT, using = "Generate Report")
	private WebElement generateReportButton;

	// Reset Button
	@FindBy(how = How.LINK_TEXT, using = "Reset Form")
	private WebElement resetButton;

	public IndividualEducationInquiryPage(WebDriver driver) {
		this.driver = driver;
	}

	public void individualEducationInquiry(String chooseReportOutputFormat) {
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		G2_Common
				.dropdownSelectionByVisibleText(driver,
						this.chooseReportOutputFormatDropDown,
						chooseReportOutputFormat);
		// this.chooseReportOutputFormatDropDown
		// .sendKeys(chooseReportOutputFormat);
		String oldTab = driver.getWindowHandle();
		this.generateReportButton.click();
		ArrayList<String> newTab = new ArrayList<String>(
				driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.close();
		driver.switchTo().window(oldTab);

	}

	public void headerInfoCheck(String data22[]) {
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(driver, "//div/div/table/tbody/tr", 1,
				data22);
	}

	public boolean validateReset(String chooseReportFormatpdf,
			String chooseReportOutputFormat) {
		Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		this.historicalDataRadioButton.click();
		G2_Common.dropdownSelectionByVisibleText(driver,
				this.chooseReportOutputFormatDropDown, chooseReportFormatpdf);
		// this.chooseReportOutputFormatDropDown.sendKeys(chooseReportFormatpdf);
		this.resetButton.click();
		if (this.IncludeCurrentDataRadioButton.isSelected() == true) {
			G2_Common.APPLICATION_LOGS.info("Reset Button is Validated");
			return true;
		} else {
			G2_Common.APPLICATION_LOGS.info("Reset Button is Not Validated");
			return false;
		}
		// List<WebElement>
		// chooseReportOutputList=driver.findElements(By.name("rptFormat"));
		// System.out.println(this.chooseReportOutputFormatDropDown.getText());
		// for(WebElement report:chooseReportOutputList){
		// System.out.println(report.getText());
		// if(report.getText().equals(chooseReportOutputFormat)){
		//
		// G2_Common.APPLICATION_LOGS.info("Reset Button is Validated");
		// return true;
		// } else {
		// G2_Common.APPLICATION_LOGS.info("Reset Button is Not Validated");
		// return false;
		// }

		// }
		// return false;
	}

}

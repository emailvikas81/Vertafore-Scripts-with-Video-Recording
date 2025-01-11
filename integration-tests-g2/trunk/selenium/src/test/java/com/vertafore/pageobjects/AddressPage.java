package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	private final WebDriver driver;

	// Add Address
	@FindBy(how = How.ID, using = "save")
	private static WebElement addAddressLink;

	// Add Location Of Convenience
	@FindBy(how = How.ID, using = "saveLoc")
	private WebElement addLocOfConvenienceLink;

	// Name Header
	@FindBy(how = How.XPATH, using = ".//*[@id='indvAddressForm']/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/div/div/table/tbody/tr/td[1]")
	private WebElement nameHeader;

	// Clone Address
	@FindBy(how = How.LINK_TEXT, using = "Clone")
	private WebElement cloneAddress;

	// Edit Address
	@FindBy(how = How.LINK_TEXT, using = "Edit")
	private WebElement editAddress;

	// Add Comment
	@FindBy(how = How.LINK_TEXT, using = "Edit")
	private WebElement addCommentAddress;

	// Edit Loc Of Convenience
	@FindBy(how = How.XPATH, using = ".//*[@id='child_1_1']/table/tbody/tr/td/table/tbody/tr[2]/td/a")
	private WebElement editLocOfConvenience;

	// Audit Loc Of Convenience
	@FindBy(how = How.XPATH, using = ".//*[@id='child_0_1']/table/tbody/tr/td/table/tbody/tr[3]/td/a")
	private WebElement auditLocOfConvenience;
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addAddress() {
		addAddressLink.click();
	}

	public void addLocOfConvenience() {
		this.addLocOfConvenienceLink.click();
	}
	
	public void headerInfoCheck(String data22[]){
		final GlobalPage global = PageFactory.initElements(driver,
				GlobalPage.class);
		global.validateHeaderInformation(
				driver,
				"//form[@id='indvAddressForm']/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/div/div/table/tbody/tr",
				1, data22);
	}

}

package com.vertafore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.vertafore.common.G2_Common;

@SuppressWarnings("deprecation")
public class AddIndividualPage extends SeleneseTestCase {
	private final WebDriver driver;

	// Last Name
	@FindBy(how = How.NAME, using = "lastName")
	private WebElement lastNameTextBox;

	// First Name
	@FindBy(how = How.NAME, using = "firstName")
	private WebElement firstNameTextBox;

	// SSN
	@FindBy(how = How.NAME, using = "SSN")
	private WebElement ssnTextBox;

	// CRD
	@FindBy(how = How.NAME, using = "CRD")
	private WebElement crdTextBox;

	// NPN
	@FindBy(how = How.NAME, using = "nationalProducer")
	private WebElement npnTextBox;

	// customer Managed
	@FindBy(how = How.NAME, using = "custManaged")
	private WebElement custManagedDropDown;

	// customer Managed
	@FindBy(how = How.NAME, using = "residentStateOne")
	private WebElement residentStateOneDropDown;

	// User Security Group
	@FindBy(how = How.XPATH, using = "//table[@id='reportingGroupsFormTable']/tbody/tr[5]/td[3]/table")
	private WebElement usgGroupBox;

	// User Security Group
	@FindBy(how = How.XPATH, using = "//table[@id='reportingGroupsFormTable']/tbody/tr[5]/td[3]/table")
	private List<WebElement> usgList;

	// Save Button
	@FindBy(how = How.LINK_TEXT, using = "Save")
	private WebElement saveButton;

	// Header Object
	@FindBy(how = How.XPATH, using = "//*[@id='ConfigureIndvForm']/div[2]/div/table/tbody/tr")
	private WebElement headerObject;

	// Name Header
	@FindBy(how = How.XPATH, using = "//form[@id='ConfigureIndvForm']/div[2]/div/table/tbody/tr/td[2]")
	private WebElement nameHeader;

	// External System ID
	@FindBy(how = How.XPATH, using = "//form[@id='ConfigureIndvForm']/div[2]/div/table/tbody/tr/td[10]")
	private WebElement externalSystemID;

	// Add Individual
	public AddIndividualPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addIndividual(String lastName, String firstName, String sSN,
			String cRD, String nPN, String custManaged,
			String residentStateOne, String uSG) {

		this.lastNameTextBox.sendKeys(lastName);
		this.firstNameTextBox.sendKeys(firstName);
		G2_Common.updateField(driver, this.ssnTextBox,
				sSN);
		this.crdTextBox.sendKeys(cRD);
		this.npnTextBox.sendKeys(nPN);
		this.custManagedDropDown.sendKeys(custManaged);
		this.residentStateOneDropDown.sendKeys(residentStateOne);

		for (String uSGval : uSG.split(",")) {
			G2_Common.groupCheckBoxSelection(usgGroupBox, "inputField",
					"selectedUserSecurityGroups", uSGval);
		}
		this.saveButton.click();
	}
		public String getExtnsystemID() {
			G2_Common.APPLICATION_LOGS.info("External System ID: "
					+ externalSystemID.getText());
			return externalSystemID.getText();
		}
	


}

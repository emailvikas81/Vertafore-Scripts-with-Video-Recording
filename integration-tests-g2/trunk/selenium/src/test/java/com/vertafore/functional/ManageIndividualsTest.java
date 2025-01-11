package com.vertafore.functional;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.common.CommonMethods;
import com.vertafore.common.G2_Common;
import com.vertafore.common.Global_Common;
import com.vertafore.common.VideoRecord;
import com.vertafore.pageobjects.AddAdditionalRegulatoryReqPage;
import com.vertafore.pageobjects.AddAddressPage;
import com.vertafore.pageobjects.AddAdministrativePage;
import com.vertafore.pageobjects.AddAppointmentPage;
import com.vertafore.pageobjects.AddAppointmentSubActionPage;
import com.vertafore.pageobjects.AddAuditPage;
import com.vertafore.pageobjects.AddBusinessProcessEventPage;
import com.vertafore.pageobjects.AddBusinessProcessPage;
import com.vertafore.pageobjects.AddCommentPage;
import com.vertafore.pageobjects.AddCommunicationTrackingPage;
import com.vertafore.pageobjects.AddComplianceSupervisorFirstPage;
import com.vertafore.pageobjects.AddEmploymentHistoryPage;
import com.vertafore.pageobjects.AddErrorsAndOmissionsPage;
import com.vertafore.pageobjects.AddExternalSystemIdentifersPage;
import com.vertafore.pageobjects.AddFirmAssociationFirstPage;
import com.vertafore.pageobjects.AddFirmAssociationSecondPage;
import com.vertafore.pageobjects.AddHeightenedSupervisionPage;
import com.vertafore.pageobjects.AddIndividualPage;
import com.vertafore.pageobjects.AddJurisdicitionPage;
import com.vertafore.pageobjects.AddLicensePage;
import com.vertafore.pageobjects.AddLocOfConveniencePage;
import com.vertafore.pageobjects.AddMultiStageAppointmentFirstPage;
import com.vertafore.pageobjects.AddMultiStateAppointmentSecondPage;
import com.vertafore.pageobjects.AddMultiStateAppointmentThirdPage;
import com.vertafore.pageobjects.AddRestrictionPage;
import com.vertafore.pageobjects.AddRoleComplianceSupervisorPage;
import com.vertafore.pageobjects.AddRoleFirmAssociationPage;
import com.vertafore.pageobjects.AddcomplianceSupervisorSecondPage;
import com.vertafore.pageobjects.AdditionalRegulatoryReqPage;
import com.vertafore.pageobjects.AddressPage;
import com.vertafore.pageobjects.AdministrativeSupervisorPage;
import com.vertafore.pageobjects.AffiliationAndappointmentSummaryPage;
import com.vertafore.pageobjects.Affiliation_AddRestrictionPage;
import com.vertafore.pageobjects.Affiliation_ViewHistoryPage;
import com.vertafore.pageobjects.BusinessProcessEventPage;
import com.vertafore.pageobjects.ChangeStatusPage;
import com.vertafore.pageobjects.CloneAddressPage;
import com.vertafore.pageobjects.CommentPage;
import com.vertafore.pageobjects.CommunicationTrackingSummaryPage;
import com.vertafore.pageobjects.ComplaintsPage;
import com.vertafore.pageobjects.ComplianceSupervisorPage;
import com.vertafore.pageobjects.EditAdditionalRegulatoryReqPage;
import com.vertafore.pageobjects.EditAddressPage;
import com.vertafore.pageobjects.EditAdministrativePage;
import com.vertafore.pageobjects.EditAppointmentPage;
import com.vertafore.pageobjects.EditBusinessProcessPage;
import com.vertafore.pageobjects.EditCommentPage;
import com.vertafore.pageobjects.EditCommunicationTrackingPage;
import com.vertafore.pageobjects.EditComplianceSupervisorPage;
import com.vertafore.pageobjects.EditEmploymentHistoryPage;
import com.vertafore.pageobjects.EditErrorsAndOmissionsPage;
import com.vertafore.pageobjects.EditEventBusinessProcessEventPage;
import com.vertafore.pageobjects.EditExternalSystemIdentifierPage;
import com.vertafore.pageobjects.EditFirmAssociationPage;
import com.vertafore.pageobjects.EditHeightenedSupervisionPage;
import com.vertafore.pageobjects.EditJurisdictionPage;
import com.vertafore.pageobjects.EditLicensePage;
import com.vertafore.pageobjects.EditLocOfConveniencePage;
import com.vertafore.pageobjects.EditRestrictionPage;
import com.vertafore.pageobjects.EditRoleComplianceSupervisorPage;
import com.vertafore.pageobjects.EditRoleFirmAssociationPage;
import com.vertafore.pageobjects.EmploymentHistoryPage;
import com.vertafore.pageobjects.ErrorsAndOmissionsPage;
import com.vertafore.pageobjects.ExternalSystemIdentifiersPage;
import com.vertafore.pageobjects.FirmAssociationPage;
import com.vertafore.pageobjects.GlobalPage;
import com.vertafore.pageobjects.HeightenedSupervisionPage;
import com.vertafore.pageobjects.IndividualEducationInquiryPage;
import com.vertafore.pageobjects.JurisdictionSummaryPage;
import com.vertafore.pageobjects.SearchIndividualsPage;
import com.vertafore.pageobjects.SummaryOfLicensesQualificationsPage;
import com.vertafore.pageobjects.TerminateAffiliationPage;
import com.vertafore.pageobjects.ViewAuditDashboardPage;
import com.vertafore.pageobjects.ViewCommunicationTrackingSummaryPage;
import com.vertafore.pageobjects.ViewHistoryPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManageIndividualsTest {

	public static WebDriver driver;
	static String id2;
	static String lName;
	static String fName;
	static String sSNNo;
	static String cRDNo;
	static String nPNNo;
	static String externalSystemID;
	static String username = Global_Common
			.getEnvironmentProperty("functionaltest.user");
	static String accountID = Global_Common
			.getEnvironmentProperty("functionaltest.accountID");
	static VideoRecord videoRecord = new VideoRecord();

	@BeforeClass
	public static void setUp() throws Exception {
		videoRecord.startRecording();
		G2_Common.APPLICATION_LOGS.info("Test execution starts...");
		driver = Global_Common.loadWebDriver();
		driver.get(CommonMethods.getLoginUrl(accountID));
		CommonMethods.login(driver, accountID, username);
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
		driver.quit();
		try {
			videoRecord.stopRecording();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testA_addIndividual() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			final SearchIndividualsPage searchIndPage = PageFactory
					.initElements(driver, SearchIndividualsPage.class);
			final AddIndividualPage addIndPage = PageFactory.initElements(
					driver, AddIndividualPage.class);
			// id = Global_Common.generateRandomNumber(4);
			String id = Global_Common.generateRandomNumber(4);
			String lastName = Global_Common.getEnvironmentProperty("lastName")
					+ id;
			String firstName = Global_Common
					.getEnvironmentProperty("firstName") + id;
			String sSN = Global_Common.getEnvironmentProperty("SSN") + id;
			String cRD = Global_Common.getEnvironmentProperty("CRD") + id;
			String nPN = Global_Common.getEnvironmentProperty("NPN") + id;
			G2_Common.APPLICATION_LOGS.info("Uniquely generated number is : "
					+ id);
			String custManaged = Global_Common
					.getEnvironmentProperty("custManaged");
			String residentStateOne = Global_Common
					.getEnvironmentProperty("residentStateOne");
			String uSG = Global_Common.getEnvironmentProperty("USG");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("AIDataValidationErrors");
			String expectedDataValidationErrors = Global_Common
					.getEnvironmentProperty("SSNFormatValidationError");
			searchIndPage.navigateToManageIndividuals();

			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("addIndividualPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();

			searchIndPage.addIndividual(); // Click Add Individual Link

			global.checkDataValidationErrors(dataValidationErrors);

			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			searchIndPage.addIndividual(); // Click Add Individual Link

			G2_Common.APPLICATION_LOGS
					.info("************Adding a new Individual Starts************");
			// SSN Format Validation
			addIndPage.addIndividual("", "", "55656", "", "", "", "", "");
			String actualValidationError = global.retrieveFailureReason();
			if (actualValidationError.equals(expectedDataValidationErrors)) {
				G2_Common.APPLICATION_LOGS
						.info("SSN Format Error is as expected.");

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

			addIndPage.addIndividual(lastName, firstName, sSN, cRD, nPN,
					custManaged, residentStateOne, uSG);
			if (global.taskResponse().equals("error")) {
				if (global.retrieveFailureReason().contains(
						"Individual SSN already exists.")) {
					// call the method again , if the SSN already exists
					// id = Global_Common.generateRandomNumber(4);
					testA_addIndividual();
				} else {
					G2_Common.APPLICATION_LOGS
							.error("Test failed due to Data Error: "
									+ global.retrieveFailureReason());
					G2_Common.captureScreenShot(driver, "Individual-");
					fail("Test failed due to Data Error: "
							+ global.retrieveFailureReason());
				}
			}
			externalSystemID = addIndPage.getExtnsystemID();
			id2 = id;
			lName = lastName;
			fName = firstName;
			sSNNo = sSN;
			cRDNo = cRD;
			nPNNo = nPN;
			String data22[] = { "Name", lastName + ", " + firstName, "SSN",
					"***-**-" + id, "CRD #", cRD, "NPN", nPN,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			searchIndPage.headerInfoCheck(data22);
		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Test
	public void testC_addresses() {
		try {

			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Addresses");

			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("addressPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}
			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			final AddressPage addrPage = PageFactory.initElements(driver,
					AddressPage.class);
			final AddAddressPage addAddrPage = PageFactory.initElements(driver,
					AddAddressPage.class);
			final EditAddressPage editAddrPage = PageFactory.initElements(
					driver, EditAddressPage.class);
			final CloneAddressPage cloneAddrPage = PageFactory.initElements(
					driver, CloneAddressPage.class);
			String aaAddressPurpose = Global_Common
					.getEnvironmentProperty("aa_AddressPurpose");
			String aaFromDate = Global_Common
					.getEnvironmentProperty("aa_FromDate");
			String aaAddressType = Global_Common
					.getEnvironmentProperty("aa_AddressType");
			String aaPrivateResidence = Global_Common
					.getEnvironmentProperty("aa_PrivateResidence");
			String aaLineOne = Global_Common
					.getEnvironmentProperty("aa_LineOne");
			String aaCity = Global_Common.getEnvironmentProperty("aa_City");
			String aaCountry = Global_Common
					.getEnvironmentProperty("aa_Country");
			String aaState = Global_Common.getEnvironmentProperty("aa_State");
			String aaPostalCode = Global_Common
					.getEnvironmentProperty("aa_PostalCode");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("AADataValidationErrors");
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			addrPage.headerInfoCheck(data22);
			addrPage.addAddress();
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "Address-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			addrPage.addAddress();
			// addAddrPage.addAddress();
			G2_Common.APPLICATION_LOGS
					.info("************Add Address Starts************");
			addAddrPage.addAddress(aaAddressPurpose, aaFromDate, aaAddressType,
					aaPrivateResidence, aaLineOne, aaCity, aaCountry, aaState,
					aaPostalCode);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Address-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String stat = aaState.substring(0, 2);
			String data[] = { "", "", aaAddressType, aaAddressPurpose,
					"Active", "", aaLineOne, aaCity, stat, aaPostalCode,
					aaCountry, aaFromDate, "", "" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 3, data);

			// Edit Address
			String eaFromDate = Global_Common
					.getEnvironmentProperty("ea_FromDate");
			String eaPrivateResidence = Global_Common
					.getEnvironmentProperty("ea_PrivateResidence");
			String eaLineOne = Global_Common
					.getEnvironmentProperty("ea_LineOne");
			String eaCity = Global_Common.getEnvironmentProperty("ea_City");
			String eaCountry = Global_Common
					.getEnvironmentProperty("ea_Country");
			String eaState = Global_Common.getEnvironmentProperty("ea_State");
			String eaPostalCode = Global_Common
					.getEnvironmentProperty("ea_PostalCode");
			String editAddressValidationErrors = Global_Common
					.getEnvironmentProperty("editAddressValidationErrors");
			String addFromFutureDate = Global_Common
					.getEnvironmentProperty("addFromFutureDate");
			String editAddressLine1 = Global_Common
					.getEnvironmentProperty("editAddressLine1");
			String editAddressPostalCode = Global_Common
					.getEnvironmentProperty("editAddressPostalCode");
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();

			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "Address-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Edit");
			editAddrPage.FromDateValidate(addFromFutureDate, editAddressLine1,
					editAddressPostalCode);
			global.checkDataValidationErrors(editAddressValidationErrors);
			G2_Common.APPLICATION_LOGS
					.info("************Edit Address Starts************");
			editAddrPage.editAddress(eaFromDate, eaPrivateResidence, eaLineOne,
					eaCity, eaCountry, eaState, eaPostalCode);

			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Address-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String stat2 = eaState.substring(0, 2);
			String data2[] = { "", "", "Residential", "Insurance", "Active",
					"", eaLineOne, eaCity, stat2, eaPostalCode, eaCountry,
					eaFromDate, "", "" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 3, data2);

			// Clone Address
			String caAddressPurpose = Global_Common
					.getEnvironmentProperty("ca_AddressPurpose");
			String caFromDate = Global_Common
					.getEnvironmentProperty("ca_FromDate");
			String caAddressType = Global_Common
					.getEnvironmentProperty("ca_AddressType");
			String caFinraSeqNo = Global_Common
					.getEnvironmentProperty("ca_FinraSeqNo");
			String caToDate = Global_Common.getEnvironmentProperty("ca_ToDate");
			String caLineOne = Global_Common
					.getEnvironmentProperty("ca_LineOne");
			String caCity = Global_Common.getEnvironmentProperty("ca_City");
			String caCountry = Global_Common
					.getEnvironmentProperty("ca_Country");
			String caState = Global_Common.getEnvironmentProperty("ca_State");
			String caPostalCode = Global_Common
					.getEnvironmentProperty("ca_PostalCode");
			String dataValidationErrors2 = Global_Common
					.getEnvironmentProperty("CADataValidationErrors");
			String dataValidationErrors3 = Global_Common
					.getEnvironmentProperty("ACADataValidationErrors");
			String pageHeader2 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();

			G2_Common.navigateTo(driver, "Clone");
			global.checkDataValidationErrors(dataValidationErrors2);
			if (global.validateCancelOp(pageHeader2).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader2);
				G2_Common.captureScreenShot(driver, "Address-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader2);
			}
			G2_Common.navigateTo(driver, "Clone");
			G2_Common.APPLICATION_LOGS
					.info("************Clone Address Starts************");
			cloneAddrPage.cloneAddress(caAddressPurpose, caFromDate,
					caAddressType, caFinraSeqNo, caToDate, caLineOne, caCity,
					caCountry, caState, caPostalCode);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Address-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String stat3 = caState.substring(0, 2);
			String data3[] = { "", "", caAddressType, caAddressPurpose,
					"Inactive", "", caLineOne, caCity, stat3, caPostalCode,
					caCountry, caFromDate, caToDate, caFinraSeqNo };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 4, data3);
			// Add Comment in Address
			G2_Common.navigateTo(driver, "Add Comment");

			G2_Common.APPLICATION_LOGS
					.info("************Add Comment in Address Starts************");
			final AddCommentPage addCommentPage1 = PageFactory.initElements(
					driver, AddCommentPage.class);
			global.checkDataValidationErrors(dataValidationErrors3);
			String testDataPrefix = "AAD.";
			String contextType = "Address";
			String addCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addCommentDate");
			String addCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "addCommentCategory");
			String addCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addComment");
			addCommentPage1.addComment(addCommentDate, addCommentCategory,
					addCommentDescription);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Address-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			global.validateCommentTable(addCommentDescription, contextType);

			// Edit Comment in Address
			G2_Common.APPLICATION_LOGS
					.info("************Edit Comment in Address Starts************");
			EditCommentPage editCommentpage1 = PageFactory.initElements(driver,
					EditCommentPage.class);
			testDataPrefix = "EAP.";
			String editCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editCommentDate");
			String editCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "editCommentCategory");
			String editCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editComment");

			editCommentpage1.locateCommentToEdit(addCommentDescription);
			editCommentpage1.editComment(editCommentDate, editCommentCategory,
					editCommentDescription);

			global.validateCommentTable(editCommentDescription, contextType);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Address-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	public void searchIndividual() {
		try {
			final SearchIndividualsPage searchIndPage = PageFactory
					.initElements(driver, SearchIndividualsPage.class);
			searchIndPage.navigateToManageIndividuals();
			final String lastName = Global_Common
					.getEnvironmentProperty("lastName");
			final String firstName = Global_Common
					.getEnvironmentProperty("firstName");
			G2_Common.APPLICATION_LOGS
					.info("************Search Individual Starts************");
			searchIndPage.searchIndividuals(lastName, firstName);

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testJ_additionalRegulatoryRequirements() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver,
					"Additional Regulatory Requirements");

			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("additionalRegulatoryRequirementPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			final AdditionalRegulatoryReqPage regulatoryReqPage = PageFactory
					.initElements(driver, AdditionalRegulatoryReqPage.class);
			String addRegulatoryRequirement = Global_Common
					.getEnvironmentProperty("addRegulatoryRequirement");
			String addState = Global_Common.getEnvironmentProperty("addAState");
			String addARStatus = Global_Common
					.getEnvironmentProperty("addARStatus");
			String addRequestedDate = Global_Common
					.getEnvironmentProperty("addRequestedDate");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("AARDataValidationErrors");
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			regulatoryReqPage.addRegulatoryReq();
			regulatoryReqPage.headerInfoCheck(data22);
			final AddAdditionalRegulatoryReqPage addRegulatoryReqPage = PageFactory
					.initElements(driver, AddAdditionalRegulatoryReqPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "ARR-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			regulatoryReqPage.addRegulatoryReq();
			G2_Common.APPLICATION_LOGS
					.info("************Add Additional Regulatory Requirements Starts************");
			addRegulatoryReqPage.addRegulatoryReq(addRegulatoryRequirement,
					addState, addARStatus, addRequestedDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "ARR-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

			String data1[] = { "", addRegulatoryRequirement, "Training", "",
					addState, "", addARStatus, "", addRequestedDate, "", "", "" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 3, data1);
			G2_Common.APPLICATION_LOGS
					.info("************Edit Additional Regulatory Requirements Starts************");
			G2_Common.navigateTo(driver, "Edit");
			String editARRState = Global_Common
					.getEnvironmentProperty("editARRState");
			String editARRStatus = Global_Common
					.getEnvironmentProperty("editARRStatus");
			String editARRRequestedDate = Global_Common
					.getEnvironmentProperty("editARRRequestedDate");
			final EditAdditionalRegulatoryReqPage editRegulatoryReqPage = PageFactory
					.initElements(driver, EditAdditionalRegulatoryReqPage.class);
			editRegulatoryReqPage.editRegulatoryReq(editARRState,
					editARRStatus, editARRRequestedDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "ARR-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

			String data2[] = { "", "Fixed Annuity Product Training",
					"Training", "", editARRState, "", editARRStatus, "",
					editARRRequestedDate, "", "", "" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 3, data2);

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testO_employmentHistory() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Employment History");

			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("employmentHistoryPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			final EmploymentHistoryPage empHistoryPage = PageFactory
					.initElements(driver, EmploymentHistoryPage.class);
			// Add Employment History
			String addemployer = Global_Common
					.getEnvironmentProperty("addEmployer");
			String addfinrasequencenumber = Global_Common
					.getEnvironmentProperty("addFinrasequence");
			String addpositionheld = Global_Common
					.getEnvironmentProperty("addPositionHeld");
			String addinvestmentrelated = Global_Common
					.getEnvironmentProperty("addInvestmentRelated");
			String addstartdate = Global_Common
					.getEnvironmentProperty("addFromDate");
			String addenddate = Global_Common
					.getEnvironmentProperty("addToDate");
			String addcityname = Global_Common
					.getEnvironmentProperty("addcity");
			String addpostalcode = Global_Common
					.getEnvironmentProperty("addPostalCode");
			String addstatename = Global_Common
					.getEnvironmentProperty("addState");
			String addcountryname = Global_Common
					.getEnvironmentProperty("addCountry");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("AEHDataValidationErrors");
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			empHistoryPage.clickAddEmploymentHistory();
			empHistoryPage.headerInfoCheck(data22);
			final AddEmploymentHistoryPage addEmpHistoryPage = PageFactory
					.initElements(driver, AddEmploymentHistoryPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "EmpHistory-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			empHistoryPage.clickAddEmploymentHistory();
			G2_Common.APPLICATION_LOGS
					.info("************Add Employment History Starts************");
			addEmpHistoryPage.addEmploymentHistory(addemployer,
					addfinrasequencenumber, addpositionheld,
					addinvestmentrelated, addstartdate, addenddate,
					addcityname, addpostalcode, addstatename, addcountryname);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "EmpHistory-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data1[] = { "", addemployer, addinvestmentrelated,
					addcityname, addstatename, addpostalcode, addcountryname,
					"", "", addpositionheld, addfinrasequencenumber };
			global.validateTable(driver,
					"//*[@id='indvEmplHistForm']/table[2]/tbody/tr", 1, data1);

			// Edit Employment History
			String updateemployer = Global_Common
					.getEnvironmentProperty("editEmployer");
			String updatefinrasequencenumber = Global_Common
					.getEnvironmentProperty("editFinrasequence");
			String updatepositionheld = Global_Common
					.getEnvironmentProperty("editpositionheld");
			String updateinvestmentrelated = Global_Common
					.getEnvironmentProperty("editInvestmentRelated");
			String updatestartdate = Global_Common
					.getEnvironmentProperty("editFromDate");
			String updateenddate = Global_Common
					.getEnvironmentProperty("editToDate");
			String updatecityname = Global_Common
					.getEnvironmentProperty("editCity");
			String updatepostalcode = Global_Common
					.getEnvironmentProperty("editPostalCode");
			String updatestatename = Global_Common
					.getEnvironmentProperty("editState");
			String updatecountryname = Global_Common
					.getEnvironmentProperty("editCountry");
			final EditEmploymentHistoryPage editEmpHistoryPage = PageFactory
					.initElements(driver, EditEmploymentHistoryPage.class);
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "EmpHistory-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Edit");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Employment History Starts************");
			editEmpHistoryPage.editEmploymentHistory(updateemployer,
					updatefinrasequencenumber, updatepositionheld,
					updateinvestmentrelated, updatestartdate, updateenddate,
					updatecityname, updatepostalcode, updatestatename,
					updatecountryname);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "EmpHistory-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data2[] = { "", updateemployer, updateinvestmentrelated,
					updatecityname, updatestatename, updatepostalcode,
					updatecountryname, updatestartdate, updateenddate,
					updatepositionheld, updatefinrasequencenumber };
			global.validateTable(driver,
					"//*[@id='indvEmplHistForm']/table[2]/tbody/tr", 1, data2);

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testP_comments() {
		try {

			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Comments");

			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("commentPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			final CommentPage commentPage1 = PageFactory.initElements(driver,
					CommentPage.class);
			// Add Comment
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			commentPage1.clickAddComment();
			commentPage1.headerInfoCheck(data22);
			final AddCommentPage addCommentPage1 = PageFactory.initElements(
					driver, AddCommentPage.class);
			String fromdateValidationErrors = Global_Common
					.getEnvironmentProperty("fromDataValidationErrors");
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "Comments-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			commentPage1.clickAddComment();
			G2_Common.APPLICATION_LOGS
					.info("************Add Comment Starts************");
			String testDataPrefix = "";
			String contextType = "Individual";
			String addCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addCommentDate");
			String addCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "addCommentCategory");
			String addCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addComment");
			addCommentPage1.addComment(addCommentDate, addCommentCategory,
					addCommentDescription);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Comments-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data1[] = { "", addCommentCategory, "", contextType, "",
					addCommentDescription, };
			global.validateTable(driver,
					"//*[@id='ConfigureCommentForm']/table[2]/tbody/tr", 1,
					data1);

			// Edit Comment
			EditCommentPage editCommentPage1 = PageFactory.initElements(driver,
					EditCommentPage.class);
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");

			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "Comments-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			// G2_Common.navigateTo(driver, "Edit");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Comment Starts************");
			// editCommentPage1.editComment("", "Individual");
			testDataPrefix = "";
			String editCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editCommentDate");
			String editCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "editCommentCategory");
			String editCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editComment");

			editCommentPage1.locateCommentToEdit(addCommentDescription);
			editCommentPage1.editComment(editCommentDate, editCommentCategory,
					editCommentDescription);

			global.validateCommentTable(editCommentDescription, contextType);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Comments-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data2[] = { "", "Inquiry                                  ",
					"", contextType, "", editCommentDescription };
			global.validateTable(driver,
					"//*[@id='ConfigureCommentForm']/table[2]/tbody/tr", 1,
					data2);
			// Search Comment
			G2_Common.APPLICATION_LOGS
					.info("************Search Comment Starts************");
			String searchStartDate = Global_Common
					.getEnvironmentProperty("searchCommentStartDate");
			String searchEndDate = Global_Common
					.getEnvironmentProperty("searchCommentEndDate");
			String commentsCategory = Global_Common
					.getEnvironmentProperty("searchCommentsCategory");
			contextType = Global_Common
					.getEnvironmentProperty("searchContextType");
			editCommentPage1.searchComment(searchStartDate, searchEndDate,
					commentsCategory, contextType);
			String data3[] = { "", commentsCategory, "", contextType, "", "" };
			global.validateTable(driver,
					"//*[@id='ConfigureCommentForm']/table[2]/tbody/tr", 1,
					data3);

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testF_errorsAndOmissions() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Errors & Omissions");

			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("errorAndOmissionPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}
			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			// Add E&O
			final ErrorsAndOmissionsPage eaoPage = PageFactory.initElements(
					driver, ErrorsAndOmissionsPage.class);
			String addStatus = Global_Common
					.getEnvironmentProperty("addStatus");
			String addEffectiveDate = Global_Common
					.getEnvironmentProperty("addEffectiveDate");
			String addExpirationDate = Global_Common
					.getEnvironmentProperty("addExpirationDate");
			String addProviderName = Global_Common
					.getEnvironmentProperty("addProviderName");
			String addPolicy = Global_Common
					.getEnvironmentProperty("addPolicy");
			String addMaximumCoverageAmount = Global_Common
					.getEnvironmentProperty("addMaximumCoverageAmount");
			String addProviderFinancialRating = Global_Common
					.getEnvironmentProperty("addProviderFinancialRating");
			String addFinancialRatingCompany = Global_Common
					.getEnvironmentProperty("addFinancialRatingCompany");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("EAODataValidationErrors");
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			eaoPage.clickAddErrorsAndOmissions();
			eaoPage.headerInfoCheck(data22);
			final AddErrorsAndOmissionsPage addEAOPage = PageFactory
					.initElements(driver, AddErrorsAndOmissionsPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "E&O-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			eaoPage.clickAddErrorsAndOmissions();
			G2_Common.APPLICATION_LOGS
					.info("************Add Errors And Omissions Starts************");
			addEAOPage.addErrorsAndOmissions(addStatus, addEffectiveDate,
					addExpirationDate, addProviderName, addPolicy,
					addMaximumCoverageAmount, addProviderFinancialRating,
					addFinancialRatingCompany);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "E&O-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data1[] = { "", addProviderName, addPolicy,
					addEffectiveDate, addExpirationDate, addStatus };
			global.validateTable(driver, "//form[2]/table/tbody/tr", 1, data1);

			// Edit E&O
			final EditErrorsAndOmissionsPage editEAOPage = PageFactory
					.initElements(driver, EditErrorsAndOmissionsPage.class);
			String updateStatus = Global_Common
					.getEnvironmentProperty("editStatus");
			String updateEffectiveDate = Global_Common
					.getEnvironmentProperty("editEffectiveDate");
			String updateExpirationDate = Global_Common
					.getEnvironmentProperty("editExpirationDate");
			String updateProviderName = Global_Common
					.getEnvironmentProperty("editProviderName");
			String updatePolicy = Global_Common
					.getEnvironmentProperty("editPolicy");
			String updateMaximumCoverageAmount = Global_Common
					.getEnvironmentProperty("editMaximumCoverageAmount");
			String updateproviderFinancialRating = Global_Common
					.getEnvironmentProperty("editProviderFinancialRating");
			String updateFinancialRatingCompany = Global_Common
					.getEnvironmentProperty("editFinancialRatingCompany");
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "E&O-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Edit");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Errors And Omissions Starts************");
			editEAOPage.editErrorsAndOmissions(updateStatus,
					updateEffectiveDate, updateExpirationDate,
					updateProviderName, updatePolicy,
					updateMaximumCoverageAmount, updateproviderFinancialRating,
					updateFinancialRatingCompany);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "E&O-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data2[] = { "", updateProviderName, updatePolicy,
					updateEffectiveDate, updateExpirationDate, updateStatus };
			global.validateTable(driver, "//form[2]/table/tbody/tr", 1, data2);

			// Add Comment E&O
			G2_Common.navigateTo(driver, "Add Comment");
			G2_Common.APPLICATION_LOGS
					.info("************Add Comment For Errors And Omissions Starts************");
			final AddCommentPage addCommentPage1 = PageFactory.initElements(
					driver, AddCommentPage.class);
			// addCommentPage1.addComment("E&O.", "Errors & Omissions");

			String testDataPrefix = "E&O.";
			String contextType = "Errors & Omissions";
			String addCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addCommentDate");
			String addCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "addCommentCategory");
			String addCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addComment");
			addCommentPage1.addComment(addCommentDate, addCommentCategory,
					addCommentDescription);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Address-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			global.validateCommentTable(addCommentDescription, contextType);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "E&O-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data3[] = { "", "General                                  ",
					"", "Errors & Omissions", "",
					"Add comment for the E&O here" };
			global.validateTable(driver,
					"//*[@id='ConfigureCommentForm']/table[2]/tbody/tr", 1,
					data3);

			// Edit Comment E&O
			G2_Common.APPLICATION_LOGS
					.info("************Edit Comment For Errors And Omissions Starts************");
			EditCommentPage editCommentpage1 = PageFactory.initElements(driver,
					EditCommentPage.class);
			// editCommentpage1.editComment("E&O.", "Errors & Omissions");
			String editCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editCommentDate");
			String editCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "editCommentCategory");
			String editCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editComment");

			editCommentpage1.locateCommentToEdit(addCommentDescription);
			editCommentpage1.editComment(editCommentDate, editCommentCategory,
					editCommentDescription);

			global.validateCommentTable(editCommentDescription, contextType);
			editCommentpage1.returnvalidate();
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "E&O-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}

	}

	@Ignore
	@Test
	public void testG_externalSystemIdentifiers() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "External System Identifiers");

			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("externalSystemIdentifiersPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			// Add External System Identifiers
			final ExternalSystemIdentifiersPage esidPage = PageFactory
					.initElements(driver, ExternalSystemIdentifiersPage.class);
			String addType = Global_Common.getEnvironmentProperty("addType");
			String addIdentificationInExternalSystem = Global_Common
					.getEnvironmentProperty("addIdentificationInExtenalSystem");
			String addStartDate = Global_Common
					.getEnvironmentProperty("addStartDate");
			String addEndDate = Global_Common
					.getEnvironmentProperty("addEndDate");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("ESIDDataValidationErrors");
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();

			esidPage.clickAddExternalsystemID();
			esidPage.headerInfoCheck(data22);
			final AddExternalSystemIdentifersPage addESIDPage = PageFactory
					.initElements(driver, AddExternalSystemIdentifersPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "ExtSysID-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			esidPage.clickAddExternalsystemID();
			G2_Common.APPLICATION_LOGS
					.info("************Add External System Identifier Starts************");
			addESIDPage
					.addExternalSystemIdentifier(addType,
							addIdentificationInExternalSystem, addStartDate,
							addEndDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "ExtSysID-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data1[] = { "", addType, addIdentificationInExternalSystem,
					addStartDate, addEndDate };
			String data2[] = { "", "System ID", "3611523", "", "" };
			global.validateTable(driver, "//form/table[2]/tbody/tr", 1, data1);
			global.validateTable(driver, "//form/table[2]/tbody/tr", 2, data2);

			// Edit External System Identifiers
			final EditExternalSystemIdentifierPage editESIDPage = PageFactory
					.initElements(driver,
							EditExternalSystemIdentifierPage.class);
			String updateType = Global_Common
					.getEnvironmentProperty("editType");
			String updateIdentificationInExternalSystem = Global_Common
					.getEnvironmentProperty("editIdentificationInExtenalSystem");
			String updateStartDate = Global_Common
					.getEnvironmentProperty("editStartDate");
			String updateEndDate = Global_Common
					.getEnvironmentProperty("editEndDate");
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();

			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "ExtSysID-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Edit");
			G2_Common.APPLICATION_LOGS
					.info("************Edit External System Identifier Starts************");
			editESIDPage.editExternalSystemIdentifier(updateType,
					updateIdentificationInExternalSystem, updateStartDate,
					updateEndDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "ExtSysID-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data3[] = { "", "CAR SSN",
					updateIdentificationInExternalSystem, updateStartDate,
					updateEndDate };
			String data4[] = { "", "System ID", "3611723", "", "" };
			global.validateTable(driver, "//form/table[2]/tbody/tr", 1, data3);
			global.validateTable(driver, "//form/table[2]/tbody/tr", 2, data4);

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testH_complaints() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Complaints");
			final ComplaintsPage complaintsPage = PageFactory.initElements(
					driver, ComplaintsPage.class);
			G2_Common.APPLICATION_LOGS
					.info("************In Complaints Page************");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("complaintsPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}
			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			complaintsPage.headerInfoCheck(data22);
			global.zeroRecordsMessage();// 0 records found. Always !

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testI_adminSupervisor() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Administrative Supervisor");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("adminSupervisorPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };

			final AdministrativeSupervisorPage adminSupervisorPage = PageFactory
					.initElements(driver, AdministrativeSupervisorPage.class);
			// Add Admin Supervisor
			String adminLastName = Global_Common
					.getEnvironmentProperty("admin_LastName");
			String admiFirstName = Global_Common
					.getEnvironmentProperty("admin_FirstName");
			String adminFromDate = Global_Common
					.getEnvironmentProperty("admin_FromDate");
			String adminSuperStatus = Global_Common
					.getEnvironmentProperty("admin_SuperStatus");
			adminSupervisorPage.headerInfoCheck(data22);
			adminSupervisorPage.addAdministrativeSupervisor();
			final AddAdministrativePage addAdminSupervisorPage = PageFactory
					.initElements(driver, AddAdministrativePage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Add Administrative Supervisor Starts************");
			addAdminSupervisorPage.addAdministrativeSupervisor(adminLastName,
					admiFirstName, adminFromDate, adminSuperStatus);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "AdminSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data1[] = { "", adminLastName + ", " + admiFirstName,
					"***-**-5555", "4444444444", "4444444444", "3459723", "",
					adminFromDate, "", adminSuperStatus };
			global.validateTable(
					driver,
					"//form[@id='SupervisorForm']/table/tbody/tr[3]/td/table[3]/tbody/tr",
					1, data1);
			// Edit Admin Supervisor

			String adminEditFromDate = Global_Common
					.getEnvironmentProperty("admin_FromDate");
			String adminEditSuperStatus = Global_Common
					.getEnvironmentProperty("admin_SuperStatus");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Administrative Supervisor Starts************");
			G2_Common.navigateTo(driver, "Edit");
			final EditAdministrativePage editAdminSupervisorPage = PageFactory
					.initElements(driver, EditAdministrativePage.class);
			String data23[] = { "Individual Name", lName + ", " + fName,
					"Individual SSN", "***-**-" + id2, "Individual CRD #",
					cRDNo, "Individual NPN", nPNNo,
					"Individual Primary External System ID", externalSystemID };
			String data24[] = { "Supervisor Name",
					adminLastName + ", " + admiFirstName, "Supervisor SSN",
					"***-**-5555", "Supervisor CRD #", "4444444444",
					"Supervisor Title", "",
					"Supervisor Primary External System ID", "3459723" };
			global.validateHeaderInformation(driver,
					"//form[@id='SupervisorForm']/div[2]/div/table/tbody/tr",
					1, data23);
			global.validateHeaderInformation(driver,
					"//form[@id='SupervisorForm']/div[2]/div/table/tbody/tr",
					2, data24);

			editAdminSupervisorPage.editAdministrativeSupervisor(
					adminEditFromDate, adminEditSuperStatus);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "AdminSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data2[] = { "", adminLastName + ", " + admiFirstName,
					"***-**-5555", "4444444444", "4444444444", "3459723", "",
					adminEditFromDate, "", adminEditSuperStatus };
			global.validateTable(
					driver,
					"//form[@id='SupervisorForm']/table/tbody/tr[3]/td/table[3]/tbody/tr",
					1, data2);

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testB_businessProcessesAndEvents() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common
					.actionsNavigateTo(driver, "Business Processes and Events");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("businessProcessAndEventPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			final BusinessProcessEventPage bpPage = PageFactory.initElements(
					driver, BusinessProcessEventPage.class);
			// Add Business Process
			String addBusinessProcess = Global_Common
					.getEnvironmentProperty("addBusinessProcess");
			String addBPEState = Global_Common
					.getEnvironmentProperty("addBPEState");
			String addBPEStatus = Global_Common
					.getEnvironmentProperty("addBPEStatus");
			String addBPEStart = Global_Common
					.getEnvironmentProperty("addBPEStart");
			String addBPELicenseType = Global_Common
					.getEnvironmentProperty("addBPELicenseType");
			String addBPEStatusReason = Global_Common
					.getEnvironmentProperty("addBPEStatusReason");
			String addBPECommentText = Global_Common
					.getEnvironmentProperty("addBPECommentText");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("BPDataValidationErrors");
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			// bpPage.headerInfoCheck(data22);
			bpPage.addBusinessProcess();

			final AddBusinessProcessPage addBPPage = PageFactory.initElements(
					driver, AddBusinessProcessPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "BPE-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			bpPage.addBusinessProcess();
			G2_Common.APPLICATION_LOGS
					.info("************Add Business Process Starts************");
			addBPPage.addBusinessProcess(addBusinessProcess, addBPEState,
					addBPEStatus, addBPEStart, addBPELicenseType,
					addBPEStatusReason, addBPECommentText);
			// if (global.taskResponse().equals("error")) {
			// G2_Common.APPLICATION_LOGS
			// .error("Test failed due to Data Error: "
			// + global.retrieveFailureReason());
			// G2_Common.captureScreenShot(driver, "BPE-");
			// fail("Test failed due to Data Error: "
			// + global.retrieveFailureReason());
			// }
			// String data1[] = { "", "", addBusinessProcess, "", "",
			// addBPEStatus, "", addBPEStart, "", addBPECommentText };
			// global.validateTable(driver, ".//*[@id='HG1']/tbody/tr", 3,
			// data1);

			// Edit Business Process
			String bpeState = Global_Common.getEnvironmentProperty("bpeState");
			String bpeStatus = Global_Common
					.getEnvironmentProperty("bpeStatus");
			String bpeStart = Global_Common.getEnvironmentProperty("bpeStart");
			String bpeLicenseType = Global_Common
					.getEnvironmentProperty("bpeLicenseType");
			String bpeStatusReason = Global_Common
					.getEnvironmentProperty("bpeStatusReason");
			String bpeComment = Global_Common
					.getEnvironmentProperty("bpeComment");
			String dataValidationErrors2 = Global_Common
					.getEnvironmentProperty("BPEDataValidationErrors");
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "BPE-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Edit");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Business Process Starts************");
			final EditBusinessProcessPage editBPPage = PageFactory
					.initElements(driver, EditBusinessProcessPage.class);
			editBPPage.editBusinessProcess(bpeState, bpeStatus, bpeStart,
					bpeLicenseType, bpeStatusReason, bpeComment);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "BPE-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data2[] = { "", "", "Appointment Renewal", bpeState, "",
					bpeStatus, bpeStatusReason, bpeStart, "", bpeComment };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 3, data2);

			// Add Business Process Event
			String pageHeader2 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Add Business Process Event");
			final AddBusinessProcessEventPage addBPEventPage = PageFactory
					.initElements(driver, AddBusinessProcessEventPage.class);
			global.checkDataValidationErrors(dataValidationErrors2);
			if (global.validateCancelOp(pageHeader2).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader2);
				G2_Common.captureScreenShot(driver, "BPE-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader2);
			}
			G2_Common.navigateTo(driver, "Add Business Process Event");
			G2_Common.APPLICATION_LOGS
					.info("************Add Business Process Event Starts************");
			addBPEventPage.addBusinessProcessEvent();
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "BPE-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data3[] = {
					"",
					"  Events\nActions Event Event Date\n     Follow-up with State\n     Follow-up with Insurer\n     Pending for Renewal\n     Follow-up with Insurer\n     Pending for Renewal\n     Follow-up with State " };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 4, data3);

			// Edit Business Process Event
			String bpeEvent = Global_Common.getEnvironmentProperty("bpeEvent");
			String bpeEventDate = Global_Common
					.getEnvironmentProperty("bpeEventDate");
			String pageHeader3 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			final WebElement moveOverObject = driver.findElement(By
					.xpath(".//*[@id='KF_ITEM_0_0']/img"));

			G2_Common.navigateToMenu(driver, moveOverObject, "Edit");
			if (global.validateCancelOp(pageHeader3).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader3);
				G2_Common.captureScreenShot(driver, "BPE-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader3);
			}
			addBPEventPage.clickExpandButton();
			final WebElement moveOverObject2 = driver.findElement(By
					.xpath(".//*[@id='KF_ITEM_0_0']/img"));
			G2_Common.navigateToMenu(driver, moveOverObject2, "Edit");
			final EditEventBusinessProcessEventPage editBPEventPage = PageFactory
					.initElements(driver,
							EditEventBusinessProcessEventPage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Edit Business Process Event Starts************");
			editBPEventPage.editEvent(bpeEvent, bpeEventDate);

			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "BPE-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data4[] = {
					"",
					"  Events\nActions Event Event Date\n     Follow-up with Insurer "
							+ bpeEventDate
							+ "\n     Follow-up with Insurer\n     Pending for Renewal\n     Follow-up with Insurer\n     Pending for Renewal\n     Follow-up with State " };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 4, data4);
			bpPage.headerInfoCheck(data22);
		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testK_communicationTrackingSummary() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Communication Tracking");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("communicationTrackingSummaryPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			final CommunicationTrackingSummaryPage ctPage = PageFactory
					.initElements(driver,
							CommunicationTrackingSummaryPage.class);
			// Add Communication Tracking
			String fromCommunicationDate = Global_Common
					.getEnvironmentProperty("fromCommunicationDate");
			String toCommunicationDate = Global_Common
					.getEnvironmentProperty("toCommunicationDate");
			String actSubjectOfCommunication = Global_Common
					.getEnvironmentProperty("act_SubjectOfCommunication");
			String actDateOfCommunication = Global_Common
					.getEnvironmentProperty("act_DateOfCommunication");
			String actCommunicationType = Global_Common
					.getEnvironmentProperty("act_CommunicationType");
			String actComments = Global_Common
					.getEnvironmentProperty("act_Comments");
			String actDueDate = Global_Common
					.getEnvironmentProperty("act_DueDate");
			String actFollowUpUser = Global_Common
					.getEnvironmentProperty("act_ToCommunicationDate");
			String actTimeOfCommunication = Global_Common
					.getEnvironmentProperty("act_TimeOfCommunication");
			String actTimePeriod = Global_Common
					.getEnvironmentProperty("act_TimePeriod");
			String actCompletionDate = Global_Common
					.getEnvironmentProperty("act_CompletionDate");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("CTDataValidationErrors");
			ctPage.headerInfoCheck(data22);
			ctPage.communicationTrackingSummary(fromCommunicationDate,
					toCommunicationDate);
			// global.checkDataValidationErrors(fromDateToDateValidationErrors);
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			ctPage.addCommunicationTracking();
			final AddCommunicationTrackingPage addCTPage = PageFactory
					.initElements(driver, AddCommunicationTrackingPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "CommTracking-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			ctPage.addCommunicationTracking();
			G2_Common.APPLICATION_LOGS
					.info("************Add Communication Tracking Starts************");
			addCTPage.addCommunicationTracking(actSubjectOfCommunication,
					actDateOfCommunication, actCommunicationType, actComments,
					actDueDate, actFollowUpUser, actTimeOfCommunication,
					actTimePeriod, actCompletionDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CommTracking-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data1[] = {
					"",
					"User Automation",
					actDateOfCommunication + " " + actTimeOfCommunication
							+ " AM", actCommunicationType,
					actSubjectOfCommunication, actDueDate, actCompletionDate,
					"" };
			global.validateTable(driver, "//form/table[2]/tbody/tr", 1, data1);

			// Edit Communication Tracking
			String ectSubjectOfCommunication = Global_Common
					.getEnvironmentProperty("ect_SubjectOfCommunication");
			String ectDateOfCommunication = Global_Common
					.getEnvironmentProperty("ect_DateOfCommunication");
			String ectCommunicationType = Global_Common
					.getEnvironmentProperty("ect_CommunicationType");
			String ectComments = Global_Common
					.getEnvironmentProperty("ect_Comments");
			String ectDueDate = Global_Common
					.getEnvironmentProperty("ect_DueDate");
			String ectFollowUpUser = Global_Common
					.getEnvironmentProperty("ect_ToCommunicationDate");
			String ectTimeOfCommunication = Global_Common
					.getEnvironmentProperty("ect_TimeOfCommunication");
			String ectTimePeriod = Global_Common
					.getEnvironmentProperty("ect_TimePeriod");
			String ectCompletionDate = Global_Common
					.getEnvironmentProperty("ect_CompletionDate");
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();

			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "CommTracking-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Edit");
			final EditCommunicationTrackingPage editCTPage = PageFactory
					.initElements(driver, EditCommunicationTrackingPage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Edit Communication Tracking Starts************");
			editCTPage.editCommunicationTracking(ectSubjectOfCommunication,
					ectDateOfCommunication, ectCommunicationType, ectComments,
					ectDueDate, ectFollowUpUser, ectTimeOfCommunication,
					ectTimePeriod, ectCompletionDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CommTracking-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data2[] = {
					"",
					"User Automation",
					ectDateOfCommunication + " " + ectTimeOfCommunication
							+ " AM", ectCommunicationType,
					ectSubjectOfCommunication, ectDueDate, ectCompletionDate,
					"" };
			global.validateTable(driver, "//form/table[2]/tbody/tr", 1, data2);

			// View Communication Tracking
			G2_Common.navigateTo(driver, "View");
			final ViewCommunicationTrackingSummaryPage viewCTPage = PageFactory
					.initElements(driver,
							ViewCommunicationTrackingSummaryPage.class);
			G2_Common.APPLICATION_LOGS
					.info("************View Communication Tracking Starts************");
			viewCTPage.viewCommunicationTracking();
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CommTracking-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}

	}

	@Ignore
	@Test
	public void testL_firmAssociation() {
		try {
			Global_Common.setDriverTimeout(driver, 10, TimeUnit.SECONDS);
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Firm Associations");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("firmAssociationPageTitle");
			String expectedPageHeader = Global_Common
					.getEnvironmentProperty("firmAssociationPageHeader1");
			String expectedPageHeader2 = Global_Common
					.getEnvironmentProperty("firmAssociationPageHeader2");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}
			if (!global.zeroRecordsMessage().equals("")) {
				G2_Common.APPLICATION_LOGS.info("0 records found");
			}
			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			final FirmAssociationPage faPage = PageFactory.initElements(driver,
					FirmAssociationPage.class);
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}
			faPage.headerInfoCheck(data22);
			faPage.clickOnAddFirmAssociationLink();
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			if (!global.zeroRecordsMessage().equals("")) {
				G2_Common.APPLICATION_LOGS.info("0 records found");
			}
			faPage.clickOnAddFirmAssociationLink();
			if (faPage.validateHeader(expectedPageHeader).equals("error")) {
				fail("Test failed due to invalid page Header. Check execution log. Expected Header:   "
						+ expectedPageHeader);
			}
			String identifiersCode = Global_Common
					.getEnvironmentProperty("firmIdentifiersCode");
			String identifiersValue = Global_Common
					.getEnvironmentProperty("firmIdentifiersValue");
			final AddFirmAssociationFirstPage addFAPage1 = PageFactory
					.initElements(driver, AddFirmAssociationFirstPage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Search Firm Association Starts************");
			addFAPage1.searchByIdentifiers(identifiersCode, identifiersValue);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			// validate if search is success
			String assignmentStartDate = Global_Common
					.getEnvironmentProperty("firmAssociationStartDate");
			String assignmentStatus = Global_Common
					.getEnvironmentProperty("firmAssociationStatus");
			String assignmentPersonnelRole = Global_Common
					.getEnvironmentProperty("firmAssociationPersonnelRole");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("AFADataValidationErrors");
			addFAPage1.clickOnRadioButton();
			addFAPage1.clickOnContinueLink();
			if (faPage.validateHeader(expectedPageHeader2).equals("error")) {
				fail("Test failed due to invalid page Header. Check execution log. Expected Header:   "
						+ expectedPageHeader2);
			}
			final AddFirmAssociationSecondPage addFAPage2 = PageFactory
					.initElements(driver, AddFirmAssociationSecondPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			G2_Common.APPLICATION_LOGS
					.info("************Add Firm Association Starts************");
			addFAPage2.addFirmAssociation(assignmentStartDate,
					assignmentStatus, assignmentPersonnelRole);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data1[] = { "", "", "Stifel", "", "", "793", "3035823",
					"Active", "Firm", assignmentPersonnelRole, "",
					assignmentStartDate, "", "Active", "" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 3, data1);

			// Edit Firm Association
			String updateFirmAssociationStartDate = Global_Common
					.getEnvironmentProperty("editFirmAssociationStartDate");
			String updateFirmAssociationStatus = Global_Common
					.getEnvironmentProperty("editFirmAssociationStatus");
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");
			final EditFirmAssociationPage editFAPage = PageFactory
					.initElements(driver, EditFirmAssociationPage.class);
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Edit");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Firm Association Starts************");
			editFAPage.editFirmAssociation(updateFirmAssociationStartDate,
					updateFirmAssociationStatus);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data2[] = { "", "", "Stifel", "", "", "793", "3035823",
					updateFirmAssociationStatus, "Firm", "Test Agent", "", "",
					"", updateFirmAssociationStatus, "" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 3, data2);

			// Add Role in Firm Association
			String addRoleStartDate = Global_Common
					.getEnvironmentProperty("addRoleToFirmAssociationStartDate");
			String addPersonnelRole = Global_Common
					.getEnvironmentProperty("addPersonalRoleToFirmAssociation");
			String dataValidationErrors2 = Global_Common
					.getEnvironmentProperty("FARDataValidationErrors");
			String pageHeader2 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Add Role");
			final AddRoleFirmAssociationPage addRoleFAPage = PageFactory
					.initElements(driver, AddRoleFirmAssociationPage.class);
			global.checkDataValidationErrors(dataValidationErrors2);
			if (global.validateCancelOp(pageHeader2).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader2);
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader2);
			}
			G2_Common.navigateTo(driver, "Add Role");
			G2_Common.APPLICATION_LOGS
					.info("************Add Role in Firm Association Starts************");
			addRoleFAPage.addRoleToFirmAssociation(addRoleStartDate,
					addPersonnelRole);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data3[] = { "", "", "Stifel", "", "", "793", "3035823",
					"Active", "Firm", addPersonnelRole, "", "", "", "Active",
					"" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 4, data3);

			// Edit Role in Firm Association
			String updateRoleStartDate = Global_Common
					.getEnvironmentProperty("editRoleToFirmAssociationStartDate");
			String pageHeader3 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit Role");
			final EditRoleFirmAssociationPage editRoleFAPage = PageFactory
					.initElements(driver, EditRoleFirmAssociationPage.class);
			if (global.validateCancelOp(pageHeader3).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader3);
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader3);
			}
			G2_Common.navigateTo(driver, "Edit Role");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Role in Firm Association Starts************");
			editRoleFAPage.editRoleToFirmAssociation(updateRoleStartDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data4[] = { "", "", "Stifel", "", "", "793", "3035823",
					"Active", "Firm", "Test Agent", "", updateRoleStartDate,
					"", "Active", "", "Terminated" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 4, data4);

			// Add Comment in Role in Firm Association
			String pageHeader4 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Add Comment");
			AddCommentPage addCommentPage1 = PageFactory.initElements(driver,
					AddCommentPage.class);
			if (global.validateCancelOp(pageHeader4).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader4);
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader4);
			}
			G2_Common.navigateTo(driver, "Add Comment");
			G2_Common.APPLICATION_LOGS
					.info("************Add Comment in Firm Association Starts************");
			// addCommentPage1.addComment("FA.", "Producer Relationship");
			String testDataPrefix = "FA.";
			String contextType = "Producer Relationship";
			String addCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addCommentDate");
			String addCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "addCommentCategory");
			String addCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addComment");
			addCommentPage1.addComment(addCommentDate, addCommentCategory,
					addCommentDescription);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data6[] = { "", "General                                  ",
					"", "Producer Relationship", "",
					"Add comment for the Firm Association here" };
			global.validateTable(driver,
					"//*[@id='ConfigureCommentForm']/table[2]/tbody/tr", 1,
					data6);

			// Edit Comment in Role in Firm Association
			String pageHeader5 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");
			EditCommentPage editCommentpage1 = PageFactory.initElements(driver,
					EditCommentPage.class);
			if (global.validateCancelOp(pageHeader5).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader5);
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader5);
			}
			// G2_Common.navigateTo(driver, "Edit");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Comment in Firm Association Starts************");
			String editCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editCommentDate");
			String editCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "editCommentCategory");
			String editCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editComment");

			editCommentpage1.locateCommentToEdit(addCommentDescription);
			editCommentpage1.editComment(editCommentDate, editCommentCategory,
					editCommentDescription);

			global.validateCommentTable(editCommentDescription, contextType);
			editCommentpage1.returnvalidate();
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "FirmAssociation-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testM_jurisdictions() {
		try {
			// testM_firmAssociation();
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Jurisdictions");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("jurisdictionPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			// Add Jurisdiction
			String addRegistrationType = Global_Common
					.getEnvironmentProperty("addRegistrationType");
			String addJurisdiction = Global_Common
					.getEnvironmentProperty("addJurisdiction");
			String addFirm = Global_Common.getEnvironmentProperty("addFirm");
			String addFinraStatus = Global_Common
					.getEnvironmentProperty("addFinraStatus");
			String addStatus = Global_Common
					.getEnvironmentProperty("addJStatus");
			String addStatusDate = Global_Common
					.getEnvironmentProperty("addStatusDate");
			String addFilingDate = Global_Common
					.getEnvironmentProperty("addFilingDate");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("JuriDataValidationErrors");
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			final JurisdictionSummaryPage jsPage = PageFactory.initElements(
					driver, JurisdictionSummaryPage.class);
			jsPage.headerInfoCheck(data22);
			jsPage.clickOnAddJurisdictionLink();
			final AddJurisdicitionPage addJuriPage = PageFactory.initElements(
					driver, AddJurisdicitionPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "Jurisdiction-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			jsPage.clickOnAddJurisdictionLink();
			G2_Common.APPLICATION_LOGS
					.info("************Add Jurisdiction Starts************");
			addJuriPage.addJurisdiction(addRegistrationType, addJurisdiction,
					addFirm, addFinraStatus, addStatus, addStatusDate,
					addFilingDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Jurisdiction-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data1[] = { "", "", addFirm, addJurisdiction,
					addRegistrationType, addStatus, addStatusDate,
					addFilingDate, "", addFinraStatus };
			global.validateTable(driver, "//*[@id='resultTableBody']/tr", 1,
					data1);

			// Edit Jurisdiction
			final EditJurisdictionPage editJuriPage = PageFactory.initElements(
					driver, EditJurisdictionPage.class);
			String updateFinraStatus = Global_Common
					.getEnvironmentProperty("editFinraStatus");
			String updateStatus = Global_Common
					.getEnvironmentProperty("editStatus");
			String updateStatusDate = Global_Common
					.getEnvironmentProperty("editStatusDate");
			String updateFilingDate = Global_Common
					.getEnvironmentProperty("editFilingDate");
			String updateApprovalDate = Global_Common
					.getEnvironmentProperty("editApprovalDate");
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "Jurisdiction-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Edit");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Jurisdiction Starts************");
			editJuriPage.editJurisdiction(updateFinraStatus, updateStatus,
					updateStatusDate, updateFilingDate, updateApprovalDate);

			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Jurisdiction-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data2[] = { "", "", "Stifel", "AL - Alabama",
					"AG - Broker-Dealer Agent", updateStatus, updateStatusDate,
					updateFilingDate, updateApprovalDate, updateFinraStatus };
			global.validateTable(driver, "//*[@id='resultTableBody']/tr", 1,
					data2);

			// Add Comment for Jurisdiction
			String pageHeader2 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Add Comment");
			AddCommentPage addCommentPage1 = PageFactory.initElements(driver,
					AddCommentPage.class);
			if (global.validateCancelOp(pageHeader2).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader2);
				G2_Common.captureScreenShot(driver, "Jurisdiction-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader2);
			}
			G2_Common.navigateTo(driver, "Add Comment");
			G2_Common.APPLICATION_LOGS
					.info("************Add Comment in Jurisdiction Starts************");
			// addCommentPage1.addComment("JD.", "Jurisdiction");
			String testDataPrefix = "JD.";
			String contextType = "Jurisdiction";
			String addCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addCommentDate");
			String addCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "addCommentCategory");
			String addCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addComment");
			addCommentPage1.addComment(addCommentDate, addCommentCategory,
					addCommentDescription);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Jurisdiction-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data3[] = { "", "General                                  ",
					"", "Jurisdiction", "",
					"Add comment for the Jurisdiction here", };
			global.validateTable(driver,
					"//*[@id='ConfigureCommentForm']/table[2]/tbody/tr", 1,
					data3);

			// Edit Comment for Jurisdiction
			String pageHeader3 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");
			EditCommentPage editCommentpage1 = PageFactory.initElements(driver,
					EditCommentPage.class);
			if (global.validateCancelOp(pageHeader3).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader3);
				G2_Common.captureScreenShot(driver, "Jurisdiction-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader3);
			}
			G2_Common.APPLICATION_LOGS
					.info("************Edit Comment in Jurisdiction Starts************");
			String editCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editCommentDate");
			String editCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "editCommentCategory");
			String editCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editComment");

			editCommentpage1.locateCommentToEdit(addCommentDescription);
			editCommentpage1.editComment(editCommentDate, editCommentCategory,
					editCommentDescription);

			global.validateCommentTable(editCommentDescription, contextType);
			editCommentpage1.returnvalidate();
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "Jurisdiction-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testN_individualEducationInquiry() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Individual Education Inquiry");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("individualEducationInquiryPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			final IndividualEducationInquiryPage ieiPage = PageFactory
					.initElements(driver, IndividualEducationInquiryPage.class);
			String chooseReportOutputFormat = Global_Common
					.getEnvironmentProperty("chooseReportOutputFormat");
			String chooseReportFormatpdf = Global_Common
					.getEnvironmentProperty("chooseReportFormatpdf");
			G2_Common.APPLICATION_LOGS
					.info("************In Individual Education Inquiry************");
			ieiPage.headerInfoCheck(data22);
			ieiPage.validateReset(chooseReportFormatpdf,
					chooseReportOutputFormat);

			ieiPage.individualEducationInquiry(chooseReportOutputFormat);

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testQ_complianceSupervisor() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Compliance Supervisors");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("complianceSupervisorPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			final ComplianceSupervisorPage csPage = PageFactory.initElements(
					driver, ComplianceSupervisorPage.class);
			// Add Compliance Supervisor
			csPage.headerInfoCheck(data22);
			csPage.clickAddComplianceSupervisor();
			String addStartDate = Global_Common
					.getEnvironmentProperty("addComplianceSupervisonStartDate");
			String addStatus = Global_Common
					.getEnvironmentProperty("addComplianceSupervisionStatus");
			String addSupervisorRole = Global_Common
					.getEnvironmentProperty("addComplianceSupervisorRole");
			String addIndividualRole = Global_Common
					.getEnvironmentProperty("addIndividualRole");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("ACSSataValidationErrors");
			final AddComplianceSupervisorFirstPage addCSFPage = PageFactory
					.initElements(driver,
							AddComplianceSupervisorFirstPage.class);
			String lastName = Global_Common
					.getEnvironmentProperty("potentialComplianceSupervisorLastName");
			addCSFPage
					.searchAndSelectPotentialComplianceSupervisorByLastName(lastName);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

			final AddcomplianceSupervisorSecondPage addCSSPage = PageFactory
					.initElements(driver,
							AddcomplianceSupervisorSecondPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			csPage.clickAddComplianceSupervisor();
			G2_Common.APPLICATION_LOGS
					.info("************Search And Select Potential Compliance Supervisor By Last Name************");
			addCSFPage
					.searchAndSelectPotentialComplianceSupervisorByLastName(lastName);
			G2_Common.APPLICATION_LOGS
					.info("************Add Compliance Supervisor************");
			addCSSPage.addComplianceSupervisor(addStartDate, addStatus,
					addSupervisorRole, addIndividualRole);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data[] = { "", "", "Last Name, 28apr", "***-**-5555", "",
					"", "", "", "Active", addSupervisorRole, addIndividualRole,
					addStartDate, "", addStatus };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 1, data);

			// Add Role Compliance Supervisor
			String addSupervisorRoleToComplianceSupervisor = Global_Common
					.getEnvironmentProperty("addSupervisorRoleToComplianceSupervisor");
			String addIndividualRoleToComplianceSupervisor = Global_Common
					.getEnvironmentProperty("addIndividualRoleToComplianceSupervisor");
			String addRoleStartDate = Global_Common
					.getEnvironmentProperty("addRoleToComplianceSupervisorStartDate");
			String dataValidationErrors2 = Global_Common
					.getEnvironmentProperty("ARCSataValidationErrors");
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			final AddRoleComplianceSupervisorPage addRoleCSSPage = PageFactory
					.initElements(driver, AddRoleComplianceSupervisorPage.class);
			G2_Common.navigateTo(driver, "Add Role");
			global.checkDataValidationErrors(dataValidationErrors2);
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Add Role");
			G2_Common.APPLICATION_LOGS
					.info("************Add Role To Compliance Supervisor Starts************");
			addRoleCSSPage.addRoleToComplianceSupervisor(
					addSupervisorRoleToComplianceSupervisor,
					addIndividualRoleToComplianceSupervisor, addRoleStartDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data1[] = { "", "", "Last Name, 28apr", "***-**-5555", "",
					"", "", "", "Active",
					addSupervisorRoleToComplianceSupervisor,
					addIndividualRoleToComplianceSupervisor, addRoleStartDate,
					"", "Active" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 2, data1);

			// Edit Role Compliance Supervisor
			String editRoleToComplianceSupervisorStartDate = Global_Common
					.getEnvironmentProperty("editRoleToComplianceSupervisorStartDate");
			String pageHeader2 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			final EditRoleComplianceSupervisorPage editRoleCSSPage = PageFactory
					.initElements(driver,
							EditRoleComplianceSupervisorPage.class);
			G2_Common.navigateTo(driver, "Edit Role");
			if (global.validateCancelOp(pageHeader2).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader2);
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader2);
			}
			G2_Common.navigateTo(driver, "Edit Role");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Role in Compliance Supervisor Starts************");
			editRoleCSSPage
					.editRoleToComplianceSupervisor(editRoleToComplianceSupervisorStartDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data2[] = { "", "", "Last Name, 28apr", "***-**-5555", "",
					"", "", "", "Active", "Agent", "Test Agent",
					editRoleToComplianceSupervisorStartDate, "", "Active" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 1, data2);

			// Edit Compliance Supervisor

			String editComplianceSupervisonStartDate = Global_Common
					.getEnvironmentProperty("editComplianceSupervisonStartDate");
			String editComplianceSupervisionStatus = Global_Common
					.getEnvironmentProperty("editComplianceSupervisionStatus");
			String editComplianceSupervisonEndDate = Global_Common
					.getEnvironmentProperty("editComplianceSupervisonEndDate");
			String supervisionStatus = Global_Common
					.getEnvironmentProperty("supervisionStatus");
			String pageHeader3 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			final EditComplianceSupervisorPage editCSSPage = PageFactory
					.initElements(driver, EditComplianceSupervisorPage.class);
			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader3).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader3);
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader3);
			}
			G2_Common.navigateTo(driver, "Edit");
			G2_Common.APPLICATION_LOGS
					.info("************Edit Compliance Supervisor Starts************");
			editCSSPage.editComplianceSupervisor(
					editComplianceSupervisonStartDate,
					editComplianceSupervisionStatus,
					editComplianceSupervisonEndDate);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			csPage.searchComplianceSupervisor(supervisionStatus);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String data3[] = { "", "", "Last Name, 28apr", "***-**-5555", "",
					"", "", "", "Inactive", "Agent", "Test Agent",
					editRoleToComplianceSupervisorStartDate,
					editComplianceSupervisonEndDate,
					editComplianceSupervisionStatus };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 1, data3);

			// Add Comment Compliance Supervisor
			String pageHeader4 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Add Comment");
			AddCommentPage addCommentPage1 = PageFactory.initElements(driver,
					AddCommentPage.class);
			if (global.validateCancelOp(pageHeader4).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader4);
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader4);
			}
			csPage.searchComplianceSupervisor(supervisionStatus);
			G2_Common.navigateTo(driver, "Add Comment");
			G2_Common.APPLICATION_LOGS
					.info("************Add Comment in Compliance Supervisor Starts************");
			// addCommentPage1.addComment("CS.", "Producer Relationship");

			String testDataPrefix = "CS.";
			String contextType = "Producer Relationship";
			String addCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addCommentDate");
			String addCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "addCommentCategory");
			String addCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addComment");
			addCommentPage1.addComment(addCommentDate, addCommentCategory,
					addCommentDescription);

			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

			// Edit Comment Compliance Supervisor
			String pageHeader5 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader5).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader5);
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader5);
			}
			// G2_Common.navigateTo(driver, "Edit");
			EditCommentPage editCommentpage1 = PageFactory.initElements(driver,
					EditCommentPage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Edit Comment in Compliance Supervisor Starts************");
			// editCommentpage1.editComment("CS.", "Producer Relationship");
			String editCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editCommentDate");
			String editCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "editCommentCategory");
			String editCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editComment");

			editCommentpage1.locateCommentToEdit(addCommentDescription);
			editCommentpage1.editComment(editCommentDate, editCommentCategory,
					editCommentDescription);

			global.validateCommentTable(editCommentDescription, contextType);
			editCommentpage1.returnvalidate();
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "CompSupervisor-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testR_locationofConvenience() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Locations of Convenience");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("locationofConveniencePageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };

			final AddressPage addrPage = PageFactory.initElements(driver,
					AddressPage.class);
			final AddLocOfConveniencePage locPage = PageFactory.initElements(
					driver, AddLocOfConveniencePage.class);
			// Add LOC
			String alcFromDate = Global_Common
					.getEnvironmentProperty("alc_FromDate");
			String alcDescription = Global_Common
					.getEnvironmentProperty("alc_Description");
			String alcLineOne = Global_Common
					.getEnvironmentProperty("alc_LineOne");
			String alcCity = Global_Common.getEnvironmentProperty("alc_City");
			String alcCountry = Global_Common
					.getEnvironmentProperty("alc_Country");
			String alcState = Global_Common.getEnvironmentProperty("alc_State");
			String alcPostalCode = Global_Common
					.getEnvironmentProperty("alc_PostalCode");
			String alcAuditBaseDate = Global_Common
					.getEnvironmentProperty("alc_AuditBaseDate");
			String alcAuditFrequency = Global_Common
					.getEnvironmentProperty("alc_AuditFrequency");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("ALOCDataValidationErrors");
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			addrPage.headerInfoCheck(data22);
			addrPage.addLocOfConvenience();
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "LOC-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			addrPage.addLocOfConvenience();
			G2_Common.APPLICATION_LOGS
					.info("************Add Location Of Convenience Starts************");
			final String crdNo = locPage.addLocOfConvenience(alcFromDate,
					alcDescription, alcLineOne, alcCity, alcCountry, alcState,
					alcPostalCode, alcAuditBaseDate, alcAuditFrequency);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "LOC-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String stat = alcState.substring(0, 2);
			String data[] = { "", alcLineOne, alcCity, stat, alcPostalCode,
					alcCountry, "", alcFromDate, "", alcDescription };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 7, data);

			// Edit LOC
			String elcFromDate = Global_Common
					.getEnvironmentProperty("elc_FromDate");
			String elcDescription = Global_Common
					.getEnvironmentProperty("elc_Description");
			String elcLineOne = Global_Common
					.getEnvironmentProperty("elc_LineOne");
			String elcCity = Global_Common.getEnvironmentProperty("elc_City");
			String elcCountry = Global_Common
					.getEnvironmentProperty("elc_Country");
			String elcState = Global_Common.getEnvironmentProperty("elc_State");
			String elcPostalCode = Global_Common
					.getEnvironmentProperty("elc_PostalCode");
			String elcAuditBaseDate = Global_Common
					.getEnvironmentProperty("elc_AuditBaseDate");
			String elcAuditFrequency = Global_Common
					.getEnvironmentProperty("elc_AuditFrequency");

			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			final WebElement moveOverObject = driver.findElement(By
					.xpath("//div[@id='KF_ITEM_01']/img"));
			G2_Common.navigateToMenu(driver, moveOverObject, "Edit");
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "LOC-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			final WebElement moveOverObject2 = driver.findElement(By
					.xpath("//div[@id='KF_ITEM_01']/img"));
			G2_Common.navigateToMenu(driver, moveOverObject2, "Edit");
			final EditLocOfConveniencePage editLOCPage = PageFactory
					.initElements(driver, EditLocOfConveniencePage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Edit Location Of Convenience Starts************");
			editLOCPage.editLocOfConvenience(elcFromDate, elcDescription,
					elcLineOne, elcCity, elcCountry, elcState, elcPostalCode,
					elcAuditBaseDate, elcAuditFrequency);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "LOC-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			String stat2 = elcState.substring(0, 2);
			String data1[] = { "", elcLineOne, elcCity, stat2, elcPostalCode,
					elcCountry, "", elcFromDate, "", elcDescription };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 7, data1);

			// Audit
			String id = Global_Common.generateRandomNumber(4);
			String auditTemplateName = Global_Common
					.getEnvironmentProperty("audit_TemplateName");
			String auditLocationOfConvenience = Global_Common
					.getEnvironmentProperty("audit_LocationOfConvenience");
			String page2AuditName = Global_Common
					.getEnvironmentProperty("page2AuditName") + id;
			String page2ScheduledStartDate = Global_Common
					.getEnvironmentProperty("page2ScheduledStartDate");
			String page2ScheduledCompletionDate = Global_Common
					.getEnvironmentProperty("page2ScheduledCompletionDate");
			String page2Comment = Global_Common
					.getEnvironmentProperty("page2Comment");
			G2_Common.APPLICATION_LOGS
					.info("Uniquely generated Audit Name is  : "
							+ page2AuditName);
			final WebElement moveOverObject1 = driver.findElement(By
					.xpath(".//*[@id='KF_ITEM_01']/img"));
			G2_Common.navigateToMenu(driver, moveOverObject1, "View Audit");
			final ViewAuditDashboardPage viewAuditPage = PageFactory
					.initElements(driver, ViewAuditDashboardPage.class);
			final AddAuditPage addAuditPage = PageFactory.initElements(driver,
					AddAuditPage.class);
			viewAuditPage.viewAudit();// this is just view, so just clicking
										// return,
										// can do some validations.
			G2_Common.APPLICATION_LOGS
					.info("************Add Audit in Location Of Convenience Starts************");
			addAuditPage.addAudit(auditTemplateName, crdNo,
					auditLocationOfConvenience, page2AuditName,
					page2ScheduledStartDate, page2ScheduledCompletionDate,
					page2Comment);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "LOC-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}

	}

	@Test
	public void testD_licenseAndQualification() {
		try {
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			G2_Common.actionsNavigateTo(driver, "Licenses & Qualifications");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("licenseAndQualificationPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}

			String data22[] = { "Name", lName + ", " + fName, "SSN",
					"***-**-" + id2, "CRD #", cRDNo, "NPN", nPNNo,
					"Primary External System ID", externalSystemID, "D.O.B.",
					"" };
			// Add License
			String id = Global_Common.generateRandomNumber(4); // Dynamically
			// generated data
			G2_Common.APPLICATION_LOGS
					.info("Uniquely generated License No. is  : " + id);
			String alState = Global_Common.getEnvironmentProperty("al_State");
			String alLicenseType = Global_Common
					.getEnvironmentProperty("al_LicenseType");
			String alStatus = Global_Common.getEnvironmentProperty("al_Status");
			String alOriginalIssueDate = Global_Common
					.getEnvironmentProperty("al_OriginalIssueDate");
			String alPhysicalCopyReceived = Global_Common
					.getEnvironmentProperty("al_PhysicalCopyReceived");
			String alEffectiveDate = Global_Common
					.getEnvironmentProperty("al_EffectiveDate");
			String alRenewalStatus = Global_Common
					.getEnvironmentProperty("al_RenewalStatus");
			String alLicenseNumber = id;// "886615";//
			// Global_Common.getEnvironmentProperty("al_LicenseNumber") + id;
			G2_Common.APPLICATION_LOGS
					.info("Uniquely generated License No. is  : "
							+ alLicenseNumber);
			String alExpirationDate = Global_Common
					.getEnvironmentProperty("al_ExpirationDate");
			String alQualification = Global_Common
					.getEnvironmentProperty("al_Qualification");

			String ceReviewPeriodStartDate = Global_Common
					.getEnvironmentProperty("ceReviewPeriodStartDate");
			String ceReviewPeriodEndDate = Global_Common
					.getEnvironmentProperty("ceReviewPeriodEndDate");
			String ceReviewPeriodStatus = Global_Common
					.getEnvironmentProperty("ceReviewPeriodStatus");
			String cerEthicsStartDate = Global_Common
					.getEnvironmentProperty("cerEthicsStartDate");
			String cerEthicsRequiredHours = Global_Common
					.getEnvironmentProperty("cerEthicsRequiredHours");
			String cerEthicsStatus = Global_Common
					.getEnvironmentProperty("cerEthicsStatus");
			String certhLicenseStart = Global_Common
					.getEnvironmentProperty("certhLicenseStart");
			String certhLicenseRequiredHours = Global_Common
					.getEnvironmentProperty("certhLicenseRequiredHours");
			String certhLicenseStatus = Global_Common
					.getEnvironmentProperty("certhLicenseStatus");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("ALDataValidationErrors");

			final SummaryOfLicensesQualificationsPage slaqPage = PageFactory
					.initElements(driver,
							SummaryOfLicensesQualificationsPage.class);
			slaqPage.headerInfoCheck(data22);
			slaqPage.addLicense();

			final AddLicensePage laqPage = PageFactory.initElements(driver,
					AddLicensePage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Add License Starts************");
			global.checkDataValidationErrors(dataValidationErrors);
			laqPage.addLicense(alState, alLicenseType, alStatus,
					alOriginalIssueDate, alPhysicalCopyReceived,
					alEffectiveDate, alRenewalStatus, alLicenseNumber,
					alExpirationDate, alQualification, ceReviewPeriodStartDate,
					ceReviewPeriodEndDate, ceReviewPeriodStatus,
					cerEthicsStartDate, cerEthicsRequiredHours,
					cerEthicsStatus, certhLicenseStart,
					certhLicenseRequiredHours, certhLicenseStatus);

			if (global.taskResponse().equals("error")) {
				if (global.retrieveFailureReason().contains(
						"The License # already exists")) {
					// call the method again , if the License # already exists
					// this can be extended to multiple counts
					alLicenseNumber = Global_Common.generateRandomNumber(6);
					laqPage.addLicense(alState, alLicenseType, alStatus,
							alOriginalIssueDate, alPhysicalCopyReceived,
							alEffectiveDate, alRenewalStatus, alLicenseNumber,
							alExpirationDate, alQualification,
							ceReviewPeriodStartDate, ceReviewPeriodEndDate,
							ceReviewPeriodStatus, cerEthicsStartDate,
							cerEthicsRequiredHours, cerEthicsStatus,
							certhLicenseStart, certhLicenseRequiredHours,
							certhLicenseStatus);
				} else {
					G2_Common.APPLICATION_LOGS
							.error("Test failed due to Data Error: "
									+ global.retrieveFailureReason());
					G2_Common.captureScreenShot(driver, "L&Q-");
					fail("Test failed due to Data Error: "
							+ global.retrieveFailureReason());
				}
			}
			// --------------------------------------
			for (int i = 2; i < 8; i++) {

				String ID = Global_Common.generateRandomNumber(4);

				Global_Common.setDriverTimeout(driver, 30, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				String state = Global_Common.getEnvironmentProperty("al" + i
						+ "State");
				String licenseType = Global_Common.getEnvironmentProperty("al"
						+ i + "LicenseType");
				String status = Global_Common.getEnvironmentProperty("al" + i
						+ "Status");
				String originalIssueDate = Global_Common
						.getEnvironmentProperty("al" + i + "OriginalIssueDate");
				String physicalCopyReceived = Global_Common
						.getEnvironmentProperty("al" + i
								+ "PhysicalCopyReceived");
				String effectiveDate = Global_Common
						.getEnvironmentProperty("al" + i + "EffectiveDate");
				String renewalStatus = Global_Common
						.getEnvironmentProperty("al" + i + "RenewalStatus");
				String licenseNumber = Global_Common
						.getEnvironmentProperty("al" + i + "LicenseNumber")
						+ ID;
				G2_Common.APPLICATION_LOGS
						.info("Uniquely generated License No. for state: "
								+ state + " is  : " + licenseNumber);
				String expirationDate = Global_Common
						.getEnvironmentProperty("al" + i + "ExpirationDate");
				String qualification = Global_Common
						.getEnvironmentProperty("al" + i + "Qualification");
				laqPage.addLicense2(state, licenseType, status,
						originalIssueDate, physicalCopyReceived, effectiveDate,
						renewalStatus, licenseNumber, expirationDate,
						qualification);

				if (global.taskResponse().equals("error")) {
					if (global.retrieveFailureReason().contains(
							"The License # already exists")) {
						licenseNumber = Global_Common.generateRandomNumber(6);
						laqPage.addLicense2(state, licenseType, status,
								originalIssueDate, physicalCopyReceived,
								effectiveDate, renewalStatus, licenseNumber,
								expirationDate, qualification);
					} else {
						G2_Common.APPLICATION_LOGS
								.error("Test failed due to Data Error: "
										+ global.retrieveFailureReason());
						G2_Common.captureScreenShot(driver, "L&Q-");
						fail("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
					}
				}
			}

			// --------------------------------------
			String data[] = { "", "", alState, alLicenseType, "Yes",
					alLicenseNumber, alStatus, alEffectiveDate, "",
					alExpirationDate, "", "None/Record Only", "No" };
			global.validateTable(driver, "//tbody[@id='resultTableBody']/tr",
					3, data);

			// Edit License
			String elOriginalIssueDate = Global_Common
					.getEnvironmentProperty("el_OriginalIssueDate");
			String elLicenseNumber = Global_Common
					.getEnvironmentProperty("el_LicenseNumber") + id;
			G2_Common.APPLICATION_LOGS
					.info("Uniquely generated License No. is  : "
							+ elLicenseNumber);
			String elEffective = Global_Common
					.getEnvironmentProperty("el_Effective");
			String elExpirationDate = Global_Common
					.getEnvironmentProperty("el_ExpirationDate");
			String elPhysicalCopy = Global_Common
					.getEnvironmentProperty("el_PhysicalCopy");
			String elRenewalStatus = Global_Common
					.getEnvironmentProperty("el_RenewalStatus");
			final WebElement moveOverObject = driver.findElement(By
					.xpath(".//*[@id='KF_ITEM_2']/img")); // .//*[@id='KF_ITEM_0']/img
			G2_Common.navigateToMenu(driver, moveOverObject, "Edit");
			final EditLicensePage elaqPage = PageFactory.initElements(driver,
					EditLicensePage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Edit License Starts************");
			elaqPage.editLicense(elOriginalIssueDate, elLicenseNumber,
					elEffective, elExpirationDate, elPhysicalCopy,
					elRenewalStatus);
			// G2_Common.navigateTo( driver, "Edit");
			if (global.taskResponse().equals("error")) {
				if (global.retrieveFailureReason().contains(
						"The License # already exists")) {
					// call the method again , if the License # already exists
					// this can be extended to multiple counts
					G2_Common.navigateToMenu(driver, moveOverObject, "Edit");
					elLicenseNumber = Global_Common.generateRandomNumber(6);
					elaqPage.editLicense(elOriginalIssueDate, elLicenseNumber,
							elEffective, elExpirationDate, elPhysicalCopy,
							elRenewalStatus);
				} else {
					G2_Common.APPLICATION_LOGS
							.error("Test failed due to Data Error: "
									+ global.retrieveFailureReason());
					G2_Common.captureScreenShot(driver, "L&Q-");
					fail("Test failed due to Data Error: "
							+ global.retrieveFailureReason());
				}
			}

			String data8[] = { "", "", "CA - California",
					"Resident Insurance Producer", "Yes", elLicenseNumber,
					"Active", elEffective, "", elExpirationDate, "",
					"None/Record Only", "No" };
			global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 3, data8);

			// Add Restriction
			WebElement moveOverObject2 = driver.findElement(By
					.xpath(".//*[@id='KF_ITEM_2']/img"));
			G2_Common
					.navigateToMenu(driver, moveOverObject2, "Add Restriction");
			String arRestrictionReason = Global_Common
					.getEnvironmentProperty("ar_RestrictionReason");
			String arStartDate = Global_Common
					.getEnvironmentProperty("ar_StartDate");
			String dataValidationErrors2 = Global_Common
					.getEnvironmentProperty("ARLDataValidationErrors");
			final AddRestrictionPage arlaqPage = PageFactory.initElements(
					driver, AddRestrictionPage.class);
			global.checkDataValidationErrors(dataValidationErrors2);
			G2_Common.APPLICATION_LOGS
					.info("************Add Restriction in License Starts************");
			arlaqPage.addRestriction(arRestrictionReason, arStartDate);
			// G2_Common.navigateTo( driver, "Add Restriction");
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

			// Edit Restriction
			String erEndDate = Global_Common
					.getEnvironmentProperty("er_EndDate");
			WebElement moveOverObject3 = driver.findElement(By
					.xpath(".//*[@id='KF_ITEM_0']/img"));
			G2_Common.navigateToMenu(driver, moveOverObject3, "Edit");
			final EditRestrictionPage erlaqPage = PageFactory.initElements(
					driver, EditRestrictionPage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Edit Restriction in License Starts************");
			erlaqPage.editRestriction(erEndDate);
			// G2_Common.navigateTo( driver, "Edit");
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "L&Q-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

			// Add Comment
			WebElement moveOverObject4 = driver.findElement(By
					.xpath(".//*[@id='KF_ITEM_2']/img"));
			G2_Common.navigateToMenu(driver, moveOverObject4, "Add Comment");
			AddCommentPage addCommentPage1 = PageFactory.initElements(driver,
					AddCommentPage.class);
			String testDataPrefix = "L&Q.";
			String contextType = "License";
			String addCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addCommentDate");
			String addCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "addCommentCategory");
			String addCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "addComment");
			addCommentPage1.addComment(addCommentDate, addCommentCategory,
					addCommentDescription);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "L&Q-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

			// edit Comment
			EditCommentPage editCommentpage1 = PageFactory.initElements(driver,
					EditCommentPage.class);
			String editCommentDate = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editCommentDate");
			String editCommentCategory = Global_Common
					.getEnvironmentProperty(testDataPrefix
							+ "editCommentCategory");
			String editCommentDescription = Global_Common
					.getEnvironmentProperty(testDataPrefix + "editComment");

			editCommentpage1.locateCommentToEdit(addCommentDescription);
			editCommentpage1.editComment(editCommentDate, editCommentCategory,
					editCommentDescription);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "L&Q-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			global.validateCommentTable(editCommentDescription, contextType);
			editCommentpage1.returnvalidate();

			// Change Status
			String csStatus = Global_Common.getEnvironmentProperty("cs_Status");
			String csTerminationDate = Global_Common
					.getEnvironmentProperty("cs_TerminationDate");
			String csTerminationReason = Global_Common
					.getEnvironmentProperty("cs_TerminationReason");
			String csProcessingInstruction = Global_Common
					.getEnvironmentProperty("cs_ProcessingInstruction");
			String csTerminationInitiated = Global_Common
					.getEnvironmentProperty("cs_TerminationInitiated");
			String dataValidationErrors3 = Global_Common
					.getEnvironmentProperty("CSLDataValidationErrors");
			final WebElement moveOverObject6 = driver.findElement(By
					.xpath(".//*[@id='KF_ITEM_2']/img"));
			G2_Common.navigateToMenu(driver, moveOverObject6, "Change Status");
			final ChangeStatusPage cslaqPage = PageFactory.initElements(driver,
					ChangeStatusPage.class);
			global.checkDataValidationErrors(dataValidationErrors3);
			G2_Common.APPLICATION_LOGS
					.info("************Change Status in License Starts************");
			cslaqPage.changeStatus(csStatus, csTerminationDate,
					csTerminationReason, csProcessingInstruction,
					csTerminationInitiated);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "L&Q-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

			// View History
			String vhChooseReportOutputFormat = Global_Common
					.getEnvironmentProperty("vh_ChooseReportOutputFormat");
			final WebElement moveOverObject7 = driver.findElement(By
					.xpath(".//*[@id='KF_ITEM_2']/img"));
			G2_Common.navigateToMenu(driver, moveOverObject7, "View History");
			final ViewHistoryPage vhlaqPage = PageFactory.initElements(driver,
					ViewHistoryPage.class);
			G2_Common.APPLICATION_LOGS
					.info("************View History in License Starts************");
			vhlaqPage.viewHistory(vhChooseReportOutputFormat);

		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}

	@Test
	public void testE_AddAppointment() {

		GlobalPage global = PageFactory.initElements(driver, GlobalPage.class);
		G2_Common.actionsNavigateTo(driver, "Affiliations & Appointments");
		String pageHeader = driver
				.findElement(By.cssSelector("td.bannerTitle")).getText();
		// Page Title Verification
		String expectedPageTitle = Global_Common
				.getEnvironmentProperty("Aff&AppPageTitle");
		if (global.validateTitle(expectedPageTitle).equals("error")) {
			fail("Test failed due to invalid page title. Check execution log. Expected title:   "
					+ expectedPageTitle);
		}
		G2_Common.APPLICATION_LOGS
				.info("Affiliation and Appointment Page Is Displaying.");
		AffiliationAndappointmentSummaryPage AffAndAPPPage = PageFactory
				.initElements(driver,
						AffiliationAndappointmentSummaryPage.class);
		AffAndAPPPage.clickOnAddSingleStateAppointmentLink();
		G2_Common.APPLICATION_LOGS.info("Navigating to Add Appointment Page.");
		// Add Single State Appointment
		AddAppointmentPage AddAPPPage = PageFactory.initElements(driver,
				AddAppointmentPage.class);
		String dataValidationErrors = Global_Common
				.getEnvironmentProperty("AddAppLDataValidationErrors");
		String companyVal = Global_Common
				.getEnvironmentProperty("AddAff&AppCompanyName");
		String stateVal = Global_Common
				.getEnvironmentProperty("AddAff&AppStateName");
		AddAPPPage.checkDataValidationErrorsAddSingleStateAppointment(
				companyVal, stateVal, dataValidationErrors);
		G2_Common.APPLICATION_LOGS
				.info("Cancelling the Add Single Appointment operation.");
		if (global.validateCancelOp(pageHeader).equals("error")) {
			fail("Test failed due to invalid page title. Check execution log. Expected title:   "
					+ pageHeader);
		}
		G2_Common.APPLICATION_LOGS
				.info("After cancelling agian navigating to the Add Appointment Page.");
		G2_Common.APPLICATION_LOGS
				.info("Add Single State Appointment operation Started.");
		for (int i = 0; i <= 5; i++) {
			AffAndAPPPage.clickOnAddSingleStateAppointmentLink();
			String company = Global_Common
					.getEnvironmentProperty("AddAff&AppCompanyName" + i);
			String state = Global_Common
					.getEnvironmentProperty("AddAff&AppStateName" + i);
			String appointmentType = Global_Common
					.getEnvironmentProperty("AddAff&AppAppointmentType" + i);
			String billingCode = Global_Common
					.getEnvironmentProperty("AddAff&AppBillingCode" + i);
			String agentCode = Global_Common
					.getEnvironmentProperty("AddAff&AppAgentCode" + i);
			String agencyCode = Global_Common
					.getEnvironmentProperty("AddAff&AppAgencyCode" + i);
			String producerType = Global_Common
					.getEnvironmentProperty("AddAff&AppProducerType" + i);
			String ProcessingInstructions = Global_Common
					.getEnvironmentProperty("A&AProcessingInstructions" + i);
			String aaAPIDisabled = Global_Common
					.getEnvironmentProperty("A&APIDisabled" + i);

			AddAPPPage.addSingleStateAppointment(company, state,
					appointmentType, billingCode, agentCode, agencyCode,
					producerType, ProcessingInstructions, aaAPIDisabled);
			if (global.taskResponse().equals("error")) {
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());

			}
			String data[] = { "", state, appointmentType, "", "", "", "",
					ProcessingInstructions, "" };
			AddAPPPage.validateAppointmentTable(driver,
					"//*[@id='resultTableBody']/tr", company, data);

		}
		AffAndAPPPage.clickOnAddMultiStateAppointmentLink();
		G2_Common.APPLICATION_LOGS
				.info("Navigating to Add Multi State Appointment First Page");
		AddMultiStageAppointmentFirstPage AddMSAPPFPage = PageFactory
				.initElements(driver, AddMultiStageAppointmentFirstPage.class);
		G2_Common.verifyAllCheckBoxSelected(driver);
		AddMSAPPFPage.clickOnPauseSessionButton();
		AffAndAPPPage.clickOnresumeMultiStateAppointmentSessionLink();
		String AddMultiStateFirstStepValidationErrors = Global_Common
				.getEnvironmentProperty("AddMultiStateFirstStepValidationErrors");
		AddMSAPPFPage
				.checkDataValidationErrorsMultiStateAppointmentFirstStep(AddMultiStateFirstStepValidationErrors);
		G2_Common.APPLICATION_LOGS
				.info("Cancelling the Add Multi State Appointment Operations first step");
		if (global.validateCancelOp(pageHeader).equals("error")) {
			fail("Test failed due to invalid page title. Check execution log. Expected title:   "
					+ pageHeader);
		}
		AffAndAPPPage.clickOnAddMultiStateAppointmentLink();
		G2_Common.APPLICATION_LOGS
				.info("Adding States And Company for the Multi State Appointment Addition Operation.");
		String appointmentStatus = Global_Common
				.getEnvironmentProperty("AddmultiStateAppAppointmentStatus");
		String stateVerified = Global_Common
				.getEnvironmentProperty("AddmultiStateAppStateVerified");
		String agentNumber = Global_Common
				.getEnvironmentProperty("AddmultiStateAppAgentNumber");
		String agencyCode = Global_Common
				.getEnvironmentProperty("AddmultiStateAppAgencyCode");
		String appointmentCompanies = Global_Common
				.getEnvironmentProperty("AppointmentCompanies");
		AddMSAPPFPage.addAppointmentStatesAndCompany(appointmentStatus,
				stateVerified, agentNumber, agencyCode, appointmentCompanies);
		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}

		// Add MutliState Appointment Second Step
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the Add Multi State Appointment Second Step");
		AddMultiStateAppointmentSecondPage AddMSAPPSPage = PageFactory
				.initElements(driver, AddMultiStateAppointmentSecondPage.class);
		G2_Common.APPLICATION_LOGS
				.info("Pausing this session of adding multi-state appointment at second step.");
		AddMSAPPSPage.clickOnPauseSessionLink();
		G2_Common.APPLICATION_LOGS.info("Resuming the Session again.");
		AffAndAPPPage.clickOnresumeMultiStateAppointmentSessionLink();
		G2_Common.APPLICATION_LOGS
				.info("Again Navigating to the second step of Add Multi-State Appointment.");
		AddMSAPPFPage.clickOnContinueButton();
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the previous Page from Add Multi-State Appointment by clicking on back button.");
		AddMSAPPSPage.clickOnBackLink();
		G2_Common.APPLICATION_LOGS
				.info("Again navigating to the second page of Add Multi-State Appointment.");
		AddMSAPPFPage.clickOnContinueButton();
		String expectedDataValidationErrors = Global_Common
				.getEnvironmentProperty("AddMultiStateSecondStepvalErrors");
		AddMSAPPSPage
				.checkDataValdaitonErrorsMultiStateAppSecondStep(expectedDataValidationErrors);
		G2_Common.APPLICATION_LOGS
				.info("Cancelling the Whole Operation Of Adding Multi State Appointment.");
		if (global.validateCancelOp(pageHeader).equals("error")) {
			fail("Test failed due to invalid page title. Check execution log. Expected title:   "
					+ pageHeader);
		}
		G2_Common.APPLICATION_LOGS
				.info("Again Navigating to the Add Multi State Appointment First Page.");
		AffAndAPPPage.clickOnAddMultiStateAppointmentLink();
		G2_Common.APPLICATION_LOGS
				.info("Adding the States And Company for the Multi State Appointment.");
		// AddMSAPPFPage.addAppointmentStatesAndCompany();
		AddMSAPPFPage.addAppointmentStatesAndCompany(appointmentStatus,
				stateVerified, agentNumber, agencyCode, appointmentCompanies);
		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}
		String appointmentTypeSc = Global_Common
				.getEnvironmentProperty("AppointmentTypeSc");
		AddMSAPPSPage.addMultiStateAppSecondStep(appointmentTypeSc);

		// Add Multi State Third Step
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the Add Multi State appointment Third page.");
		AddMultiStateAppointmentThirdPage AddMSAPPTHPage = PageFactory
				.initElements(driver, AddMultiStateAppointmentThirdPage.class);
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the previous page from Add Multi-State Appointment Third Page.");
		AddMSAPPTHPage.clickOnBackButton();
		G2_Common.APPLICATION_LOGS
				.info("Again navigating to the Add Multi-State Appointment Third Page.");
		AddMSAPPSPage.clickOnContinueButton();
		G2_Common.APPLICATION_LOGS
				.info("Pausing this session from the third step of the adding the multi-state Appointment.");
		AddMSAPPTHPage.clickOnPauseSessionButton();
		G2_Common.APPLICATION_LOGS.info("Resuming the session again.");
		AffAndAPPPage.clickOnresumeMultiStateAppointmentSessionLink();
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the Second Page again. ");
		AddMSAPPFPage.clickOnContinueButton();
		G2_Common.APPLICATION_LOGS
				.info("Navigating from second page to the third page again. ");
		AddMSAPPFPage.clickOnContinueButton();
		String AddMultiStateFinalStepValidationErrors = Global_Common
				.getEnvironmentProperty("AddMultiStateFinalStepValidationErrors");
		AddMSAPPTHPage
				.checkDataValidationErrorsMultiStateAppointmentFinalStep(AddMultiStateFinalStepValidationErrors);
		G2_Common.APPLICATION_LOGS
				.info("Cancelling the whole operation of adding Multi State Appointment.");
		if (global.validateCancelOp(pageHeader).equals("error")) {
			fail("Test failed due to invalid page title. Check execution log. Expected title:   "
					+ pageHeader);
		}
		G2_Common.APPLICATION_LOGS
				.info("Navigating to thr Add Multi State Appointment First Page again after Cancellation.");
		AffAndAPPPage.clickOnAddMultiStateAppointmentLink();
		G2_Common.APPLICATION_LOGS
				.info("Adding States and Company for the multi states appointment addition again.");
		// AddMSAPPFPage.addAppointmentStatesAndCompany();
		AddMSAPPFPage.addAppointmentStatesAndCompany(appointmentStatus,
				stateVerified, agentNumber, agencyCode, appointmentCompanies);
		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the Add Multi State Appointment Third Page.");
		// AddMSAPPSPage.clickOnContinueLink();
		AddMSAPPSPage.addMultiStateAppSecondStep(appointmentTypeSc);
		G2_Common.APPLICATION_LOGS
				.info("Adding Value to the field Billing code and Additional Required Question as final step.");
		String fieldToPopulate = Global_Common
				.getEnvironmentProperty("FieldToPopulate");
		String fieldToPopulateValue = Global_Common
				.getEnvironmentProperty("FieldToPopulateValue");
		String Experience = Global_Common
				.getEnvironmentProperty("YearsOfExperince");
		AddMSAPPTHPage.populateField(fieldToPopulate, fieldToPopulateValue,
				Experience);
		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}
		String data1[] = { "", "",
				"Allianz Life Ins Co Of North America 90611", "Active", "", "",
				"No" };
		global.validateTable(driver, "//*[@id='HG1']/tbody/tr", 2, data1);

		// SubActions:Add Appointment
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the Add Appointment Action Page.");
		AffAndAPPPage.clickOnExpandButton();
		WebElement Mouseover9 = driver.findElement(By
				.xpath("//div[@id='KF_ITEM_0_0']/img"));
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the Add Appointment Page.");
		G2_Common.navigateToMenu(driver, Mouseover9, "Add");
		G2_Common.APPLICATION_LOGS
				.info("Addition of the Appointment Starts here.");
		AddAppointmentSubActionPage AddAppSubPage = PageFactory.initElements(
				driver, AddAppointmentSubActionPage.class);
		String subCompany = Global_Common
				.getEnvironmentProperty("AddAppSubCompany");
		String subState = Global_Common
				.getEnvironmentProperty("AddAppSubState");
		String subAppointmentType = Global_Common
				.getEnvironmentProperty("AddAppSubAppType");
		String subBillingCode = Global_Common
				.getEnvironmentProperty("AddAppSubBillingCode");
		String SubAgentCode = Global_Common
				.getEnvironmentProperty("AddAppSubAgentCode");
		String SubAgencyCode = Global_Common
				.getEnvironmentProperty("AddAppSubAgencyCode");
		String SubProducerType = Global_Common
				.getEnvironmentProperty("AddAppSubProducerType");
		String SubProcessingInstructions = Global_Common
				.getEnvironmentProperty("AddAppSubProcessingInstruction");
		String SubAAPIDisabled = Global_Common
				.getEnvironmentProperty("AddAppSubSubAAPIDisabled");
		AddAppSubPage.addSingleStateAppointmentSubAction(subCompany, subState,
				subAppointmentType, subBillingCode, SubAgentCode,
				SubAgencyCode, SubProducerType, SubProcessingInstructions,
				SubAAPIDisabled);
		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}

		// SubActions:Add Comment
		AffAndAPPPage.clickOnExpandButton();

		WebElement Mouseover = driver.findElement(By
				.xpath("//div[@id='KF_ITEM_0_0']/img"));
		G2_Common.APPLICATION_LOGS.info("Naviagting to the Add Comment Page.");
		G2_Common.navigateToMenu(driver, Mouseover, "Add Comment");

		AddCommentPage AddCommentPage1 = PageFactory.initElements(driver,
				AddCommentPage.class);
		// global.checkDataValidationErrors(pageHeader); what is this?

		if (global.validateCancelOp(pageHeader).equals("error")) {
			fail("Test failed due to invalid page title. Check execution log. Expected title:   "
					+ pageHeader);
		}
		AffAndAPPPage.clickOnExpandButton();
		WebElement Mouseover6 = driver.findElement(By
				.xpath("//div[@id='KF_ITEM_0_0']/img"));
		G2_Common.navigateToMenu(driver, Mouseover6, "Add Comment");
		G2_Common.APPLICATION_LOGS
				.info("Adding Comment in context of the Appointment.");

		String testDataPrefix = "App.";
		String contextType = "Appointment";
		String addCommentDate = Global_Common
				.getEnvironmentProperty(testDataPrefix + "addCommentDate");
		String addCommentCategory = Global_Common
				.getEnvironmentProperty(testDataPrefix + "addCommentCategory");
		String addCommentDescription = Global_Common
				.getEnvironmentProperty(testDataPrefix + "addComment");
		AddCommentPage1.addComment(addCommentDate, addCommentCategory,
				addCommentDescription);
		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}
		final WebElement ReturnButton = driver.findElement(By
				.linkText("Return"));
		ReturnButton.click();

		// SubActions:Add Restriction To Appointment
		G2_Common.APPLICATION_LOGS
				.info("Naviagtiong to the Add Restriction Page.");
		AffAndAPPPage.clickOnExpandButton();
		WebElement Mouseover1 = driver.findElement(By
				.xpath("//div[@id='KF_ITEM_0_0']/img"));
		G2_Common.navigateToMenu(driver, Mouseover1, "Add Restriction");
		Affiliation_AddRestrictionPage AffAddResPage = PageFactory
				.initElements(driver, Affiliation_AddRestrictionPage.class);
		// AffAddResPage.checkDataValidationErrors();
		if (global.validateCancelOp(pageHeader).equals("error")) {
			fail("Test failed due to invalid page title. Check execution log. Expected title:   "
					+ pageHeader);
		}
		AffAndAPPPage.clickOnExpandButton();
		WebElement Mouseover7 = driver.findElement(By
				.xpath("//div[@id='KF_ITEM_0_0']/img"));
		G2_Common.navigateToMenu(driver, Mouseover7, "Add Restriction");
		G2_Common.APPLICATION_LOGS
				.info("Adding ReStrictions to the Appointment.");
		String restrictionReason = Global_Common
				.getEnvironmentProperty("RestrictionReason");
		AffAddResPage.addRestrictionToAffiliation(restrictionReason);
		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}

		// SubActions:Edit Appointment
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the Edit Appointment page.");
		AffAndAPPPage.clickOnExpandButton();
		WebElement Mouseover2 = driver.findElement(By
				.xpath("//div[@id='KF_ITEM_0_0']/img"));
		G2_Common.navigateToMenu(driver, Mouseover2, "Edit");
		EditAppointmentPage EditAppPage = PageFactory.initElements(driver,
				EditAppointmentPage.class);
		if (global.validateCancelOp(pageHeader).equals("error")) {
			fail("Test failed due to invalid page title. Check execution log. Expected title:   "
					+ pageHeader);
		}
		AffAndAPPPage.clickOnExpandButton();
		WebElement Mouseover8 = driver.findElement(By
				.xpath("//div[@id='KF_ITEM_0_0']/img"));
		G2_Common.navigateToMenu(driver, Mouseover8, "Edit");
		G2_Common.APPLICATION_LOGS.info("Updating the Appointment.");
		String editEffectiveDate = Global_Common
				.getEnvironmentProperty("EditAff&AppEffectiveDate");
		String editBillingCode = Global_Common
				.getEnvironmentProperty("EditAff&AppBillingCode");
		String editAgentCode = Global_Common
				.getEnvironmentProperty("EditAddAff&AppAgentCode");
		String editAgencyCode = Global_Common
				.getEnvironmentProperty("EditAddAff&AppAgencyCode");

		EditAppPage.editAppointment(editEffectiveDate, editBillingCode,
				editAgentCode, editAgencyCode);
		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}

		// SubActions:Add Restriction to affiliation
		G2_Common.APPLICATION_LOGS.info("Navigating to the Add Restriction.");
		G2_Common.navigateTo(driver, "Add Restriction");
		// AffAddResPage.checkDataValidationErrors();
		if (global.validateCancelOp(pageHeader).equals("error")) {
			fail("Test failed due to invalid page title. Check execution log. Expected title:   "
					+ pageHeader);
		}
		G2_Common.navigateTo(driver, "Add Restriction");
		G2_Common.APPLICATION_LOGS
				.info("Adding Restrictions to the Affiliations.");
		AffAddResPage.addRestrictionToAffiliation(restrictionReason);
		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}

		// SubActions: Terminate Affiliations
		G2_Common.APPLICATION_LOGS
				.info("Navigating to the Terminate Affiliation Page.");
		G2_Common.navigateTo(driver, "Terminate");
		TerminateAffiliationPage TAffPage = PageFactory.initElements(driver,
				TerminateAffiliationPage.class);
		String processingInstruction = Global_Common
				.getEnvironmentProperty("processingInstruction");
		TAffPage.checkDataValidationErrors(processingInstruction);

		if (global.taskResponse().equals("error")) {
			fail("Test failed due to Data Error: "
					+ global.retrieveFailureReason());
		}
		// SubActions: ViewHistory
		G2_Common.APPLICATION_LOGS.info("Navigating to the View History Page.");
		G2_Common.navigateTo(driver, "View History");
		String selectState = Global_Common
				.getEnvironmentProperty("SelectState");
		Affiliation_ViewHistoryPage AffViewHisPage = PageFactory.initElements(
				driver, Affiliation_ViewHistoryPage.class);
		G2_Common.APPLICATION_LOGS
				.info("View the history of the Affiliation And Appointment.");
		AffViewHisPage.viewHistoryOfAffiliation(selectState);

	}

	@Ignore
	@Test
	public void testS_heightenedSupervison() {
		try {
			String identifiers = Global_Common
					.getEnvironmentProperty("identifiers");
			String identifierValue = Global_Common
					.getEnvironmentProperty("identifierValue");
			final GlobalPage global = PageFactory.initElements(driver,
					GlobalPage.class);
			final SearchIndividualsPage searchIndPage = PageFactory
					.initElements(driver, SearchIndividualsPage.class);
			searchIndPage.navigateToManageIndividuals();
			searchIndPage.searchIndividualsForHeightenedSupervision(
					identifiers, identifierValue);
			if (!global.zeroRecordsMessage().equals("")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed as no records found in search.");
				G2_Common.captureScreenShot(driver, "HeightenedSuper-");
				fail("Test failed as no records found in search.");
			}
			G2_Common.navigateTo(driver, "Heightened Supervision");
			String expectedPageTitle = Global_Common
					.getEnvironmentProperty("heightenedSupervisonPageTitle");
			if (global.validateTitle(expectedPageTitle).equals("error")) {
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ expectedPageTitle);
			}
			// Add HS
			String fromDate = Global_Common
					.getEnvironmentProperty("addHeightenedSupervisorFromDate");
			String toDate = Global_Common
					.getEnvironmentProperty("addHeightenedSupervisorToDate");
			String supervisionReason = Global_Common
					.getEnvironmentProperty("addHeightenedSupervisionReason");
			String heightenedSupervisionSupervisor = Global_Common
					.getEnvironmentProperty("addHeightenedSupervisonSupervisor");
			String dataValidationErrors = Global_Common
					.getEnvironmentProperty("AHSDataValidationErrors");
			String pageHeader = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			final HeightenedSupervisionPage hsPage = PageFactory.initElements(
					driver, HeightenedSupervisionPage.class);
			hsPage.clickOnAddHeightenedSupervision();
			final AddHeightenedSupervisionPage addHSPage = PageFactory
					.initElements(driver, AddHeightenedSupervisionPage.class);
			global.checkDataValidationErrors(dataValidationErrors);
			if (global.validateCancelOp(pageHeader).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader);
				G2_Common.captureScreenShot(driver, "HeightenedSuper-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader);
			}
			hsPage.clickOnAddHeightenedSupervision();
			G2_Common.APPLICATION_LOGS
					.info("************Add Heightened Supervison Starts************");
			addHSPage.addHeightenedSupervison(fromDate, toDate,
					supervisionReason, heightenedSupervisionSupervisor);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "HeightenedSuper-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
			// Edit HS
			String updateFromDate = Global_Common
					.getEnvironmentProperty("editHeightenedSupervisorFromDate");
			String updateToDate = Global_Common
					.getEnvironmentProperty("editHeightenedSupervisorToDate");
			String updateSupervisionReason = Global_Common
					.getEnvironmentProperty("editHeightenedSupervisionReason");
			String pageHeader1 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Edit");
			if (global.validateCancelOp(pageHeader1).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader1);
				G2_Common.captureScreenShot(driver, "HeightenedSuper-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader1);
			}
			G2_Common.navigateTo(driver, "Edit");
			final EditHeightenedSupervisionPage editHSPage = PageFactory
					.initElements(driver, EditHeightenedSupervisionPage.class);
			G2_Common.APPLICATION_LOGS
					.info("************Edit Heightened Supervison Starts************");
			editHSPage.editHeightenedSupervison(updateFromDate, updateToDate,
					updateSupervisionReason);
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "HeightenedSuper-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}

			// Add Comment HS
			String pageHeader2 = driver.findElement(
					By.cssSelector("td.bannerTitle")).getText();
			G2_Common.navigateTo(driver, "Add Comment");
			if (global.validateCancelOp(pageHeader2).equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to invalid page title. Check execution log. Expected title:   "
								+ pageHeader2);
				G2_Common.captureScreenShot(driver, "HeightenedSuper-");
				fail("Test failed due to invalid page title. Check execution log. Expected title:   "
						+ pageHeader2);
			}
			AddCommentPage addCommentPage1 = PageFactory.initElements(driver,
					AddCommentPage.class);
			G2_Common.navigateTo(driver, "Add Comment");
			G2_Common.APPLICATION_LOGS
					.info("************Add Comment in Heightened Supervison Starts************");
			addCommentPage1.addCommentHS("HS.", "Heightened Supervisor");
			if (global.taskResponse().equals("error")) {
				G2_Common.APPLICATION_LOGS
						.error("Test failed due to Data Error: "
								+ global.retrieveFailureReason());
				G2_Common.captureScreenShot(driver, "HeightenedSuper-");
				fail("Test failed due to Data Error: "
						+ global.retrieveFailureReason());
			}
		} catch (Exception e) {
			G2_Common.APPLICATION_LOGS.error(e);
			G2_Common.captureScreenShot(driver, "Failure");
			fail(e.getMessage());
		}
	}
}

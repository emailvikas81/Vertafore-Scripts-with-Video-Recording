package com.vertafore.common;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.vertafore.pageobjects.HomePage;
import com.vertafore.pageobjects.LoginPage;

public class CommonMethods {

	public static WebDriver login(WebDriver driver, String accountID,
			String username) {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(accountID, username);
		if (loginPage.getRequestTimeoutErrorExists().equals(true)) {
			int limit = 0;
			LoginPage loginPageTryAgain;
			do {
				driver.manage().deleteAllCookies();
				driver.get(CommonMethods.getLoginUrl(accountID));
				loginPageTryAgain = PageFactory.initElements(driver,
						LoginPage.class);
				loginPageTryAgain.login(accountID, username);
				limit++;
			} while (loginPageTryAgain.getRequestTimeoutErrorExists().equals(
					true)
					&& limit < 10);
			if (limit == 10) {
				fail("Request Timeout Error (408) - Run Test Again.");
			}
		}
		String expectedUserFirstLastName = Global_Common
				.getEnvironmentProperty("accountID." + accountID + "."
						+ username + ".name");
		String actualUserFirstLastName = homePage
				.getUserFirstLastNameLoggedIn();
		if (!expectedUserFirstLastName.equals(actualUserFirstLastName)) {
			fail("Test failed due to authentication failure: "
					+ loginPage.retrieveLoginFailureReason());
		}
		return driver;
	}

	public static String getLoginUrl(String accountID) {
		return Global_Common.getEnvironmentProperty("g2.environment.url")
				+ accountID;
	}

}

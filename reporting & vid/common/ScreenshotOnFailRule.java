package com.vertafore.common;

import java.io.IOException;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

public class ScreenshotOnFailRule extends TestWatcher {

	// this is updated, but not working
	// private static final WebDriver driver = null;
	private static boolean shouldStopTests = false;

	public void fail(Throwable e, Description d, WebDriver driver) {
		try {
			Event.takeScreenshot(driver, "Failure");
		} catch (IOException ioe) {
			// Logger.error("Test didn't finish due to hard failure.");
			shouldStopTests = true;
		}
		if (shouldStopTests) {
			System.exit(0);
		}
	}

	// public static void takeScreenshot(WebDriver driver, String name)
	// throws IOException {
	// if (driver instanceof TakesScreenshot) {
	// File tempFile = ((TakesScreenshot) driver)
	// .getScreenshotAs(OutputType.FILE);
	// FileUtils.copyFile(tempFile,
	// new File(String.format("screenshots/%s.png", name)));
	// }
	// }
}
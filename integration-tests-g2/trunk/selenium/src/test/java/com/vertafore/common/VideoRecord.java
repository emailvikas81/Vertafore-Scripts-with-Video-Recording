package com.vertafore.common;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VideoRecord {
	private ScreenRecorder screenRecorder;

	public static void main(String[] args) throws Exception {

		VideoRecord videoRecord = new VideoRecord();
		videoRecord.startRecording();

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("testing");
		element.submit();
		System.out.println("Page title is: " + driver.getTitle());
		driver.quit();
		videoRecord.stopRecording();
	}

	public void startRecording() throws Exception {

		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		this.screenRecorder = new ScreenRecorder(gc, new Format(MediaTypeKey,
				MediaType.FILE, MimeTypeKey, MIME_AVI), new Format(
				MediaTypeKey, MediaType.VIDEO, EncodingKey,
				ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey,
				ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24,
				FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f,
				KeyFrameIntervalKey, 15 * 60), new Format(MediaTypeKey,
				MediaType.VIDEO, EncodingKey, "black", FrameRateKey,
				Rational.valueOf(30)), null);
		this.screenRecorder.start();

	}

	public void stopRecording() throws Exception {
		this.screenRecorder.stop();
	}
}

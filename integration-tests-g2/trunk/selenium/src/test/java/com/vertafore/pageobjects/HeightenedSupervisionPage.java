package com.vertafore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeightenedSupervisionPage {
	private WebDriver driver;

	// Add Heightened Supervision
	@FindBy(how = How.LINK_TEXT, using = "Add Heightened Supervision")
	private WebElement addHeightenedSupervisionLink;

	// Information Message
	@FindBy(how = How.XPATH, using = "//div[@id='msgValidtnDiv']/font/ul")
	private WebElement informationMessage;

	//Expand Button 
	@FindBy(how = How.XPATH, using = ".//*[@id='GB_001_image']")
	private WebElement expandButton;
	
	public HeightenedSupervisionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddHeightenedSupervision() {
		this.addHeightenedSupervisionLink.click();
	}
	
	public void expandButtonClick(){
		this.expandButton.click();
	}

}

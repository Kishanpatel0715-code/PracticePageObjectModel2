package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class HomePage extends BasePage{

	@FindBy(xpath="(//div[@class='exehdJ'])[1]")
	WebElement AccountLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String HomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyAccountLink() {
		return AccountLink.isDisplayed();
	}
}

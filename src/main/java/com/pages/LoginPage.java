package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class LoginPage extends BasePage{

	//Page locators or OBject repository or Page objects
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="(//*[contains(text(),'Become a Seller')])[1]")
	WebElement becomeSalerLink;
	
	@FindBy(xpath= "//input[@class='_2IX_2- VJZDxU']")
	WebElement email;
	
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL' and @type='submit']")
	WebElement login;
	
	//initialization of page objects 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//use the methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySalerLink() {
		return becomeSalerLink.isDisplayed();
	}
	
	public void verifyLoginBtn() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		loginBtn.click();
		Thread.sleep(4000);
	}
	
	public HomePage Login(String un, String pwd) throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		loginBtn.click();
		Thread.sleep(4000);
		
		email.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
	}
}

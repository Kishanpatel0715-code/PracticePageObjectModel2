package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginPageTest extends BasePage{

	
	public LoginPageTest() {
		super();
	}
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String loginTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(loginTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(priority = 2)
	public void verifySalerLinkTest() {
		boolean b = loginPage.verifySalerLink();
		Assert.assertTrue(b);
	}
	
	@Test(priority = 3)
	public void LoginBtnTest() throws InterruptedException {
		loginPage.verifyLoginBtn();
	}
	
	@Test(priority = 4)
	public void LoginTest() throws InterruptedException {
		homePage = loginPage.Login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

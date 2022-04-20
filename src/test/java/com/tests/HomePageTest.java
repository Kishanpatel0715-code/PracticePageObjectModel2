package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class HomePageTest extends BasePage{

	public HomePageTest() {
		super();
	}
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUP() throws InterruptedException {
		Initialization();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String hTitle = homePage.HomePageTitle();
		Assert.assertEquals(hTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test
	public void verifyAccountLinkTest() {
		boolean b2 = homePage.verifyAccountLink();
		Assert.assertTrue(b2);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

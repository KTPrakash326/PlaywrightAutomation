package com.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.BaseTest;

public class HomeTest extends BaseTest {

	@Test(priority = 1)
	public void homePageTitleTest() throws InterruptedException {
		logger.info("URL is entered");
		logger.info("HomePage is opened");
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, "AskOmDch – Become a Selenium automation expert!");
		}
	
	@Test(priority = 2)
	public void homePageUrlTest() throws InterruptedException {
		String title = homePage.getHomePageUrl();
		Assert.assertEquals(title, "https://askomdch.com/");
		}
	
	@Test(priority = 3)
	public void homePageLogoTest() throws InterruptedException {
		boolean logo = homePage.verifyLogo();
		Assert.assertTrue(logo);
		}
		
}

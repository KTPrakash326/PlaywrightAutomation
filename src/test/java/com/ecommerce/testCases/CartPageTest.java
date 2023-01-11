package com.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.BaseTest;

public class CartPageTest extends BaseTest {
	
	@Test(priority = 8)
	public void navigateToCartPageTest() throws InterruptedException
	{
		storePage=homePage.clickStoreTab();
		storePage.addToCart();
		cartPage = storePage.clickViewCart();
		logger.info("cartPage is opened");
		String title = cartPage.getCartPageUrl();
		Assert.assertEquals(title, "https://askomdch.com/cart/");
	}
	
	@Test(priority = 9)
	public void applyCouponCodeTest() throws InterruptedException {
		cartPage.applyCouponCode();
		Assert.assertTrue(true);
		}
	
	
}
